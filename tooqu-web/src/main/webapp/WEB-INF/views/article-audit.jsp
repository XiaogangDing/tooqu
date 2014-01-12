<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script>
    
    var currentPage = 1;
    var commentNumber = 0;
    var numberPerPage = 1;
    
    $(document).ready(function(){
        ajaxGetCommentNumber();
        paginate();
        ajaxGetComment();
    });
    
    function post(URL) {
        var temp = document.createElement("form");
        var PARAMS = {article_id : ${article_id}};
        temp.action = URL;
        temp.method = "post";
        temp.style.display = "none";
        for(var x in PARAMS) {
            var opt = document.createElement("textarea");
            opt.name = x;
            opt.value = PARAMS[x];
            temp.appendChild(opt);
        }        
        document.body.appendChild(temp);
        temp.submit();
        return temp;
    }      
    
    function ajaxCreateComment() {
        $.ajax({
            url: "articleComment/create",
            data: {comment : $('#comment').val(), article_id : ${article_id}},
            type: 'post',
            dataType: "json",
            success: function(data) {
                ajaxGetComment();
                commentNumber++;
                changeCommentNumber();
                paginate();
            },
            error: function(data) {
                alert("发送失败!");
            }
        });
    }
    
    function ajaxGetComment() {
        $.ajax({
            url: "getArticleCmtListByPage",
            data: {article_id : ${article_id}, pp : numberPerPage, p : currentPage},
            type: 'post',
            dataType: "json",
            success: function(data) {
                var comElement = document.getElementById("commentlist");
                comElement.innerHTML = "";
                for(var i = 0; i < data.rs.length; i++) {
                    var comment = document.createElement("li");
                    var commentDiv1 = document.createElement("div");
                    commentDiv1.className = "pics";
                    commentDiv1.innerHTML += "<a title='' class='cusPhoto' href='#'><img src='" + data.rs[i].user_portrait + "'/></a>";
                    commentDiv1.innerHTML += "<a class='guanzhu' href='#'></a>";
                    var commentP = document.createElement("p");
                    commentP.className = "weizhixinxi";
                    commentP.innerHTML += "<span class='colorOrange nicheng'>" + data.rs[i].user_name + "</span>";
                    commentP.innerHTML += "<span class='trtr shijian'>" + data.rs[i].article_comment_time + "</span>";
                    var commentDiv2 = document.createElement("div");
                    commentDiv2.id = data.rs[i].article_comment_id;
                    commentDiv2.className = "colorBlack";
                    commentDiv2.innerHTML += data.rs[i].article_comment_content;
                    var commentDiv3 = document.createElement("div");
                    commentDiv3.className = "huifuSec";
                    commentDiv3.innerHTML += "<a href='#' onclick='javascript:ajaxDeleteComment(this);' class='colorBlue'>删除</a>";                
                    comment.appendChild(commentDiv1);
                    comment.appendChild(commentP);
                    comment.appendChild(commentDiv2);
                    comment.appendChild(commentDiv3);
                    comElement.appendChild(comment);
                }
            },
            error: function(data) {
                alert("发送失败!");
            }
        });
    }
    
    function ajaxDeleteComment(element) {
        var comment_id = element.parentNode.previousSibling.id;
        $.ajax({
            url: "articleComment/delete",
            data: {article_comment_id : comment_id},
            type: 'post',
            dataType: "json",
            success: function(data) {
                ajaxGetComment();
                commentNumber--;
                changeCommentNumber();
                paginate();
            },
            error: function(data) {
                alert("发送失败!");
            }
        });
    }
    
    function ajaxGetCommentNumber() {
         $.ajax({
            url: "articleComment/getTotalNumber",
            data: {article_id : ${article_id}},
            type: 'post',
            dataType: "json",
            success: function(data) {
                commentNumber = data.rs;
                changeCommentNumber();
                paginate();
            },
            error: function(data) {
                alert("发送失败!");
            }
        });   
    }
    
    function next_page() {
        if(currentPage*numberPerPage >= commentNumber)
            alert("已经是最后一页了，无法向后翻页");
        else{
            currentPage++;
            ajaxGetComment();
            paginate();
        }
    }
    
    function previous_page() {
        if(currentPage == 1)
            alert("已经是第一页了，无法向前翻页");
        else{
            currentPage--;
            ajaxGetComment();
            paginate();
        }
    }
    
    function changeCommentNumber() {
        var numberElement = document.getElementById("commentNumber");
        numberElement.innerHTML = "全部评论（" + commentNumber + "）";
    }
    
    function paginate() {
        var paginationElement = document.getElementById("pagination");
        paginationElement.className = "pagination flr";
        paginationElement.innerHTML = "";
        if(commentNumber > 0){
            paginationElement.innerHTML += "<a class='sideBtns prev' href='#' onclick='javascript:previous_page();'>&lt; 上一页</a>";
            if(commentNumber <= numberPerPage*10){
                for(var i = 1; i < 1 + commentNumber/numberPerPage; i++){
                    var page = document.createElement("a");
                    page.innerHTML = i;
                    page.setAttribute("onclick", "javascript:changePage(" + i + ");");
                    page.setAttribute("href", "#");
                    if(i == currentPage)
                      page.className = "current";
                    paginationElement.appendChild(page);
                }
            }
            else{
                if(currentPage <= 4){
                    for(var i = 1; i <= currentPage + 2; i++){
                        var page = document.createElement("a");
                        page.innerHTML = i;
                        page.setAttribute("onclick", "javascript:changePage(" + i + ");");
                        page.setAttribute("href", "#");
                        if(i == currentPage)
                            page.className = "current";
                        paginationElement.appendChild(page);
                    }
                    paginationElement.innerHTML += "<span>...</span>";
                    var page = document.createElement("a");
                    var lastPage = 1 + (commentNumber-1)/numberPerPage;
                    page.innerHTML = lastPage;
                    page.setAttribute("onclick", "javascript:changePage(" + lastPage + ");");
                    page.setAttribute("href", "#");
                    paginationElement.appendChild(page);
                }
                else if(currentPage >= (commentNumber-1)/numberPerPage - 2){
                    var page = document.createElement("a");
                    page.innerHTML = 1;
                    page.setAttribute("onclick", "javascript:changePage(" + 1 + ");");
                    page.setAttribute("href", "#");
                    paginationElement.appendChild(page);
                    paginationElement.innerHTML += "<span>...</span>";
                    var lastPage = 1 + (commentNumber-1)/numberPerPage;
                    for(i = currentPage - 2; i <= lastPage; i++){
                        var page = document.createElement("a");
                        page.innerHTML = i;
                        page.setAttribute("onclick", "javascript:changePage(" + i + ");");
                        page.setAttribute("href", "#");
                        if(i == currentPage)
                            page.className = "current";
                        paginationElement.appendChild(page);
                    }
                }
                else{
                    var page1 = document.createElement("a");
                    page1.innerHTML = 1;
                    page1.setAttribute("onclick", "javascript:changePage(" + 1 + ");");
                    page1.setAttribute("href", "#");
                    paginationElement.appendChild(page1);
                    paginationElement.innerHTML += "<span>...</span>";
                    for(i = currentPage - 2; i <= currentPage + 2; i++){
                        var page = document.createElement("a");
                        page.innerHTML = i;
                        page.setAttribute("onclick", "javascript:changePage(" + i + ");");
                        page.setAttribute("href", "#");
                        if(i == currentPage)
                            page.className = "current";
                        paginationElement.appendChild(page);
                    }
                    paginationElement.innerHTML += "<span>...</span>";
                    var page2 = document.createElement("a");
                    var lastPage = 1 + (commentNumber-1)/numberPerPage;
                    page2.innerHTML = lastPage;
                    page2.setAttribute("onclick", "javascript:changePage(" + lastPage + ");");
                    page2.setAttribute("href", "#");
                    paginationElement.appendChild(page2);
                }
            }
            paginationElement.innerHTML += "<a class='sideBtns next' href='#' onclick='javascript:next_page();'>下一页 &gt;</a>";
            var inputPageSpan = document.createElement("span");
            inputPageSpan.innerHTML += "跳至";
            var inputPageSelect = document.createElement("select");
            for(var i = 1; i <= 1 + (commentNumber-1)/numberPerPage; i++){
                var inputPageOption = document.createElement("option");
                inputPageOption.setAttribute("value", i);
                inputPageOption.setAttribute("onclick", "javascript:changePage(" + i + ");");
                inputPageOption.innerHTML += i;
                if(i == currentPage)
                    inputPageOption.setAttribute("selected", "selected");
                inputPageSelect.appendChild(inputPageOption);
            }
            inputPageSpan.appendChild(inputPageSelect);
            inputPageSpan.innerHTML += "页";
            paginationElement.appendChild(inputPageSpan);
        }
    }
    
    function changePage(i) {
        currentPage = i;
        ajaxGetComment();
        paginate();
    }
