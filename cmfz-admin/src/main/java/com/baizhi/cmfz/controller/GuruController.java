package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
    /**
    *@Author    zsj
    *@Description   Excel上传
    *@Time  2018/7/8  10:09
    *@Param 文件
    */
    /*@RequestMapping("/excelUpload")
    @ResponseBody
    public String excelUpload(MultipartFile myFile, HttpServletRequest request, HttpServletResponse response){
        if(myFile==null) return "isEmpty";
        //获取文件名
        String name=myFile.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=myFile.getSize();
        if(name==null || ("").equals(name) && size==0) return "isEmpty";

        //批量导入。参数：文件名，文件。
        boolean b = gs.excelUpload(name, myFile);
        if(b){
           return "success";
        }else{
           return "error";
        }
    }*/
    /**
    *@Author    zsj
    *@Description   easypopi   Excel上传
    *@Time  2018/7/8  19:06
    *@Param 文件
    */
    @RequestMapping("/excelUpload1")
    @ResponseBody
    public String excelUpload1(MultipartFile myFile){
        // 参数一：输入流
        // 参数二：pojo
        // 参数三：导入参数对象
        try {
            ImportParams importParams = new ImportParams();

            List<Guru> gurus = ExcelImportUtil.importExcel(myFile.getInputStream(), Guru.class, importParams);
            int i = gs.addGurus(gurus);
            if(i>0){return "success";}else{return "error";}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    /**
     * 注意事项：下载文件的时候不能使用异步请求 ajax
     *
     * dataType:json
     *          xml
     *          不支持stream类型
     *
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse resp) throws IOException {
        List<Guru> gurus = gs.queryGurus();
        // Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("c118", "上师信息表"), Guru.class, gurus);
        ServletOutputStream out = resp.getOutputStream();
        // 文件下载 设置响应头
        // 注意：响应头 默认使用的编码格式iso-8859-1

        String fileName = new String("上师信息.xls".getBytes(), "iso-8859-1");

        resp.setContentType("application/vnd.ms-excel"); //响应类型  text/html  application/json
        resp.setHeader("content-disposition","attachment;fileName="+fileName);
        // 导出 文件下载的方式
        workbook.write(out);
        out.close();
    }
    /**
    *@Author    zsj
    *@Description 显示所有上师名字，被逼查找
    *@Time  2018/7/10 10:02
    */
    @RequestMapping("/queryName")
    @ResponseBody
    public List<Guru> queryAllGuru(){
        return gs.queryGurus();
    }
}
