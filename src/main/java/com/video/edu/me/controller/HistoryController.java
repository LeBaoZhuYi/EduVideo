package com.video.edu.me.controller;

import com.video.edu.me.entity.History;
import com.video.edu.me.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/history")
public class HistoryController {

    private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private boolean create(History history) throws IllegalArgumentException, IllegalAccessException {
        return historyService.insertSelective(history) != 0;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private History find(int id) throws IllegalArgumentException, IllegalAccessException {
        return historyService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private boolean delete(int id) throws IllegalArgumentException, IllegalAccessException {
        return historyService.deleteByPrimaryKey(id) != 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    private boolean update(History history) throws IllegalArgumentException, IllegalAccessException {
        return historyService.updateByPrimaryKey(history) != 0;
    }
}
