package com.video.edu.me.service;

import com.video.edu.me.dao.VideoMapper;
import com.video.edu.me.entity.Video;
import com.video.edu.me.entity.VideoExample;
import com.video.edu.me.enumeration.VideoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoService extends BaseService<Video, VideoExample> {
    private static final Logger logger = LoggerFactory.getLogger(VideoService.class);

    private VideoMapper videoMapper;

    @Resource
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
        super.setBaseDao(videoMapper);
    }

    public void addWatchTimes(int videoId){
        Video video = videoMapper.selectByPrimaryKey(videoId);
        video.setWatchedTimes(video.getWatchedTimes() + 1);
        videoMapper.updateByPrimaryKey(video);
    }
    
    public List<Video> getAllNotDeletedVideoList(){
        VideoExample videoExample = new VideoExample();
        videoExample.createCriteria().andStatusLessThan(VideoStatus.REMOVED.getId());
        videoExample.setOrderByClause("ctime DESC");
        return videoMapper.selectByExample(videoExample);
    }

    public String getVideoTitleById(int videoId){
        Video video = videoMapper.selectByPrimaryKey(videoId);
        return video.getTitle();
    }
    public boolean create(Video video){
        return 1 == videoMapper.insertSelective(video);
    }
}
