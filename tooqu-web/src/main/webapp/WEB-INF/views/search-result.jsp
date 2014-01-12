<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    
    function testSearchUserByQQ(){
        $.ajax({
            url: "searchUserByQQ",
            data: {qq: ''},
            type: 'post',
            dataType: "json",
            success: function(data) {
                alert(JSON.stringify(data));
            },
            error: function(data) {
                alert("发送失败!");
            }

        });
    }
    
$(function(){
    
    $("#shengfen3").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        var firstKey;
        $.post('getCityByProvince',{select_province : parm},function(data){           
            $.each(data.rs, function(i,key){
                $("<option value="+ key.city +">"+key.city+"</option>").appendTo($('#shengfen3').next());
                if(i===0){
                  firstKey = key.city; 
                  return  firstKey;
                  }
                });
                $.post('getCountyByCity',{select_city : firstKey},function(advance){
                $('#shiqu3').next().empty();
                $.each(advance.rs, function(i,item){       
                    $("<option value="+ item.county +">"+item.county+"</option>").appendTo($('#shiqu3').next());                 
                    });       
                });
            });           
        });   
   
   $("#shiqu3").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        $.post('getCountyByCity',{select_city : parm},function(data){    
            $.each(data.rs, function(i,key){
                $("<option value="+ key.county +">"+key.county+"</option>").appendTo($('#shiqu3').next());                 
                });       
            });       
       });
      window.onload=function(){
      var pageNum=parseInt("${sessionScope.pageNum}");
      var pageSelect= $("#page_select");    
//      var page1=$("#page1");
      var page2=$("#page2");
      var page3=$("#page3");
      var otherpage=$(".otherpage");
      if(pageNum<2){
         page2.hide(1);
         page3.hide(1);
         otherpage.hide(1);
      }
      else if(pageNum===2){
          page2.show(1);
          page3.hide(1);
          otherpage.hide(1);
      }
      else if(pageNum===3){
           page2.show(1);
           page3.show(1);
          otherpage.hide(1);
      }
      else {
            page2.show(1);
           page3.show(1);
          otherpage.show(1);          
      }
      for (var i=1;i<pageNum+1;i++)
      {
          $("<option value='"+i+"'>"+i+"</option>").appendTo(pageSelect);   
            }
        };
//        alert(document.getElementById("page"+document.getElementsByName("p")[0].value));
  $('.mypageBtns').click(function() {
      var pageIndex=$(this).attr("myvalue");
      var currentBtn=$(this);
      var datas={};
      datas.type=$("select[name=type]").val();
      datas.sex=$("select[name=sex]").val();
      datas.select_province=$("select[name=select_province]").val();
      datas.select_city=$("select[name=select_city]").val();
      datas.select_county=$("select[name=select_county]").val();
      $('input[name="p"]').attr("value",pageIndex);
        $.ajax({
                url: "bannerSearchUserByPage",
                data: datas,
                type: 'post',
                dataType: "json",
                
                 success: function(data) {
                     
//                    alert(JSON.stringify(data));
                    //pageTabs(".jiebanFabuArticleNav a",".jiebanFabuArticleCont .faBuSecondStep",before,after);
                    currentBtn.addClass("current").siblings().removeClass("current");
                    
                    var result=data.rs.test;
                    console.log(data.rs[0].userList[0].user);
                    alert(data.rs[0].userList[0].user);
//                   for(var key in result['userList'])
//                        alert(key);
                    
//                    $(".jiebanFabuArticleCont .faBuSecondStep").show();
//		    $(".jiebanFabuArticleCont .faBuSecondStep").siblings().hide();
                },
                error: function(data) {
                    alert("error");
                }
            });
  
  });
});
function page_index(page){   
//    this.className="current";
    document.getElementsByName("p")[0].value=page;
    document.getElementsByClassName('current').className='';
    document.getElementById("page"+page).className="current";
    document.getElementById('bannerSearchform').submit();
//    alert(document.getElementsByName("p")[0].value);
}
function prev_page(current){
    if(current===1)     
      document.getElementsByName("p")[0].value=current;
    else
      document.getElementsByName("p")[0].value=parseInt(current)-1;   
    document.getElementById('bannerSearchform').submit();
}
function next_page(current,pagenum){
    if(current===pagenum)     
      document.getElementsByName("p")[0].value=current;
    else
      document.getElementsByName("p")[0].value=parseInt(current)+1;   
    document.getElementById('bannerSearchform').submit();
}

