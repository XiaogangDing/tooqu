/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tooqu.common.dao.PageContext;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author guo
 */
public class ControllerBase extends MultiActionController {

    public final static String ATTR_AJAX_VIEW_OBJ = "ajax-view-object-attr";
    public final static String AJAX_CONTENT_TYPE = "application/json";
    public final static String ATTR_PAGE_DESCRIPTION = "metaDescription";
    public final static String ATTR_PAGE_KEYWORDS = "metaKeywords";
    
    public final static int DEFAULT_PAGE_LENGTH = 2;
    public final static String QS_PAGE = "p";
    public final static String QS_PER_PAGE = "pp";

    public final static int ALLLIST = 0;
    public final static int SEARCHLIST = 1;

    @Autowired(required = true)
    protected HttpServletRequest request;
    
    protected static Log logger = LogFactory.getLog(ControllerBase.class);
    
    
    protected String ajaxResponse(Object rs) {
        request.setAttribute(ATTR_AJAX_VIEW_OBJ, rs);
        request.setAttribute("isAjax", true);
        return null;
    }
    
    protected boolean isNullOrEmpty(String... str) {
        for (String s : str) {
            if (s == null || s.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    protected String getCookieValue(String cookieName,
            String defaultValue) {
        if (request.getCookies() == null) {
            return defaultValue;
        }
        for (Cookie c : request.getCookies()) {
            if (cookieName.equals(c.getName())) {
                return c.getValue();
            }
        }
        return defaultValue;
    }

    protected String getCookieValue(String cookieName) {
        return getCookieValue(cookieName, null);
    }

    protected void setCookie(HttpServletResponse response, String name, String value) {
        setCookie(response, name, value, -1, null, null);
    }

    protected void setCookie(HttpServletResponse response, String name, String value, int expire) {
        setCookie(response, name, value, expire, null, null);
    }

    protected void setCookie(HttpServletResponse response, String name, String value, int expire, String path) {
        setCookie(response, name, value, expire, path, null);
    }

    protected void setCookie(HttpServletResponse response, String name, String value, int expire, String path, String domain) {
        Cookie c = new Cookie(name, value);
        if (domain != null) {
            c.setDomain(domain);
        }
        if (path == null) {
            path = "/";
        }
        c.setPath(path);
        c.setMaxAge(expire);
        response.addCookie(c);
    }

    protected void removeCookie(HttpServletResponse response, String name) {
        setCookie(response, name, "", 0);
    }

    protected void removeCookie(HttpServletResponse response, String name, String path) {
        setCookie(response, name, "", 0, path);
    }    
    
    protected String toJsonString(Object obj) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(FieldAttributes fa) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> type) {
                if (type.equals(Log.class)) {
                    return true;
                } else {
                    return false;
                }
            }
        }).create();
        return gson.toJson(obj);
    }

    protected JSONObject toJSONObject(Object obj) throws JSONException {
        if (obj == null) {
            return null;
        }
        return new JSONObject(toJsonString(obj));
    }

    protected JSONArray toJSONArray(Object obj) throws JSONException {
        if (obj == null) {
            return null;
        }
        return new JSONArray(toJsonString(obj));
    }
    
    protected void setCache(HttpServletResponse response, int expire) {
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "max-age=" + 31536000);
        response.setDateHeader("Expires", System.currentTimeMillis() + expire);
    }

    protected String redirectPermanently(HttpServletResponse response, String location) {
        response.reset();
        response.resetBuffer();
        response.setStatus(301);
        response.setHeader("Location", request.getContextPath() + location);
        return null;
    }
    
    protected void setPageDescription(String description) {
        request.setAttribute(ATTR_PAGE_DESCRIPTION, description);
    }

    protected void setPageKeywords(String keywords) {
        request.setAttribute(ATTR_PAGE_KEYWORDS, keywords);
    }    
    
     protected String getUserIP() {
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (isNullOrEmpty(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
     
    protected PageContext getPageContext() {
        PageContext page = new PageContext();
        page.setLength(DEFAULT_PAGE_LENGTH);
        try {
            if (request.getParameter(QS_PER_PAGE) != null) {
                page.setLength(Integer.parseInt(request.getParameter(QS_PER_PAGE)));
            }
        } catch (NumberFormatException ex) {
            logger.debug(ex);
        }
        page.setStart(0);
        try {
            if (request.getParameter(QS_PAGE) != null) {
                int p = Integer.parseInt(request.getParameter(QS_PAGE));
                if (p < 1) {
                    p = 1;
                }
                page.setStart((p - 1) * page.getLength());
            }
        } catch (NumberFormatException ex) {
            logger.debug(ex);
        }
        request.setAttribute("page", page);
        return page;
    }

    protected PageContext getPageContext(int perpage) {
        PageContext page = new PageContext();
        page.setLength(perpage);
        page.setStart(0);
        try {
            if (request.getParameter(QS_PAGE) != null) {
                int p = Integer.parseInt(request.getParameter(QS_PAGE));
                if (p < 1) {
                    p = 1;
                }
                page.setStart((p - 1) * page.getLength());
            }
        } catch (NumberFormatException ex) {
            logger.debug(ex);
        }
        request.setAttribute("page", page);
        return page;
    }
    protected int getDefaultPerpage(){
        return DEFAULT_PAGE_LENGTH;
    } 
    protected int getCurrentPage(){
        int p=1;
      if (request.getParameter(QS_PAGE) != null) {
                p = Integer.parseInt(request.getParameter(QS_PAGE));
                if (p < 1) {
                    p = 1;
                }
            }
      return p;
    }
    protected Date strToDate(String year, String month, String day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = year + "-" + month + "-" + day;
        java.util.Date toDate = new java.util.Date();
        
        try {
            // toDate = dateFormat.parse("2008-12-12");
            toDate = dateFormat.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        java.sql.Date sqlDate=new java.sql.Date(toDate.getTime());
        return sqlDate;
    }
    
    protected String dateToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }
    
    protected String timestampToStr(Timestamp timestamp) {
        
        String tsStr ="";  
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        try {   
            tsStr = sdf.format(timestamp); 
           
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        return tsStr;
    }
    
    protected int ageToYear(int age){
        
         return Calendar.getInstance().get(Calendar.YEAR)-age;
    }
    protected void deleteFile(File file)
    {
        if(file.exists()){                    //判断文件是否存在
        if(file.isFile()){                    //判断是否是文件
        file.delete();                       //delete()方法 你应该知道 是删除的意思;
    }else if(file.isDirectory()){              //否则如果它是一个目录
     File files[] = file.listFiles();               //声明目录下所有的文件 files[];
     for(int i=0;i<files.length;i++){            //遍历目录下所有的文件
      this.deleteFile(files[i]);             //把每个文件 用这个方法进行迭代
     } 
    } 
    file.delete(); 
   }else{ 
    System.out.println("所删除的文件不存在！"+'\n'); 
   } 
} 
        
    
}
