package com.video.edu.me.service;

import com.video.edu.me.dao.VideoClassMapper;
import com.video.edu.me.entity.Student;
import com.video.edu.me.entity.VideoClass;
import com.video.edu.me.entity.VideoClassExample;
import com.video.edu.me.enumeration.VideoClassStatus;
import com.video.edu.me.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class VideoClassService extends BaseService<VideoClass, VideoClassExample> {

    private static final Logger logger = LoggerFactory.getLogger(VideoClassService.class);

    private VideoClassMapper videoClassMapper;
    @Autowired
    private StudentService studentService;

    @Resource
    public void setVideoClassMapper(VideoClassMapper videoClassMapper) {
        this.videoClassMapper = videoClassMapper;
        super.setBaseDao(videoClassMapper);
    }

    public VideoClass getTodayVideoClassByUserId(int userId) {
        Student student = studentService.getStudentByUserId(userId);
        return getTodayVideoClassByGroupId(student.getGroupId());
    }

    public VideoClass getTodayVideoClassByGroupId(int groupId) {
        VideoClassExample videoClassExample = new VideoClassExample();
        Date zeroTime = DateUtil.getTodayZeroTime();
        Date zeroNextTime = DateUtil.getTomorrowZeroTime();
        videoClassExample.createCriteria().andStartTimeGreaterThanOrEqualTo(zeroTime).
                andEndTimeLessThanOrEqualTo(zeroNextTime)
                .andGroupIdEqualTo(groupId);
        List<VideoClass> videoClassList = videoClassMapper.selectByExample(videoClassExample);
        if (videoClassList.size() == 0) {
            return null;
        }
        return videoClassList.get(0);
    }

    public List<VideoClass> getCurrentMonthClassListByUserId(int userId) {
        Student student = studentService.getStudentByUserId(userId);
        return getCurrentMonthClassListByGroupId(student.getGroupId());
    }

    public List<VideoClass> getCurrentMonthClassListByGroupId(int groupId) {
        VideoClassExample videoClassExample = new VideoClassExample();
        Date currentMonthFirstDay = DateUtil.getCurrentMonthFirstDay();
        Date nextMonthFirstDay = DateUtil.getNextMonthFirstDay();
        videoClassExample.createCriteria().andStartTimeGreaterThanOrEqualTo(currentMonthFirstDay).
                andEndTimeLessThan(nextMonthFirstDay)
                .andGroupIdEqualTo(groupId);
        List<VideoClass> videoClassList = videoClassMapper.selectByExample(videoClassExample);
        return videoClassList;
    }


    public List<VideoClass> getAllNotDeletedVideoClassList(){
        VideoClassExample videoClassExample = new VideoClassExample();
        videoClassExample.createCriteria().andStatusLessThan(VideoClassStatus.REMOVED.getId());
        videoClassExample.setOrderByClause("ctime DESC");
        return videoClassMapper.selectByExample(videoClassExample);
    }
}
