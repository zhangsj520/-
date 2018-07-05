import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestDao {
    @Autowired
    private ManagerDao md;

    @Autowired
    private ManagerService ms;
    @Test
    public void TestManager(){
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
        System.out.println(ms.login("张三","123456"));

    }



}
