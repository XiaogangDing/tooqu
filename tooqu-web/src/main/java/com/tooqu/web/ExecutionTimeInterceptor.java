package com.tooqu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Using this class to do account validation before the request is handled by
 * our controller.
 *
 * @author Mike
 */
public class ExecutionTimeInterceptor extends HandlerInterceptorAdapter {

    private final static String RK_REQUEST_START_TIME = "request-start-time-holder";
    private static Log logger = LogFactory.getLog(ExecutionTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    private boolean isStatic(HttpServletRequest request) {
        return request.getRequestURI().startsWith(request.getContextPath() + "/app/static");
    }
}
