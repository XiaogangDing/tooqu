<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/global.js"></script>
<script src="<c:url value="js/ajax_global.js"/>"></script>
<script>
    
    $(function() {
        
        $(".Btns6em").click(function(){
            $("#fir").addClass("current").siblings().removeClass("current");
            $(".jiebanFabuArticleCont .faBuFirstStep").show();
            $(".jiebanFabuArticleCont .faBuFirstStep").siblings().hide();
        });
        
        $(".Btns7em").click(function(){
            $("#thd").addClass("current").siblings().removeClass("current");
            $(".jiebanFabuArticleCont .faBuThirdStep").show();
            $(".jiebanFabuArticleCont .faBuThirdStep").siblings().hide();
            //$("#createAccompyStep3").show();
        });
        
        

        $("#DesProv").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            var firstKey;
            $.post('getCityByProvince', {select_province: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.city + ">" + key.city + "</option>").appendTo($('#DesProv').next());
                    if (i === 0) {
                        firstKey = key.city;
                        return  firstKey;
                    }
                });
                $.post('getCountyByCity', {select_city: firstKey}, function(advance) {
                    $('#DesCty').next().empty();
                    $.each(advance.rs, function(i, item) {
                        $("<option value=" + item.county + ">" + item.county + "</option>").appendTo($('#DesCty').next());
                    });
                });
            });
        });

        $("#DesCty").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            $.post('getCountyByCity', {select_city: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.county + ">" + key.county + "</option>").appendTo($('#DesCty').next());
                });
            });
        });


        $("#StartProv").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            var firstKey;
            $.post('getCityByProvince', {select_province: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.city + ">" + key.city + "</option>").appendTo($('#StartProv').next());
                    if (i === 0) {
                        firstKey = key.city;
                        return  firstKey;
                    }
                });
                $.post('getCountyByCity', {select_city: firstKey}, function(advance) {
                    $('#StartCty').next().empty();
                    $.each(advance.rs, function(i, item) {
                        $("<option value=" + item.county + ">" + item.county + "</option>").appendTo($('#StartCty').next());
                    });
                });
            });
        });

        $("#StartCty").change(function() {
            $(this).next().empty();
            var parm = $(this).val();
            $.post('getCountyByCity', {select_city: parm}, function(data) {
                $.each(data.rs, function(i, key) {
                    $("<option value=" + key.county + ">" + key.county + "</option>").appendTo($('#StartCty').next());
                });
            });
        });

        $('#accompanyStepBtn1').click(function() {
            var datas0 = {};
            datas0.country = $("#accompanyStep1 select[name=country]").val();
            datas0.province = $("#accompanyStep1 select[name=province]").val();
            datas0.city = $("#accompanyStep1 select[name=city]").val();
            datas0.county = $("#accompanyStep1 select[name=county]").val();

            datas0.country2 = $("#accompanyStep1 select[name=country2]").val();
            datas0.province2 = $("#accompanyStep1 select[name=province2]").val();
            datas0.city2 = $("#accompanyStep1 select[name=city2]").val();
            datas0.county2 = $("#accompanyStep1 select[name=county2]").val();

            $.ajax({
                url: "createAccompanyStep1",
                data: datas0,
                type: 'post',
                dataType: "json",
                timeout: 6000,
                
                success: function(data) {
                    //alert(JSON.stringify(data));
                    //pageTabs(".jiebanFabuArticleNav a",".jiebanFabuArticleCont .faBuSecondStep",before,after);
                    $("#se").addClass("current").siblings().removeClass("current");
                    $(".jiebanFabuArticleCont .faBuSecondStep").show();
		    $(".jiebanFabuArticleCont .faBuSecondStep").siblings().hide();
                },
                error: function(data) {
                    alert("error");
                }
            });
        });

        $('#accompanyStepBtn3').click(function() {
        var datas = {};
        datas.acc_checkword =$('input[name="acc_checkword"]').val();
        datas.acc_name =$('input[name="acc_name"]').val();
        datas.acc_type =$("select[name=acc_type]").val();
        datas.acc_acctype =$("select[name=acc_acctype]").val();
        datas.acc_sex =$("select[name=acc_sex]").val();
        datas.acc_deadline_year =$('input[name="acc_deadline_year"]').val();
        datas.acc_deadline_month =$('input[name="acc_deadline_month"]').val();
        datas.acc_deadline_day =$('input[name="acc_deadline_day"]').val();
        datas.acc_traveltime_year =$('input[name="acc_traveltime_year"]').val();
        datas.acc_traveltime_month =$('input[name="acc_traveltime_month"]').val();
        datas.acc_traveltime_day =$('input[name="acc_traveltime_day"]').val();
        datas.acc_travelduration =$('input[name="acc_travelduration"]').val();
        datas.acc_amount =$('input[name="acc_amount"]').val();
        datas.acc_age =$("select[name=acc_age]").val();
        datas.acc_weight =$("select[name=acc_weight]").val();
        datas.acc_height =$("select[name=acc_height]").val();
        datas.acc_education =$("select[name=acc_education]").val();
        datas.acc_car =$("select[name=acc_car]").val();
        datas.acc_language =$("select[name=acc_language]").val();
        datas.acc_license =$("select[name=acc_license]").val();
        datas.acc_passport =$("select[name=acc_passport]").val();
        datas.acc_pick =$("select[name=acc_pick]").val();
        datas.acc_businessrequirement =$("select[name=acc_businessrequirement]").val();
        datas.acc_feetype =$("select[name=acc_feetype]").val();
        datas.acc_remark =$(".editorCont").val();
        datas.acc_userauthority=$("select[name=acc_userauthority]").val();
        
        
        $.ajax({
            url: "createAccompanyStep3",
            data: datas,
            type: 'post',
            dataType: "json",
            
            success: function(data) {
                //console.log(data);
                var reString=data.rs;
                
                if(reString=="验证码不符!"){
                    alert(reString);
                    tooquAjaxReloadValiPic();
                }else{
                    alert("创建成功!");
                    location.href ="accompanyDetail?acc_id="+reString+"&p=1&pp=3";
                }
            },
            error: function(data) {
               //console.log(data);        
               alert("error");
//               location.href ="/tooqu/accompanyDetail?acc_id=2";
               //
            }
        });
    });


    });

