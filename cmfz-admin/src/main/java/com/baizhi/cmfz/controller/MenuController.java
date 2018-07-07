package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baizhi.cmfz.entity.Menu;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService ms;
    @RequestMapping("/queryMenu")
    @ResponseBody
    public List<Menu> queryMenu(){
        return ms.queryMenu();
    }

}
