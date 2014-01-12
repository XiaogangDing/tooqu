<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <a href="#" id="clickShow">点击显示弹窗 >> </a>
        <!--弹窗在 #footer 下面-->
        <script>
            $(function() {
                //点击显示弹窗
                $("#clickShow").click(function() {
                    $(".pageConfirm,.coverLayer").show();
                });
            });
        </script>
    </div>
</div>