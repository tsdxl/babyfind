package org.babyfind.service;

import org.babyfind.po.MissInfo;

/**
 * @author zx
 * @ClassName ${FILE_NAME}
 * @Description
 * @date 2018/3/13 14:42
 */
public interface MissInfoService{

    public Integer deleteInfobyMid(Integer mid);

    public Integer insertInfoByMissInfo(MissInfo missInfo);

    public MissInfo getInfoByMid(Integer mid);

    public Integer updateInfoByMissInfo(MissInfo missInfo);
}
