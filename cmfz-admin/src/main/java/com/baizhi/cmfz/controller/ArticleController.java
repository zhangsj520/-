package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.MenuService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService as;
    /**
     *@Author zsj
     *@Description 查找所有文章
     *@Time 2018/7/8 21:38
     *@Param 参数一：当前页，参数二：每页条数
     */
    @RequestMapping("/queryArticles")
    @ResponseBody
    public Map<String,Object> queryAllArticle(@RequestParam("page") int nowPage, @RequestParam("rows") int pageSize){
        return  as.queryAllArticle(nowPage,pageSize);
    }
    /**
     * 多文件上传
     * @param files
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }
    /**
    *@Author
    *@Description
    *@Time
    *@Param
    *@Exception
    */
    @RequestMapping("/addArticle")
    @ResponseBody
    public Integer addArticle(Article article){
        System.out.println(article.getArticleStatus());
        if(article.getArticleStatus()==null || article.getArticleStatus() ==""){
            article.setArticleStatus("下架");
        }
        return as.addArticle(article);
    }
}
