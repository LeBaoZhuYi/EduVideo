/**
 * Created with JetBrains WebStorm.
 * User: zzwang
 * Date: 14-3-10
 * Time: 下午3:08
 * checkValidCas方法先判断是否在cas登录过，如无登录直接返回fail，如登录过再去校验ticket是否合法，如不合法则返回fail，如合法则返回success
 */
function checkValidCas(casUrl,serviceUrl,timeout,callback){
	if(!timeout){
		timeout=1000;
	}
	var loginURL = casUrl + "/login?service=" + encodeURIComponent(serviceUrl);
	$.ajax({
		url: loginURL,
		type: "GET",
		timeout:timeout,
		dataType: 'jsonp',
		jsonp: "callback",
		crossDomain: true,
		cache: false,
		success: function (html) {
			try{
				html = $.trim(html).replace(/\t/g, '');
				var resultobj = eval("("+html+")");
				if (resultobj && resultobj.result && resultobj.result == "success" && parseInt(resultobj.code) == 1001 && resultobj.data && resultobj.data.st) {
					$.ajax({
						url: serviceUrl,
						type: "POST",
						timeout:timeout,
						data: {"action":"login","ticket":resultobj.data.st},
						cache: false,
						success: function (html) {
							html = $.trim(html).replace(/\t/g, '');
							if(html=="success"){
								callbackProcessors({result: "success", code: "1000", data: "登录成功！"},callback);
							}else{
								callbackProcessors({result: "fail", code: "1000", data: "登录失败！"+html},callback);
							}
						},
						error: function (data) {
							var resultobj = {result: "fail", code: "-3", data: "登录Service失败，出现异常！"};
						}
					});
				}else{
					callbackProcessors({result: "fail", code: "1001", data: "获取st失败！"},callback);
				}
			}catch(e){
				callbackProcessors({result: "fail", code: "-2", data: "代码异常！"},callback);
			}
		},
		error: function (error) {
			callbackProcessors({result: "fail", code: "-1", data: "获取st异常！"},callback);
		}
	});
	
	function callbackProcessors(data,callback){
		if(typeof callback=="function"){
			callback(data);
		}
	}
}
