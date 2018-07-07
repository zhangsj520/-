package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService gs;
    /**
    *@Author zsj
    *@Description 查找上师
    *@Time 2018/7/6/23:19
    *@Param 参数一：当前页，参数二：每页条数
    */
    @RequestMapping("/queryGuru")
    @ResponseBody
    public Map<String,Object> queryAll(@RequestParam("page") int nowPage,@RequestParam("rows") int pageSize){
        return  gs.queryAllGuru(nowPage,pageSize);
    } /**
    *@Author zsj
    *@Description 通过条件查找上师
    *@Time 2018/7/7 16:48
    *@Param 参数一：当前页，参数二：每页条数
    */
    @RequestMapping("/queryGuruByKey")
    @ResponseBody
    public Map<String,Object> queryGuruByKey(String key,String value,@RequestParam("page") int nowPage,@RequestParam("rows") int pageSize){
        return  gs.queryGuruByKey(key,value,nowPage,pageSize);
    }
    /**
     *@Author  zsj
     *@Description 添加上师
     *@Time  2018/7/6 23:20
     */
    @RequestMapping("/addguru")
    @ResponseBody
    public String addguru(Guru g, MultipartFile myFile, HttpSession session) throws IOException {
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
        g.setGuruPicture(uuid+suffix);
        int i = gs.addGuru(g);
        if(i>0){return "success";}else{return "error";}
    } /**
     *@Author  zsj
     *@Description 修改上师
     *@Time  2018/7/7 14:06
     */
    @RequestMapping("/modifyGuru")
    @ResponseBody
    public String modifyGuru(Guru g, MultipartFile myFile, HttpSession session) throws IOException {
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
            g.setGuruPicture(uuid+suffix);
        }
        int i = gs.modifyGuru(g);
        if(i>0){return "success";}else{return "error";}
    }

}
