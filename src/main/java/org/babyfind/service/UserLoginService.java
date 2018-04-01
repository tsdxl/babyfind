package org.babyfind.service;

import org.babyfind.po.UserLogin;

/**
 * @author zx
 * @Description
 * @date 2018/3/13 17:10
 */
public interface UserLoginService {
    public Integer deleteInfobyLid(Integer lid);

    public Integer insertInfoByUserLogin(UserLogin userLogin);

    public UserLogin getInfoByLid(Integer lid);

    public Integer updateInfoByMissInfo(UserLogin userLogin);

    public UserLogin getInfoByPhone(String Phone);

}
