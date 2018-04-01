package org.babyfind.service.impl;

import org.babyfind.dao.MissInfoMapper;
import org.babyfind.dao.UserLoginMapper;
import org.babyfind.po.UserLogin;
import org.babyfind.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zx
 * @Description
 * @date 2018/3/13 17:12
 */
@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private MissInfoMapper missInfoMapper;
    @Override
    public Integer deleteInfobyLid(Integer lid) {
        userLoginMapper.deleteByPrimaryKey(lid);
        return missInfoMapper.deleteByLid(lid);
    }

    @Override
    public Integer insertInfoByUserLogin(UserLogin userLogin) {
        return userLoginMapper.insertSelective(userLogin);
    }

    @Override
    public UserLogin getInfoByLid(Integer lid) {
        return userLoginMapper.selectByPrimaryKey(lid);
    }

    @Override
    public Integer updateInfoByMissInfo(UserLogin userLogin) {
        return userLoginMapper.updateByPrimaryKeySelective(userLogin);
    }

    @Override
    public UserLogin getInfoByPhone(String phone) {
        return userLoginMapper.selectByPhone(phone);
    }
}
