package com.video.edu.me.controller.admin;

import com.video.edu.me.entity.History;
import com.video.edu.me.entity.HistoryExample;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminHistoryController")
@RequestMapping(value = "/admin/history")
public class HistoryController {
    private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> create(History history) {
        Map<String, Object> res = new HashMap<>();
        try {
            int insertResult = historyService.insertSelective(history);
            if (insertResult == 0) {
                res.put("status", 1);
                res.put("msg", "未成功插入历史记录");
            } else {
                res.put("status", 0);
                res.put("msg", "创建历史记录成功！");
            }
            res.put("data", insertResult);
        } catch (Exception e) {
            logger.error("create error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> find(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            History findResult = historyService.selectByPrimaryKey(id);
            if (findResult == null) {
                res.put("status", 1);
                res.put("msg", "查找历史记录失败");
            } else {
                res.put("status", 0);
                res.put("msg", "查找历史成功");
            }
            res.put("data", findResult);
        } catch (Exception e) {
            logger.error("find error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> delete(int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            int deleteResult = historyService.deleteByPrimaryKey(id);
            if (deleteResult == 0) {
                res.put("status", 1);
                res.put("msg", "删除历史出错");
            } else {
                res.put("status", 0);
                res.put("msg", "删除历史成功");
            }
            res.put("data", deleteResult);
        } catch (Exception e) {
            logger.error("delete error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    @RequestMapping(value = "/getWatchHistoryList", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getWatchHistoryList(int id) {
        List<Map<String, Object>> watchHistoryList = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        try {
            HistoryExample historyExample = new HistoryExample();
            historyExample.createCriteria().andStuIdEqualTo(id);
            List<History> recordList = historyService.selectByExample(historyExample);
            if(recordList == null){
                res.put("status", 1);
                res.put("msg", "获取记录出错");
            }else {
                res.put("status", 0);
                res.put("msg", "获取记录成功");
                for(int i = 0; i < recordList.size(); i++) {
                    temp.put("stuID", recordList.get(i).getStuId());
                    temp.put("videoID", recordList.get(i).getVideoId());
                    temp.put("watchTime", recordList.get(i).getCtime());
                    watchHistoryList.add(temp);
                }
                res.put("data", watchHistoryList);
            }
        } catch (Exception e) {
            logger.error("getWatchHistoryList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }

    /*@RequestMapping(value = "/getLoginHistoryList", method = RequestMethod.GET)
    @ResponseBody
    private List<Map<String, Object>> getLoginHistoryList() {
        List<Map<String, Object>> loginHistoryList = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> list = getUserList();
        try {
            while (!list.isEmpty()) {
                UserExample userExample = new UserExample();
                userExample.createCriteria().andIdIsNotNull();
                res.put("data", userService.selectByExample(userExample));
                res.put("loginHistory", )
            }

        } catch (Exception e) {
            logger.error("getList error with exception: {}", e.getMessage());
            res.put("status", -1);
            res.put("msg", e.getMessage());
            res.put("data", null);
        }
        return res;
    }*/
}
