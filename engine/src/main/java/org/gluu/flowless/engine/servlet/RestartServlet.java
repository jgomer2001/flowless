package org.gluu.flowless.engine.servlet;

import java.io.IOException;
import java.util.Base64;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.gluu.flowless.engine.model.FlowStatus;
import org.gluu.flowless.engine.service.FlowService;
import org.gluu.flowless.engine.service.SessionService;
import org.slf4j.Logger;

import org.gluu.flowless.engine.misc.FlowUtils;

@WebServlet(urlPatterns = RestartServlet.PATH)
public class RestartServlet extends HttpServlet {

    public static final String PATH = "/fl/restart";
    
    private static final String FLOW_PARAM = "flowName";
    
    @Inject
    private Logger logger;
    
    @Inject
    private FlowService flowService;
    
    @Inject
    private SessionService sessionService;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.debug("Restart servlet");
        String encQname = request.getParameter(FLOW_PARAM);
        
        if (encQname == null) {
            String sid = sessionService.getId();
            FlowStatus fstatus = flowService.getFlowStatus(sid);

            if (fstatus != null) {
                flowService.terminateFlow(sid);
                encQname = FlowUtils.encode(fstatus.getQname());
            }
        }

        if (encQname == null) {
            response.sendError(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "No flow to restart");
        } else {
            logger.debug("Sending user's browser for a flow start");
            response.sendRedirect(request.getContextPath() + ExecutionServlet.URL_PREFIX +
                    encQname + ExecutionServlet.URL_SUFFIX);
        }
        
    }
    
}
