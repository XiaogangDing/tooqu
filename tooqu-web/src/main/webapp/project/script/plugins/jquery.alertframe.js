/* 
 * name    : jquery.alertframe.js \ contain:div--draggable
 * time    : 2013-03-19
 * version : 1.0 IE6+ and other browser
 *
 * 使用说明 : 
 * 1.适用于动态生成的弹窗效果 
 * 2.点击弹窗生成一下结构
 *   ----蒙层 div.pageCover
 *   ----弹窗模块 div.pageAlert[id] > div.pageAlertTitle && div.pageAlertCont && a.pageAlertClose
 *   ----ajax加载内容模块 div.pageAlertCont
 *   ----每个弹窗生成时会加载相对应 蒙层 div.pageCover[cover=@pageAlert.attr(id)]
 * 3.具体参数设置参考 defaults() 
 *
 \**** **** **** **** **** **** ****\
 * update  : 2013-03-25
 * 添加拖动效果，弹窗动画时间参数，展示方式选择alert/confirm ，按钮参数 
 *
 * update  : 2013-03-25
 * 添加弹窗关闭回调函数 closed(function(){ $.noop(); });
 */

(function($){
	/* alertframe */
	$.fn.alertframe = function(options){
		/*设置传入参数*/
		var defaults = {
			//弹窗id
			alertID:null,
			//弹窗模式：alert / confirm
			displayMode:'confirm',
			//alert弹窗按钮字段
			alertModeSureText:'确定',
			//confirm弹窗按钮字段
			confirmModeSureText:'确定',
			confirmModeCancleText:'取消',
			//弹窗尺寸
			frameWidth:600,
			frameHeight:280,
			//弹窗标题
			frameTitle:"警告",
			//显示效果 normal:show/hide fade:fadeIn/fadeOut slide:slideUp/slideDown
			effects:'fade',
			//弹窗显示关闭延迟时间
			alertOpenTimer:300,
			alertCloseTimer:200,
			//覆盖层背景色
			pageCoverColor:"#000000",
			//覆盖层透明度
			pageCoverOpacity:0.3,
			//模块拖动
			draggable:true,
			//节点操作             
			before:function(){$.noop()},
			after:function(){$.noop()},
			//模块关闭调用
			closed:function(){$.noop()}
			};
		var opts = $.extend(defaults,options,{});
		
		//按钮对象点击事件-委派事件
		this.live("click",function(){
			//创建背景层
			if(!$('body>.pageCover[cover="'+ opts.alertID +'"]').length){
				$("body").append('<div class="pageCover" cover="'+ opts.alertID +'"></div>');
				//追加蒙层样式
				$('body>.pageCover[cover="'+ opts.alertID +'"]').css({position:'fixed',top:0,left:0,'z-index':888,width:'100%',height:'100%','background-color':opts.pageCoverColor,opacity:opts.pageCoverOpacity});
				}else{
					$('body>.pageCover[cover="'+ opts.alertID +'"]').show();
					};
					
			//创建alert模块
			if(!$('body>.pageAlert[id="'+ opts.alertID +'"]').length){
				//追加节点样式
				$("body").append('<div class="pageAlert" id='+ opts.alertID +'><div class="pageAlertTitle">'+ opts.frameTitle +'</div><div class="pageAlertCont"></div><a href="javascript:;" class="pageAlertClose">×</a></div>');
				//展示方式选择
				if(opts.displayMode=="alert"){
					$('body>.pageAlert[id="'+ opts.alertID +'"]').append('<div class="pageAlertBtns"><a href="javascript:;" class="alertModeSure">'+opts.alertModeSureText+'</a></div>');
					}else{
						$('body>.pageAlert[id="'+ opts.alertID +'"]').append('<div class="pageAlertBtns"><a href="javascript:;" class="confirmModeSure">'+opts.confirmModeSureText+'</a><a href="javascript:;" class="confirmModeCancle">'+opts.confirmModeCancleText+'</a></div>');
						};
				//调用before方法
				opts.before();
				$('body>.pageAlert[id="'+ opts.alertID +'"]').css({position:'fixed',top:'46%',left:'50%','z-index':999,'display':'none','margin-top':-(opts.frameHeight/2)+'px','margin-left':-(opts.frameWidth/2)+'px',width:opts.frameWidth,height:opts.frameHeight});
				//弹窗显示效果
				alertEffects();
				//调用after方法
				opts.after();
				}else{
					//弹窗显示效果
					alertEffects();
					};
			});
					
		//弹窗出现效果
		function alertEffects(){
			var pageAlert=$('body>.pageAlert[id="'+ opts.alertID +'"]');
			//是否需要拖动效果
			if(opts.draggable){
				pageAlert.draggable({handle:pageAlert.find(".pageAlertTitle")});
				};
			switch(opts.effects){
				case 'normal':pageAlert.show();
				break;
				case 'fade':pageAlert.fadeIn(opts.alertOpenTimer);
				break;
				case 'slide':pageAlert.slideDown(opts.alertOpenTimer);
				break;
				};	
			};
		//关闭弹窗	
		$(".pageAlert[id="+ opts.alertID +"] .pageAlertClose,.pageAlert[id="+ opts.alertID +"] .alertModeSure,.pageAlert[id="+ opts.alertID +"] .confirmModeCancle").live('click',function(){
			var pageAlert=$('body>.pageAlert[id="'+ opts.alertID +'"]');
			//模块关闭前函数调用
			opts.closed();
			//关闭效果
			switch(opts.effects){
				case 'normal':pageAlert.hide();
				break;
				case 'fade':pageAlert.fadeOut(opts.alertCloseTimer);
				break;
				case 'slide':pageAlert.slideUp(opts.alertCloseTimer);
				break;
				};	
			$("body>.pageCover[cover="+ opts.alertID +"]").fadeOut(180);
			});	  
	  };	
		
	/* div--draggable */
	$.fn.draggable = function(opt) {
			opt = $.extend({ handle : "", cursor : "move" }, opt);
			var $el = null;
			if (opt.handle === "") {
					$el = this;
			} else if (opt.handle instanceof jQuery) {
					$el = opt.handle;
			} else {
					$el = this.find(opt.handle);
			}

			return $el.css('cursor', opt.cursor).bind("mousedown", function(e) {
					var $drag = null;
					if (opt.handle === "") {
							$drag = $(this).addClass('draggable');
					} else {
							$drag = $(this).addClass('active-handle').parent().addClass('draggable');
					}
					var z_idx = $drag.css('z-index');
					var drg_h = $drag.outerHeight();
					var drg_w = $drag.outerWidth();
					var pos_y = $drag.offset().top + drg_h - e.pageY;
					var pos_x = $drag.offset().left + drg_w - e.pageX;
					$drag.css('z-index', 1000).parents().bind("mousemove", function(e) {
							$('.draggable').offset({ top : e.pageY + pos_y - drg_h, left : e.pageX + pos_x - drg_w })
											.bind("mouseup", function() {
													$(this).removeClass('draggable').css('z-index', z_idx);
											});
					});
					e.preventDefault(); // disable selection
			}).bind("mouseup", function() {
					if (opt.handle === "") {
							$(this).removeClass('draggable');
					} else {
							$(this).removeClass('active-handle').parent().removeClass('draggable');
					}
			});
	};	
	})(jQuery);