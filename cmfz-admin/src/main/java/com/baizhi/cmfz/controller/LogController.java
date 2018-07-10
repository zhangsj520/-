package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService ls;

    @RequestMapping("/queryAllLog")
    @ResponseBody
    public Map<String,Object> queryAllLogs(@RequestParam("page") int nowPage, @RequestParam("rows") int pageSize){
        return ls.queryAllLog(nowPage,pageSize);
    }


}
