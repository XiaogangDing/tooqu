<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title><c:if test="${pageTitle == null}"><tiles:getAsString name="title"/></c:if><c:if test="${pageTitle != null}">${pageTitle}</c:if></title>
        <tiles:insertAttribute name="styles"/>
        <meta name="Description"  content="" />
        <meta name="Keywords" content="" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" href="#" />
        <script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.js" />"></script>
    </head>
    <compress:html enabled="${!isDebug}" compressJavaScript="false">
        <body>
            <tiles:insertAttribute name="header"/>
            <tiles:insertAttribute name="content"/>
            <tiles:insertAttribute name="footer"/>
        </body>
    </compress:html>
</html>