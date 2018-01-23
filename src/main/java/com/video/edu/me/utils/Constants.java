package com.video.edu.me.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

public class Constants {

    public static String FILE_PATH;

    static{
        Properties prop = System.getProperties();

        String os = prop.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("linux") > -1) {
            FILE_PATH = "/tmp/edu_video/";
        } else if (os != null && os.toLowerCase().indexOf("windows") > -1){
            FILE_PATH = "C:\\Users\\Temp\\EduVideo\\";
        } else{
            throw new RuntimeException("未知的系统环境");
        }
    }

    public static String APP_ID;
    public static String SECRET_ID;
    public static String SECRET_KEY;

    static{
        try {
            Resource resource = new ClassPathResource("/vod.properties");
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            APP_ID = properties.getProperty("appId");
            SECRET_ID = properties.getProperty("secretId");
            SECRET_KEY = properties.getProperty("secretKey");
        } catch (Exception e){
            throw new RuntimeException("有毒");
        }
    }
}
