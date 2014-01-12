<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <img src="<c:url value="/captchaImage"/>"  id="captchaImage" width="55" height="20"/>
    <c:out value="${sessionScope.user_pic}" default="no value" escapeXml="false"/>
    <p>this is a test page</p>
</div>