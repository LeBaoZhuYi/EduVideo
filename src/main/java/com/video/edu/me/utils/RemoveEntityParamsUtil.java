package com.video.edu.me.utils;

import java.util.Map;

public class RemoveEntityParamsUtil {
    public final static String [] USER_USELESS_PARAMS = {"password", "status", "utime", "ctime"};
    public final static String [] VIDEO_USELESS_PARAMS = {"id", "utime", "ctime"};
    public final static String [] VIDEO_List_USEFUL_PARAMS = {"id", "title"};

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
