<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <div class="registerSteps">
            <div class="registerStepsTitle">（填写基本资料）</div>
            <div class="registerStep01 registerStep02">        
                <form action="registerStep2" method="post">
                    <table cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <th><span class="red">*</span>性别：</th>
                            <td>
                                <input type="radio" name="sex"  value="0" checked="checked" /><label>男</label> 
                                &nbsp;
                                <input type="radio" name="sex" value="1" /><label>女</label>
                                <label class="inputInfoTips hide"><img truesrc="../../images/trueinput.jpg" attentionsrc="../../images/attentionsinput.jpg" errorsrc="../../images/errorinput.jpg" class="attentionsIcon" src="<c:url value="images/trueinput.jpg"/>"><span class="colorRed"> 请正确选择此项</span></label>
                            </td>
                        </tr>
                        <tr>
                            <th>出生年月：</th>
                            <td>
                                <input type="text" class="input-text" name="year" style="width:4em;" value="1990" />年 -
                                <input type="text" class="input-text" name="month" style="width:3em;" value="05" />月 -
                                <input type="text" class="input-text" name="day" style="width:3em;" value="01" />日
                            </td>
                        </tr>
                        <tr>
                            <th><span class="red">*</span>常住地：</th>
                            <td>
                                <select name="country">
                                    <option value="中国">中国</option>
                                </select>
                                <select id="shengfen2" name="province">
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
                                    <option value="香港">香港</option> </select>
                                </select>
                                <select id="shiqu2" name="city">
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
                        </tr>
                        <tr>
                            <th>籍贯：</th>
                            <td>
                                <input name="hometown" value="123" type="text" class="input-text" />
                            </td>
                        </tr>
                        <tr>
                            <th><span class="red">*</span>身高：</th>
                            <td>
                                <input name="height" value="160" style="width:3em;" type="text" class="input-text" /> CM                              
                               
                            </td>
                        </tr>
                        <tr>
                            <th><span class="red">*</span>驾照：</th>
                            <td>
                                <select name="license">
                                    <option value="有">有</option>
                                    <option value="无">无</option>
                                </select> 
                            </td>
                        </tr>
                        <tr>
                            <th><span class="red">*</span>学历：</th>
                            <td>
                                <input name="education" value="大学本科" type="text" class="input-text" />                                                  
                            </td>
                        </tr>
                         <tr>
                            <th><span class="red">*</span>语言：</th>
                            <td>
                                <input name="user_language" value="普通话" type="text" class="input-text" />                                                  
                            </td>
                        </tr>
                        <tr>
                            <th><span class="red">*</span>职业：</th>
                            <td><input name="job" value="学生" type="text" class="input-text" /></td>
                        </tr>
                        <tr>
                            <th>签证：</th>
                            <td>
                                <input name="passport" value="港澳通行证" type="text" class="input-text" />                               
                            </td>
                        </tr>                        
                        <tr>
                            <th>手机：</th>
                            <td>
                                <input type="text" value="15399994566" name="phonenum" id="phonenumber" onblur="validataPhoneNumber('#phonenumber')" class="input-text" />
                                <span class="hide">手机验证<a href="#" class="a-blue">发送手机</a></span>
                                <label class="inputInfoTips hide" id="shoePhoneNumber">
                                    <img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                                    <span class="colorRed">请正确输入手机号码</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>QQ/雅虎通/skipe：</th>
                            <td><input type="text" name="qq" value="12312123131" class="input-text" />
                              <label class="inputInfoTips hide" id="yahooInput">
                                  <img src="<c:url value="images/errorinput.jpg"/>" class="attentionsIcon" errorsrc="<c:url value="images/errorinput.jpg"/>" attentionsrc="<c:url value="images/attentionsinput.jpg"/>" truesrc="<c:url value="images/trueinput.jpg"/>" />
                                  <span class="colorRed">请正确输入该选项</span>
                              </label>
                            </td>                       
                        </tr>
                        <tr>
                            <th>个性宣言：</th>
                            <td height="135"><textarea name="intro" class="text">12312123131</textarea></td>
                        </tr>                     
                        <tr>
                            <th>&nbsp;</th>
                            <td><input type="submit" class="btn-next" value="" /></td>
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
        if(msg=="该QQ/Skipe/雅虎通已存在!"){
            $("#yahooInput").show();
            }else if(msg=="该电话已存在!"){
                $("#shoePhoneNumber").show();
                }
        });
</script>

<script>
    $(function(){
    
    $("#shengfen2").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        var firstKey;
        $.post('getCityByProvince',{select_province : parm},function(data){           
            $.each(data.rs, function(i,key){
                $("<option value="+ key.city +">"+key.city+"</option>").appendTo($('#shengfen2').next());
                if(i==0){
                  firstKey = key.city; 
                  return  firstKey;
                  }
                });
                $.post('getCountyByCity',{select_city : firstKey},function(advance){
                $('#shiqu2').next().empty();
                $.each(advance.rs, function(i,item){       
                    $("<option value="+ item.county +">"+item.county+"</option>").appendTo($('#shiqu2').next());                 
                    });       
                });
            });           
        });   
   
   $("#shiqu2").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        $.post('getCountyByCity',{select_city : parm},function(data){    
            $.each(data.rs, function(i,key){
                $("<option value="+ key.county +">"+key.county+"</option>").appendTo($('#shiqu2').next());                 
                });       
            });       
       });
});
</script>