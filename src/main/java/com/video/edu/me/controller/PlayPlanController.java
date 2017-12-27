package com.video.edu.me.controller;

import com.video.edu.me.entity.PlayPlan;
import com.video.edu.me.service.PlayPlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/playplan")
public class PlayPlanController {

    private static final Logger logger = LoggerFactory.getLogger(PlayPlanController.class);

    @Autowired
    PlayPlanService playPlanService;
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private boolean creat(PlayPlan playPlan) throws IllegalArgumentException, IllegalAccessException{
        return playPlanService.insertSelective(playPlan) != 0;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private PlayPlan find(int id) throws IllegalArgumentException, IllegalAccessException {
        return playPlanService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private boolean delete(int id) throws IllegalArgumentException, IllegalAccessException {
        return playPlanService.deleteByPrimaryKey(id) != 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private boolean update(PlayPlan playPlan) throws IllegalArgumentException, IllegalAccessException{
        return playPlanService.updateByPrimaryKey(playPlan) != 0;
    }

}
