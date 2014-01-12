<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <div class="cont-top fix">
            <div class="title f15 fwbold">结伴旅游——<span class="font14 colorOrange">（修改计划）</span></div>
        </div>
        <!--start jieban_fabu -->
        <div class="jiebanFabuArticle">
            <div class="jiebanFabuArticleCont jiebanFabuModify">
                <div class="jiebanFabuContent faBuFirstStep">
                    <form>
                        <table width="700" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="62" class="fwbold">目的地：</td>
                                <td width="54"><input class="radio" type="radio" name="" /> 国内</td>
                                <td width="54"><input class="radio" type="radio" name="" /> 国外</td>
                                <td width="132"><select class="countrySelect"><option>选择省内</option><option>江苏</option></select></td>
                                <td width="132"><select class="countrySelect"><option>选择省内</option><option>江苏</option></select></td>
                                <td width="84"><input type="button" class="orangeBtns Btns3em" name="" value="+ 添加" /></td>
                                <td>（每次添加一个，可多次添加）<span class="errorInput hide">每次添加一个，可多次添加</span><!--错误提示--></td>
                            </tr>
                            <tr>
                                <td width="62" class="fwbold">&nbsp;</td>
                                <td colspan="6"><span class="goToAddress">美国<a href="#" class="closeBtns"></a></span><span class="goToAddress">美国<a href="#" class="closeBtns"></a></span><span class="goToAddress">美国<a href="#" class="closeBtns"></a></span></td>
                            </tr>
                            <tr>
                                <td width="62" class="fwbold">出发地：</td>
                                <td width="54"><input class="radio" type="radio" name="" /> 国内</td>
                                <td width="54"><input class="radio" type="radio" name="" /> 国外</td>
                                <td width="132"><select class="countrySelect"><option>选择省内</option><option>江苏</option></select></td>
                                <td width="132"><select class="countrySelect"><option>选择省内</option><option>江苏</option></select></td>
                                <td colspan="2"><span class="errorInput hide">每次添加一个，可多次添加</span></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="jiebanFabuContent faBuThirdStep">
                    <div class="tableLeft">
                        <ul>
                            <li><label>计划名称：</label><input type="text" class="text text01" value="" /></li>
                            <li><label>出游方式：</label><select><option>选择省内</option><option>江苏</option></select><label>需要导游/伴游的方式：</label><select><option>选择省内</option><option>江苏</option></select></li>
                            <li><label>出游方式：</label> <select><option>选择省内</option><option>江苏</option></select> <select><option>选择省内</option><option>江苏</option></select> <select><option>选择省内</option><option>江苏</option></select> 
                                <label><span class="fwnormal">大约：</span></label> <input type="text" value="" class="text text02" /> <label><span class="fwnormal">天</span> </label>
                            </li>
                            <li><label>报名截止日期：</label><select><option>选择省内</option><option>江苏</option></select><select><option>选择省内</option><option>江苏</option></select><select><option>选择省内</option><option>江苏</option></select>
                                <label>性别要求：</label><select><option>选择省内</option><option>江苏</option></select>
                                <label>邀请人数：</label><select><option>选择省内</option><option>江苏</option></select>
                            </li>
                            <li>
                                <label>费用支付时间及方式：</label><select><option>选择省内</option><option>江苏</option></select>
                            </li>
                        </ul>
                        <ul>
                            <li><input type="radio" class="radio" /> <label>聘请导游</label> <input type="radio" class="radio" /> <label>不聘请导游/伴游</label></li>
                            <li><label class="colorOrange">对导游和伴游其他要求：</label></li>
                            <li><label>年龄：</label><select><option>选择省内</option><option>江苏</option></select><label>身高：</label><select><option>选择省内</option><option>江苏</option></select><label>体重：</label><select><option>选择省内</option><option>江苏</option></select></li>
                            <li><label>性格：</label><select><option>选择省内</option><option>江苏</option></select><label>语言能力：</label><select><option>选择省内</option><option>江苏</option></select></li>
                            <li><label>语言能力：</label><select><option>选择省内</option><option>江苏</option></select><label>有无驾照：</label><select><option>选择省内</option><option>江苏</option></select></li>
                            <li><label>是否需要接机/接站：</label><select><option>选择省内</option><option>江苏</option></select><label>是否需要备车：</label><select><option>选择省内</option><option>江苏</option></select></li>
                        </ul>
                        <ul class="lastUl">
                            <li><label>活动具体安排及其他说明：</label></li>
                            <li class="editorList">
                                <div class="editor">
                                    <div class=" editorBtns fix">
                                        <a href="#" class="tupian">图片</a>
                                        <a href="#" class="shipin">视频</a>
                                        <a href="#" class="lianjie">链接</a>
                                        <a href="#" class="biaoqing">表情</a>
                                    </div>
                                    <div class="editorCont"></div>
                                </div>
                            </li>
                            <li><label class="txtr">语言能力：</label><select><option>选择省内</option><option>江苏</option></select></li>
                            <li><label class="txtr">验证码：</label><input type="text" class="text text03" value="">
                                <span class="yanZM"><img src="../images/yanzhma.png" /></span>  看不清，<a href="#" class="colorBlue">换一张</a>
                            </li>
                            <li><button class="write-newplan" title="发布新计划">发布新计划</button></li>  
                        </ul>
                    </div>
                </div>
                <span class="jiebanFabuTips"><img src="../images/fabutips.jpg" /></span>
            </div>
        </div>
        <!-- end -->
    </div>
</div>