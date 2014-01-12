/*jieban page functions*/
$(function(){
	//关闭消息浮窗
	$(".auto-userMessages .auto-userMessages-close").click(function(){
		$(this).parent(".auto-userMessages").hide();
		})
	//消息下拉框 
	$(".userMessagesTips").hover(function(){
		var addtion=$(".userMessagesTips .auto-userMessages").css("display");
		if(addtion=="none"){
			$(this).find(".sub-userMessages").not('.auto-userMessages').show();
			}
		},function(){
			$(this).find(".sub-userMessages").not('.auto-userMessages').hide();
			})
	//用户编辑
	$(".userSystem").hover(function(){
		$('.auto-userMessages').fadeOut(200);
		$(this).find(".sub-userMessages").show();
		},function(){
			$(this).find(".sub-userMessages").hide();
			});
			
	//发布选项卡		
  pageTabs(".jiebanFabuArticleNav li",".jiebanFabuArticleCont .jiebanFabuContent",before,after);
	
	//首页选项卡		
  pageTabs(".indexProTabsNav a",".indexProTabsCont .indexTabsCont",before,after);
	
	//返回顶部
	setBackToTop();
	$(window).bind('scroll resize',setBackToTop)
	$("#container .backTopBtn").click(function() {
			$('html, body').animate({
					scrollTop: "0"
			}, "slow");
    });
	
	$(".pageConfirmBtns .BtnsCancel,.pageConfirm .pageConfirmClose").click(function(){
		$(".pageConfirm,.coverLayer").hide();
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
