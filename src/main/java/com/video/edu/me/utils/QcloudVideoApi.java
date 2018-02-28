package com.video.edu.me.utils;


public class QcloudVideoApi {
    private static final String VIDEO_API_URL = "https://vod.api.qcloud.com/v2/index.php";
    private static final String VIDEO_INFO_PARAMS = "Action=GetVideoInfo&fileId=%s&infoFilter.0=basicInfo&infoFilter.1=transcodeInfo&COMMON_PARAMS";
    private static final String VIDEO_CONVERT_PARAMS = "Action=ConvertVodFile&fileId=%s&isScreenshot=1&isWatermark=1&COMMON_PARAMS";
    private static final String VIDEO_COMMON_PARAMS = "&SecretId=" +
            "&Region=bj" +
            "&Timestamp=%d" +
            "&Nonce=345122" +
            "&Signature=mysignature" +
            "&instanceId=101";

    public static String getVideoInfo(String fileId){
        String res = HttpRequest.sendGet(VIDEO_API_URL, String.format(VIDEO_INFO_PARAMS,fileId));
        return res;
    }
    public static String convertVideo(String fileId){
        String res = HttpRequest.sendGet(VIDEO_API_URL, String.format(VIDEO_CONVERT_PARAMS, fileId));
        return res;
    }

    private String getCommmonParams(){
        return "&SecretId=" + Constants.SECRET_ID + "&Region=bj&Timestamp=%d" +
                "&Nonce=345122" +
                "&Signature=mysignature" +
                "&instanceId=101";
    }
}
