<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<iframe id="user-photo-upload" style="display: none;" src="<c:url value="/upload?t=/register/${userId}/upload"/>"></iframe>
<div id="page-upload-photo" style="width: 600px;"></div>
<div id="container">
    <div class="icontainer">
        <div class="registerSteps">
            <div class="registerStepsTitle">（上传头像）</div>
            <div class="registerStep03"></div>
            <div class="clear"></div>
            <br />
            <a class="orangeBtns Btns3em" style="display:inline-block; color: #fff; margin-right: 15px;"  id="upload-button">上传照片</a> 
            <a class="orangeBtns Btns3em" style="display:inline-block; color: #fff;" href="<c:url value="/emailActive"/>">下一步</a>
        </div>      
    </div>
</div>