package org.babyfind.service.impl;

import org.babyfind.dao.MissInfoMapper;
import org.babyfind.po.MissInfo;
import org.babyfind.service.MissInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zx
 * @Description
 * @date 2018/3/13 15:18
 */
@Service("missInfoService")
public class MissInfoServiceImpl implements MissInfoService{

    @Autowired
    private MissInfoMapper missInfoMapper;
    @Override
    public Integer deleteInfobyMid(Integer mid) {
        return missInfoMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public Integer insertInfoByMissInfo(MissInfo missInfo) {
        return missInfoMapper.insertSelective(missInfo);
    }

    @Override
    public MissInfo getInfoByMid(Integer mid) {
        return missInfoMapper.selectByPrimaryKey(mid);
    }

    @Override
    public Integer updateInfoByMissInfo(MissInfo missInfo) {
        return missInfoMapper.updateByPrimaryKeySelective(missInfo);
    }

    @Override
    public List<MissInfo> getInfoByLid(Integer lid) {
        return missInfoMapper.selectByLid(lid);
    }

    @Override
    public List<MissInfo> getAll() {
        return missInfoMapper.selectAll();
    }

    @Override
    public Integer deleteInfobyLid(Integer lid) {
        return missInfoMapper.deleteByLid(lid);
    }
}
