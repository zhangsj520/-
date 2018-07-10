package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.List;
import java.util.Map;

public interface LogService {
    public Map<String,Object> queryAllLog(Integer nowPage, Integer pageSize );

    public int addLog(Log log);
}
