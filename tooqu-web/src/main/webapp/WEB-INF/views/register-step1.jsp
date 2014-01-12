<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <div class="registerSteps">
            <div class="registerStepsTitle">（填写注册信息）</div>
            <div class="registerStep01">        
                <form action="registerStep1" id="form" method="POST" onsubmit="return formValidata();">
                    <table cellpadding="0" cellspacing="0" width="778">
                        <tr>
                            <th width="78">注册类型：</th>
                            <td width="700">
                                <select name="type">
                                    <option value="0">游客</option>
                                    <option value="1">导游/伴游</option>
                                </select>
                                （导游/伴游、游客）
                            </td>
                        </tr>
                        <tr>
                            <th>邮箱：</th>
                            <td>
                                <input type="text" class="text" id="email" onblur="emailValidation('#email');" value="@nju.cn" name="email" />
                                <label class="inputInfoTips hide">
                                    <img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                                    <span class="colorRed"> 请正确输入邮箱</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>密码：</th>
                            <td>
                                <input type="password" name="password_data" id="password_data" onblur='validataPasswordLength("#password_data");' class="text" value="123456" />
                                <label class="inputInfoTips hide">
                                    <img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                                    <span class="colorRed">请正确输入密码，长度不小于六位</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>重复密码：</th>
                            <td>
                                <input type="password" class="text" value="123456" id="password" name="password" onblur="validataUserPassword('#password_data','#password');" />
                                <label class="inputInfoTips hide">
                                    <img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                                    <span class="colorRed"> 请确认输入密码</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>用户昵称：</th>
                            <td>
                                <input type="text" class="text" value="2222" name="name" id="userName" />
                                <label class="inputInfoTips hide"><img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="../../images/errorinput.jpg" attentionsrc="../../images/attentionsinput.jpg" truesrc="../../images/trueinput.jpg" /><span class="colorRed"> 请输入用户名</span></label>
                            </td>
                        </tr>
                        <tr>
                            <th>验证码：</th>
                            <td>
                                <input type="text" class="text validate" name="checkword" value="" />
                                <label class="yanZM"><img src="<c:url value="/captchaImage"/>" height="26" width="60" id="yanZM" /></label>
                                <span>看不清，<a href="javascript:;" onclick="tooquAjaxReloadValiPic();" class="yanZMChange colorBlue">换一张</a></span>
                                <label class="inputInfoTips hide"><img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="../../images/errorinput.jpg" attentionsrc="../../images/attentionsinput.jpg" truesrc="../../images/trueinput.jpg" /><span class="colorRed"> 请输入用户名</span></label>
                            </td>
                        </tr>
                        <!--
                        <tr>
                            <th>个性宣言：</th>
                            <td height="135"><textarea class="text"></textarea></td>
                        </tr>
                        -->
                        <tr>
                            <th colspan="2" width="100%" class="addtions">使用条款和条件</th>
                        </tr>
                        <tr>
                            <td colspan="2" width="100%">
                                <div class="addtionsWords text">
                                    <div>进入本网站的访问者接受本协议书条款，注册成为国航电子客票用户，并遵守本协议所述之条款使用本 网站所提供之服务。如果不接受本声明之条款，您将遵守本协议之规定。进入本网站的访问者接受本协议书条款，注册成为国航电子客票用户，并遵守本协议所述之条款使用本 网站所提供之服务。如果不接受本声明之条款，您将遵守本协议之规定。</div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" width="100%">
                                <div class="submitBtns fix">
                                    <div class="fll"><input class="checkbox" id="agree" type="checkbox" checked="checked" /><label for="agree">我阅读并同意途趣用户协议</label></div>
                                    <div class="flr"><input class="submit" type="submit" value="" /> 
                                    <span class="colorBlue">已有账号 <a href="/tooqu/jumpToLogin" class=" colorBlue yanZMChange">登录</a></span></div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
<script src="<c:url value="js/ajax_global.js"/>"></script>
</div>

