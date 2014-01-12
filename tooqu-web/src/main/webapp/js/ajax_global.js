/* 
 * 项目：
 * 数据验证插件
 * 注册登陆数据提交 
 * 
 * 时间：2013-05-04
 */

 /* 数据验证插件 */
 
 
/* 注册模块 */
$(function(){
    $('input[name]').focus(function(){
     $(this).css({'border-color':'#7F9DB9','background-color':'#fff'});   
      });
    });

//判断邮箱js
function emailValidation(obj){
    var temp = $(obj);
    var mailValue = $(obj).val();
    //对电子邮件的验证
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!myreg.test(mailValue)){   
        temp.parent("td").find(".inputInfoTips").show();
        temp.parent("td").find(".inputInfoTips span").show();
        temp.parent("td").find(".inputInfoTips img").attr('src',temp.parent("td").find(".inputInfoTips .attentionsIcon").attr("errorsrc"));
           }else{
              temp.parent("td").find(".inputInfoTips").show();
              temp.parent("td").find(".inputInfoTips span").hide();
              temp.parent("td").find(".inputInfoTips img").attr('src',temp.parent("td").find(".inputInfoTips .attentionsIcon").attr("truesrc"));
           };
    };


//判断重复密码
function reIntputPassWord(PassWord,reInput){
    var password = $(PassWord).val();
    var rePassword = $(reInput).val();
    if( password == rePassword ){
        $(PassWord).add(reInput).parent("td").find(".inputInfoTips").show();
        $(PassWord).add(reInput).parent("td").find(".inputInfoTips span").hide();
        $(PassWord).add(reInput).parent("td").find(".inputInfoTips img").attr('src',$(PassWord).parent("td").find(".inputInfoTips .attentionsIcon").attr("truesrc"));
      }else{
          $(PassWord).add(reInput).parent("td").find(".inputInfoTips").show();
          $(PassWord).add(reInput).parent("td").find(".inputInfoTips span").show();
          $(PassWord).add(reInput).parent("td").find(".inputInfoTips img").attr('src',$(PassWord).parent("td").find(".inputInfoTips .attentionsIcon").attr("errorsrc"));
          }
  };

//刷新验证码
function tooquAjaxReloadValiPic(){
    $.get('/tooqu/captchaImage',function(data){
        $(".yanZM img").attr('src','/tooqu/captchaImage');      
        });
    };

//用户名验证		
//正确格式字母数字下划线组合
//禁用汉字
function validataUserName(obj){
	var value=$(obj).val();
	var reg= /[^A-Za-z0-9_]/g ;
	if(!value=="" && !reg.test(value) && value.match(/\D/)){
		trueCallBack("#name");
		}else{
			falseCallBack("#name");
			}
	};

//验证密码长度
function validataPasswordLength(obj){
	var value=$(obj).val();
	$(obj).removeClass("passed");
	if(!value=="" && value.length >= 6){
		$(obj).addClass("passed");
		trueCallBack('#password_data');
		}else{
			falseCallBack('#password_data');
			}
	};

//密码确认
//原始密码包含psssed类
function validataUserPassword(data,obj){
	var oldvalue=$(data).val();
	var value=$(obj).val();
	if(oldvalue == value && $(data).hasClass("passed")){
		trueCallBack('#password');
		}else{
			falseCallBack('#password');
			}
	};

//验证为数字
function validataNumber(obj){
	var value=$(obj).val();
	if(!value.match(/\D/) && !value==""){
		trueCallBack('#number');
		}else{
			falseCallBack('#number');
			};
	};

//验证手机号码
function validataPhoneNumber(obj){
	var value=$(obj).val();
	var RegCellPhone = /^([0-9]{11})?$/;
	if(RegCellPhone.test(value) && !value==""){  
		trueCallBack('#phonenumber');
		}else{
			falseCallBack("#phonenumber");
			};
	};

function trueCallBack(obj){
	$(obj).removeClass("no").addClass("ok");
        $(obj).parent("td").find(".inputInfoTips").show();
        $(obj).parent("td").find(".inputInfoTips span").hide();
        $(obj).parent("td").find(".inputInfoTips img").attr('src',$(obj).parent("td").find(".inputInfoTips .attentionsIcon").attr("truesrc"));
	};

function falseCallBack(obj){
	$(obj).removeClass("ok").addClass("no");
        $(obj).parent("td").find(".inputInfoTips").show();
        $(obj).parent("td").find(".inputInfoTips span").show();
        $(obj).parent("td").find(".inputInfoTips img").attr('src',$(obj).parent("td").find(".inputInfoTips .attentionsIcon").attr("errorsrc"));
          
	};
			 
//表单提交验证
function formValidata(){
	for(var i=0;i<$("#form input[name]").length;i++){
		if($("#form input[name]").eq(i).val()=="" || $("#form input[name]").eq(i).hasClass("no") ){
			$("#form input[name]").eq(i).css({"border":'1px solid red','background-color':'#f99'});
			return false;
			};
		};
	};		