</script>

<div id="container">
    <div class="icontainer">
        <h3 class="font14 youjiTitle" style="margin-top:20px;"><span class="colorOrange">北京欢乐谷、上海、深圳</span>（审核中...）</h3>
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
                                        <a href="#" class="cusPhoto" title=""><img src="<c:url value="/images/cusphote58.jpg"/>" /></a>
                                        <a href="#" class="cusDengji txtc fwbold">LV.68</a>
                                        <div class="articleAuthorDetails hide">
                                            <div class="fix cusPhotoBg">
                                                <div class="fll">
                                                    <a href="#" class="cusPhotos" title=""><img src="<c:url value="/images/cusphote58.jpg"/>" /></a>
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
                                                    <td><img src="/images/articleauthordetailsdiv.png" /></td>
                                                    <td height="48">
                                                        <a href="#">10</a>
                                                        粉丝 
                                                    </td>
                                                    <td><img src="/images/articleauthordetailsdiv.png" /></td>
                                                    <td height="48">
                                                        <a href="#">10</a>
                                                        游记 
                                                    </td>
                                                    <td><img src="/images/articleauthordetailsdiv.png" /></td>
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
                                <td class="youjiContTd">
                                    <div class="youjiContTitle fix">
                                        <a href="#" class="colorOrange fwbold fll">小小海洋</a>
                                        <span class="timer font12 fwbold fll">2013-09-08</span>
                                        <span class="timer font12 fwbold fll">16:26:23</span>
                                        <p class="flr"><a href="#" class="colorOrange">删除</a><a href="#" class="colorOrange">回复</a></p>
                                    </div>
                                    <div class="youjiContArticle">   
                                        ${content}
                                    </div>
                                    <div class="youjiContJiFen">
                                        <fieldset>
                                            <legend class="font12 colorOrange">获得积分</legend>
                                            <p class="font12">发表游记（审核通过） <span class="colorOrange">+1分</span> <span class="jingpin">精品游记 </span> <span class="colorOrange">+3分</span></p>
                                        </fieldset>
                                    </div>  
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="jiebanFabuInfoTable discuzzTable">
                        <table width="100%" cellspacing="0" cellpadding="1" border="0">
                            <tbody>
                                <tr>
                                    <td width="66" class="leftCusPhoto">
                                        <a title="" class="cusPhoto" href="#"><img src="./images/cusphote58.jpg"></a>
                                        <p class="txtc">昨日之星</p>
                                    </td>
                                    <td>
                                        <div class="jieBanfabuPlun">
                                            <p class="liaoL"><strong>我要回复</strong></p>
                                            <div class="pingLunSection">
                                                <div class="pingLunForm">
                                                    <form>
                                                        <textarea id="comment" name="comment" value=""></textarea>
                                                        <div class="fix">
                                                            <div class="fll">
                                                                <a class="tupian pingLunIcon" href="#"></a>
                                                                <a class="biaoqing pingLunIcon" href="#"></a>
                                                            </div>
                                                            <div class="flr">
                                                                <a class="myEditTomeInfoBtns" href="javascript:" onclick="ajaxCreateComment();">
                                                                    <span>+ 发布</span>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <span class="arrow"></span>
                                            </div>
                                            <p style="margin:8px 0 0;">注：您发表的回复，只有对方自己才能看到</p>
                                            <div class="pingLunCont youjiPingLunCont">
                                                <div class="pingLunContTitle"><strong id="commentNumber" class="font14">全部评论（70）</strong></div> 
                                                <ul id="commentlist">
                                                    <li>
                                                        <div class="pics">
                                                            <a title="" class="cusPhoto" href="#"><img src="./images/cusphote58.jpg"></a>
                                                            <a class="guanzhu" href="#"></a>
                                                        </div>
                                                        <p class="weizhixinxi">
                                                            <span class="colorOrange nicheng">昵称昵称</span>
                                                            <span class="trtr diliweizhi">南京</span>
                                                            <span class="trtr shijian">2012-07-22 06:26</span>
                                                        </p>
                                                        <div class="colorBlack">我刚好在找人一起去丽江和香格里拉，刚毕业一穷学生，预计28号走，一起不？</div>
                                                        <div class="huifuSec"><a href="#" class="colorBlue">回复</a> <span>1</span>楼</div>
                                                    </li>
                                                    <li>
                                                        <div class="pics">
                                                            <a title="" class="cusPhoto" href="#"><img src="./images/cusphote58.jpg"></a>
                                                            <a class="guanzhu" href="#"></a>
                                                        </div>
                                                        <p class="weizhixinxi">
                                                            <span class="colorOrange nicheng">昵称昵称</span>
                                                            <span class="trtr diliweizhi">南京</span>
                                                            <span class="trtr shijian">2012-07-22 06:26</span>
                                                        </p>
                                                        <div class="colorBlack">我刚好在找人一起去丽江和香格里拉，刚毕业一穷学生，预计28号走，一起不？</div>
                                                        <div class="huifuSec"><a href="#" class="colorBlue">回复</a> <span>1</span>楼</div>
                                                    </li>
                                                    <li>
                                                        <div class="pics">
                                                            <a title="" class="cusPhoto" href="#"><img src="./images/cusphote58.jpg"></a>
                                                            <a class="guanzhu" href="#"></a>
                                                        </div>
                                                        <p class="weizhixinxi">
                                                            <span class="colorOrange nicheng">昵称昵称</span>
                                                            <span class="trtr diliweizhi">南京</span>
                                                            <span class="trtr shijian">2012-07-22 06:26</span>
                                                        </p>
                                                        <div class="colorBlack">我刚好在找人一起去丽江和香格里拉，刚毕业一穷学生，预计28号走，一起不？</div>
                                                        <div class="huifuSec"><a href="#" class="colorBlue">回复</a> <span>1</span>楼</div>
                                                    </li>

                                                </ul>
                                                <div class="fix">                                                   
                                                    <div id="pagination" class="pagination flr">
                                                        <a class="sideBtns prev" href="#" onclick="javascript:previous_page();">&lt; 上一页</a>
                                                        <a href="#">1</a>
                                                        <a class="current" href="#">1</a>
                                                        <a href="#">1</a>
                                                        <a href="#">10</a>
                                                        <span>...</span>
                                                        <a href="#">100</a>
                                                        <a class="sideBtns next" href="#" onclick="javascript:next_page();">下一页 &gt;</a>
                                                    </div>
                                                </div> 
                                            </div>
                                        </div>
                                        <a href="#" class="woYaoPinL colorBlue fwbold font14 txtc">发布评论</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--end man-left-->
            <!--start main-right-->
            <div class="cont-main-right flr" style="width:276px;">
                <div class="xiangGuanMD">
                    <p class="title">相关目的地</p>
                    <div>
                        <a href="#"><img src="../../images/youjifenmian.jpg" /></a>
                        <p><a href="#" class="font14 fwbold">北京</a></p>
                        <a href="#" class="orangeBtns colorWhite Btns7em">更多游记和图片&gt;&gt;</a>
                    </div>
                </div>
                <div class="nearlyTravels-border youjiFMcurrent">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">当前游记封面</h3></div>
                        <div class="asideSections txtc">
                            <div class="fMian"><img src="../../images/youjifenmian.jpg" /></div>
                            <a href="#" class="fMiana colorOrange font14 fwbold"><span>设置游记封面&gt;&gt;</span></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--end main-right-->
        </div>
    </div>
</div>