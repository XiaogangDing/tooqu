<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/global.js"></script>
<script src="<c:url value="js/ajax_global.js"/>"></script>
<script>
    $(function(){
       $("#followAccompanyBtn").click(function(){
           $.ajax({
              url:"followAccompany",
              data: {acc_id: "${accompany.aid}"},
                type: 'post',
                dataType: "json",
                success: function(data) {
                    alert("关注成功!");
//                    document.getElementById("followAccompanyBtn").value("已关注");
//                    $("#followAccompanyBtn").addClass("grayBtns").siblings().removeClass("orangeBtns");
                    window.location.reload();
                },
                error: function(data) {
                    alert("关注失败!");
                }

            });
        });

        $("#participateAccompanyBtn").click(function() {
//           var data={};
//           data.acc_id=${accompany.aid};
//           data.number=$('input[name="ParticipateNum"]').val();
//           data.acc_participate_record_remark=$(".ptext").val();

            $.ajax({
                url: "participateAccompany",
                data: {acc_id: "${accompany.aid}",
                    number: $('input[name="ParticipateNum"]').val(),
                    acc_participate_record_remark: $(".ptext").val()},
                type: 'post',
                dataType: "json",
                success: function(data) {
                    alert("报名成功!");
                    window.location.reload();
                },
                error: function(data) {
                    alert("报名失败!");
                }

            });
        });
    });

    function commentAccompany() {
        $.ajax({
            url: "accompanyComment/create",
            data: {acc_id: "${accompany.aid}",
                acc_comment_content: $(".Commenttext").val()},
            type: 'post',
            dataType: "json",
            success: function(data) {
                alert("评论成功!");
                window.location.reload();
            },
            error: function(data) {
                alert("评论失败!");
            }

        });
    }

    function prev_page(current) {
        if (current !== 1) {
            current--;
        }
        location.href = "accompanyDetail?acc_id=${accompany.aid}&p=" + current + "&pp=3";



    }
    function next_page(current, pagenum) {
        if (current !== pagenum) {
            current++;
        }
        location.href = "accompanyDetail?acc_id=${accompany.aid}&p=" + current + "&pp=3";
    }


