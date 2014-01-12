/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web;

import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.taglibs.standard.tag.common.core.ImportSupport;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

/**
 *
 * @author guo
 */
public class ResourceUrlTag extends BodyTagSupport {

    protected Log logger = LogFactory.getLog(getClass());
    //*********************************************************************
    // Protected state
    protected String value;                      // 'value' attribute
    //*********************************************************************
    // Private state
    private String var;                          // 'var' attribute
    private int scope;				 // processed 'scope' attr
    private String value_;			// stores EL-based property
    private static String version;

    //*********************************************************************
    // Constructor and initialization
    public ResourceUrlTag() {
        super();
        init();
    }

    private void init() {
        value_ = null;
        value = var = null;
        scope = PageContext.PAGE_SCOPE;
        if (version == null) {
            Properties prop = new Properties();
            try {
                prop.load(getClass().getClassLoader().getResourceAsStream("/dev.properties"));
                if (prop.containsKey("version")) {
                    version = prop.getProperty("version");
                    if (!version.matches("[\\d\\.]+")) {
                        throw new Exception("Invalid version: " + version);
                    }
                } else {
                    throw new Exception("Version not configured");
                }
                logger.info("Tooqu version: " + version);
            } catch (Exception e) {
                logger.warn(e);
                version = "0.0.0." + (int) (1000 * Math.random());
            }
        }
    }

    //*********************************************************************
    // Tag attributes known at translation time
    public void setVar(String var) {
        this.var = var;
    }

    public void setScope(String scope) {
        this.scope = Util.getScope(scope);
    }

    public void setValue(String value_) {
        this.value_ = value_;
    }

    //*********************************************************************
    // Tag logic
    // resets any parameters that might be sent
    @Override
    public int doStartTag() throws JspException {
        // evaluate any expressions we were passed, once per invocation
        evaluateExpressions();
        return EVAL_BODY_BUFFERED;
    }

    // gets the right value, encodes it, and prints or stores it
    @Override
    public int doEndTag() throws JspException {
        String result = resolveUrl(value, pageContext);

        // if the URL is relative, rewrite it
        if (!ImportSupport.isAbsoluteUrl(result)) {
            HttpServletResponse response =
                    ((HttpServletResponse) pageContext.getResponse());
            result = response.encodeURL(result);
        }

        // store or print the output
        if (var != null) {
            pageContext.setAttribute(var, result, scope);
        } else {
            try {
                pageContext.getOut().print(result);
            } catch (java.io.IOException ex) {
                throw new JspTagException(ex.toString(), ex);
            }
        }

        return EVAL_PAGE;
    }

    // Releases any resources we may have (or inherit)
    @Override
    public void release() {
        init();
    }

    //*********************************************************************
    // Utility methods
    public static String resolveUrl(
            String url, PageContext pageContext)
            throws JspException {

        // normalize relative URLs against a context root
        HttpServletRequest request =
                (HttpServletRequest) pageContext.getRequest();
        if (url.startsWith("/")) {
            url = url.substring(1);
        }
        return String.format("%s/v%s/%s", request.getContextPath(), version, url);
    }


    /*
     * Evaluates expressions as necessary
     */
    private void evaluateExpressions() throws JspException {
        /*
         * Note: we don't check for type mismatches here; we assume the
         * expression evaluator will return the expected type (by virtue of
         * knowledge we give it about what that type is). A ClassCastException
         * here is truly unexpected, so we let it propagate up.
         */

        value = (String) ExpressionUtil.evalNotNull(
                "url", "value", value_, String.class, this, pageContext);
    }
}