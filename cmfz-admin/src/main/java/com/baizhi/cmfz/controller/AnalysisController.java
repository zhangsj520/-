package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*@Author    zsj
*@Description 统计分析
*@Time  2018/7/9 19:41
*@Param
*@Exception
*/
@Controller
@RequestMapping("/analysis")
public class AnalysisController {
    /**
    *@Author  zsj
    *@Description 地图分布
    *@Time  2018/7/9 19:42
    */
    @RequestMapping("/man")
    @ResponseBody
    public List<City> getMan(){
        List<City> list= new ArrayList<>();
        list.add(new City("北京",10));
        list.add(new City("天津",10));
        list.add(new City("上海",10));
        list.add(new City("河北",10));
        list.add(new City("云南",10));
        list.add(new City("黑龙江",10));
        list.add(new City("安徽",10));
        list.add(new City("新疆",10));
        list.add(new City("浙江",10));
        list.add(new City("湖北",10));
        list.add(new City("甘肃",10));
        list.add(new City("内蒙古",10));
        list.add(new City("吉林",10));
        return list;
    }
    @RequestMapping("/map")
    @ResponseBody
    public Map<String,Object> map(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"20天","15天","30天","60天","20天","40天"});
        map.put("counts",new int[]{5,10,15,23,43,32});
        return map;
    }
}
