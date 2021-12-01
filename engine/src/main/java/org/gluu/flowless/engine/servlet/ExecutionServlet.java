package org.gluu.flowless.engine.servlet;

import java.io.IOException;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.Base64;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.gluu.flowless.engine.page.BasicTemplateModel;
import org.gluu.flowless.engine.page.Page;
import org.gluu.flowless.engine.exception.FlowCrashException;
import org.gluu.flowless.engine.exception.FlowTimeoutException;
import org.gluu.flowless.engine.exception.TemplateProcessingException;
import org.gluu.flowless.engine.model.EngineConfig;
import org.gluu.flowless.engine.model.ExternalRedirect;
import org.gluu.flowless.engine.model.FlowResult;
import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.flowless.engine.service.FlowService;
import org.gluu.flowless.engine.service.SessionService;
import org.gluu.flowless.engine.service.TemplatingService;
import org.slf4j.Logger;

@WebServlet(urlPatterns = "*" + ExecutionServlet.URL_SUFFIX)
public class ExecutionServlet extends HttpServlet {
    
    public static final String URL_SUFFIX = ".fls"; 
    public static final String URL_PREFIX = "/fl/";

    @Inject
    private Logger logger;
    
    @Inject
    private EngineConfig engineConf;
    
    @Inject
    private FlowService flowService;
    
    @Inject
    private SessionService sessionService;
    
    @Inject
    private TemplatingService templatingService;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid = sessionService.getId();
        FlowStatus fstatus = flowService.getFlowStatus(sid);
        String path = request.getServletPath();
        
        if (fstatus == null) {
            String flQname = flowQnameInRequest(path);
            logger.info("Attempting to trigger flow {}", flQname);
            
            if (flQname == null) {
                response.setStatus(Status.NOT_FOUND.getStatusCode());
            } else {
                try {
                    String strParams = flowParamsAsString(request.getQueryString());
                    fstatus = flowService.startFlow(flQname, sid, strParams);
                    FlowResult result = fstatus.getResult();
                    
                    if (result == null) {
                        sendRedirect(response, request.getContextPath(), fstatus);
                    } else {
                        sendFinalRedirect(response, result);
                    }
                } catch (FlowCrashException e) {
                    sendFlowCrashed(response, e.getMessage());
                }
            }
        } else {
            String expectedUrl = getExpectedUrl(fstatus);

            if (path.equals(expectedUrl)) {
                processTemplate(URL_PREFIX + fstatus.getTemplatePath(), fstatus.getTemplateDataModel(), response);
            } else {
                //This is an attempt to GET a page which is not the current page of this flow
                sendPageMismatch(response, expectedUrl);
            }
        }
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sid = sessionService.getId();
        FlowStatus fstatus = flowService.getFlowStatus(sid);        
        if (fstatus == null) return;

        String path = request.getServletPath();
        String expectedUrl = getExpectedUrl(fstatus);

        if (path.equals(expectedUrl)) {
            try {
                fstatus = flowService.continueFlow(fstatus.getQname(), sid,
                        request.getParameterMap(), false);
                FlowResult result = fstatus.getResult();

                if (result == null) {
                    sendRedirect(response, request.getContextPath(), fstatus);
                } else {                    
                    sendFinalRedirect(response, result);
                }
            } catch (FlowTimeoutException te) {
                sendFlowTimeout(response, te.getMessage());
            } catch (FlowCrashException ce) {
                sendFlowCrashed(response, ce.getMessage());
            }
        } else {
            //This is an attempt to POST to a URL which is not the current page of this flow
            sendPageMismatch(response, expectedUrl);
        }
        
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String method = request.getMethod();         
        String path = request.getServletPath();
        boolean match = path.startsWith(URL_PREFIX);

        if (match) {
            logger.debug("ExecutionServlet {} {}", method, path);

            if (method.equals(HttpMethod.GET)) {
                doGet(request, response);
            } else if (method.equals(HttpMethod.POST)) {
                doPost(request, response);
            } else {
                response.sendError(Status.METHOD_NOT_ALLOWED.getStatusCode());
            }
        } else {
            response.setStatus(Status.NOT_FOUND.getStatusCode());         
            logger.debug("Unexpected path {}", path);
        }
   
    }

    /**
     * Extracts the flow identifier in a url path if such flow exists
     * @param path A string that starts with URL_PREFIX and ends with URL_SUFFIX
     * @return 
     */
    private String flowQnameInRequest(String path) {
        
        String flowName = null;
        try {
            String tmp = path.substring(URL_PREFIX.length(), path.length() - URL_SUFFIX.length());
            flowName = new String(Base64.getUrlDecoder().decode(tmp), UTF_8);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
            logger.warn("Unable to extract flow identifier in url path");
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
                params = new String(Base64.getUrlDecoder().decode(queryString), UTF_8);
            }
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
            logger.warn("Unable to extract flow parameters");
        }
        return params;
        
    }
    
    private void sendRedirect(HttpServletResponse response, String contextPath,
            FlowStatus fls) throws IOException {
        
        ExternalRedirect exr = fls.getExternalRedirect();
        if (exr == null) {
            // Local redirection
            response.sendRedirect(contextPath + getExpectedUrl(fls));
        } else {
            // Redirect to an external site
            // TODO:
        }
        
    }

    private void sendFinalRedirect(HttpServletResponse response, FlowResult result) throws IOException {
        
        Page page = new Page(engineConf.getFinishedFlowPage());
        page.setDataModel(result);
        sendPageContents(response, page);
        
    }

    private void sendFlowTimeout(HttpServletResponse response, String message) throws IOException {

        Page page = new Page(engineConf.getInterruptionErrorPage());
        page.setDataModel(new BasicTemplateModel(message));
        sendPageContents(response, page);

    }
    
    private void sendFlowCrashed(HttpServletResponse response, String error) throws IOException {

        Page page = new Page(engineConf .getCrashErrorPage());
        page.setDataModel(new BasicTemplateModel(error));
        sendPageContents(response, page);
        
    }
    
    private void sendPageMismatch(HttpServletResponse response, String url) throws IOException {
        
        Page page = new Page(engineConf.getPageMismatchErrorPage());
        page.setDataModel(new BasicTemplateModel(url));
        sendPageContents(response, page);

    }

    private void sendPageContents(HttpServletResponse response, Page page) throws IOException {
        processTemplate(page.getTemplatePath(), page.getDataModel(), response);        
    }
    
    public void processTemplate(String path, Object dataModel, HttpServletResponse response)
            throws IOException {

        try {
            response.setContentType(MediaType.TEXT_HTML);
            templatingService.process(path, dataModel, response.getWriter(), false);
        } catch (TemplateProcessingException e) {
            response.sendError(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
        }

    }
    
    private String getExpectedUrl(FlowStatus fls) {
        String templPath = fls.getTemplatePath();
        return URL_PREFIX + templPath.substring(0, templPath.lastIndexOf(".")) + URL_SUFFIX;
    }

    public static void main(String ...args) throws Exception {
        byte[] bytes = Base64.getUrlEncoder().encode("test1".getBytes());
        System.out.println(new String(bytes, UTF_8));
    }
    
}
