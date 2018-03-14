package org.babyfind.dao;

import org.babyfind.po.MissInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissInfoMapper {
    int deleteByPrimaryKey(Integer mid);

    int deleteByLid(Integer lid);
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

    List<MissInfo> selectByLid(Integer lid);

    List<MissInfo> selectAll();
}