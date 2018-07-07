package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public Map<String,Object> queryAllGuru(int nowPage,int pageSize) {
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
}
