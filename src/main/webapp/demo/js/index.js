/**
 * 每日任务
 * author hanzhang
 * @date 2016-4-22
 */
(function(window,jQuery){

    // 限制每页人数
    var viewLimit = 2;

    var MissionList =  MissionList || {}
    var elementItem = {};
    var index = 0;
    var intervalIndex = 0;
    var missionCount = 0;

    var MissionList = (function () {
        var MissionList = {
            initElements:function() {
                elementItem.missions = $("div[id^='daily_mission_']");
                elementItem.dailyGroup = $("[group='daily']");
                missionCount = elementItem.missions.length;
                if(missionCount == 0) {
                    elementItem.dailyGroup.hide();
                }
            },
            bindEvents:function() {
                elementItem.missions.hover(function() {
                    clearInterval(intervalIndex);
                }, function(){
                    MissionList.autoRun();
                });
            },
            initView:function(callback) {
                elementItem.comSDaily = $("#com_sDaily");
                $.ajax({
                    url: basePath+"/container/student/daily/",
                    type: "GET",
                    dataType:"json",
					cache:false,
                    success: function(data){
                        if(!data) {
                            return;
                        }
                        if(typeof data == "string") {
                            data = eval("(" + data + ")");
                        }
                        var _html = __sDaily__({
                            missions : data
                        });
                        elementItem.comSDaily.html(_html);
                        if(typeof callback == "function") {
                            callback();
                        }
                    },
                    error:function(){
                    }
                });
            },
            _displayMission : function() {
                elementItem.missions.hide();
                if(missionCount < viewLimit) {
                    elementItem.missions.show();
                } else if(missionCount >= viewLimit) {
                    for(var i = 0; i < viewLimit; i++) {
                        $(elementItem.missions[i]).show();
                    }
                }
            },
            autoRun:function() {
                MissionList._displayMission();
                intervalIndex = setInterval(function(){
                    $(elementItem.missions[index]).hide();
                    $(elementItem.missions[(index + viewLimit) % missionCount]).show();
                    if(index + viewLimit == missionCount){
                        index = 0;
                        MissionList._displayMission();
                    }else{
                        index ++;
                    }
                },3000);
            }
        };
        return MissionList;
    })();
    $(function () {
        MissionList.initView(function() {
            MissionList.initElements();
            MissionList.bindEvents();
            MissionList.autoRun();
        });
    });
})(window,jQuery);