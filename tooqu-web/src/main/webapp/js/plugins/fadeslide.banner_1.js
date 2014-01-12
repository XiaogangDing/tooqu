//fadeslide banner
	var currentImage;
	var currentIndex=-1;
	var interval;
	var myTimer;
	
	function showImage(index){
		if(index<$('#bigPic li').length){
			var indexImage=$('#bigPic li')[index];
				if(currentImage){
					if(currentImage!=indexImage){
						$(currentImage).css('z-index',2);
						clearTimeout(myTimer);
						$(currentImage).fadeOut(400,function(){
							myTimer=setTimeout("showNext()",4600);
							$(this).css({'display':'none','z-index':1})
							});
						}}
					$(indexImage).css({'display':'block','opacity':1});
					currentImage=indexImage;
					currentIndex=index;
					$('#thumbs a').removeClass('active');
					$($('#thumbs a')[index]).addClass('active');
				}
			}
			
			function showNext(){
				var len=$('#bigPic li').length;
				var next=currentIndex<(len-1)?currentIndex+1:0;showImage(next);
			};

$(document).ready(function(){
	if($('#bigPic li').length>1){
		for(var i=1;i<=$('#bigPic li').length;i++){
			$('#thumbs').append('<a href="javascript:;" rel="'+i+'"></a>')
			};
		};
	myTimer=setTimeout("showNext()",4600);
	showNext();
	$('#thumbs a').bind('click',function(e){
		var count=$(this).attr('rel');
		showImage(parseInt(count)-1);
		});
	});
