package com.video.edu.me.service;

import com.video.edu.me.dao.VideoClassMapper;
import com.video.edu.me.entity.VideoClass;
import com.video.edu.me.entity.VideoClassExample;
import com.video.edu.me.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class VideoClassService extends BaseService<VideoClass, VideoClassExample> {

    private static final Logger logger = LoggerFactory.getLogger(VideoClassService.class);

    private VideoClassMapper videoClassMapper;

    @Resource
    public void setVideoClassMapper(VideoClassMapper videoClassMapper) {
        this.videoClassMapper = videoClassMapper;
        super.setBaseDao(videoClassMapper);
    }

    public VideoClass getTodayVideoClass(){
        VideoClassExample videoClassExample = new VideoClassExample();
        Date zeroTime = DateUtil.getTodayZeroTime();
        Date zeroNextTime = DateUtil.getTomorrowZeroTime();
        videoClassExample.createCriteria().andStartTimeGreaterThanOrEqualTo(zeroTime).andEndTimeLessThanOrEqualTo(zeroNextTime);
        List<VideoClass> videoClassList = videoClassMapper.selectByExample(videoClassExample);
        if (videoClassList.size() == 0){
            return null;
        }
        return videoClassList.get(0);
    }
}
