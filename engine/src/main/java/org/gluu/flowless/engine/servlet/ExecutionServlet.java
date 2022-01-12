package org.gluu.flowless.engine.servlet;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.HttpMethod;

import org.gluu.flowless.engine.exception.FlowCrashException;
import org.gluu.flowless.engine.exception.FlowTimeoutException;
import org.gluu.flowless.engine.exception.TemplateProcessingException;
import org.gluu.flowless.engine.misc.FlowUtils;
import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.flowless.engine.model.FlowResult;
import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.flowless.engine.page.BasicTemplateModel;
import org.gluu.flowless.engine.page.Page;
import org.gluu.flowless.engine.service.FlowService;
import org.gluu.flowless.engine.service.WebContext;
import org.gluu.flowless.engine.service.TemplatingService;
import org.slf4j.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

@WebServlet(urlPatterns = {
    "*" + ExecutionServlet.URL_SUFFIX,
    ExecutionServlet.CALLBACK_PATH,
    ExecutionServlet.ABORT_PATH
})
public class ExecutionServlet extends HttpServlet {
    
    public static final String URL_SUFFIX = ".fls"; 
    public static final String URL_PREFIX = "/fl/";
    public static final String CALLBACK_PATH = URL_PREFIX + "callback";
    public static final String ABORT_PATH = URL_PREFIX + "abort";

    @Inject
    private Logger logger;
    
    @Inject
    private EngineConfig engineConf;
    
    @Inject
    private FlowService flowService;
    
    @Inject
    private WebContext webCtx;
    
    @Inject
    private TemplatingService templatingService;
    
    @Inject
    private Page page;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FlowStatus fstatus = flowService.getRunningFlowStatus();
        String path = webCtx.getRelativePath();

        if (fstatus == null) {
            String flQname = flowQnameInRequest(path);
            
            if (flQname == null) {
                sendNotFound(response);
                return;
            }
            
            logger.info("Attempting to trigger flow {}", flQname);
            try {
                String strParams = flowParamsAsString(request.getQueryString());
                fstatus = flowService.startFlow(flQname, strParams);
                FlowResult result = fstatus.getResult();

                if (result == null) {
                    sendRedirect(response, webCtx.getContextPath(), fstatus, true);
                } else {
                    sendFinalRedirect(response, result);
                }
            } catch (FlowCrashException e) {
                logger.error(e.getMessage(), e);
                //json-based clients must explicitly pass the content-type in GET requests
                sendFlowCrashed(response, isJsonRequest(request), e.getMessage());
            }

        } else {
            if (processCallback(request, response, fstatus, path)) return;
            
            String expectedUrl = getExpectedUrl(fstatus);

            if (path.equals(expectedUrl)) {
                page.setTemplatePath(URL_PREFIX + fstatus.getTemplatePath());
                page.setDataModel(fstatus.getTemplateDataModel());
                sendPageContents(response);
            } else {
                //This is an attempt to GET a page which is not the current page of this flow
                //json-based clients must explicitly pass the content-type in GET requests
                sendPageMismatch(response, isJsonRequest(request), expectedUrl);
            }
            
        }
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FlowStatus fstatus = flowService.getRunningFlowStatus();
        String path = webCtx.getRelativePath();

        if (fstatus == null) {
            sendNotFound(response);
            return;
        }
        
        if (processCallback(request, response, fstatus, path)) return;
        
        String expectedUrl = getExpectedUrl(fstatus);

        if (path.equals(expectedUrl)) {
            continueFlow(request, response, fstatus, false, false);
        } else if (path.equals(ABORT_PATH)) {
            continueFlow(request, response, fstatus, false, true);
        } else {
            //This is an attempt to POST to a URL which is not the current page of this flow
            sendPageMismatch(response, isJsonRequest(request), expectedUrl);
        }
        
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String method = request.getMethod();         
        String path = webCtx.getRelativePath();
        boolean match = path.startsWith(URL_PREFIX);

        if (match) {
            logger.debug("ExecutionServlet {} {}", method, path);

            if (method.equals(HttpMethod.GET)) {
                doGet(request, response);
            } else if (method.equals(HttpMethod.POST)) {
                doPost(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            }
        } else {
            sendNotFound(response);
            logger.debug("Unexpected path {}", path);
        }
   
    }
    
    private void continueFlow(HttpServletRequest request, HttpServletResponse response, FlowStatus fstatus,
            boolean callbackResume, boolean abortSubflow) throws IOException {

        try {
            String jsonParams;
            if (isJsonRequest(request)) {
                //Obtain from payload
                jsonParams = request.getReader().lines().collect(Collectors.joining());
            } else {
                jsonParams = FlowUtils.toJsonString(request.getParameterMap());
            }
            
            fstatus = flowService.continueFlow(fstatus, jsonParams, callbackResume, abortSubflow);
            FlowResult result = fstatus.getResult();

            if (result == null) {
                sendRedirect(response, webCtx.getContextPath(), fstatus, request.getMethod().equals(HttpMethod.GET));
            } else {                    
                sendFinalRedirect(response, result);
            }
        } catch (FlowTimeoutException te) {
            sendFlowTimeout(response, isJsonRequest(request), te.getMessage(), te.getQname());
        } catch (FlowCrashException ce) {
            logger.error(ce.getMessage(), ce);
            sendFlowCrashed(response, isJsonRequest(request), ce.getMessage());
        }
        
    }
    
