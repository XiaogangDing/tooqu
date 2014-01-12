<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script>
    
    function testmodifyBaseInfo(){
       var datas = {};
        datas.province ="江苏";
        datas.city="无锡市";
        datas.county ="崇安区";
        datas.job ="工人";
        datas.language ="阿富汗语";
        datas.license ="有";
        datas.passport ="有";
        datas.intro ="狂魔";
        datas.phonenum ="111333222";
        datas.qq ="2013";
        
        
        $.ajax({
            url: "modifyPersonalInfo/baseInfo",
            data: datas,
            type: 'post',
            dataType: "json",
            success: function(data) {
                alert(JSON.stringify(data));
                //window.location.reload();
            },
            error: function(data) {
                alert("发送失败!");
            }

        });
    }
    function testmodifyPassword(){
        $.ajax({
            url: "modifyPersonalInfo/password",
            data: {raw_password: 000000,
                new_password:123456},
            type: 'post',
            dataType: "json",
            success: function(data) {
                alert(JSON.stringify(data));
                //window.location.reload();
            },
            error: function(data) {
                alert("发送失败!");
            }

        });
    }
    
    
    function testemptyMySentMessage(){
        $.ajax({
            url: "emptyMySentMessage",
            
            type: 'post',
            dataType: "json",
            success: function(data) {
                alert(JSON.stringify(data));
                //window.location.reload();
            },
            error: function(data) {
                alert("发送失败!");
            }

        });
    }
    
    function testemptyMyReceiveMessage(){
        $.ajax({
            url: "emptyMyReceiveMessage",
            
            type: 'post',
            dataType: "json",
            success: function(data) {
                alert(JSON.stringify(data));
                //window.location.reload();
            },
            error: function(data) {
                alert("发送失败!");
            }

        });
    }
    
    
    
</script>

