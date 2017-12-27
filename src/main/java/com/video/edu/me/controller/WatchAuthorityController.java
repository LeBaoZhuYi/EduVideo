package com.video.edu.me.controller;

import com.video.edu.me.entity.WatchAuthority;
import com.video.edu.me.service.WatchAuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/watchAuthority")
public class WatchAuthorityController {

    private static final Logger logger = LoggerFactory.getLogger(WatchAuthorityController.class);

    @Autowired
    WatchAuthorityService watchAuthorityService;
    @RequestMapping(value = "/creat", method = RequestMethod.GET)
    @ResponseBody
    private boolean creat(WatchAuthority watchAuthority)throws IllegalArgumentException, IllegalAccessException{
        return watchAuthorityService.insertSelective(watchAuthority) != 0;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private WatchAuthority find(int id) throws IllegalArgumentException, IllegalAccessException {
        return watchAuthorityService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private boolean delete(int id) throws IllegalArgumentException, IllegalAccessException {
        return watchAuthorityService.deleteByPrimaryKey(id) != 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private boolean update(WatchAuthority watchAuthority) throws IllegalArgumentException, IllegalAccessException{
        return watchAuthorityService.updateByPrimaryKey(watchAuthority) != 0;
    }
}
