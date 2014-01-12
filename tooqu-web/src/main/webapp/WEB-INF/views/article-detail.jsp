    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
   $(function(){
     $('.deleteArticle').click(function() {
         var aid= $(this).attr("myvalue");
         var datas={};
         datas.article_id=aid;
           $.ajax({
                url: "articleDelete",
                data: datas,
                type: 'post',
                dataType: "json",
                
                 success: function(data) {                    
                   location.href ="getArticleByPage";

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
        <div class="youjiCrumbs fix">
            <a href="#">北京游记</a>
            <a href="#">北京游记</a>
            <a href="#">北京游记</a>
            <span>北京游记</span>
        </div>
        <h3 class="font14 youjiTitle">北京欢乐谷、上海、深圳</h3>
        <div class="cont-main fix">
            <!--start main-left-->
            <div class="cont-main-left fll" style="width:690px;">
                <!--信息发布模块-我看到的-->
                <div class="jiebanFabuInfo youjiFabuSelf">
                    <div class="jiebanFabuInfoTable">
                        <table width="100%" border="0" cellspacing="0" cellpadding="1">
                            <tr>
                                <td width="68">
                                    <div class="articleAuthor">
                                        <a href="#" class="cusPhoto" title=""><img src="./images/cusphote58.jpg" /></a>
                                        <a href="#" class="cusDengji txtc fwbold">LV.68</a>
                                        <div class="articleAuthorDetails hide">
                                            <div class="fix cusPhotoBg">
                                                <div class="fll">
                                                    <a href="#" class="cusPhotos" title=""><img src="./images/cusphote58.jpg" /></a>
                                                    <p class="txtc font12">导游 | 结伴</p>
                                                </div>
                                                <div class="zhanghaoDetails fll">
                                                    <p class="fix"><span class="fll">帐号：</span><a href="#" class=" fll colorOrange">小小海洋</a></p>
                                                    <a href="#" class="dangAn">档案</a>
                                                    <div class="fix">
                                                        <a href="#" class="fll faTa yiguanzhu"></a>
                                                        <a href="#" class="flr faTa fasixin"></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <table cellpadding="0" cellspacing="0" width="100%">
                                                <tr>
                                                    <td height="48">
                                                        <a href="#">10</a>
                                                        关注 
                                                    </td>
                                                    <td><img src="./images/articleauthordetailsdiv.png" /></td>
                                                    <td height="48">
                                                        <a href="#">10</a>
                                                        粉丝 
                                                    </td>
                                                    <td><img src="./images/articleauthordetailsdiv.png" /></td>
                                                    <td height="48">
                                                        <a href="#">10</a>
                                                        游记 
                                                    </td>
                                                    <td><img src="./images/articleauthordetailsdiv.png" /></td>
                                                    <td height="48">
                                                        <a href="#">10</a>
                                                        结伴 
                                                    </td>
                                                </tr>
                                            </table>
                                            <div class="jiebanJiHua">
                                                <div>结伴计划：<a href="#" class="colorBrown">结伴计划结伴计划</a></div>
                                                <div><span class="colorBrown">08月04</span> &nbsp; 出发地：<span class="colorBrown">西宁</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <c:forEach items="${article_list}" var="spec">
                                <tr>
                                <td class="youjiContTd">
                                    <div class="youjiContTitle fix">
                                        <a href="#" class="colorOrange fwbold fll">小小海洋</a>
                                        <span class="timer font12 fwbold fll">2013-09-08</span>
                                        <span class="timer font12 fwbold fll">16:26:23</span>
                                        <p class="flr"><a  href="javascript:;" class="colorOrange deleteArticle" myvalue="${spec.aid}">删除</a><a href="#" class="colorOrange">回复</a></p>
                                    </div>
                                    <div class="youjiContArticle">
                                        <table>
                                        
                                  <tr>
                                      <td>${spec.aid}</td>
                                      <td class="td-label">${spec.title}</td>
                                     <td class="td-info">${spec.content}</td>
                                    </tr>
                               
                        </table>
                                    </div>
                                    <div class="youjiContJiFen">
                                        <fieldset>
                                            <legend class="font12 colorOrange">获得积分</legend>
                                            <p class="font12">发表游记（审核通过） <span class="colorOrange">+1分</span> <span class="jingpin">精品游记 </span> <span class="colorOrange">+3分</span></p>
                                        </fieldset>
                                    </div>
                                </td>
                            </tr>
                                 </c:forEach>
                    <div class="pagination"><a href="#" class="sideBtns prev">&lt; 上一页</a><a href="?p=1">1</a><a href="?p=2" class="current">2</a><a href="?p=3">3</a><a href="?p=4">4</a><a href="?p=5">5</a><a href="?p=6">6</a><span>...</span><a href="#">100</a><a href="#" class="sideBtns next">下一页 &gt;</a><span class="total">共100页</span><span>跳到第 <select><option>1</option><option>2</option></select> 页</span></div>
                        </table>
                        <a href="#" class="yiJshoucang"></a>
                        <a href="#" class="faBuXinyouji"><img src="./images/xinyouji.png" alt="发布新游记" /></a>
                    </div>
                    <div class="shenQingVIP">
                        <div>
                            <p class="fwbold"><span class="colorOrange">普通VIP</span>级别以上的用户才能评论</p>
                            <a href="#" class="colorOrange fwbold">马上升级VIP吧&gt;&gt;</a>
                        </div>
                    </div>
                </div>
            </div>
            <!--end man-left-->
            <!--start main-right-->
            <div class="cont-main-right flr" style="width:276px;">
                <div class="xiangGuanMD">
                    <p class="title">相关目的地</p>
                    <div>
                        <a href="#"><img src="./images/youjifenmian.jpg" /></a>
                        <p><a href="#" class="font14 fwbold">北京</a></p>
                        <a href="#" class="orangeBtns colorWhite Btns7em">更多游记和图片&gt;&gt;</a>
                    </div>
                </div>
                <div class="nearlyTravels-border youjiFMcurrent">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">当前游记封面</h3></div>
                        <div class="asideSections txtc">
                            <div class="fMian"><img src="./images/youjifenmian.jpg" /></div>
                            <a href="#" class="fMiana colorOrange font14 fwbold"><span>设置游记封面&gt;&gt;</span></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--end main-right-->
        </div>
    </div>
</div>