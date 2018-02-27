package com.video.edu.me.service;

import com.video.edu.me.entity.Video;
import com.video.edu.me.enumeration.VideoStatus;
import com.video.edu.me.qcloud.vod.VodApi;
import com.video.edu.me.qcloud.vod.response.VodBaseResponse;
import com.video.edu.me.qcloud.vod.response.VodUploadCommitResponse;
import com.video.edu.me.utils.BeanLoader;
import com.video.edu.me.utils.Constants;
import com.video.edu.me.utils.QcloudVideoApi;

public class UploadService implements Runnable {
    private int videoId;
    private VideoService videoService;
    private Video video;

    public UploadService(int videoId){
        videoService = BeanLoader.getBean(VideoService.class);
        this.videoId = videoId;
    }
    @Override
    public void run() {
        video = videoService.selectByPrimaryKey(videoId);
        String fileName = video.getFileName();
        try {
            if (video.getFileName() == null || video.getFileName().equals("")){
                video.setStatus(VideoStatus.WAIT_COMPLETE.getId());
            } else {
                String fileId;
                if (video.getFileId() == null || video.getFileId().equals("")) {
                    String filePath = Constants.FILE_PATH + fileName;
                    VodApi vodApi = new VodApi(Constants.SECRET_ID, Constants.SECRET_KEY);
                    VodBaseResponse vodBaseResponse = vodApi.upload(filePath);
                    fileId = ((VodUploadCommitResponse) vodBaseResponse).getFileId();
                    video.setStatus(VideoStatus.NORMAL.getId());
                    video.setFileId(fileId);
                } else {
                    // 转码
                }
            }
        } catch (Exception e){
            video.setStatus(VideoStatus.FAILED.getId());
        }
        videoService.updateByPrimaryKey(video);
    }
}
