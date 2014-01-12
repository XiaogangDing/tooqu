<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div class="icontainer">
        <div class="youjiFaBu fix">
            <div class="fll cont-main-left youjiFaBuTextArea">
                <form action="#">
                    <table cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <td colspan="2">
                                <div class="fix">
                                    <h3 class="fll font14">发布游记</h3>
                                    <a href="#" class="flr ruheFaBu colorBlue"></a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th width="46" align="left"><strong class="font14">标题：</strong></th>
                            <td><input type="text" class="text" /></td>
                        </tr>
                        <tr>
                            <th width="46" align="left" valign="top"><strong class="font14">标题：</strong></th>
                            <td><textarea class="youjiContent" name="youjiContent"></textarea></td>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <td><strong class="font14">隐私设置：</strong>
                                <select>
                                    <option>VIP会员1级可见</option>
                                    <option>VIP会员2级可见</option>
                                    <option>VIP会员3级可见</option>
                                    <option>无</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <td>
                                <input type="submit" class="orangeBtns Btns3em submit" value="发表" />
                                <button class="grayBtns BtnsCancel">取消</button>
                            </td>
                        </tr>
                    </table>
                </form>
                <link rel="stylesheet" href="js/plugins/kindeditor/themes/default/default.css" />
                <script charset="utf-8" src="js/plugins/kindeditor/kindeditor-min.js"></script>
                <script charset="utf-8" src="js/plugins/kindeditor/lang/zh_CN.js"></script>
                <script>
                    var editor;
                    KindEditor.ready(function(K) {
                        editor = K.create('textarea[name="youjiContent"]', {
                            //uploadJson : '../../script/plugins/kindeditor/jsp/upload_json.jsp',
                            //fileManagerJson : '../../script/plugins/kindeditor/jsp/file_manager_json.jsp',
                            //allowFileManager : true,
                            resizeType: 0,
                            height: 410,
                            width: 670,
                            items: ['image', 'emoticons', '|', 'media']
                        });
                    });
                </script>
            </div>
            <div class="flr cont-main-right youjiFaBuHelp">
                <div class="helpCont">
                    <h4>发表文章小贴士：</h4>
                    <p class="pics">
                        <strong>添加图片</strong>
                        <span>图片将会保存在你的相册中。</span>
                    </p>
                    <p class="howIt">
                        <strong>快速撰写文章内容</strong>
                        <span>1.博客搬家：直接复制自己发表的博客内容，然后粘贴到文字内容填写区即可；目前支持的博客网站：新浪、腾讯、网易、搜狐；</span> 
                        <span>2.Word复制：从Word文档复制文字，然后粘贴到内容填写区，但是不能复制图片。</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>