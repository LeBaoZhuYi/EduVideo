package com.video.edu.me.utils;

import com.video.edu.me.service.VideoService;

public class UploadThread {

    private VideoService videoService;
    private int videoId;
    private int filePath;

    public UploadThread(int videoId, int filePath){
        this.videoId = videoId;
        this.filePath = filePath
    }
}
