package org.babyfind.dao;

import org.babyfind.po.VolunteerInfo;

public interface VolunteerInfoMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(VolunteerInfo record);

    int insertSelective(VolunteerInfo record);

    VolunteerInfo selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(VolunteerInfo record);

    int updateByPrimaryKey(VolunteerInfo record);
}