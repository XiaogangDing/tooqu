package com.tooqu.web;

import com.tooqu.common.environment.BaseConfigurationDetector;
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
public class ActionInterceptor extends HandlerInterceptorAdapter {

    private static Log logger = LogFactory.getLog(ActionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("contextPath", request.getContextPath());
        request.setAttribute("fullBaseUrl", BaseConfigurationDetector.getInstance().getWebBaseUrl());
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
