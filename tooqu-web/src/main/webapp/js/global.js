//some common functions
(function($, w) {
    //from the google recaptcha
    /*$.fn.recaptcha = function(op) {
     var el = this;
     if (!el.length) return el;
     if (!$('body').data('recaptcha')) {
     var url = "http://www.google.com/recaptcha/api/js/recaptcha_ajax.js";
     if (location.protocol == 'https:') {
     url.replace("http:", "https:");
     }
     $.getScript(url)
     .done(function() {
     $('body').data('recaptcha', true);
     el.recaptcha(op);
     })
     .fail(function() {
     el.text("Error loading reCAPTCHA!");
     });
     return el;
     }
     if (op == "reload") {
     Recaptcha.reload();
     return el;
     }
     el.each(function() {
     var c = $(this);
     var id = c.attr("id");
     if(!id) {
     id = 'recaptcha-' + Math.random();
     c.attr('id', id);
     }
     Recaptcha.create("6LeUotASAAAAAE9J-h8j9rF6cT7K6OeHTBmESJSR", id, {
     theme: 'white'
     });
     });
     return el;
     };*/

    w.$rpc = function(path, data, success, failure, always) {
        if (path.charAt(0) == '/')
            path = path.substring(1);
        var it = setTimeout(function() {
            showTimeoutDialog();
            req.abort();
        }, 30000);
        var req = $.ajax({
            url: baseUrl + path,
            data: data,
            type: "POST",
            dataType: "json",
            success: function(data) {
                clearTimeout(it);
                if (data.ack == "ok") {
                    if ($.isFunction(success))
                        success(data.rs);
                } else {
                    logger.debug("Request error " + data.ex + ", message: " + data.msg);
                    if ($.isFunction(failure))
                        failure('[' + data.ex + ']' + (data.msg ? data.msg : ''), data.ex);
                }
                if ($.isFunction(always))
                    always();
            },
            error: function(request, status, ex) {
                clearTimeout(it);
                if (request.responseText != '' && status != "abort")
                    showTimeoutDialog();
                logger.error("Request " + path + " failed with status: " + status + ", exception: " + ex);
            }
        });
    }

    $.fn.upload = function(cb, fail) {
        var iframe = this.filter(function() {
            return $(this).is("iframe");
        });
        if (iframe.length == 0)
            return this;
        if (iframe.length > 1)
            iframe = iframe.eq(0);
        var src = iframe.attr('src');
        var onComplete = function() {
            if (iframe.contents().find('title').length) {
                fail(iframe.contents());
            } else if (iframe.contents().find('pre').length) {
                cb(iframe.contents().find('pre').text());
            } else {
                fail(iframe.contents());
            }
            iframe.unbind('load').attr('src', src);
        }
        var elFile = iframe.contents().find('input[type="file"]');
        if (elFile.length != 1)
            return this;
        elFile.change(function() {
            iframe.trigger("uploadfile");
            iframe.contents().find('form').submit();
        }).click();
        iframe.unbind('load').load(onComplete);
        return this;
    };


})(jQuery, window);

$(function() {
   if(!$('#page-upload-photo').length) return;
   $('#upload-button').click(function() {
       $('#user-photo-upload').upload(function(result) {
//           if (result.match(/^\{.*\}$/ig)) {
               alert("success");
               $('.registerStep03').append($('<img style="width: 400px;box-shadow:1px 1px 3px rgba(0,0,0,0.5);"/>').attr("src", baseUrl + '/register/uploaded/catch?imagePath=' + result + "&_=" + Math.random()));
//           }else{
//               alert("文件类型错误！重新上上传");
//           }
       },function() {
           alert("error");
       });
   });
});

/*jieban page functions*/
$(function() {
    //关闭消息浮窗
    $(".auto-userMessages .auto-userMessages-close").click(function() {
        $(this).parent(".auto-userMessages").hide();
    })
    //消息下拉框 
    $(".userMessagesTips").hover(function() {
        var addtion = $(".userMessagesTips .auto-userMessages").css("display");
        if (addtion == "none") {
            $(this).find(".sub-userMessages").not('.auto-userMessages').show();
        }
    }, function() {
        $(this).find(".sub-userMessages").not('.auto-userMessages').hide();
    })
    //用户编辑
    $(".userSystem").hover(function() {
        $('.auto-userMessages').fadeOut(200);
        $(this).find(".sub-userMessages").show();
    }, function() {
        $(this).find(".sub-userMessages").hide();
    });

    

    
 //首页选项卡		
  pageTabs(".indexProTabsNav a",".indexProTabsCont .indexTabsCont",before,after);
 
//返回顶部
	setBackToTop();
	$(window).bind('scroll resize',setBackToTop);
	$("#container .backTopBtn").click(function() {
			$('html, body').animate({
					scrollTop: "0"
			}, "slow");
    });
	//弹窗关闭
	$(".pageConfirmBtns .BtnsCancel,.pageConfirm .pageConfirmClose").click(function(){
		$(".pageConfirm,.coverLayer").hide();
		});    
});

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
});


function pageTabs(obj,tabsCont,before,after){
	$(obj).click(function(){
		if(!$(this).hasClass(".current")){
			$(this).addClass("current").siblings().removeClass("current");
			before();
			$(tabsCont).eq($(this).index()).show();
			$(tabsCont).eq($(this).index()).siblings().hide();
			after();
			}
		});
	};
//setBackToTop
 function setBackToTop() {
        var scrollTop = $(window).scrollTop();
        if (scrollTop > 420) {
            $("#container .backTopBtn").removeClass("hide");
        }
        else {
            $("#container .backTopBtn").addClass("hide");
        }
 }
function before(){
	null;
	};

function after(){
	null;
	};