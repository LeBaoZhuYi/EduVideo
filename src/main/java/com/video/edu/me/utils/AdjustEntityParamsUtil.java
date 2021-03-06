package com.video.edu.me.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdjustEntityParamsUtil {
    public final static String[] USER_USELESS_PARAMS = {"password", "utime", "ctime"};
    public final static String[] COMMON_USELESS_PARAMS = {"id", "utime", "ctime"};
    public final static String[] VIDEO_LIST_USELESS_PARAMS = {"route"};
    public final static String[] VIDEO_CLASS_LIST_USEFUL_PARAMS = {"id", "className"};

    public static void removeParams(Map<String, Object> entityMap, String[] paramNames) {
        for (String paramName : paramNames) {
            if (entityMap.containsKey(paramName)) {
                entityMap.remove(paramName);
            }
        }
    }

    public static void reserveParams(Map<String, Object> entityMap, String[] paramNames) {
        List<String> removeKeyList = new ArrayList<>();
        for (String key : entityMap.keySet()) {
            boolean isExist = false;
            for (String paramName : paramNames) {
                if (paramName.equals(key)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                removeKeyList.add(key);
            }
        }
        for (String removeKey : removeKeyList) {
            entityMap.remove(removeKey);
        }
    }
}
