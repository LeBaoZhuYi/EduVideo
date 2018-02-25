package com.video.edu.me.service;

import com.video.edu.me.entity.Video;
import com.video.edu.me.enumeration.VideoStatus;
import com.video.edu.me.qcloud.vod.VodApi;
import com.video.edu.me.qcloud.vod.response.VodBaseResponse;
import com.video.edu.me.qcloud.vod.response.VodUploadCommitResponse;
import com.video.edu.me.utils.BeanLoader;
import com.video.edu.me.utils.Constants;

public class UploadService implements Runnable {
    private int videoId;
    private VideoService videoService;

    public UploadService(int videoId){
        videoService = BeanLoader.getBean(VideoService.class);
        this.videoId = videoId;
    }
    @Override
    public void run() {
        Video video = videoService.selectByPrimaryKey(videoId);
        String fileName = video.getRoute();
        try {
            String filePath = Constants.FILE_PATH + fileName;
            VodApi vodApi = new VodApi(Constants.SECRET_ID, Constants.SECRET_KEY);
            VodBaseResponse vodBaseResponse = vodApi.upload(filePath);
            video.setStatus(VideoStatus.NORMAL.getId());
            video.setRoute(((VodUploadCommitResponse)vodBaseResponse).getFileId());
        } catch (Exception e){
            video.setStatus(VideoStatus.FAILED.getId());
        }
        videoService.updateByPrimaryKey(video);
    }
}
