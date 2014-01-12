<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <div class="registerSteps">
            <div class="registerStepsTitle">（上传头像）</div>
            <div class="registerStep03">  
                <div class="cusImgSelectEdit fix">
                    <form action="#">
                        <div class="defaultPic" style="float: left; width:285px;">
                            <h4>您现在要做的是在下方剪切形象照</h4>
                            <div class="frame" style="width:270px; height:270px; border:1px solid #d8d8d8;">
                                <img id="photo" src="../../images/editpics.jpg" style="width:100%;" />
                            </div>
                            <br />
                            <p class="txtc">支持JPG、JPEG、GIF、BMP和PNG文件，最大4M。</p>
                            <p class="txtc"><input type="checkbox" class="checkbox" />上传的原始照片，在头像相册中显示</p>
                            <br />
                            <div class="submitBtns txtc"><input type="submit" class="submit" value="保存" /> &nbsp; <input type="reset" class="reset" value="取消" /></div>
                            <!--左上角坐标-->
                            <input id="x1" value="-" type="hidden" />
                            <input id="y1" value="-" type="hidden" />
                            <!--右下角坐标-->
                            <input id="x2" value="-" type="hidden" />
                            <input id="y2" value="-" type="hidden" />
                            <!--选区尺寸-->
                            <input id="imgWidth" value="-" type="hidden" />
                            <input id="imgHeight" value="-" type="hidden" />

                        </div>

                        <div class="resizePic" style="float: left; width: 50%;">
                            <div class="fileBtns">
                                <h4>照片不好<a href="javascript:;" class="colorBlue">重新上传</a></h4>
                                <input type="file" value="" />
                            </div>
                            <div class="resizePicCont">
                                <div class="frame" style=" width:216px; height:216x;">
                                    <div id="preview216" style="width:216px; height:216px; overflow: hidden;">
                                        <img  src="../../images/editpics.jpg" />
                                    </div>
                                </div>

                                <div class="frame" style=" width:110px; height:110px;">
                                    <div id="preview110" style=" width:110px; height:110px; overflow: hidden;">
                                        <img  src="../../images/editpics.jpg" />
                                    </div>
                                </div>

                                <div class="frame" style=" width:64px; height:64px;">
                                    <div id="preview64" style="width:64px; height:64px; overflow: hidden;">
                                        <img  src="../../images/editpics.jpg" />
                                    </div>
                                </div>

                                <div class="frame" style=" width:20px; height:20px;">
                                    <div id="preview20" style=" width:20px; height:20px; overflow: hidden;">
                                        <img  src="../../images/editpics.jpg" />
                                    </div>
                                </div>

                                <span class="colorDGray D216">216×216</span>
                                <span class="colorDGray D110">110×110</span>
                                <span class="colorDGray D64">64×64</span>
                                <span class="colorDGray D20">20×20</span>
                                <div class="imgselectTip"><img src="../../images/imgselect_tip.png" /></div>
                            </div>
                        </div>
                    </form>
                    <link rel="stylesheet" type="text/css" href="../../script/plugins/img_select/css/imgareaselect-default.css" />
                    <script type="text/javascript" src="../../script/plugins/img_select/jquery.imgareaselect.min.js"></script>
                    <script type="text/javascript">
                        function preview(img, selection) {
                            if (!selection.width || !selection.height)
                                return;

                            var scaleX = 100 / selection.width;
                            var scaleY = 100 / selection.height;

                            $('#preview216 img').css({
                                width: Math.round(scaleX * 540),
                                height: Math.round(scaleY * 540),
                                marginLeft: -Math.round(scaleX * selection.x1),
                                marginTop: -Math.round(scaleY * selection.y1)
                            });

                            $('#preview110 img').css({
                                width: Math.round(scaleX * 340),
                                height: Math.round(scaleY * 340),
                                marginLeft: -Math.round(scaleX * selection.x1),
                                marginTop: -Math.round(scaleY * selection.y1)
                            });

                            $('#preview64 img').css({
                                width: Math.round(scaleX * 220),
                                height: Math.round(scaleY * 220),
                                marginLeft: -Math.round(scaleX * selection.x1),
                                marginTop: -Math.round(scaleY * selection.y1)
                            });

                            $('#preview20 img').css({
                                width: Math.round(scaleX * 120),
                                height: Math.round(scaleY * 120),
                                marginLeft: -Math.round(scaleX * selection.x1),
                                marginTop: -Math.round(scaleY * selection.y1)
                            });

                            $('#x1').val(selection.x1);
                            $('#y1').val(selection.y1);
                            $('#x2').val(selection.x2);
                            $('#y2').val(selection.y2);
                            $('#imgWidth').val(selection.width);
                            $('#imgHeight').val(selection.height);
                        }

                        $(function() {
                            $('#photo').imgAreaSelect({aspectRatio: '1:1', handles: true,
                                fadeSpeed: 200, onSelectChange: preview});
                            $(".resizePicCont .imgselectTip").click(function() {
                                $(this).hide();
                            });
                        });
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>    