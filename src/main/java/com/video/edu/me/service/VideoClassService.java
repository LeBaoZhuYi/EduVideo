package com.video.edu.me.service;

import com.video.edu.me.dao.VideoClassMapper;
import com.video.edu.me.entity.VideoClass;
import com.video.edu.me.entity.VideoClassExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zeroTime = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date zeroNextTime = calendar.getTime();
        videoClassExample.createCriteria().andStartTimeGreaterThanOrEqualTo(zeroTime).andEndTimeLessThanOrEqualTo(zeroNextTime);
        List<VideoClass> videoClassList = videoClassMapper.selectByExample(videoClassExample);
        if (videoClassList.size() == 0){
            return null;
        }
        return videoClassList.get(0);
    }
}
