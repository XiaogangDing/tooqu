package com.tooqu.web;

import com.google.gson.Gson;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Using this class to do account validation before the request is handled by
 * our controller.
 *
 * @author Mike
 */
public class AjaxActionInterceptor extends HandlerInterceptorAdapter {

    private static Log logger = LogFactory.getLog(AjaxActionInterceptor.class);
    private static Set<Class> PRIMITIVE_TYPES;

    private static boolean isPrimitive(Class clazz) {
        if (PRIMITIVE_TYPES == null) {
            PRIMITIVE_TYPES = new HashSet<Class>();
            PRIMITIVE_TYPES.add(Boolean.class);
            PRIMITIVE_TYPES.add(Character.class);
            PRIMITIVE_TYPES.add(Byte.class);
            PRIMITIVE_TYPES.add(Short.class);
            PRIMITIVE_TYPES.add(Integer.class);
            PRIMITIVE_TYPES.add(Long.class);
            PRIMITIVE_TYPES.add(Float.class);
            PRIMITIVE_TYPES.add(Double.class);
            PRIMITIVE_TYPES.add(Void.class);
        }
        return PRIMITIVE_TYPES.contains(clazz);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO avoid XSRF
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            logger.debug("POST Referer: " + request.getHeader("Referer"));
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null && ((HandlerMethod) handler).getMethod().getName().startsWith("ajax")) {
            JSONObject rs = new JSONObject();
            rs.put("ack", "error");
            rs.put("ex", ex.getClass().getSimpleName());
            rs.put("msg", ex.getMessage());
            request.setAttribute("AjaxException", new AjaxRequestException(rs.toString(), ex));
        }
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getAttribute("isAjax") != null) {
            if ((handler instanceof HandlerMethod)
                    && (((HandlerMethod) handler).getBean() instanceof ControllerBase)) {
                if (modelAndView != null) {
                    modelAndView.clear();
                }
                Object result = request.getAttribute(ControllerBase.ATTR_AJAX_VIEW_OBJ);
                if (result != null && !(result instanceof JSONObject)
                        && !(result instanceof JSONArray)
                        && !(result instanceof String) && !isPrimitive(result.getClass())) {
                    Gson gson = new Gson();
                    try {
                        String tstr = gson.toJson(result);
                        if (tstr.startsWith("[")) {
                            result = new JSONArray(tstr);
                        } else {
                            result = new JSONObject(tstr);
                        }
                    } catch (Exception ex) {
                        result = null;
                    }
                }
                JSONObject rs = new JSONObject();
                rs.put("ack", "ok");
                rs.put("rs", result);
                response.setContentType(ControllerBase.AJAX_CONTENT_TYPE);
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                response.getWriter().append(rs.toString());
                response.flushBuffer();
            } else {
                logger.debug("Unknown controller: " + ((HandlerMethod) handler).getBean().getClass().getCanonicalName());
            }
        }     
        super.postHandle(request, response, handler, modelAndView);
    }
}
