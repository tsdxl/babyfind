package org.babyfind.service;

import org.babyfind.po.VolunteerInfo;

import java.util.List;

/**
 * @author zx
 * @Description
 * @date 2018/3/13 17:10
 */
public interface VolunteerInfoService {
    public Integer deleteInfobyMid(Integer vid);

    public Integer insertInfoByVolunteerInfo(VolunteerInfo missInfo);

    public VolunteerInfo getInfoByMid(Integer vid);

    public Integer updateInfoByVolunteerInfo(VolunteerInfo missInfo);

    public List<VolunteerInfo> getInfoByLid(Integer lid);

    public List<VolunteerInfo> getAll();

    public Integer deleteInfobyLid(Integer lid);
}
