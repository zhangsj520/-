package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.SaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@Author  zhangshaojie
 *@Description 管理员serviceImpl层
 *@Time  2018/7/4 12:30
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao md;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Manager login(String mName, String mPassword) {
        Manager manager = md.selectManager(mName);
        String salt = manager.getmSalt();
        if(manager.getmPassword().equals(DigestUtils.md5Hex(mPassword.concat(salt)))){
            return manager;
        }else {
            return null;
        }
    }

    @Override
    public int registManager(Manager m) {
        String salt = SaltUtil.getSalt();
        m.setmSalt(salt);
        m.setmPassword(DigestUtils.md5Hex(m.getmPassword().concat(salt)));
        return  md.insertManager(m);


    }
}
