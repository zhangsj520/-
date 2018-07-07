package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Slideshow;
import com.baizhi.cmfz.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
*@Author  zsj
*@Description 轮播图的控制层
*@Time  2018/7/5 20:15
*/
@Controller
@RequestMapping("/slide")
public class SlideshowController {
    @Autowired
    private SlideshowService ss;
    /**
     *@Author  zsj
     *@Description 查看所有轮播图
     *@Time  2018/7/5 20:15
     * @Param 参数一： 当前页码  参数二：每页条数
     */
    @RequestMapping("/querySlideByPage")
    @ResponseBody
    public Map<String,Object> queryAllSlide(@RequestParam("page") int nowPage,@RequestParam("rows") int pageSize ){
        Map<String, Object> map = ss.queryAllSlideshowByPage(nowPage, pageSize);
        return map;
    }
    /**
     *@Author  zsj
     *@Description 添加轮播图
     *@Time  2018/7/5 20:15
     */
    @RequestMapping("/addSlideshow")
    @ResponseBody
    public String addSlideShow(Slideshow s, MultipartFile myFile,HttpSession session) throws IOException {
        //获取文件夹名称
        String realPath = session.getServletContext().getRealPath("/");
        String substring = realPath.substring(0, realPath.lastIndexOf("\\"));
        String s1 = substring.substring(0, substring.lastIndexOf("\\"))+"\\upload\\";
        //生成UUID唯一的文件名
        String uuid = UUID.randomUUID().toString().replace("-","");
        //截取文件本身的后缀名
        String oldName = myFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        String slidePath = s1+uuid+suffix;
        myFile.transferTo(new File(slidePath));
        s.setSlidePath(uuid+suffix);
        s.setSlideDate(new Date());
        int i = ss.addSlideshow(s);
        if(i>0){return "success";}else{return "error";}
    }
    /**
     *@Author  zsj
     *@Description 修改轮播图
     *@Time  2018/7/5 20:15
     */
    @RequestMapping("/modifySlideshow")
    @ResponseBody
    public String modifySlideShow(Slideshow s, MultipartFile myFile,HttpSession session)throws Exception{
        if(!myFile.isEmpty()){
            //获取文件夹名称
            String realPath = session.getServletContext().getRealPath("/");
            String substring = realPath.substring(0, realPath.lastIndexOf("\\"));
            String s1 = substring.substring(0, substring.lastIndexOf("\\"))+"\\upload\\";
            //生成UUID唯一的文件名
            String uuid = UUID.randomUUID().toString().replace("-","");
            //截取文件本身的后缀名
            String oldName = myFile.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            String slidePath = s1+uuid+suffix;
            myFile.transferTo(new File(slidePath));
            s.setSlidePath(uuid+suffix);
        }else{
            s.setSlidePath("");
        }
        s.setSlideDate(new Date());
        int i = ss.modifySlideshow(s);
        if(i>0){return "success";}else{return "error";}
    } /**
     *@Author  zsj
     *@Description 查询轮播图根据id
     *@Time  2018/7/6 18:48
     */
    @RequestMapping("/querySlideshow")
    @ResponseBody
    public Slideshow querySlideShow(String slideId){
        return ss.querymodifySlideshow(slideId);
    }


}
