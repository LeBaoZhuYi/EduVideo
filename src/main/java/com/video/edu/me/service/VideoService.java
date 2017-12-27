package com.video.edu.me.service;

import com.video.edu.me.dao.VideoMapper;
import com.video.edu.me.entity.Video;
import com.video.edu.me.entity.VideoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VideoService extends BaseService<Video, VideoExample> {
    private static final Logger logger = LoggerFactory.getLogger(VideoService.class);

    private VideoMapper videoMapper;

    @Resource
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
        super.setBaseDao(videoMapper);
    }
}
