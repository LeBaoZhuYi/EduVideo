// 依赖jQuery

function userActionLog(module, opCode, userId, otherInfos) {
    var url = _log_getUrl();
    var resolution = _log_getResolution();
    
    if (!otherInfos) {
        otherInfos = {};
    }
    otherInfos.module = module;
    otherInfos.opCode = opCode;
    otherInfos.userId=userId;
    otherInfos.sessionId=_log_getSessionId();
    
    $.ajax({
        url: url,
        type: 'POST',
        data: otherInfos,
        headers: {
        	"resolution": resolution
        }
    });
}

function userActionLog4Cross(module, opCode, userId, otherInfos) {
    var url = _log_getUrl();
    var resolution = _log_getResolution();
    if (!otherInfos) {
        otherInfos = {};
    }
    otherInfos.module = module;
    otherInfos.opCode = opCode;
    otherInfos.userId=userId;
    otherInfos.sessionId=_log_getSessionId();
    $.ajax({
        url: url,
        type: 'POST',
        data: otherInfos,
        dataType: 'jsonp',
        jsonp: "jsonpcallback",
        headers: {
        	"resolution": resolution
        }
    });
}

function _log_getUrl(){
    return 'http://www.zhixue.com/log/userActionLog/create';
}

function _log_getSessionId(){
    var sessionId=_log_getCookie('tlsysSessionId');
    if(!sessionId){
        sessionId=_log_getCookie('JSESSIONID');
    }
    return sessionId;
}

function _log_getUserId(){
    var userId=_log_getCookie('loginUserName');
    return userId;
}

function _log_getCookie(name){
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)){
        return unescape(arr[2]);
    }else{
        return null;
    }
}

function _log_getResolution(){
	var resolution = window.screen.width +  "*" + window.screen.height;
	return resolution;
}