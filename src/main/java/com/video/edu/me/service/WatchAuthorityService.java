package com.video.edu.me.service;

import com.video.edu.me.dao.WatchAuthorityMapper;
import com.video.edu.me.entity.WatchAuthority;
import com.video.edu.me.entity.WatchAuthorityExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WatchAuthorityService extends BaseService<WatchAuthority, WatchAuthorityExample> {

	private static final Logger logger = LoggerFactory.getLogger(WatchAuthorityService.class);

	private WatchAuthorityMapper watchAuthorityMapper;

	@Resource
	public void setWatchAuthorityMapper(WatchAuthorityMapper watchAuthorityMapper){
		this.watchAuthorityMapper = watchAuthorityMapper;
		super.setBaseDao(watchAuthorityMapper);
	}

	public boolean checkAuthority(int stuId, int videoId){
		try {
			WatchAuthorityExample watchAuthorityExample = new WatchAuthorityExample();
			watchAuthorityExample.createCriteria().andStuIdEqualTo(stuId)
					.andVideoIdEqualTo(videoId);
			if (watchAuthorityMapper.countByExample(watchAuthorityExample) > 0) {
				return true;
			}
		} catch (Exception e){
			logger.error("checkAuthority error with stuId: {}, videoId: {}, exception: {}", stuId, videoId, e.getMessage());
		}
		return false;
	}

	public List<Integer> getVideoIdListByStuId(int stuId){
		WatchAuthorityExample watchAuthorityExample = new WatchAuthorityExample();
		watchAuthorityExample.createCriteria().andStuIdEqualTo(stuId);
		List<WatchAuthority> watchAuthorityList = watchAuthorityMapper.selectByExample(watchAuthorityExample);
		List<Integer> videoIdList = new ArrayList<>();
		for(WatchAuthority watchAuthority: watchAuthorityList){
			videoIdList.add(watchAuthority.getVideoId());
		}
		return videoIdList;
	}
}
