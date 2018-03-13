package org.babyfind.dao;

import org.babyfind.po.MissInfo;

public interface MissInfoMapper {
    int deleteByPrimaryKey(Integer mid);

    /**
     * @param record
     * @return int
     * @Description 新增
     * @author zx 2018/3/13 14:24
     */
    int insert(MissInfo record);

    /**
     * @param record
     * @return int
     * @Description 选择性新增
     * @author zx 2018/3/13 14:24
     */
    int insertSelective(MissInfo record);

    MissInfo selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(MissInfo record);

    int updateByPrimaryKeyWithBLOBs(MissInfo record);

    int updateByPrimaryKey(MissInfo record);
}