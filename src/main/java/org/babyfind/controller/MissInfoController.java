package org.babyfind.controller;

import org.babyfind.common.AjaxResult;
import org.babyfind.po.MissInfo;
import org.babyfind.service.MissInfoService;
import org.babyfind.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zx
 * @Description
 * @date 2018/3/13 16:56
 */
@Controller
@RequestMapping("/missInfo/")
public class MissInfoController {
    @Resource
    private MissInfoService missInfoService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "deleteInfo", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult deleteInfobyMid(Integer mid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(missInfoService.getInfoByMid(mid)==null){
            return AjaxResult.error("没有此账户");
        }
        missInfoService.deleteInfobyMid(mid);
        return ajaxResult;
    }

    @RequestMapping(value = "insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult insertInfoByMissInfo(String phone,MissInfo missInfo) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(userLoginService.getInfoByPhone(phone)==null){
            return AjaxResult.error("没有此账户");
        }
        missInfo.setLid(userLoginService.getInfoByPhone(phone).getLid());
        missInfoService.insertInfoByMissInfo(missInfo);
        return ajaxResult;
    }

    @RequestMapping(value = "getInfoByMid", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getInfoByMid(Integer mid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        MissInfo missInfo=missInfoService.getInfoByMid(mid);
        ajaxResult.addSingleModel(missInfo);
        return ajaxResult;
    }

    @RequestMapping(value = "updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateInfoByMissInfo(MissInfo missInfo) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(missInfoService.getInfoByMid(missInfo.getMid())==null){
            return AjaxResult.error("没有此账户");
        }
        missInfoService.updateInfoByMissInfo(missInfo);
        ajaxResult.addSingleModel(missInfoService.getInfoByMid(missInfo.getMid()));
        return ajaxResult;
    }
}
