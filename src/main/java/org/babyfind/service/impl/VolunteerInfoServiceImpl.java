package org.babyfind.service.impl;

import org.babyfind.dao.VolunteerInfoMapper;
import org.babyfind.po.VolunteerInfo;
import org.babyfind.service.VolunteerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zx
 * @Description
 * @date 2018/3/14 14:09
 */
@Service("volunteerInfoService")
public class VolunteerInfoServiceImpl implements VolunteerInfoService {
    @Autowired
    private VolunteerInfoMapper volunteerInfoMapper;
    @Override
    public Integer deleteInfobyMid(Integer mid) {
        return volunteerInfoMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public Integer insertInfoByVolunteerInfo(VolunteerInfo missInfo) {
        return volunteerInfoMapper.insertSelective(missInfo);
    }

    @Override
    public VolunteerInfo getInfoByMid(Integer mid) {
        return volunteerInfoMapper.selectByPrimaryKey(mid);
    }

    @Override
    public Integer updateInfoByVolunteerInfo(VolunteerInfo missInfo) {
        return volunteerInfoMapper.updateByPrimaryKeySelective(missInfo);
    }

    @Override
    public List<VolunteerInfo> getInfoByLid(Integer lid) {
        return null;
    }

    @Override
    public List<VolunteerInfo> getAll() {
        return null;
    }

    @Override
    public Integer deleteInfobyLid(Integer lid) {
        return null;
    }
}
