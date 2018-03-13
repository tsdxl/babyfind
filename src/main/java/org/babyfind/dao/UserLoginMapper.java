package org.babyfind.dao;

import org.babyfind.po.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer lid);

    UserLogin selectByPhone(String phone);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}