</script>

<div id="container">
    <div class="icontainer">
        <div class="cont-main fix">
            <!--start main-left-->
            <div class="cont-main-left fll">
                <div class="innerPagebanner">
                    <img src="/tooqu/images/innerbanner.jpg" border="0" usemap="#Map" />
                    <map name="Map" id="Map">
                        <area shape="rect" coords="557,10,713,69" href="#" alt="扬州旅游攻略" />
                        <area shape="rect" coords="559,81,713,140" href="#" alt="扬州导游/伴游" />
                        <area shape="rect" coords="559,153,715,210" href="#" alt="扬州旅友" />
                        <area shape="rect" coords="561,218,713,277" href="#" alt="扬州游记" />
                    </map>
                </div>
                <div class="nearlyTravels-border borderNone searchResaultTitle">
                    <div class="asideSecTitle"><span class="font16">扬州导游/伴游</span></div>
                </div>
                <div class="order-style innerPageFilterResault">
                    <div class="order-style-title fix">
                        <div class="fll">
                            <span class="fwbold">排序方式：</span>
                            <a href="#" class="fliterTime01">按时间排序<span></span></a>
                            <!--当前选择状态-去除span的hide类-->
                            <a href="#" class="fliterTime02">按发布时间排序<span class="hide"></span></a>
                            <a href="#" class="fliterTime03">按人气排序<span class="hide"></span></a>
                        </div>
                    </div>
                </div>
                <div class="searchFilterResaultSec">
                    <ul class="searchFilterList fix">
                         <c:forEach items="${userList}" var="spec">
                         <li>
                            <a href="#" class="fll hPics"><img style="height:108px;width: 108px;float:hidden" src="/tooqu/register/uploaded/catch?imagePath=${spec.portrait}" /></a>
                            <div class="fll name">
                                <strong class="colorOrange bigName">${spec.name}</strong>
                                <p class="job">导游/伴游 ${spec.name}<img src="/tooqu/images/gaoduan03.jpg" /></p>
                                <div class="details">
                                    <table cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td width="36">${spec.uinfo.birthday}</td>
                                            <td width="50">${spec.uinfo.birthday}</td>
                                            <td width="36">${spec.uinfo.education}</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>职业：</td>
                                            <td>${spec.uinfo.job}</td>
                                            <td>语种：</td>
                                            <td>${spec.uinfo.user_language}</td>
                                        </tr>
                                        <tr>
                                            <td>签证：</td>
                                            <td colspan="3">${spec.uinfo.passport}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="flr discriptions">
                                <strong class="colorOrange" >个性宣言</strong>
                                <p>${spec.uinfo.intro}</p>
                            </div>
                         </li>
                         </c:forEach>                       
                    </ul>
                    <div class="pagination"><a href="javascript:;" onclick="prev_page(${currentPage});" class="sideBtns prev">&lt; 上一页</a>
                        <a id="page1" href="javascript:;"  class="mypageBtns" myvalue="1" >1</a>
                        <a id="page2"href="javascript:;"  class="mypageBtns" myvalue="2">2</a>
                        <a id="page3" href="javascript:;"  class="mypageBtns" myvalue="3">3</a>  
                        <span class="otherpage">...</span>
                        <a class="otherpage" href="javascript:;" onclick="page_index('${pageNum}');">最后一页</a>           
                        <a href="javascript:;" onclick="next_page(${currentPage},${pageNum});" class="sideBtns next">下一页 &gt;</a>
                        <span class="total">共${pageNum}页</span>
                        <span>跳到第 <select id="page_select" onchange="page_index(this.options[this.selectedIndex].value)"></select> 页</span></div>
                </div>
            </div>
            <!--end man-left-->
            <!--start main-right-->
            <div class="cont-main-right flr">
                <div class="nearlyTravels-border innerAsideFilter">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><span class="font16">目的地旅游攻略</span></div>
                        <div class="asideSections">   
                            <form action="advanceSearchUser" method="post"> 
                                <table cellpadding="0" cellspacing="0" border="0" width="100%">  
                                    <tr>
                                        <td width="44" align="right">类型：</td>
                                        <td>
                                            <select name="type">
                                                <option value="1">导游/伴游</option>
                                                <option value="0">游客</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">地区：</td>
                                        <td>
                                            <select name="country">
                                                <option value="中国">中国</option></select>          
                                 
                            <select id="shengfen3" name="province"> 
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
                            <select id="shiqu3"  name="city">
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
                                        <td width="44" align="right">性别：</td>
                                        <td>
                                            <select name="sex">
                                                <option value="0">男</option>
                                                <option value="1">女</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">年龄：</td>
                                        <td>
                                            <select name="age">
                                                <option value="18,20">18-20岁</option>
                                                <option value="20,25">20-25岁</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">身高：</td>
                                        <td>
                                            <select name="height">
                                                <option value="0.0,160.0">低于160cm</option>
                                                <option value="160.0,165.0">160cm-165cm</option>
                                                <option value="165.0,300.0">高于165cm</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">学历：</td>
                                        <td>
                                            <select name="degree">
                                                <option value="本科">本科</option>
                                                <option value="研究生">研究生</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">职业：</td>
                                        <td>
                                            <select name="job">
                                                <option value="IT">IT</option>
                                                <option value="金融">金融</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">语种：</td>
                                        <td>
                                            <select name="language">
                                                <option value="英语">英语</option>
                                                <option value="法语">法语</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">签证：</td>
                                        <td>
                                            <select name="passport">
                                                <option value="有">有</option>
                                                <option value="无">无</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">在线：</td>
                                        <td>
                                            <select>
                                                <option>-请选择-</option>
                                                <option>南京</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">驾照：</td>
                                        <td>
                                            <select name="license">
                                                <option value="有">有</option>
                                                <option value="无">无</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="44" align="right">&nbsp;</td>
                                        <td style="padding:6px 0;">
                                            <input type="submit" value="" class="searchFliter" />
                                        </td>
                                    </tr>
                                </table>
                            </form>           
                        </div>
                    </div>
                    <div class="nearlyTravels-border borderNone jingQueSou">
                        <div class="iasideCont">
                            <div class="asideSecTitle"><h3 class="font16">精确搜索</h3></div>
                            <div class="asideSections">    
                                <form action="#">
                                    <input type="text" class="text" onblur="if (this.value == '') {
                                                this.value = this.defaultValue;
                                            }" onfocus="if (this.value == this.defaultValue) {
                                                this.value = '';
                                            }" value="请输入对方QQ、昵称、手机或MSN" />
                                    <input type="submit" onclick="javascript:testSearchUserByQQ();" class="submit" value="" />
                                </form>           
                            </div>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border searchTrevalers innerAsideTrevalers">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><span class="font16">扬州游记及图片</span></div>
                    </div>
                    <div id="advSlideshow">
                        <a href="#" title=""><img src="../images/sidebanner01.jpg" height="118" width="230" /></a>
                        <a href="#" title=""><img src="../images/sidebanner02.jpg" height="118" width="230" /></a>
                        <a href="#" title=""><img src="../images/sidebanner03.jpg" height="118" width="230" /></a>
                    </div>
                    <div class="iasideCont">
                        <div class="asideSections">
                            <p class="instru">一直以来，西藏就是夙愿。那里美的不真实的天空、清澈的云、辽阔的草原还有和我们生活完全不...</p>
                            <a href="#" class="indexMore slider colorOrange">更多&gt;&gt; </a>
                        </div>
                    </div>
                </div>
                <script type="text/javascript" src="../script/plugins/jquery.KinSlideshow-1.1.js"></script>
                <script type="text/javascript">
                                        $(function() {
                                            $("#advSlideshow").KinSlideshow({
                                                intervalTime: 3,
                                                mouseEvent: 'mouseover',
                                                btn: {btn_bgColor: "#fff", btn_bgHoverColor: "#ff8a00", btn_fontColor: "#ff8a00", btn_fontHoverColor: "#fff", btn_borderHoverColor: "#FF0000", btn_borderWidth: 0, btn_bgAlpha: 1}
                                            });
                                        });
                </script>
                <div class="nearlyTravels-border goAplan">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><span class="font16">即将前往扬州的计划</span></div>
                        <div class="asideSections"> 
                            <table cellpadding="0" cellspacing="0" width="100%">
                                <tr>
                                    <th>名称</th>
                                    <th width="1">|</th>
                                    <th>出发地</th>
                                    <th width="1">|</th>
                                    <th>时间</th>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州台州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州台州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州台州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><span class="colorLGray">扬州台州自游行</span></td>
                                    <td colspan="2"><span class="colorOrange">东莞</span></td>
                                    <td><span class="colorLGray">9月30日</span></td>
                                </tr>
                            </table>
                            <a href="#" class="indexMore slider colorOrange">更多&gt;&gt; </a>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border traveling">
                    <div class="iasideCont">
                        <div class="asideSecTitle fix"><h3 class="font16 fll">正在扬州旅行的</h3></div>
                        <div class="asideSections">
                            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                <tbody><tr>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                        <td>
                                            <a href="#"><img src="../images/cusphote48.jpg"></a>
                                            <p><a href="#" class="colorOrange">小小海洋</a></p>
                                        </td>
                                    </tr>
                                </tbody></table>
                            <a href="#" class="indexMore slider colorOrange">更多&gt;&gt; </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--end main-right-->
        </div>
        <div class="bottomPlaceTable">
            <table cellpadding="0" cellspacing="1" width="100%">
                <tr>
                    <th width="142" style="border-bottom:1px solid #d8d8d8;">热门旅行景点</th>
                    <td style="border-bottom:1px dashed #d8d8d8;"><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a></td>
                </tr>
                <tr>
                    <th width="142" style="border-top:1px solid #f8f8f8;">地图旅行景点</th>
                    <td><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a><a href="#" title="">泰国</a></td>
                </tr>
            </table>
        </div>
        <div class="tooquService">
            <table cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <th width="25%"><strong>旅游服务</strong></th>
                    <th width="25%"><strong>个人服务</strong></th>
                    <th width="25%"><strong>关于图趣网 </strong></th>
                    <th width="25%"><strong>关注图趣网</strong></th>
                </tr>
                <tr>
                    <td class="contTD">
                        <table cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td><a href="#">首页</a></td>
                                <td><a href="#">最新游记</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">定酒店</a></td>
                                <td><a href="#">订机票</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">结伴出游</a></td>
                                <td><a href="#">旅行直播</a></td>
                            </tr>
                        </table>
                    </td>
                    <td class="contTD">
                        <table cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td><a href="#">免费注册</a></td>
                                <td><a href="#">我的途趣</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">消息</a></td>
                                <td><a href="#">订机票</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">结伴出游</a></td>
                                <td><a href="#">设置</a></td>
                            </tr>
                        </table>
                    </td>
                    <td class="contTD">
                        <table cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td><a href="#">加入图趣网团队</a></td>
                                <td><a href="#">版权申明</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">招商与合作</a></td>
                                <td><a href="#">隐私原则</a></td>
                            </tr>
                            <tr>
                                <td><a href="#">关于图趣网</a></td>
                                <td><a href="#">网站地图</a></td>
                            </tr>
                        </table>
                    </td>
                    <td class="contTD">
                        <table cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td><a href="#">新浪微博 <img src="../images/weiboicon.jpg" /></a></td>
                            </tr>
                            <tr>
                                <td><a href="#">腾讯微博 <img src="../images/qqweiboicon.jpg" /></a></td>
                            </tr>
                            <tr>
                                <td><a href="#">豆瓣小站 <img src="../images/doubanicon.jpg" /></a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <a href="javascript:;" class="backTopBtn hide"><img src="../images/backtopicon.jpg" /></a>
    </div>
</div>