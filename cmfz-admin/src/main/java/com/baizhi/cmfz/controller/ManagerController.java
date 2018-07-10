package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.CreateValidateCode;
import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

@Controller
@RequestMapping("/man")
public class ManagerController {
    @Autowired
    private ManagerService ms;

    /**
    *@Author    zhangshaojie
    *@Description   回去cookie的值
    *@Time  2018/7/5 9:52
    *@Param 参数1：请求
    *@Exception
    */
    @RequestMapping("/toLoginJsp")
    public String toLoginJsp11(HttpServletRequest request)throws Exception{
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("mName")){
                String s = URLDecoder.decode(cookie.getValue(), "utf-8");
                request.setAttribute("mName",s);
            }
        }
        return "login";
    }

    /**
    *@Author  zhangshaojie
    *@Description   登录判断
    *@Time  2018/7/4 16:08
    *@Param 用户名 密码 验证码
    *@Exception
    */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String mName,String mPassword,String code,String check,HttpServletRequest request,HttpServletResponse resp)throws Exception{
        HttpSession session = request.getSession();

        String code1 = (String) session.getAttribute("code");
        if(code.equals(code1)){
            Manager m = ms.login(mName, mPassword);
            if(m!=null){
                String managerName = m.getmName();
                session.setAttribute("mn",managerName);
                if(check!=null) {
                    Cookie cook = new Cookie("mName",java.net.URLEncoder.encode(mName,"UTF-8"));
                    cook.setMaxAge(30 * 24 * 60 * 60);
                    resp.addCookie(cook);
                }
                return "success";
            }else{
                return "error";
            }
        }else{
            return "error";
        }
    }

    @RequestMapping("/vCode")
    public void cVode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        CreateValidateCode vCode = new CreateValidateCode(100, 30, 5, 10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());

    }

}
