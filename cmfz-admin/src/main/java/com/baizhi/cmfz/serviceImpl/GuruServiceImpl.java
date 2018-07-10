package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author  zhangshaojie
 *@Description 上师serviceImpl层
 *@Time  2018/7/6 23:02
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao gd;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String,Object> queryAllGuru(Integer nowPage,Integer pageSize) {
        int start = (nowPage -1)*pageSize;
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = gd.count("","");
        List<Guru> gurus = gd.selectAllGuru(start, pageSize);
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    @Override
    public int addGuru(Guru g) {
        return gd.insertOne(g);
    }

    @Override
    public int modifyGuru(Guru g) {
        return gd.updateOne(g);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String,Object> queryGuruByKey(String key, String value,int nowPage,int pageSize) {
        int start = (nowPage -1)*pageSize;
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = gd.count(key,value);
        List<Guru> gurus = gd.selectByKey(key, value, start, pageSize);
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }
    /**
    *@Author  zsj
    *@Description   Excel批量插入
    *@Time  2018/7/8 10:43
     *@Param 参数：文件名，文件。
     */
    public Boolean excelUpload(String name,MultipartFile myFile){
        boolean b = false;
        //创建处理EXCEL
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<Guru> guruList= readExcel.getExcelInfo(name, myFile);


        if(guruList != null){
            b = true;
        }
        int i = gd.insertList(guruList);

        //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        /*for(Price price:priceList){
            pm.addPrice(price);
        }*/
        if(i>0){b = true;}else{ b = false;}
        return b;

    }

    /**
    *@Author    zsj
    *@Description easypoi excel批量插入
    *@Time 2018/7/8 19:18
    */
    public int addGurus(List<Guru> gurus){
       return  gd.insertList(gurus);
    }

    public List<Guru> queryGurus(){
        return gd.selectAllGuru(null,null);
    }
}