<div id="container">
    <div class="icontainer">
        <div class="cont-main fix">
            <!--start main-left-->
            <div class="cont-main-left flr">
                <div class="indexBanner" id="indexBanner">
                    <ul id="bigPic">
                        <li><a href="#" title=""><img src="<c:url value="images/indexbanner01.jpg" />" alt="02" /></a></li>
                        <li><a href="#" title=""><img src="<c:url value="images/indexbanner02.jpg" />" alt="01" /></a></li>
                        <li><a href="#" title=""><img src="<c:url value="images/indexbanner01.jpg" />" alt="02" /></a></li>
                        <li><a href="#" title=""><img src="<c:url value="images/indexbanner02.jpg" />" alt="01" /></a></li>
                    </ul>
                    <div id="thumbs"><div></div></div>
                </div>
                    <script type="text/javascript" src="<c:url value="js/plugins/fadeslide.banner.js" />"></script>
                    <div class="indexAdv"><a href="#" title=""><img alt="" src="<c:url value="images/indexbanner.jpg" />" /></a></div>
                <div class="indexHotTreval">
                    <h2>当地游展示</h2>
                    <a href="modifyPersonalInfo" class="shengQXianL">申请线路</a>
                    <div class="indexProTabsNav fix">                                
                        <a href="javascript:;" onclick="testmodifyPassword()" class="current">热门推荐</a>
                        <a href="javascript:;">最新发布</a>
                        <a href="javascript:;">一月热榜 <img src="<c:url value="images/redhoticon.gif" />" /></a>
                    </div>
                    <div class="indexProTabsCont">
                        <div class="indexTabsCont">
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游01</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pagination"><a href="#" class="sideBtns prev">&lt; 上一页</a><a href="#">1</a><a href="#" class="current">1</a><a href="#">1</a><a href="#">1</a><a href="#">1</a><a href="#">1</a><a href="#">10</a><span>...</span><a href="#">100</a><a href="#" class="sideBtns next">下一页 &gt;</a><span class="total">共100页</span><span>跳到第 <select><option>1</option><option>2</option></select> 页</span></div>
                        </div>
                        <div class="indexTabsCont hide">
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游02</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pagination"><a href="#" class="sideBtns prev">&lt; 上一页</a><a href="#">1</a><a href="#" class="current">1</a><a href="#">1</a><a href="#">1</a><a href="#">1</a><a href="#">1</a><a href="#">10</a><span>...</span><a href="#">100</a><a href="#" class="sideBtns next">下一页 &gt;</a><span class="total">共100页</span><span>跳到第 <select><option>1</option><option>2</option></select> 页</span></div>
                        </div>
                        <div class="indexTabsCont hide">
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pro-show fix">
                                <img src="<c:url value="images/indexpics/001.jpg" />" class="fll" />  
                                <div class="pro-show-detail fll">
                                    <p class="pro-show-title">台湾心跳声之旅游</p>
                                    <div class="pro-show-cont">
                                        <p>路线提供作者：<span class="head-img">方天画戟</span>（2013-1-12&nbsp;23:00 ）</p>
                                        <p>服务评价：<span class="eval-num">685</span>预订次数：<em>6</em>次（天数：2天）</p>
                                    </div>
                                    <p class="pro-show-text">十多年前上高中时去爬山玩，山是高约100年前上高中时去爬山玩，山年前上高中时去爬山玩，山年前上高中时去爬山玩约100年前上高中时去爬山玩···</p>
                                </div>
                                <div class="fll view-details">
                                    <p class="pro-show-money"><span class="font28">480</span>元起</p>
                                    <a class="view-pro-details" href="#">查看详情</a>
                                </div>
                            </div>
                            <div class="pagination"><a href="#" class="sideBtns prev">&lt; 上一页</a><a href="#">1</a><a href="#" class="current">1</a><a href="#">1</a><a href="#">1</a><a href="#">1</a><a href="#">1</a><a href="#">10</a><span>...</span><a href="#">100</a><a href="#" class="sideBtns next">下一页 &gt;</a><span class="total">共100页</span><span>跳到第 <select><option>1</option><option>2</option></select> 页</span></div>
                        </div>
                    </div>
                </div>
            </div>
            <!--end man-left-->
            <!--start main-right-->
            <div class="cont-main-right fll">
                <div class="nearlyTravels-border siteNavBar">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">目的地旅游攻略</h3></div>
                        <div class="asideSections">               
                            <a href="#" title="" class="dangji">当季旅游地</a>
                            <a href="#" title="" class="zhuti">主题旅游地</a>
                            <a href="#" title="" class="haibian">最佳海边度假地</a>
                            <a href="#" title="" class="guonei">国内</a>
                            <a href="#" title="" class="yazhou">亚洲</a>
                            <a href="#" title="" class="ouzhou">欧洲</a>
                            <a href="#" title="" class="qitazhou">其它洲</a>
                        </div>
                        <div class="siteNavShadow"></div>
                    </div>
                </div>
                <div class="nearlyTravels-border myTravalPlan">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><span class="font16">计划完美的行程</span></div>
                        <div class="asideSections"> 
                            <form action="#">
                                <input type="radio" class="radio" /> <label>酒店</label>
                                <input type="radio" class="radio" /> <label>景点</label>
                                <input type="radio" class="radio" /> <label>攻略</label>
                                <div class="indexSearch fix">
                                    <input class="text fll" type="text" onblur="if (this.value == '') {
                                                this.value = this.defaultValue;
                                            }" onfocus="if (this.value == this.defaultValue) {
                                                this.value = '';
                                            }" value="输入城市名" />
                                    <input class="submit fll" type="submit" value="" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border gaoduanDaoyou">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">高端导游/伴游</h3></div>
                        <div class="asideSections"> 
                            <table cellpadding="0" cellspacing="0" width="100%">
                                <tr>
                                    <td width="72"><a href="#"><img src="<c:url value="images/cusphoto62.jpg" />" /></a></td>
                                    <td>
                                        <a href="#">逍遥子</a>
                                        <div><span>20</span>岁/<span>168</span>cm <span>杭州</span></div>
                                        <p>享受旅游是人生意义享受旅游是人生意义...    </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="72"><a href="#"><img src="<c:url value="images/cusphoto62.jpg" />" /></a></td>
                                    <td>
                                        <a href="#">逍遥子</a>
                                        <div><span>20</span>岁/<span>168</span>cm <span>杭州</span></div>
                                        <p>享受旅游是人生意义享受旅游是人生意义...    </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="72"><a href="#"><img src="<c:url value="images/cusphoto62.jpg" />" /></a></td>
                                    <td>
                                        <a href="#">逍遥子</a>
                                        <div><span>20</span>岁/<span>168</span>cm <span>杭州</span></div>
                                        <p>享受旅游是人生意义享受旅游是人生意义...    </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="72"><a href="#"><img src="<c:url value="images/cusphoto62.jpg" />" /></a></td>
                                    <td>
                                        <a href="#">逍遥子</a>
                                        <div><span>20</span>岁/<span>168</span>cm <span>杭州</span></div>
                                        <p>享受旅游是人生意义享受旅游是人生意义...    </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="72"><a href="#"><img src="<c:url value="images/cusphoto62.jpg" />" /></a></td>
                                    <td>
                                        <a href="#">逍遥子</a>
                                        <div><span>20</span>岁/<span>168</span>cm <span>杭州</span></div>
                                        <p>享受旅游是人生意义享受旅游是人生意义...    </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="72"><a href="#"><img src="<c:url value="images/cusphoto62.jpg" />" /></a></td>
                                    <td>
                                        <a href="#">逍遥子</a>
                                        <div><span>20</span>岁/<span>168</span>cm <span>杭州</span></div>
                                        <p>享受旅游是人生意义享受旅游是人生意义...    </p>
                                    </td>
                                </tr>
                            </table>
                            <a href="#" class="indexMore">更多导游/伴游>> </a>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border borderNone searchTrevalers">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><span class="font16">寻找旅行家</span></div>
                    </div>
                    <div id="advSlideshow">
                        <a href="#" title=""><img src="<c:url value="images/sidebanner01.jpg" />" height="118" width="230" /></a>
                        <a href="#" title=""><img src="<c:url value="images/sidebanner02.jpg" />" height="118" width="230" /></a>
                        <a href="#" title=""><img src="<c:url value="images/sidebanner03.jpg" />" height="118" width="230" /></a>
                    </div>
                    <div class="iasideCont">
                        <div class="asideSections">
                            <p class="instru">一直以来，西藏就是夙愿。那里美的不真实的天空、清澈的云、辽阔的草原还有和我们生活完全不...</p>
                            <a href="#" class="indexMore slider">全部旅行家&gt;&gt; </a>
                        </div>
                    </div>
                </div>
                                    <script type="text/javascript" src="<c:url value="js/plugins/jquery.KinSlideshow-1.1.js" />"></script>
                <script type="text/javascript">
                                        $(function() {
                                            $("#advSlideshow").KinSlideshow({
                                                intervalTime: 3,
                                                mouseEvent: 'mouseover',
                                                btn: {btn_bgColor: "#fff", btn_bgHoverColor: "#ff8a00", btn_fontColor: "#ff8a00", btn_fontHoverColor: "#fff", btn_borderHoverColor: "#FF0000", btn_borderWidth: 0, btn_bgAlpha: 1}
                                            });
                                        });
                </script>
                <div class="nearlyTravels-border taZhouKan">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">TA周刊</h3></div>
                        <div class="asideSections">
                            <table cellpadding="0" cellspacing="0" width="100%">
                                <tr>
                                    <td><img src="<c:url value="images/tazhoukan.jpg" />" /></td>
                                    <td align="center">
                                        <h4>逍遥子</h4>
                                        <p><span>20</span>岁/<span>168</span>cm <span>杭州</span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">过淡雅、简朴、有文化的生活。做最平凡的人、却简朴、有文化的生简朴、有文化的生简朴、有文化的生简朴、有文化的生简朴</td>
                                </tr>
                            </table>
                            <a class="indexMore slider" href="#">全部TA周刊>> </a>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border borderNone indexJieban">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><span class="font16">结伴旅行</span></div>
                        <a href="/tooqu/accompany/create" class="woyaojieban">我要结伴</a>
                        <div class="asideSections">
                            <dl>
                                <dd><a href="#">自驾澳大利亚领地：去世界中心探险 饮一杯葡萄的时光2012八大最佳寻酒</a></dd>
                                <dd><a href="#">自驾澳大利亚领地：去世界中心</a></dd>
                                <dd><a href="#">自驾澳大利亚领地：去世界中心</a></dd>
                                <dd><a href="#">自驾澳大利亚领地：去世界中心</a></dd>
                                <dd><a href="#">自驾澳大利亚领地：去世界中心</a></dd>
                                <dd><a href="#">自驾澳大利亚领地：去世界中心</a></dd>
                            </dl>
                            <a href="/tooqu/accompany" class="indexMore slider">更多结伴旅行&gt;&gt; </a>
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
                                <td><a href="#">新浪微博 <img src="<c:url value="images/weiboicon.jpg" />" /></a></td>
                            </tr>
                            <tr>
                                <td><a href="#">腾讯微博 <img src="<c:url value="images/qqweiboicon.jpg" />" /></a></td>
                            </tr>
                            <tr>
                                <td><a href="#">豆瓣小站 <img src="<c:url value="images/doubanicon.jpg" />" /></a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
      <a href="javascript:;" class="backTopBtn hide"><img src="<c:url value="images/backtopicon.jpg" />" /></a>
    </div>
</div>
