package com.video.edu.me.utils;

import java.util.Map;

public class AdjustEntityParamsUtil {
    public final static String [] USER_USELESS_PARAMS = {"password", "status", "utime", "ctime"};
    public final static String [] COMMON_USELESS_PARAMS = {"id", "utime", "ctime"};
    public final static String [] VIDEO_LIST_USEFUL_PARAMS = {"id", "title"};
    public final static String [] STUDENT_BASE_INFO_PARAMS = {"id", "study_id", "stu_name", "birthday", "phone"};

    public static void removeParams(Map<String, Object> entityMap, String [] paramNames){
        for(String paramName: paramNames){
            if (entityMap.containsKey(paramName)) {
                entityMap.remove(paramName);
            }
        }
    }

    public static void reserveParams(Map<String, Object> entityMap, String [] paramNames){
        for(String key: entityMap.keySet()){
            boolean isExist = false;
            for(String paramName: paramNames){
                if (paramName.equals(key)){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                entityMap.remove(key);
            }
        }
    }
}