    private boolean processCallback(HttpServletRequest request, HttpServletResponse response, 
            FlowStatus fstatus, String path) throws IOException {

        if (path.equals(CALLBACK_PATH)) {
            if (fstatus.isAllowCallbackResume()) {
                continueFlow(request, response, fstatus, true, false);
            } else {
                logger.warn("Unexpected incoming response at flow callback endpoint");
                sendNotFound(response);
            }
            return true;
        }
        return false;
        
    }

    private boolean isJsonRequest(HttpServletRequest request) {
        return MediaType.APPLICATION_JSON.equals(request.getContentType());
    }

    /**
     * Extracts the flow identifier in the url path if such flow exists
     * @param path A string that starts with URL_PREFIX and ends with URL_SUFFIX
     * @return 
     */
    private String flowQnameInRequest(String path) {
        
        String flowName = null;
        try {
            String tmp = path.substring(URL_PREFIX.length(), path.length() - URL_SUFFIX.length());
            flowName = FlowUtils.decode(tmp);
        } catch (IllegalArgumentException e) {
            logger.warn("Unable to extract flow identifier in url path");
            logger.error(e.getMessage(), e);
        }
        
        if (flowName != null) {
            flowName = flowService.existing(flowName) ? flowName : null;
        }
        return flowName;

    }
    
    private String flowParamsAsString(String queryString) {
        
        String params = null;
        try {
            if (queryString != null) {
                params = FlowUtils.decode(queryString);
            }
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            logger.warn("Unable to extract flow parameters");
        }
        return params;
        
    }
    
    private void sendNotFound(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    
    private void sendRedirect(HttpServletResponse response, String contextPath, FlowStatus fls,
            boolean currentIsGet) throws IOException {
        
        String newLocation = fls.getExternalRedirectUrl();
        if (newLocation == null) {
            // Local redirection
            newLocation = contextPath + getExpectedUrl(fls);
        }
        //See https://developer.mozilla.org/en-US/docs/Web/HTTP/Redirections and
        //https://stackoverflow.com/questions/4764297/difference-between-http-redirect-codes
        if (currentIsGet) {
            //This one uses 302 (Found) redirection
            response.sendRedirect(newLocation);
        } else {
            response.setHeader(HttpHeaders.LOCATION, newLocation);
            response.setStatus(HttpServletResponse.SC_SEE_OTHER);
        }
        
    }

    private void sendFinalRedirect(HttpServletResponse response, FlowResult result) throws IOException {

        page.setTemplatePath(engineConf.getFinishedFlowPage());
        page.setRawDataModel(result);
        sendPageContents(response);
        
    }

    private void sendFlowTimeout(HttpServletResponse response, boolean jsonResponse, String message,
            String qname) throws IOException {

        String errorPage = engineConf.getInterruptionErrorPage();
        page.setTemplatePath(jsonResponse ? engineConf.getJsonErrorPage(errorPage) : errorPage);
        page.setDataModel(new BasicTemplateModel(message, FlowUtils.encode(qname)));
        sendPageContents(response);

    }
    
    private void sendFlowCrashed(HttpServletResponse response, boolean jsonResponse, String error)
            throws IOException {

        String errorPage = engineConf.getCrashErrorPage();
        page.setTemplatePath(jsonResponse ? engineConf.getJsonErrorPage(errorPage) : errorPage);
        page.setRawDataModel(new BasicTemplateModel(error));
        sendPageContents(response);
        
    }
    
    private void sendPageMismatch(HttpServletResponse response, boolean jsonResponse, String url)
            throws IOException {
        
        String errorPage = engineConf.getPageMismatchErrorPage();        
        page.setTemplatePath(jsonResponse ? engineConf.getJsonErrorPage(errorPage) : errorPage);
        page.setDataModel(new BasicTemplateModel(url));
        sendPageContents(response);

    }

    private void sendPageContents(HttpServletResponse response) throws IOException {
        processTemplate(page.getTemplatePath(), page.getDataModel(), response);        
    }
    
    private void processTemplate(String path, Object dataModel, HttpServletResponse response)
            throws IOException {

        try {
            engineConf.getDefaultResponseHeaders().forEach((h, v) -> response.setHeader(h, v));
            String mimeType = templatingService.process(path, dataModel, response.getWriter(), false);
            if (mimeType != null) {
                response.setHeader(HttpHeaders.CONTENT_TYPE, mimeType);
            }
        } catch (TemplateProcessingException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
    
    private String getExpectedUrl(FlowStatus fls) {
        String templPath = fls.getTemplatePath();
        if (templPath == null) return null;
        return URL_PREFIX + templPath.substring(0, templPath.lastIndexOf(".")) + URL_SUFFIX;
    }

    public static void main(String ...args) throws Exception {
        byte[] bytes = FlowUtils.encode("org.gluu.flow1").getBytes(UTF_8);
        System.out.println(new String(bytes, UTF_8));
    }
    
}