</script>
<div id="container">
    <div class="icontainer">
        <div class="cont-top fix">
            <div class="title f15 fwbold">结伴旅游</div>
            <!--<a title="" class="colorOrange flr fwbold" href="#"> << 返回上一页 </a>-->
        </div>
        <div class="cont-main fix">
            <!--start main-left-->
            <div class="cont-main-left fll">
                <!--信息发布模块-我看到的-->
                <div class="jiebanFabuInfo">
                    <div class="jiebanFabuInfoTable">
                        <table width="100%" border="0" cellspacing="0" cellpadding="1">
                            <tr>
                                <td width="66" rowspan="13">
                                    <a href="#" class="cusPhoto" title=""><img style="height:60px;width:60px" src="/tooqu/register/uploaded/catch?imagePath=${accompany.creator_user.portrait}" /></a>
                                    <p class="txtc">${accompany.creator_user.name}</p>
                                    <a href="#" class="cusDengji txtc fwbold">LV.68</a>
                                </td>
                                <th width="162">计划名称：</th>
                                <td colspan="3">${accompany.name} <span class="font12">[发布于<span>${accompany.createTime}</span>  浏览<span>51</span>次]</span></td>
                            </tr>
                            <!--<tr>
                                <th width="162">计划类型：</th>
                                <td colspan="3"><span class="colorOrange">聘导游</span></td>
                            </tr>-->
                            <tr>
                                <th width="162">计划时间：</th>
                                <td colspan="3">${accompany.travelTime}</td>
                            </tr>

                            <tr>
                                <th width="162">出发地：</th>
                                <td width="140">${accompany.departure.city}${accompany.departure.county}</td>
                                <th width="166">大约：</th>
                                <td>${accompany.travelduration} 天</td>
                            </tr>
                            <tr>
                                <th width="162">出游方式：</th>
                                <td width="140">${accompany.getTypeStr()}</td>
                                
                                <th width="166">目的地：</th>
                                <td><span class="colorOrange">${accompany.destination.city}${accompany.destination.county}</span></td>
                            </tr>
                            <tr>
                                <th width="162">性别要求：</th>
                                <td width="140">${accompany.getAccSexStr()}</td>
                                <th width="166">需要导游伴有方式：</th>
                                <td>${accompany.getAccTypeStr()}</td>
                            </tr>
                            <tr>
                                <th width="162">报名截止日期：</th>
                                <td width="140">${accompany.deadline}</td>
                                <th width="166">费用支付时间及方式：</th>
                                <td>${accompany.feeType}</td>
                            </tr>

                            <tr>
                                <th width="162"><span class="colorOrange">对导游/伴游的其他要求</span></th>
                                <td width="140"></td>
                                <th width="166"></th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="162">年龄：</th>
                                <td width="140">${accompany.accAge}</td>
                                <th width="166">身高：</th>
                                <td>${accompany.accHeight}</td>
                            </tr>
                            <tr>
                                <th width="162">体重：</th>
                                <td width="140">${accompany.accWeight}</td>
                                
                            </tr>
                            <tr>
                                <th width="162">语言能力：</th>
                                <td width="140">${accompany.accLanguage}</td>
                                <th width="166">学历要求：</th>
                                <td>${accompany.accEducation}</td>
                            </tr>
                            <tr>
                                <th width="162">签证要求：</th>
                                <td width="140">${accompany.accPassport}</td>
                                <th width="166">有无驾照：</th>
                                <td>${accompany.accLicense}</td>
                            </tr>
                            <tr>
                                <th width="162">是否需要接机/接站：</th>
                                <td width="140">${accompany.accPick}</td>
                                <th width="166">是否需要备车：</th>
                                <td>${accompany.accCar}</td>
                            </tr>

                            <tr>
                                <td></td>
                                <td colspan="4" style="padding:10px 0 6px;">
                                    

                                    <c:choose>
                                        <c:when test="${id_follow==0}">
                                            <input type="button" value="+ 关注" name="" id="followAccompanyBtn" class="orangeBtns Btns3em" />
                                        </c:when>
                                        <c:otherwise>
                                            <input type="button" value="已关注" name="" class="grayBtns Btns3em" />
                                        </c:otherwise>
                                    </c:choose>  
                                    
                                </td>
                                
                            <tr>
                                <td></td>
                                <td colspan="4"><br />
                                    <a href="#" class="myEditTomeInfoBtns size2"><span>编辑</span></a>&nbsp; &nbsp; 
                                    <a href="#" class="myEditTomeInfoBtns size2"><span>删除</span></a></td>
                            </tr>
                            </tr>
                        </table>
                    </div>
                    <div class="yiBaoM">
                        <div class="yiBaoMTitle"><span class="font14">已报名：</span> <!--<strong class="colorBlue">GG</strong>（<a href="#">1</a>） &nbsp; <strong class="colorPink">MM</strong>（<a href="#">1</a>）--></div>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                            <thead>
                                <tr>
                                    <th width="100" class="niCheng">昵称</th>
                                    <th width="1" class="fwnormal">|</th>
                                    <th width="110">性别</th>
                                    <th width="1" class="fwnormal">|</th>
                                    <th width="86">同行</th>
                                    <th width="1" class="fwnormal">|</th>
                                    <th class="niCheng">备注</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${accompany_participate_record_list}" var="record">
                                    <tr>
                                    <td class="niCheng" colspan="2"><a class="cusPhotoNiCh" href="#"><img style="height:16px;width: 16px;float:hidden"src="/tooqu/register/uploaded/catch?imagePath=${record.user.portrait}"/></a> ${record.user.name}</td>
                                    <td colspan="2"><strong class="colorBlue">${record.user.getSexStr()}</strong></td>
                                    <td colspan="2">${record.number}</th>
                                    <td class="niCheng"><p class="beiZhu">${record.remark}</p></td>
                                    </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                    <div class="wantJoin">
                        <h4 class="colorBlack fwbold">我也要报名</h4>
                        <form>
                            <ul class="fix">
                                <!--<li><label>性别：</label><div><input class="radio" name="" type="radio" /> 男 &nbsp; <input class="radio" name="" type="radio" /> 女</div></li>-->
                                <li><label>同行：</label><div> <input class="text" value="3" name="ParticipateNum" type="text" /> 人 </div></li>
                                <li><label>备注：</label><div><textarea name="ParticipateRemark" class="ptext">12312123131</textarea></div></li>
                                <li><label>&nbsp;</label><div>
                                        <c:choose>
                                        <c:when test="${if_participate==0}">
                                            <input type="button" id="participateAccompanyBtn" class="orangeBtns Btns3em" name="" value="报名" />
                                        </c:when>
                                        <c:otherwise>
                                            <input type="button" id="participateAccompanyBtn" class="grayBtns Btns3em" name="" value="已报名" />
                                            
                                        </c:otherwise>
                                    </c:choose>
                                    </div></li>
                            </ul>
                        </form>
                    </div>
                    <div class="jiebanFabuInfoTable discuzzTable">
                        <table width="100%" cellspacing="0" cellpadding="1" border="0">
                            <tbody>
                                <tr>
                                    <td width="66" class="leftCusPhoto">
                                        <a title="" class="cusPhoto" href="#"><img style="height:60px;width:60px"src="/tooqu/register/uploaded/catch?imagePath=${sessionScope.user_photo}"/></a>
                                        <p class="txtc">${sessionScope.user_name}</p>
                                    </td>
                                    <td>
                                        <div class="jieBanfabuPlun">
                                            <p class="liaoL">聊聊</p>
                                            <div class="pingLunSection">
                                                <div class="pingLunForm">
                                                    <form>
                                                        <textarea class="Commenttext">加油！</textarea>
                                                        <div class="fix">
                                                            <div class="fll">
                                                                <a class="tupian pingLunIcon" href="#"></a>
                                                                <a class="biaoqing pingLunIcon" href="#"></a>
                                                            </div>
                                                            <div class="flr"><a class="myEditTomeInfoBtns" href="javascript:;" onclick="commentAccompany();"><span>+ 发布</span></a>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <span class="arrow"></span>
                                            </div>
                                            <div class="pingLunCont">
                                                <ul>
                                                    <li>
                                                        <c:forEach items="${accompany_comment_list}" var="accCmt">
                                                            <p>
                                                                <a class="cusPhotoNiCh" href="#"><img style="height:16px;width: 16px;float:hidden"src="/tooqu/register/uploaded/catch?imagePath=${accCmt.from.portrait}"/></a>
                                                                <span class="colorOrange nicheng">${accCmt.from.name}</span>
                                                                <span class="colorOrange">（${accCmt.from.location.province}${accCmt.from.location.city}）</span>
                                                                <span class="colorOrange">${accCmt.createTime}</span>
                                                            </p>
                                                            <div class="colorBlack">${accCmt.content}</div>
                                                        </c:forEach>
                                                        
                                                        <!--<div class="buttons">
                                                            <a href="#">回复</a>
                                                            <a href="#">举报</a>
                                                        </div>-->
                                                    </li>
                                                </ul>
                                                <div class="fix">
                                                    <!--<span class="fll colorDGray">第1-10/<span>38</span>条</span>-->
                                                    <div class="pagination flr">
                                                        <a class="sideBtns prev" href="javascript:;" onclick="prev_page(${currentPage});" >&lt; 上一页</a>
                                                        <c:forEach var="i" begin="1" end="${pageNum}" step="1">
                                                            <c:choose>
                                                                <c:when test="${i==currentPage}">
                                                                    <a id="page1" href="accompanyDetail?acc_id=${accompany.aid}&p=${i}&pp=3" class="current">${i}</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="accompanyDetail?acc_id=${accompany.aid}&p=${i}&pp=3">${i}</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                        <a class="sideBtns next" href="javascript:;" onclick="next_page(${currentPage},${pageNum});" >下一页 &gt;</a>
                                                    </div>
                                                </div> 
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
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
                <div class="nearlyTravels-border traveling">
                    <div class="iasideCont">
                        <div class="asideSecTitle fix"><h3 class="font16 fll">正在扬州旅行的</h3><a href="#" class="colorOrange flr">更多 >></a></div>
                        <div class="asideSections">
                            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                <tr>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                    <td>
                                        <a href="#"><img src="../images/cusphote48.jpg" /></a>
                                        <p><a href="#" class="colorOrange">小小海洋</a></p>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="nearlyTravels-border">
                    <div class="iasideCont">
                        <div class="asideSecTitle"><h3 class="font16">最近出发</h3></div>
                        <div class="asideSections"> 
                            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="../images/cusphoto_16.jpg" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="../images/cusphoto_16.jpg" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="../images/cusphoto_16.jpg" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="../images/cusphoto_16.jpg" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="../images/cusphoto_16.jpg" /><span class="reporterName">小小海洋</span></p>
                                        <p><span>桂林</span> <span>阳朔5日游</span></p>
                                    </td>
                                    <td valign="middle" align="left"><span>08月02日</span> <a href="#" class="colorOrange">出发</a></td>
                                </tr>
                                <tr>
                                    <td valign="top" width="130">
                                        <p class="travelReporter"><img src="../images/cusphoto_16.jpg" /><span class="reporterName">小小海洋</span></p>
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
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                        <li>
                            <a href="#" class="travelsPic" title="travels"><img src="../images/travels.jpg" alt="travels" /></a>
                            <p class="address"><a href="#" title="">凤凰古城</a></p>
                        </li>
                    </ul>
                </div>
            </div>
            <!--end main-right-->
        </div>
    </div>
</div>