function before(){
	null;
	};

function after(){
	null;
	};

</script>
<div id="container">
    <div class="icontainer">
        <div class="cont-top fix">
            <div class="title f15 fwbold"><h3 class="jiebanFabu">结伴旅游——<span class="font14 colorOrange">（发布计划）</span></h3></div>
        </div>
        <!--start jieban_fabu -->
        <div class="jiebanFabuArticle">
            <div class="jiebanFabuArticleNav">
                <ul class="fix">
                    <li id="fir" class="current"><a href="javascript:;">发布计划概要 >></a></li><!--当前流程-->
                    <li id="se"><a href="javascript:;">是否参与已有计划 >></a></li>
                    <li id="thd"><a href="javascript:;">详细计划说明 >></a></li>
                    <li id="fth"><a href="javascript:;">计划成功发布</a></li>
                </ul>
            </div>
            <div class="jiebanFabuArticleCont">
                <!--第一步-->
                <div class="jiebanFabuContent faBuFirstStep">
                    <form id="accompanyStep1">
                        <table width="700" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="62" class="fwbold">目的地：</td>
                                <td colspan="3">
                                    <select name="country">
                                        <option value="中国">中国</option>
                                    </select>
                                    <select id="DesProv" name="province">                                
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

                                    <select id="DesCty" name="city">
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
                                    <select name="county">
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

                                </td>
                                <td width="72"><input type="button" class="orangeBtns Btns3em" value="+ 添加" /></td>
                                <td>（每次添加一个，可多次添加）<span class="errorInput hide">每次添加一个，可多次添加</span><!--错误提示--></td>
                            </tr>
                            <tr>
                                <td width="62" class="fwbold">&nbsp;</td>
                                <td colspan="6">
                                    <span class="goToAddress">美国<a href="#" class="closeBtns"></a></span>
                                    <span class="goToAddress">美国<a href="#" class="closeBtns"></a></span>
                                    <span class="goToAddress">美国<a href="#" class="closeBtns"></a></span>
                                </td>
                            </tr>
                            <tr>
                                <td width="62" class="fwbold">出发地：</td>
                                <td colspan="3">
                                    <select name="country2">
                                        <option value="中国">中国</option>
                                    </select>
                                    <select id="StartProv" name="province2">                                
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

                                    <select id="StartCty" name="city2">
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
                                    <select name="county2">
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
                                </td>
                                <td colspan="2"><span class="errorInput hide">每次添加一个，可多次添加</span></td>
                            </tr>
                            <tr>
                                <td width="62" class="fwbold">&nbsp;</td>
                                <td colspan="6" class="nextStepButton">
                                    <input type="button" value="下一步" id="accompanyStepBtn1" class="orangeBtns Btns3em" />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <!--第二步-->
                <div class="jiebanFabuContent faBuSecondStep hide">
                    <h4 class="faBuStepTitle">您是否对下列已有计划感兴趣：</h4>
                    <div class="tableLeft">
                        <table width="704" cellpadding="0" cellspacing="0">
                            <tr>                                                 
                                <th class="txtl" width="242">计划名称</th>
                                <th>出发地</th>
                                <th>目的地</th>
                                <th class="txtl" width="72">出发时间</th>
                                <th width="136">发布人</th>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="../images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td class="txtl" width="242"><a href="#" title="">南京游</a></td>
                                <td>山东枣庄</td>
                                <td>河北石家庄</td>
                                <td class="txtl" width="72">9月10号</td>
                                <td width="136"><span class="travelerPic"><img src="<c:url value="images/icon-member.png"/>"></span><span class="travelerName">小小海洋</span></td>
                            </tr>
                            <tr>
                                <td colspan="5" class="stepBtns"><input type="button" class="orangeBtns Btns6em" name="" value="<< 返回上一步" /><input type="button" class="orangeBtns Btns7em" name="" value="继续发布新计划" /></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <!--第三步-->
                
                    <div class="jiebanFabuContent faBuThirdStep hide">
                        <form id="createAccompyStep3"><!--url:createAccompyStep3-->
                        <div class="tableLeft">
                            <ul>
                                <li><label>计划名称：</label><input type="text" class="text text01" value="Test" name="acc_name"/></li>
                                <li><label>出游方式：</label>
                                    <select name="acc_type">
                                        <option value="0">自助游</option>
                                        <option value="1">自驾游</option>
                                        <option value="2" >登山</option>
                                        <option value="3">徒步</option>
                                        <option value="4">跟团</option>
                                    </select>
                                    <label>需要导游/伴游的方式：</label>
                                    <select name="acc_acctype">
                                        <option value="0">多日陪同</option>
                                        <option value="1">当日</option>
                                    </select></li>
                                <!--时间只传数字--><li>
                                    <label>出游日期：</label>
                                    <input class="text text02" name="acc_traveltime_year"  value="2013"/> 年 -
                                    <input class="text text02"  name="acc_traveltime_month" value="5"/> 月- 
                                    <input class="text text02"  name="acc_traveltime_day" value="1"/> 日 
                                    <label><span class="fwnormal">大约：</span></label> <input type="text" value="5" name="acc_travelduration" class="text text02" /> <label><span class="fwnormal">天</span> </label>
                                </li>
                                <!--时间只传数字--><li><label>报名截止日期：</label>
                                    <input class="text text02" name="acc_deadline_year" value="2013"/> 年 -
                                    <input class="text text02"  name="acc_deadline_month" value="2"/> 月- 
                                    <input class="text text02"  name="acc_deadline_day" value="1"/> 日
                                    <label>性别要求：</label>
                                    <select name="acc_sex"><option value="0">男</option><option value="1">女</option>
                                    </select>
                                    <label>邀请人数：</label><input class="text text02" name="acc_amount" value="5"/>
                                </li>
                                <li>
                                    <label>费用支付时间及方式：</label>
                                    <select name="acc_feetype">
                                        <option value="网站担保">网站担保</option>
                                        <option value="活动前支付">活动前支付</option>
                                        <option value="活动后支付">活动后支付</option>
                                    </select>
                                </li>
                            </ul>
                            <ul>
                                <!--<li><input type="radio" class="radio" /> <label>聘请导游</label> <input type="radio" class="radio" /> <label>不聘请导游/伴游</label></li>-->
                                <li><label class="colorOrange">对导游和伴游其他要求：</label></li>
                                <li>
                                    <label>年龄：</label><select name="acc_age">
                                        <option value="18-22岁">18-22岁</option>
                                        <option value="23-27岁">23-27岁</option>
                                        <option value="28-32岁">28-32岁</option>
                                        <option value="33-37岁">33-37岁</option>
                                        <option value="37-41岁">37-41岁</option>
                                        <option value="41-45岁">41-45岁</option>
                                        <option value="45-49岁">45-49岁</option>
                                        <option value="49-59岁">49-59岁</option>
                                        <option value="59-69岁">59-69岁</option>
                                        <option value="69-79岁">69-79岁</option>
                                        <option value="79-89岁">79-89岁</option></select>
                                    <label>身高：</label><select name="acc_height">
                                        <option value="140-145cm">140-145cm</option>
                                        <option value="145-150cm">145-150cm</option>
                                        <option value="150-155cm">150-155cm</option>
                                        <option value="155-160cm">155-160cm</option>
                                        <option value="160-165cm">160-165cm</option>
                                        <option value="165-170cm">165-170cm</option>
                                        <option value="170-175cm">170-175cm</option>
                                        <option value="175-180cm">175-180cm</option>
                                        <option value="180-190cm">180-190cm</option>
                                        <option value="190cm以上">190cm以上</option>
                                    </select>
                                    <label>体重：</label><select  name="acc_weight">
                                        <option value="40-45kg">40-45kg</option>
                                        <option value="45-50kg">45-50kg</option>
                                        <option value="50-55kg">50-55kg</option>
                                        <option value="55-60kg">55-60kg</option>
                                        <option value="60-65kg">60-65kg</option>
                                        <option value="65-70kg">65-70kg</option>
                                        <option value="70-75kg">70-75kg</option>
                                        <option value="75-80kg">75-80kg</option>
                                        <option value="80-85kg">80-85kg</option>
                                        <option value="85-90kg">85-90kg</option>
                                        <option value="90-100kg">90-100kg</option>
                                        <option value="100kg以上">100kg以上</option></select>
                                </li>
                                <li>
                                    
                                    <label>语言能力：</label><select name="acc_language"><option value="英语6级">英语6级</option></select>
                                    <label>商务公关要求：</label><select name="acc_businessrequirement"><option value="有">有</option>
                                        <option value="无">无</option></select>
                                </li>
                                
                                <li>
                                    <label>学历要求：</label><select name="acc_education"><option value="初中">初中</option>
                                        <option value="高中">高中</option>
                                        <option value="中专">中专</option>
                                        <option value="大专">大专</option>
                                        <option value="本科">本科</option>
                                        <option value="硕士">硕士</option>
                                        <option value="博士">博士</option>
                                        <option value="博士以上">博士以上</option>
                                    </select>
                                    <label>签证要求：</label><select name="acc_passport"><option value="阿尔巴尼亚">阿尔巴尼亚</option>
                                        <option value="阿尔及利亚">阿尔及利亚</option>
                                        <option value="阿富汗">阿富汗</option>
                                        <option value="阿根廷">阿根廷</option>
                                        <option value="阿联酋">阿联酋</option>
                                        <option value="阿曼">阿曼</option>
                                        <option value="阿塞拜疆">阿塞拜疆</option>
                                        <option value="埃及">埃及</option>
                                        <option value="埃塞俄比亚">埃塞俄比亚</option>
                                        <option value="爱尔兰">爱尔兰</option>
                                        <option value="爱沙尼亚">爱沙尼亚</option>
                                        <option value="安道尔">安道尔</option>
                                        <option value="安哥拉">安哥拉</option>
                                        <option value="奥地利">奥地利</option>
                                        <option value="澳大利亚">澳大利亚</option>
                                        <option value="巴布亚新几内亚">巴布亚新几内亚</option>
                                        <option value="巴哈马">巴哈马</option>
                                        <option value="巴基斯坦">巴基斯坦</option>
                                        <option value="巴拉圭">巴拉圭</option>
                                        <option value="巴勒斯坦">巴勒斯坦</option>
                                        <option value="巴林">巴林</option>
                                        <option value="巴拿马">巴拿马</option>
                                        <option value="巴西">巴西</option>
                                        <option value="白俄罗斯">白俄罗斯</option>
                                        <option value="保加利亚">保加利亚</option>
                                        <option value="北马里亚纳群岛">北马里亚纳群岛</option>
                                        <option value="贝宁">贝宁</option>
                                        <option value="比利时">比利时</option>
                                        <option value="冰岛">冰岛</option>
                                        <option value="波多黎各">波多黎各</option>
                                        <option value="波黑">波黑</option>
                                        <option value="波兰">波兰</option>
                                        <option value="玻利维亚">玻利维亚</option>
                                        <option value="博茨瓦纳">博茨瓦纳</option>
                                        <option value="不丹">不丹</option>
                                        <option value="布基纳法索">布基纳法索</option>
                                        <option value="朝鲜">朝鲜</option>
                                        <option value="丹麦">丹麦</option>
                                        <option value="德国">德国</option>
                                        <option value="东帝汶">东帝汶</option>
                                        <option value="多哥">多哥</option>
                                        <option value="多米尼加">多米尼加</option>
                                        <option value="俄罗斯">俄罗斯</option>
                                        <option value="厄瓜多尔">厄瓜多尔</option>
                                        <option value="厄立特里亚">厄立特里亚</option>
                                        <option value="法国">法国</option>
                                        <option value="法属波里尼西亚">法属波里尼西亚</option>
                                        <option value="梵蒂冈">梵蒂冈</option>
                                        <option value="菲律宾">菲律宾</option>
                                        <option value="斐济">斐济</option>
                                        <option value="芬兰">芬兰</option>
                                        <option value="哥伦比亚">哥伦比亚</option>
                                        <option value="哥斯达黎加">哥斯达黎加</option>
                                        <option value="格鲁吉亚">格鲁吉亚</option>
                                        <option value="古巴">古巴</option>
                                        <option value="关岛">关岛</option>
                                        <option value="哈萨克斯坦">哈萨克斯坦</option>
                                        <option value="海地">海地</option>
                                        <option value="韩国">韩国</option>
                                        <option value="荷兰">荷兰</option>
                                        <option value="黑山共和国">黑山共和国</option>
                                        <option value="洪都拉斯">洪都拉斯</option>
                                        <option value="吉布提">吉布提</option>
                                        <option value="加拿大">加拿大</option>
                                        <option value="加纳">加纳</option>
                                        <option value="加蓬">加蓬</option>
                                        <option value="柬埔寨">柬埔寨</option>
                                        <option value="捷克">捷克</option>
                                        <option value="津巴布韦">津巴布韦</option>
                                        <option value="喀麦隆">喀麦隆</option>
                                        <option value="卡塔尔">卡塔尔</option>
                                        <option value="科特迪瓦">科特迪瓦</option>
                                        <option value="科威特">科威特</option>
                                        <option value="克罗地亚">克罗地亚</option>
                                        <option value="肯尼亚">肯尼亚</option>
                                        <option value="库克群岛">库克群岛</option>
                                        <option value="拉脱维亚">拉脱维亚</option>
                                        <option value="老挝">老挝</option>
                                        <option value="黎巴嫩">黎巴嫩</option>
                                        <option value="立陶宛">立陶宛</option>
                                        <option value="利比里亚">利比里亚</option>
                                        <option value="利比亚">利比亚</option>
                                        <option value="列支敦士登">列支敦士登</option>
                                        <option value="留尼旺">留尼旺</option>
                                        <option value="卢森堡">卢森堡</option>
                                        <option value="罗马尼亚">罗马尼亚</option>
                                        <option value="马达加斯加">马达加斯加</option>
                                        <option value="马尔代夫">马尔代夫</option>
                                        <option value="马耳他">马耳他</option>
                                        <option value="马来西亚">马来西亚</option>
                                        <option value="马里">马里</option>
                                        <option value="马其顿">马其顿</option>
                                        <option value="马绍尔群岛">马绍尔群岛</option>
                                        <option value="毛里求斯">毛里求斯</option>
                                        <option value="毛里塔尼亚">毛里塔尼亚</option>
                                        <option value="美国">美国</option>
                                        <option value="蒙古国">蒙古国</option>
                                        <option value="孟加拉">孟加拉</option>
                                        <option value="秘鲁">秘鲁</option>
                                        <option value="缅甸">缅甸</option>
                                        <option value="摩洛哥">摩洛哥</option>
                                        <option value="摩纳哥">摩纳哥</option>
                                        <option value="莫桑比克">莫桑比克</option>
                                        <option value="墨西哥">墨西哥</option>
                                        <option value="纳米比亚">纳米比亚</option>
                                        <option value="南非">南非</option>
                                        <option value="尼泊尔">尼泊尔</option>
                                        <option value="尼加拉瓜">尼加拉瓜</option>
                                        <option value="尼日尔">尼日尔</option>
                                        <option value="尼日利亚">尼日利亚</option>
                                        <option value="挪威">挪威</option>
                                        <option value="帕劳">帕劳</option>
                                        <option value="葡萄牙">葡萄牙</option>
                                        <option value="日本">日本</option>
                                        <option value="瑞典">瑞典</option>
                                        <option value="瑞士">瑞士</option>
                                        <option value="萨尔瓦多">萨尔瓦多</option>
                                        <option value="塞尔维亚">塞尔维亚</option>
                                        <option value="塞拉利昂">塞拉利昂</option>
                                        <option value="塞内加尔">塞内加尔</option>
                                        <option value="塞浦路斯">塞浦路斯</option>
                                        <option value="塞舌尔">塞舌尔</option>
                                        <option value="沙特阿拉伯">沙特阿拉伯</option>
                                        <option value="圣马力诺">圣马力诺</option>
                                        <option value="斯里兰卡">斯里兰卡</option>
                                        <option value="斯洛伐克">斯洛伐克</option>
                                        <option value="苏丹">苏丹</option>
                                        <option value="所罗门群岛">所罗门群岛</option>
                                        <option value="索马里">索马里</option>
                                        <option value="索马里兰">索马里兰</option>
                                        <option value="泰国">泰国</option>
                                        <option value="坦桑尼亚">坦桑尼亚</option>
                                        <option value="突尼斯">突尼斯</option>
                                        <option value="土耳其">土耳其</option>
                                        <option value="危地马拉">危地马拉</option>
                                        <option value="委内瑞拉">委内瑞拉</option>
                                        <option value="文莱">文莱</option>
                                        <option value="乌干达">乌干达</option>
                                        <option value="乌克兰">乌克兰</option>
                                        <option value="乌拉圭">乌拉圭</option>
                                        <option value="乌兹别克斯坦">乌兹别克斯坦</option>
                                        <option value="西班牙">西班牙</option>
                                        <option value="希腊">希腊</option>
                                        <option value="新加坡">新加坡</option>
                                        <option value="新喀里多尼亚">新喀里多尼亚</option>
                                        <option value="新西兰">新西兰</option>
                                        <option value="匈牙利">匈牙利</option>
                                        <option value="叙利亚">叙利亚</option>
                                        <option value="牙买加">牙买加</option>
                                        <option value="也门">也门</option>
                                        <option value="伊拉克">伊拉克</option>
                                        <option value="伊朗">伊朗</option>
                                        <option value="以色列">以色列</option>
                                        <option value="意大利">意大利</option>
                                        <option value="印度">印度</option>
                                        <option value="印度尼西亚">印度尼西亚</option>
                                        <option value="英国">英国</option>
                                        <option value="约旦">约旦</option>
                                        <option value="越南">越南</option>
                                        <option value="赞比亚">赞比亚</option>
                                        <option value="智利">智利</option>
                                        <option value="港澳">港澳</option></select>
                                    <label>有无驾照：</label><select name="acc_license"><option value="有">有</option>
                                        <option value="无">无</option></select>
                                </li>
                                <li>
                                    <label>是否需要接机/接站：</label><select name="acc_pick"><option value="是">是</option>
                                        <option value="否">否</option></select>
                                    <label>是否需要备车：</label><select name="acc_car"><option value="是">是</option>
                                        <option value="否">否</option></select>
                                </li>
                            </ul>
                            <ul class="lastUl">
                                <li><label>活动具体安排及其他说明：</label></li>
                                <li class="editorList">
                                    <div class="editor">                                        
                                        <textarea class="editorCont" name="acc_remark">test</textarea>
                                    </div>
                                </li>
                                <li><label class="txtr">隐私设置：</label><select name="acc_userauthority">
                                        <option value="1">VIP会员1级可见</option>
                                        <option value="2">VIP会员2级可见</option>
                                        <option value="3">VIP会员3级可见</option>
                                        <option value="0">任何人</option></select></li>
                                <li><label class="txtr">验证码：</label><input type="text" class="text text03" value="" name="acc_checkword">
                                    <span class="yanZM"><img width="60" height="26" src="<c:url value="/captchaImage"/>" /></span>  看不清，<a href="javascript:;" onclick="tooquAjaxReloadValiPic();" class="colorBlue">换一张</a>
                                </li>
                                <li></li>  
                                <!---->
                            </ul>
                        </div>
                      </form>
                                <button class="write-newplan" id="accompanyStepBtn3" title="发布新计划">发布</button>
                    </div>
                
                <span class="jiebanFabuTips"><img src="<c:url value="images/fabutips.jpg" />" /></span>
            </div>
        </div>
        <!-- end -->
    </div>
</div>