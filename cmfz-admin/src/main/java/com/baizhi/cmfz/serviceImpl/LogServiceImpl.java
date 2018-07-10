package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao ld;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String,Object> queryAllLog(Integer nowPage, Integer pageSize) {
        int start = (nowPage -1)*pageSize;
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = ld.count();
        List<Log> logs = ld.selectAllLogs(start, pageSize);
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }

    @Override
    public int addLog(Log log) {
        return ld.insertLog(log);
    }
}
