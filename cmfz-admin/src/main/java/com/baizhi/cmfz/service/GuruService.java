package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 *@Author  zhangshaojie
 *@Description 上师service层
 *@Time  2018/7/4 12:30
 */
public interface GuruService {
    /**
     *@Author    zsj
     *@Description 根据page查询所有上师
     *@Time      2018/7/6  23:00
     */
    public Map<String ,Object> queryAllGuru(Integer nowPage,Integer pageSize);
    /**
     *@Author zsj
     *@Description 添加一个上师信息
     *@Time  2018/7/6 23:00
     */
    public int addGuru(Guru g);
    /**
     *@Author zsj
     *@Description 修改一个上师信息
     *@Time  2018/7/6 23:00
     */
    public int modifyGuru(Guru g);
    /**
     *@Author zsj
     *@Description 模糊查询
     *@Time  2018/7/6 22:38

     */
    public Map<String,Object> queryGuruByKey(String key,String value,int nowPage,int pageSize);
    /**
    *@Author    zsj
    *@Description easypoi Excel 插入
    *@Time  2018/7/8 19：15
    */
    public int addGurus(List<Guru> gurus);
    /**
     *@Author    zsj
     *@Description poi Excel 插入
     *@Time  2018/7/8 19：15
     */
    public Boolean excelUpload(String name,MultipartFile myFile);

    public List<Guru> queryGurus();
}
