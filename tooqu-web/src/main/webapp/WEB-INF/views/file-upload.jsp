<%-- 
    Document   : file-upload
    Created on : May 4, 2013, 10:35:53 AM
    Author     : guo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%><!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>File Upload</title>
    </head>
    <body>
        <h1>File Upload</h1>
        <form method="POST" action="<c:url value="${target}"/>" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input type="submit"/>
        </form>
    </body>
</html>