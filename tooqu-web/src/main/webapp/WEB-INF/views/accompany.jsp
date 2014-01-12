<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    $(function(){
    
    $("#DesPro1").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        var firstKey;
        $.post('getCityByProvince',{select_province: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.city + ">" + key.city + "</option>").appendTo($('#DesPro1').next());
                    if (i == 0) {
                        firstKey = key.city;
                        return  firstKey;
                    }
                });
                $.post('getCountyByCity', {select_city: firstKey}, function(advance) {
                    $('#DesCty1').next().empty();
                    $.each(advance.rs, function(i, item) {
                        $("<option value=" + item.county + ">" + item.county + "</option>").appendTo($('#DesCty1').next());
                    });
                });
            });
        });

        $("#DesCty1").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            $.post('getCountyByCity', {select_city: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.county + ">" + key.county + "</option>").appendTo($('#DesCty1').next());
                });
            });
        });

        $("#DesPro2").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            var firstKey;
            $.post('getCityByProvince', {select_province: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.city + ">" + key.city + "</option>").appendTo($('#DesPro2').next());
                    if (i == 0) {
                        firstKey = key.city;
                        return  firstKey;
                    }
                });
                $.post('getCountyByCity', {select_city: firstKey}, function(advance) {
                    $('#DesCty2').next().empty();
                    $.each(advance.rs, function(i, item) {
                        $("<option value=" + item.county + ">" + item.county + "</option>").appendTo($('#DesCty2').next());
                    });
                });
            });
        });

        $("#DesCty2").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            $.post('getCountyByCity', {select_city: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.county + ">" + key.county + "</option>").appendTo($('#DesCty2').next());
                });
            });
        });
        
        $('#searchAccompany').click(function() {
            var datas = {};
            datas.country = document.getElementById("DesCtry1").value;
            datas.province = document.getElementById("DesPro1").value;
            datas.city = document.getElementById("DesCty1").value;
            datas.county = document.getElementById("DesCot1").value;

            datas.country2 = document.getElementById("DesCtry2").value;
            datas.province2 = document.getElementById("DesPro2").value;
            datas.city2 = document.getElementById("DesCty2").value;
            datas.county2 = document.getElementById("DesCot2").value;

            $.ajax({
                url: "searchAccompany",
                data: datas,
                type: 'post',
                dataType: "json",
                timeout: 6000,
                
                success: function(data) {
                    alert(JSON.stringify(data));
                    
                },
                error: function(data) {
                    alert("error");
                }
            });
        });
    });
    
    

</script>

