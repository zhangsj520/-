import com.baizhi.cmfz.dao.*;
import com.baizhi.cmfz.entity.*;
import com.baizhi.cmfz.service.*;
import com.baizhi.cmfz.util.SaltUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestDao {
    @Autowired
    private ManagerDao md;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MenuService menuService;
    @Autowired
    private ManagerService ms;
    @Autowired
    private SlideshowDao sd;
    @Autowired
    private SlideshowService ss;
    @Autowired
    private GuruDao gd;
    @Autowired
    private GuruService gs;
    @Autowired
    private ArticleDao ad;
    @Autowired
    private ArticleService as;
    @Test
    public void TestManager(){
        Manager fgx = ms.login("fgx", "123456");
        System.out.println(fgx);
       /* Map<String, Object> map = as.queryAllArticle(1, 4);
        for (String s : map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }*/
        /*List<Article> a = ad.selectAllArticle(0, 1);
        System.out.println(a);*/
       /* Manager manager = md.selectManager("zsj");
        System.out.println(manager);*/
       /* int i = md.insertManager(new Manager(null, "fjk", SaltUtil.getSalt(), "1", "1234556"));
        System.out.println(i);*/
      /*  int i = ms.registManager(new Manager(null, "fgx", null, "1", "123456"));
        System.out.println(i);*/
       /* Boolean b = ms.login("fgx", "12456");
        System.out.println(b);*/
       /* int i = ms.registManager(new Manager(null, "张三", SaltUtil.getSalt(), "1", "123456"));
        System.out.println(i);*/
       // System.out.println(ms.login("张三","123456"));
       /* List<Menu> menus = menuService.queryMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }*/
        /*int i = sd.updateSlideshow(new Slideshow("f0c436dd804011e89720f0761cbd21c0", "第一张", new Date(), "大力", "选中"));
        System.out.println(i);*/
       /* List<Slideshow> slideshows = sd.selectAllSlideshow();
        for (Slideshow slideshow : slideshows) {
            System.out.println(slideshow);
        }*/
       /* int i = sd.insertSlideshow(new Slideshow(null, "第er张", new Date(), "大力", "未选中"));
        System.out.println(i);*/
        /*Map<String, Object> map = ss.queryAllSlideshowByPage(1, 2);
        for (String s : map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }*/
       /* Slideshow slideshow = sd.selectSlideById("860779a880fc11e89720f0761cbd21c0");

        System.out.println(slideshow);*/
       /* int i = sd.updateSlideshow(new Slideshow("7cee2d2a811f11e89720f0761cbd21c0", null, new Date(), "dao", "不展示"));
        System.out.println(i);*/
       /* List<Guru> gurus = gd.selectAllGuru();
        for (Guru guru : gurus) {
            System.out.println(guru);
        }*/
        //System.out.println(gd.insertOne(new Guru(null,"zsj","saf","saf")));
       // System.out.println(gd.count("g_religionName","阿"));
       /* List<Guru> gurus = gd.selectByKey("g_religionName","阿",0,2);
        for (Guru guru : gurus) {
            System.out.println(guru);
        }*/
       /* Map<String, Object> map = gs.queryGuruByKey("g_religionName","阿",1,2);
        for (String s : map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }*/
      /* List<Guru> list = new ArrayList<>();
       list.add(new Guru(null,"测试1","cesh1","ceshi 1"));
       list.add(new Guru(null,"测试2","cesh2","ceshi 2"));
        int i = gd.insertList(list);
        System.out.println(i);*/
       /* List<Guru> gurus = gd.selectAllGuru(1, 4);
        for (Guru guru : gurus) {
            System.out.println(guru);
        }*/
        /*Map<String, Object> map = gs.queryAllGuru( 1, 4);
        for (String s : map.keySet()) {
            System.out.println(s);
            System.out.println(map.get(s));
        }*/

    }



}
