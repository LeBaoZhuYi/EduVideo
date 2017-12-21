/**
 * Created with JetBrains WebStorm.
 * User: zzwang
 * Date: 14-3-10
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 */
(function(window,jQuery){
	var Transcripts = Transcripts || {};
	var elements = elements || {};
	var _loginFailTime = 0;
	var _errorMessage = decodeURI(Request.QueryString("errorMessage"));
	var _webcontainerUrl = "";
	var _loginChangyanUrl = "";
    var _customBanner = false;


	Transcripts.bindData = function () {
		function bindBaseData() {
			$.ajax("./getLoginFailTime/", {
				type: "POST",
				data: {},
				dataType: "json",
				success: function (data) {
					if (data.result = "success") {
						_loginFailTime = data.message;
					}
					getLoginFailTimeCB();
				},
				error: function (request, textStatus, errorThrown) {
					getLoginFailTimeCB();
				}
			});
			
			$.ajax("./login/getModuleUrl/", {
				type: "GET",
				data: {},
                timeout:1000,
				dataType: "json",
				cache: true,
				success: function (data) {
					if (data.result = "success") {
                        _customBanner = true;
						_webcontainerUrl = data.webcontainerUrl;
						_loginChangyanUrl = data.loginChangyanUrl;
						getModuleUrlCB();
                        loadBannerCB();
					}
				},
				complete: function (request, textStatus, errorThrown) {
                    if(!_customBanner) {
                        setBanner();
                    }
				}
			});
				
			function getModuleUrlCB(){
				$.ajax(_webcontainerUrl + "/commonModule/getBannerListForWeb/", {
					type: "GET",
					data: {"tag":"ZX_LOGIN_SCHOOL"},
					dataType:"JSONP",
					cache:true,
					jsonp: 'callback',
					jsonpCallback: "getBannerListForWeb",
					success: function (data) {
						if(data&&data.length>0){
							var html = "";
							for(var i = 0; i < data.length; i++){
								if(i >= 20){
									break;
								}
								html+='<li><a href="javascript:void(0);"><img alt="智学网登陆" src="'+data[i].image+'"/></a></li>';
							}
							elements.schoolList.html(html);
						}
					},
					error: function (request, textStatus, errorThrown) {
					}
				});
			}

            function loadBannerCB() {
                $.ajax(_webcontainerUrl + "/commonModule/getBannerListForWeb/", {
                    type: "GET",
                    data: {"tag":"ZX_LOGIN_BNN"},
                    dataType:"JSONP",
                    timeout:1000,
                    cache:true,
                    jsonp: 'callback',
                    jsonpCallback: "getBannerListForLogin",
                    success: function (data) {
                        if(data&&data.length>0){
                            var html = "";
                            for(var i = 0; i < data.length; i++){
                                if(i >= 20){
                                    break;
                                }
                                html+='<li><a style="background: #fff url(' + data[i].image +
                                    ') no-repeat center center;" href="javascript:void(0);"></a></li>';
                            }
                            if(html) {
                                elements.imgPlay.find(".imgList").html(html);
                            }
                        }
                    },
                    complete: function (request, textStatus, errorThrown) {
                        setBanner();
                    }
                });
            }
		}

		function bindDomainInfo() {
			var _url = window.location.href;
			if (_url.indexOf("whpj.zhixue.com") > -1) {
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_whpj"));
				elements.foot_copyright.html("科大讯飞股份有限公司 版权所有&nbsp;&nbsp;客服电话：400-887-8557");
			} else if (_url.indexOf("hfpj.zhixue.com") > -1) {
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_hfpj"));
				elements.foot_copyright.html("科大讯飞股份有限公司 版权所有&nbsp;&nbsp;客服电话：400-887-8557");
			} else if (_url.indexOf("luyang.zhixue.com") > -1) {
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_luyang"));
				elements.foot_copyright.html("科大讯飞股份有限公司 版权所有&nbsp;&nbsp;客服电话：400-887-8557");
			} else if (_url.indexOf("yuxi.zhixue.com") > -1 || _url.indexOf("zhixue.yuxicloud.cn") > -1) {
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_yuxi"));
                elements.foot_copyright.html("主办单位：玉溪市教育局 承办单位：玉溪市教育局信息办  技术支持：科大讯飞股份有限公司");
			}  else if (_url.indexOf("ybpj.zhixue.com") > -1) {
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_ybpj"));
				elements.foot_copyright.html("主办单位：重庆市渝北区教育委员会 承办单位：重庆市渝北区教育技术装备中心  技术支持：科大讯飞股份有限公司");
			}else if (_url.indexOf("xq1.nceduc.cn") > -1) {
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_xq1"));
				elements.foot_copyright.html("主办单位：南昌市教育局  承办单位：南昌市现代教育技术中心  技术支持：科大讯飞股份有限公司");
			}else if (_url.indexOf("sc.zhixue.com") > -1) {
				//临时屏蔽
				$(".sc_display").hide();
				$(".download_app_box").css({background:"#FFFFFF",height:"0px"});
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_sc"));
				elements.foot_copyright.html("");
			} else if (_url.indexOf("puning.zhixue.com") > -1) {
                elements.head_select.hide();
                elements.headLogo.html(elements.head_imgList.find(".head_logo_tea_puning"));
            } else {
				elements.head_select.show();
				elements.headLogo.html(elements.head_imgList.find(".head_logo_tea"));
				elements.foot_copyright.html("科大讯飞股份有限公司 版权所有&nbsp;&nbsp;客服电话：400-887-8557");
			}
		}

		function getLoginFailTimeCB() {
			//触发密码文本框，判断第一次登陆是否失败。
			elements.txtPassword.focus(function () {
				if (_loginFailTime > 0 && elements.panelImageCode.css("display") == "none") {
					//显示验证码
					elements.imageCode.attr("src", "./login/forgetpwd/getImageCode?token=" + Math.random());
					elements.panelImageCode.show();
				}
			});
			
			var userName = $.cookie("loginUserName");
			elements.divName.hide();
			if (_errorMessage != "null" && _errorMessage != "") {
				elements.errorMsg.html("*" + _errorMessage);
				_errorMessage = "";
			} else {
				elements.errorMsg.html("");
			}
			elements.txtName.val("");
			if (userName) {
				elements.txtUserName.val(userName);
				elements.txtPassword.val("").focus();
			} else {
				elements.txtUserName.val("").focus();
				elements.txtPassword.val("");
			}
		}

		function postOpenUrl(url, args) {
			var _form = $("<form></form>", {
				"id": "tempForm",
				"method": "post",
				"action": url,
				"style": "display:none"
			}).appendTo($("body"));
			for (var i in args) {
				_form.append($("<input>", {"type": "hidden", "name": i, "value": args[i]}));
			}
			_form.trigger("submit");
		}
		
		function setBanner(){
			var IntervalName;
			var imgList=elements.imgPlay.find(".imgList li");
			var bannerIndex=0;
			var bannerCount=imgList.length;	
			for(var i=0;i<bannerCount;i++){
				if(i==0){
					$(imgList[i]).show();
				}else{
					$(imgList[i]).hide();
				}
			}
			if(bannerCount>1){
				var html="";
				for(var i=0;i<bannerCount;i++){
					if(i==0){
						html+='<dd><a tag='+i+' class="active" href="javascript:void(0);"></a></dd>';
					}else{
						html+='<dd><a tag='+i+' href="javascript:void(0);"></a></dd>';
					}
				}
				elements.imgPlay.find(".btnList").html(html);
				var btnList=elements.imgPlay.find(".btnList a");
				bindBannerTime();
				btnList.click(function(){
					var _this=$(this);
					clearInterval(IntervalName);
					bindBannerTime();
					if(_this.hasClass("active")){
						return;
					}
					bannerIndex=_this.attr("tag");
					switchBanner(bannerIndex);
				});
			}
			function bindBannerTime(){
				IntervalName = setInterval(function(){
					bannerIndex++;
					if(bannerIndex>=bannerCount){
						bannerIndex=0;
					}
					switchBanner(bannerIndex);
				},3000);
			}
			
			function switchBanner(index){
				imgList.fadeOut();
				$(imgList[index]).fadeIn();
				btnList.removeClass("active");
				$(btnList[index]).addClass("active");
			}
		}
		
		Transcripts.bindData.login = function(txtUserName, txtPassword, txtImageCode) {
			elements.signup_button.html("正在登录...").css("cursor", "default");
			var params = {
				loginName: txtUserName,
				password: txtPassword,
				code: txtImageCode
			};
			var userId;
			$.ajax("./login/?from=web_login", {
				type: "POST",
				dataType: "json",
				data: params || {},
				success: function (resultInfo) {
					if (resultInfo.result != "success") {
						if (resultInfo.message == "needValidName") {
							elements.divName.show();
							elements.divLogin.hide();
							elements.txtName.val("");
							elements.txtName.focus();
							elements.signup_button.html("登录").css("cursor", "pointer");
							return;
						} else {
							//登录失败，增加验证码
							_loginFailTime = 1;
							elements.imageCode.attr("src", "./login/forgetpwd/getImageCode?token=" + Math.random());
							elements.panelImageCode.show();
							elements.errorMsg.html("*" + resultInfo.message);
							elements.signup_button.html("登录").css("cursor", "pointer");
							return;
						}
					} else if (resultInfo.result == "success") {
						userId = resultInfo.data;
						postOpenUrl("./login.jsp", {"decPwd": "1", "userId": userId, "password": txtPassword, "backUrl": "./login.html", "nextpage": nextpageUrl});
					}
				},
				error: function (request, textStatus, errorThrown) {
					var errorInfo = "";
					//登录失败，增加验证码
					_loginFailTime = 1;
					elements.imageCode.attr("src", "./login/forgetpwd/getImageCode?token=" + Math.random());
					elements.panelImageCode.show();
					try {
						result = eval('(' + request.responseText + ')');
						if (result) {
							errorInfo = "系统请求出错，请稍后重试!";
							//errorInfo = result.message;
						} else {
							errorInfo = "系统请求出错，请稍后重试！";
						}
						elements.errorMsg.html("*" + errorInfo);
						elements.signup_button.html("登录").css("cursor", "pointer");
					} catch (e) {
						elements.errorMsg.html("*系统请求出错，请稍后重试！");
						elements.signup_button.html("登录").css("cursor", "pointer");
					}
				}
			});
		}

		Transcripts.bindData.nameLogin = function (txtUserName, txtPassword, txtName) {
			elements.signup_button.html("正在登录...").css("cursor", "default");
			var params = {
				loginName: txtUserName,
				password: txtPassword,
				name: txtName
			};
			var userId;

			$.ajax("./login/validateName/", {
				type: "POST",
				dataType: "json",
				data: params || {},
				success: function (resultInfo) {
					if (resultInfo.result !== "success") {
						var errorInfo = "";
						errorInfo = resultInfo.message;
						elements.errorMsg.html("*" + errorInfo);
						elements.signup_button.html("登录").css("cursor", "pointer");
						return;
					} else if (resultInfo.result == "success") {
						userId = resultInfo.data;
						postOpenUrl("./login.jsp", {"decPwd": "1", "userId": userId, "password": txtPassword, "backUrl": "./login.html", "nextpage": nextpageUrl});
					}
				},
				error: function (request, textStatus, errorThrown) {
					var errorInfo = "";
					try {
						result = eval('(' + request.responseText + ')');
						if (result) {
							errorInfo = "系统请求出错，请稍后重试！";
							//errorInfo = result.message;
						} else {
							errorInfo = "系统请求出错，请稍后重试！";
						}
						elements.errorMsg.html("*" + errorInfo);
						elements.signup_button.html("登录").css("cursor", "pointer");
					} catch (e) {
						elements.errorMsg.html("*系统请求出错，请稍后重试！");
						elements.signup_button.html("登录").css("cursor", "pointer");
					}
				}
			});
		}
		bindBaseData();
		bindDomainInfo();
	};

	Transcripts.bindBaseEvent = function () {
		elements.container_login.fullpage({
			verticalCentered: false,
			anchors: ['p1', 'p2', 'p3', 'p4', 'p5'],
			navigation: true,
			afterLoad: function(anchorLink,index){
				switch (index){
					case 1:
						elements.btnBackTop.slideUp();
						break;
					case 2:
					case 3:
					case 4:
						elements.btnBackTop.slideDown();
						break;
					case 5:
						elements.btnBackTop.slideDown();
						var options ={
							"app": "tlsysapp",
							"action": "indexScrollScreen",
							"data": "/index/home/#p5"
						};
						setUserAction(options);
						break;
					default :
						break;
				}
			}
		});
		
		//回到顶部
		elements.btnBackTop.click(function (e) {
			$.fn.fullpage.moveTo(1);
		});
		
		elements.imgPlay.height(document.documentElement.clientHeight - 80);
		$(window).resize(function() {
			elements.imgPlay.height(document.documentElement.clientHeight - 80);
		});
		
		elements.signup_button.click(function () {
			if (elements.signup_button.html() == "正在登录...") {
				return;
			}
			var userName = $.trim(elements.txtUserName.val());
			var userPassword = elements.txtPassword.val();
			var txtImageCode = elements.txtImageCode.val();
			if (!userName) {
				elements.errorMsg.html("*用户名不能为空");
				return;
			}
			if (!userPassword) {
				elements.errorMsg.html("*密码不能为空");
				return;
			}
			if (!txtImageCode && $.cookie("loginError") == "userLogin") {
				elements.errorMsg.html("*验证码不能为空");
				return;
			}
			$.cookie("loginUserName", userName, { expires: 7, path: "/"});
			if (elements.divName.is(":hidden") === true) {
				elements.errorMsg.html("");
				Transcripts.bindData.login(userName, userPassword, txtImageCode);
			} else {
				var name = $.trim(elements.txtName.val());
				if (!name) {
					elements.errorMsg.html("*真实姓名不能为空");
					return;
				}
				elements.errorMsg.html("");
				Transcripts.bindData.nameLogin(userName, userPassword, name);
			}
		});
		
		//切换验证码
		elements.imageCode.click(function () {
			elements.imageCode.attr("src", "./login/forgetpwd/getImageCode?token=" + Math.random());
		});
		
		document.onkeydown = function (event) {
			var e = event || window.event || arguments.callee.caller.arguments[0];
			if (e && e.keyCode == 13) { // enter 键
				elements.signup_button.trigger("click");
			}
		};
		
		elements.txtUserName.keyup(function () {
			var text = $.trim($(this).val());
			if (text.length > 30) {
				$(this).empty();
				$(this).val(text.substring(0, 30));
			}
		});
		
		elements.divName.find(".btnReturn").click(function(){
			elements.errorMsg.html("");
			_loginFailTime = 1;
			elements.divName.hide();
			elements.imageCode.attr("src", "./login/forgetpwd/getImageCode?token=" + Math.random());
			elements.divLogin.show();
			elements.txtPassword.focus();
		});
		
		elements.forget_password.click(function () {
			window.open("./login/findPwd");
		});

		elements.regUser.click(function () {
			if(_webcontainerUrl){
				window.open(_webcontainerUrl+"/reg/parent/reg?channel=" + getChannel());
			}else{
				alert("服务异常！");
			}
		});
		
		elements.chanyanLogin.click(function () {
			try {
				userActionLog('rq_web_login','1001',null,{'type':'changyan'});
			} catch (error) {}
			collectBtnInfo(this);
			if(_loginChangyanUrl){
				window.open(_loginChangyanUrl);
			}else{
				alert("服务异常！");
			}
		});
		
		//侧边SHOW绑定，屏蔽在线客服电话
		// elements.rightBtn.find(".aEm").hover(function() {
		// 	$(this).find(".showEm").fadeIn();
		// }, function() {
		// 	$(this).find(".showEm").hide();
		// });

		// 第三方账户登录
		elements.qqLogin.click(function(){
			// 埋点
			try {
				userActionLog('rq_web_login','1001',null,{'type':'qq'});
			} catch (error) {}
			$.get(basePath + "/third/to/qq", function(data){
  				window.location = data;
			});
		});
		
		elements.wechatLogin.click(function(){
			try {
				userActionLog('rq_web_login','1001',null,{'type':'wechat'});
			} catch (error) {}
			$.get(basePath + "/third/to/wechat", function(data){
  				window.location = data;
			});
		});

		elements.weiboLogin.click(function(){
			try {
				userActionLog('rq_web_login','1001',null,{'type':'weibo'});
			} catch (error) {}
			$.get(basePath + "/third/to/weibo", function(data){
  				window.location = data;
			});
		});
	};

    /**
     * 获取渠道号
     * @returns {渠道号}
     */
    function getChannel() {
        var channelKey = "channel";
        var channelMatcher = new RegExp("[\?\&]" + channelKey + "=([^\&]*)(\&?)", "i");
        var channel = location.search.match(channelMatcher);
        if(!channel) {
            channel = document.referrer.match(channelMatcher);
        }
        return channel ? channel[1] : "00";
    }

	$(function () {
		elements.imgPlay = $("#imgPlay");
		elements.head_imgList = $("#head_imgList");
		elements.headLogo = $("#head_logo");
		elements.head_select = $("#head_select");
		elements.foot_copyright = $("#foot_copyright");
		elements.errorMsg = $("#errorMsg");
		elements.divLogin = $("#divLogin");
		elements.txtUserName = $("#txtUserName");
		elements.txtPassword = $("#txtPassword");
		elements.panelImageCode = $("#panelImageCode");
		elements.txtImageCode = $("#txtImageCode");
		elements.imageCode = $("#imageCode");
		elements.forget_password = $("#forget_password");
		elements.divName = $("#divName");
		elements.txtName = $("#txtName");
		elements.signup_button = $("#signup_button");
		elements.rightBtn = $("#rightBtn");
		elements.btnBackTop = $("#btnBackTop");
		elements.regUser = $("#regUser");
		elements.schoolList = $("#schoolList");
		elements.container_login = $("#container_login");
		elements.chanyanLogin = $("#chanyanLogin");
		elements.qqLogin = $('#qq_login_btn');
		elements.wechatLogin = $("#wechat_login_btn");
		elements.weiboLogin = $("#weibo_login_btn");

		Transcripts.bindData();
		Transcripts.bindBaseEvent();
	});
})(window,jQuery);