<div id="container">
    <div class="icontainer">
        <div class="cont-top fix">
            <div class="title f15 fwbold"><h3>结伴旅游</h3></div>
            <a href="/tooqu/accompanycreate"><button title="发布新计划" class="write-newplan flr">发布新计划</button></a>
        </div>
        <div class="cont-main fix">
            <!--start main-left-->
            <div class="cont-main-left fll">
                <!--start search-plan-->
                <div class="search-plan">
                    <div class="search-plan-detail fix">
                        <span class="search-plan-icon font14 fll">搜索计划</span>
                        <div class="search-plan-cont">
                            <ul class="fix">
                                <li>出发地：</li>
                                <select id="DesCtry1" name="select_country">
                                        <option value="中国">中国</option>
                                    </select>
                                <select id="DesPro1" name="select_province"> 
                                <option value="江苏">江苏</option> 
                                <option value="北京">北京</option> 
                                <option value="天津">天津</option> 
                                <option value="上海">上海</option> 
                                <option value="重庆">重庆</option> 
                                <option value="河北省">河北省</option> 
                                <option value="山西">山西</option> 
                                <option value="辽宁">辽宁</option> 
                                <option value="吉林省">吉林省</option> 
                                <option value="黑龙江">黑龙江</option> 
                                <option value="浙江省">浙江省</option> 
                                <option value="安徽省">安徽省</option> 
                                <option value="福建省">福建省</option> 
                                <option value="江西省">江西省</option> 
                                <option value="山东省">山东省</option> 
                                <option value="湖北省">湖北省</option> 
                                <option value="湖南省">湖南省</option> 
                                <option value="广东省">广东省</option> 
                                <option value="海南省">海南省</option> 
                                <option value="四川省">四川省</option> 
                                <option value="河南省">河南省</option> 
                                <option value="贵州省">贵州省</option> 
                                <option value="云南省">云南省</option> 
                                <option value="陕西省">陕西省</option> 
                                <option value="甘肃省">甘肃省</option> 
                                <option value="青海省">青海省</option> 
                                <option value="西藏自治区">西藏自治区</option> 
                                <option value="广西省">广西省</option> 
                                <option value="宁夏回族自治区">宁夏回族自治区</option> 
                                <option value="新疆维吾尔自治区">新疆维吾尔自治区</option> 
                                <option value="内蒙古自治区">内蒙古自治区</option> 
                                <option value="台湾">台湾</option> 
                                <option value="香港">香港</option> 
                                    </select>
                                <select id="DesCty1" name="select_city">
                                <option value="南京市">南京市</option>
                                <option value="无锡市">无锡市</option>
                                <option value="徐州市">徐州市</option>
                                <option value="常州市">常州市</option>
                                <option value="苏州市">苏州市</option>
                                <option value="南通市">南通市</option>
                                <option value="连云港市">连云港市</option>
                                <option value="淮安市">淮安市</option>
                                <option value="盐城市">盐城市</option>
                                <option value="扬州市">扬州市</option>
                                <option value="镇江市">镇江市</option>
                                <option value="泰州市">泰州市</option>
                                <option value="宿迁市">宿迁市</option>
                            </select>
                                <select id="DesCot1" name="select_county">
                                <option value="玄武区">玄武区</option>
                                <option value="白下区">白下区</option>
                                <option value="秦淮区">秦淮区</option>
                                <option value="建邺区">建邺区</option>
                                <option value="鼓楼区">鼓楼区</option>
                                <option value="下关区">下关区</option>
                                <option value="浦口区">浦口区</option>
                                <option value="栖霞区">栖霞区</option>
                                <option value="雨花台">雨花台</option>
                                <option value="江宁区">江宁区</option>
                                <option value="六合区">六合区</option>
                                <option value="溧水县">溧水县</option>
                                <option value="高淳县">高淳县</option>
                            </select>
                            </ul>
                            <ul class="fix">
                                <li>目的地：</li>
                                <select id="DesCtry2" name="select_country2">
                                        <option value="中国">中国</option>
                                    </select> 
                                <select id="DesPro2" name="select_province2"> 
                                <option value="江苏">江苏</option> 
                                <option value="北京">北京</option> 
                                <option value="天津">天津</option> 
                                <option value="上海">上海</option> 
                                <option value="重庆">重庆</option> 
                                <option value="河北省">河北省</option> 
                                <option value="山西">山西</option> 
                                <option value="辽宁">辽宁</option> 
                                <option value="吉林省">吉林省</option> 
                                <option value="黑龙江">黑龙江</option> 
                                <option value="浙江省">浙江省</option> 
                                <option value="安徽省">安徽省</option> 
                                <option value="福建省">福建省</option> 
                                <option value="江西省">江西省</option> 
                                <option value="山东省">山东省</option> 
                                <option value="湖北省">湖北省</option> 
                                <option value="湖南省">湖南省</option> 
                                <option value="广东省">广东省</option> 
                                <option value="海南省">海南省</option> 
                                <option value="四川省">四川省</option> 
                                <option value="河南省">河南省</option> 
                                <option value="贵州省">贵州省</option> 
                                <option value="云南省">云南省</option> 
                                <option value="陕西省">陕西省</option> 
                                <option value="甘肃省">甘肃省</option> 
                                <option value="青海省">青海省</option> 
                                <option value="西藏自治区">西藏自治区</option> 
                                <option value="广西省">广西省</option> 
                                <option value="宁夏回族自治区">宁夏回族自治区</option> 
                                <option value="新疆维吾尔自治区">新疆维吾尔自治区</option> 
                                <option value="内蒙古自治区">内蒙古自治区</option> 
                                <option value="台湾">台湾</option> 
                                <option value="香港">香港</option> 
                                    </select>
                                <select id="DesCty2" name="select_city2">
                                <option value="南京市">南京市</option>
                                <option value="无锡市">无锡市</option>
                                <option value="徐州市">徐州市</option>
                                <option value="常州市">常州市</option>
                                <option value="苏州市">苏州市</option>
                                <option value="南通市">南通市</option>
                                <option value="连云港市">连云港市</option>
                                <option value="淮安市">淮安市</option>
                                <option value="盐城市">盐城市</option>
                                <option value="扬州市">扬州市</option>
                                <option value="镇江市">镇江市</option>
                                <option value="泰州市">泰州市</option>
                                <option value="宿迁市">宿迁市</option>
                            </select>
                                <select id="DesCot2" name="select_county2">
                                <option value="玄武区">玄武区</option>
                                <option value="白下区">白下区</option>
                                <option value="秦淮区">秦淮区</option>
                                <option value="建邺区">建邺区</option>
                                <option value="鼓楼区">鼓楼区</option>
                                <option value="下关区">下关区</option>
                                <option value="浦口区">浦口区</option>
                                <option value="栖霞区">栖霞区</option>
                                <option value="雨花台">雨花台</option>
                                <option value="江宁区">江宁区</option>
                                <option value="六合区">六合区</option>
                                <option value="溧水县">溧水县</option>
                                <option value="高淳县">高淳县</option>
                            </select>
                            </ul>
                        </div>
                        <button id="searchAccompany" class="flr search-plan-btn"></button>
                    </div>
                    <dl class="our-country">
                        <dt>国内目的地</dt>
                        <dd>
                            <a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a>
                        </dd>
                    </dl>
                    <dl class="foreign fix">
                        <dt>国外目的地</dt>
                        <dd>
                            <a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a><a href="#">丽江</a>
                        </dd>
                    </dl>
                </div>
                <!--end search-plan-->
                <!--start order-style-->
                <div class="order-style">
                    <div class="order-style-title fix">
                        <div class="fll">
                            <span class="fwbold">排序方式：</span>
                            <a href="#" class="fliterTime01">按时间排序<span></span></a>
                            <!--当前选择状态-去除span的hide类-->
                            <a href="#" class="fliterTime02">按发布时间排序<span class="hide"></span></a>
                        </div>
                        <div class="flr">
                            <a href="#" title="">全部</a><span>|</span><a href="#" title="">一周后</a><span>|</span><a href="#" title="">两周后</a><span>|</span><a href="#" title="">一个月后</a><span>|</span><a href="#" title="">已经发出</a>
                        </div>
                    </div>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <thead>
                            <tr>
                                <th width="120">&nbsp;</th>
                                <th width="162"><div>计划名称</div></th>
                        <th width="1" class="fwnormal">|</th>
                        <th>出发地</th>
                        <th width="1" class="fwnormal">|</th>
                        <th>目的地</th>
                        <th width="1" class="fwnormal">|</th>
                        <th>出发时间</th>
                        <th width="1" class="fwnormal">|</th>
                        <th>发布人</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/pro-img.jpg"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="accompanyDetail?acc_id=1&p=1&pp=3" class="colorOrange">TestAccompany</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/pro-img.jpg"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/pro-img.jpg"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/pro-img.jpg"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/pro-img.jpg"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/pro-img.jpg"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/icon-member.png"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td width="120" valign="middle"><a href="#" title=""><img src="<c:url value="images/icon-member.png"/>" alt="" /></a></td>
                                <td colspan="2" valign="top" class="thisTravelName">
                                    <div>
                                        <strong><a href="#" class="colorOrange">新疆自助游</a></strong>
                                        <p>回复（<a href="#" title="">0</a>） 浏览（<a href="#" title="">9</a>）</p>
                                    </div>
                                </td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">新疆</strong></td>
                                <td colspan="2" valign="top" align="center"><strong class="colorGreen">深圳</strong></td>
                                <td colspan="2" valign="top" align="center"><strong>9月10号</strong></td>
                                <td valign="top" align="right" class="traveler">
                                    <div class="fix">
                                        <span class="travelerName flr">小小海洋小小海洋</span>
                                        <span class="flr"><img src="<c:url value="images/icon-member.png"/>" /></span>
                                    </div>
                                    <p class="data">发布于：<span>07月26日</span></p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <a href="#" class="sideBtns prev">&lt; 上一页</a>
                        <a href="?p=1">1</a><a href="#" class="current">1</a>
                        <a href="#">1</a><a href="#">1</a><a href="#">1</a>
                        <a href="#">1</a><a href="#">10</a>
                        <span>...</span><a href="#">100</a>
                        <a href="#" class="sideBtns next">下一页 &gt;</a>
                        <span class="total">共100页</span>
                        <span>跳到第 
                            <select>
                                <option>1</option>
                                <option>2</option>
                            </select> 
                            页</span>
                    </div>
                </div>
                <!--end order-style-->
            </div>
            <!--end man-left-->
            <!--start main-right-->
            <div class="cont-main-right flr">
                <div class="youCanDo">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">我可以？</h3></div>
                        <div class="asideSections"> 
                            <a href="#" title="" class="addPlans">添加一个旅行计划!</a>
                            <a href="#" title="" class="seeFriends">看看朋友最近去哪?</a>
                            <a href="#" title="" class="shareMyTravel">分享旅行归来的感受！</a>
                        </div>
                    </div>
                </div>
                <div class="asideAdv img-border"><img src="<c:url value="/images/img1.jpg"/>" title="" /></div>
                <div class="nearlyTravels-border">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">最近出发</h3></div>
                        <div class="asideSections"> 
                            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="<c:url value="images/cusphoto_16.jpg"/>" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="<c:url value="images/cusphoto_16.jpg"/>" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="<c:url value="images/cusphoto_16.jpg"/>" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="<c:url value="images/cusphoto_16.jpg"/>" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="<c:url value="images/cusphoto_16.jpg"/>" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="<c:url value="images/cusphoto_16.jpg"/>" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border borderNone">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">最近出发</h3></div>
                        <div class="asideSections"></div>
                    </div>
                    <ul class="fix">
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="<c:url value="images/travels.jpg"/>" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                    </ul>
                </div>
            </div>
            <!--end main-right-->
        </div>
    </div>
</div>