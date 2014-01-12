<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <div class="loginSection fix">
            <div class="loginPics fll"><img src="<c:url value="images/login.jpg"/>" /></div>
            <div class="loginForm flr">
                <form action="login" method="post">
                    <div class="topTips" style="height:29px;"><label style="display: none;" class="inputError">请输入Email</label></div>
                    <table cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <td height="22" colspan="2"><h4>Email：</h4></td>
                        </tr>
                        <tr>
                            <td height="39" valign="top" width="258">
                                <input type="text" class="text" name="email" onfocus="if (this.value == this.defaultValue) {
                                            this.value = '';
                                        }" onblur="if (this.value == '') {
                                            this.value = this.defaultValue;
                                        }" />
                            </td>
                            <td>
                                <img class="inputInfoTips hide" src="<c:url value="images/errorinput.jpg"/>" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                            </td>
                        </tr>
                        <tr>
                            <td height="22" colspan="2">
                                <div class="fix">
                                    <h4 class="fll">登录密码：</h4>
                                    <a href="#" class="colorBlue flr">忘记登录密码？</a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="39" valign="top" width="258">
                                <input type="password" name="password" class="text" />
                            </td>
                            <td>
                                <img class="inputInfoTips hide" src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div class="activePlugins">
                                    <!--<input type="checkbox" class="checkbox" /><label class="colorLGray">安全控件登录</label> &nbsp; <input type="checkbox" class="checkbox" /><label class="colorLGray">十天内免登录</label> 
                                    <img src="<c:url value="images/helpinput.jpg" />" />-->
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" class="submit font14 fwbold" value="登 &nbsp;录" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" height="30">
                                <div class="fix">
                                    <a href="/tooqu/jumpToRegister" class="colorBlue flr">注册新帐号</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<div style="position: absolute; bottom: 0; left:-999em;" id="callBackMsg">${msg}</div>
<script>
    $(function(){
        $('input[name]').focus(function(){
          $(this).parent("td").find(".inputInfoTips").hide();
          });
        var msg = $("#callBackMsg").text();
        if(msg=="账号不存在！"){
            $(".topTips label").show().text('账号不存在！');
            }else if(msg=="密码错误！"){
                $(".topTips label").show().text('密码错误！');
                }else if(msg=='账号未激活！'){
                    $(".topTips label").show().text('账号未激活！');
                    };
        });
</script>