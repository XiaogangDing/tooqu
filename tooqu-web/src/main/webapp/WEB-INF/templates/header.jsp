<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script>
    $(function(){
    
    $("#shengfen").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        var firstKey;
        $.post('getCityByProvince',{select_province : parm},function(data){           
            $.each(data.rs, function(i,key){
                $("<option value="+ key.city +">"+key.city+"</option>").appendTo($('#shengfen').next());
                if(i==0){
                  firstKey = key.city; 
                  return  firstKey;
                  }
                });
                $.post('getCountyByCity',{select_city : firstKey},function(advance){
                $('#shiqu').next().empty();
                $.each(advance.rs, function(i,item){       
                    $("<option value="+ item.county +">"+item.county+"</option>").appendTo($('#shiqu').next());                 
                    });       
                });
            });           
        });   
   
   $("#shiqu").change(function(){
        $(this).next().empty(); 
        var parm =$(this).val();
        $.post('getCountyByCity',{select_city : parm},function(data){    
            $.each(data.rs, function(i,key){
                $("<option value="+ key.county +">"+key.county+"</option>").appendTo($('#shiqu').next());                 
                });       
            });       
       });
      window.onload=function(){
      var status="${sessionScope.status}";
      var showw=$("#showMessage");
      var iQuickMenu=$(".iQuickMenu");
      if(status==''||status=='logout'){
          showw.hide(1);    
          $("<a href='/tooqu/jumpToLogin' rel='noflow'>登录</a><a href='/tooqu/jumpToRegister' rel='noflow'>注册</a>您好，欢迎来到途趣网!").appendTo(iQuickMenu);
      }
      else{
          showw.show(1);
          $("<td>您好，欢迎来到途趣网!  </td> <td><a href='/tooqu/logout'>退出</a></td>'").appendTo(iQuickMenu);
      }
      };
      
});
</script>
<input type="hidden" name="status"/>
<div id="header">
    <div class="quickMenu">
        <div class="iQuickMenu">
    
        
<!--	String message=(String)session.getAttribute("status");      
	if(message==null||message=="logout")
        {
            message="<a href='/tooqu/jumpToLogin' rel='noflow'>登录</a><a href='/tooqu/jumpToRegister' rel='noflow'>注册</a>您好，欢迎来到途趣网!";
        }
    else{
		message="<td>您好，欢迎来到途趣网!  </td>"+
                        "<td><a href='/tooqu/logout'>退出</a></td>";
	}
	out.println(message);-->
	
           
        </div>
    </div>
    <div class="iheader">
        <h1 class="logo" title="途趣网"><a href="/tooqu" title="途趣网">途趣网</a></h1>
        <div class="fliterSearch">
            <div class="search">
                <form action="bannerSearchUser" id="bannerSearchform" method="POST" >
                    <ul class="fix">
                        <select name="type">
                                <option value="1">导游/伴游</option>
                                <option value="0">游客</option>
                                
                            </select>    
                            <select name="sex">
                                <option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                        <li>
                              
                            
                            <select>
                                <option value="中国">中国</option>
                            </select>                            
                            <select id="shengfen" name="select_province"> 
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
                            <select id="shiqu" name="select_city">
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
                            <select name="select_county">
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
                        </li>
                    </ul>
                    <input id="p" type="hidden" name="p" value="1"/>

                    <input type="submit" class="searchBtn" value="搜索" />
                </form>
            </div>
            <div class="advanced"><p><a href="/tooqu/advanceSearch" rel="noflow">高级搜索</a></p><p><a href="#" rel="noflow">使用帮助</a></p></div>
        </div>
        <div class="nav">
            <ul class="fix">                                                   
                <li class="currentPage"><a href="/tooqu/" title="途趣网">首页</span></a></li>
                <li><a href="/tooqu/accompany" title="途趣网">结伴旅行</a></li>
                <li><a href="#" title="途趣网">直播</a></li>
                <li><a href="jumpToCreateArticle" title="途趣网">酒店</a></li>
                <li><a href="/tooqu/CreateAlbum" title="途趣网">机票</a></li>
                <li><a href="#" title="途趣网">旅行服务</a></li>
                <li><a href="/tooqu/advanceUser" title="途趣网">高端趣友</a></li>
                <li><a href="/tooqu/getArticleByPage" title="途趣网">活动</a></li>
            </ul>
        </div>
        <div id="showMessage">
        <div class="userMessages userMessagesTips">
            <a href="#" class="messageIcon">消息</a>
            <!--下拉效果-->
            <div class="sub-userMessages hide">
                <ul>
                    <li class="firstchild"><a href="#">消息</a></li>
                    <li><a href="#">消息</a></li>
                    <li><a href="#">消息</a></li>
                    <li><a href="#">消息</a></li>
                    <li><a href="#">消息</a></li>
                </ul>
                <span class="subArrow"></span>
            </div>
            <!--end-->
            <!--自动弹出-->
            <div class="sub-userMessages auto-userMessages" style="display: none;">
                <ul>     
                    <li class="firstchild"><span>2条私信</span><a rel="noflow" href="#">查看</a></li>
                    <li><span>2条文章消息</span><a rel="noflow" href="#">查看</a></li>
                    <li><span>2条直播消息</span><a rel="noflow" href="#">查看</a></li>
                    <li><span>2位新粉丝</span><a rel="noflow" href="#">查看</a></li>
                </ul>
                <span class="subArrow"></span>
                <a rel="noflow" class="auto-userMessages-close" href="javascript:;"></a>
            </div>
            <!--end-->
        </div>
        <div class="userMessages userSystem">
                    <!--%

                    String personal_content="";
                    if(name!=""&&name!=null)
		personal_content="<a href='#' class='userSystemIcon'>"+name+"</a>"+
                        "<a href='#' class='userPhotoMini'><img src='' /></a>"+
                         "<span class='division'>&nbsp;</span>"+                     
                          "<div class='sub-userMessages hide'>"+
                           "<ul>"+    
                           " <li class='firstchild'><a href='#'>编辑资料</a></li>"+
                           "<li><a href='#'>设置名片</a></li>"+
                            "<li><a href='#'>设置隐私</a></li>"+
                            "<li><a href='#'>帮助中心</a></li>"+
                            "</ul>"+
                            "<span class='subArrow'></span>";
	out.println(personal_content);
                %>
            <!-->
            
            <a href="#" class="userSystemIcon"><c:out value="${sessionScope.user_name}" default="no value"/></a>
            <a href="#" class="userPhotoMini"><img style="height:16px;width: 16px;float:hidden"src="/tooqu/register/uploaded/catch?imagePath=${sessionScope.user_photo}"/></a>
            
            <span class="division">&nbsp;</span>
            <!--下拉效果-->
            <div class="sub-userMessages hide">
                <ul>    
                    <li class="firstchild"><a href="#">编辑资料</a></li>
                    <li><a href="#">设置名片</a></li>
                    <li><a href="#">设置隐私</a></li>
                    <li><a href="#">帮助中心</a></li>
                </ul>
                <span class="subArrow"></span>
            </div>
            <!--end-->
        </div>
        </div>
    </div>  
</div>
