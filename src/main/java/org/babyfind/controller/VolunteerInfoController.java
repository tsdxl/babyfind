package org.babyfind.controller;

import org.babyfind.common.AjaxResult;
import org.babyfind.po.VolunteerInfo;
import org.babyfind.service.UserLoginService;
import org.babyfind.service.VolunteerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zx
 * @Description
 * @date 2018/3/14 14:15
 */
public class VolunteerInfoController {
    @Resource
    private VolunteerInfoService volunteerInfoService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("deleteInfo")
    @ResponseBody
    public AjaxResult deleteInfobyVid(Integer vid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(volunteerInfoService.getInfoByMid(vid)==null){
            return AjaxResult.error("没有此账户");
        }
        volunteerInfoService.deleteInfobyMid(vid);
        return ajaxResult;
    }

    @RequestMapping("insertInfo")
    @ResponseBody
    public AjaxResult insertInfoByVolunteerInfo(String phone,VolunteerInfo VolunteerInfo) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();

        if(userLoginService.getInfoByPhone(phone)==null){
            return AjaxResult.error("没有此账户");
        }
        VolunteerInfo.setLid(userLoginService.getInfoByPhone(phone).getLid());
        volunteerInfoService.insertInfoByVolunteerInfo(VolunteerInfo);
        return ajaxResult;
    }

    @RequestMapping("getInfoByVid")
    @ResponseBody
    public AjaxResult getInfoByVid(Integer vid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        VolunteerInfo VolunteerInfo=volunteerInfoService.getInfoByMid(vid);
        ajaxResult.addSingleModel(VolunteerInfo);
        return ajaxResult;
    }

    @RequestMapping("updateInfoByVid")
    @ResponseBody
    public AjaxResult updateInfoByVolunteerInfo(VolunteerInfo VolunteerInfo) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(volunteerInfoService.getInfoByMid(VolunteerInfo.getVid())==null){
            return AjaxResult.error("没有此账户");
        }
        volunteerInfoService.updateInfoByVolunteerInfo(VolunteerInfo);
        ajaxResult.addSingleModel(volunteerInfoService.getInfoByMid(VolunteerInfo.getVid()));
        return ajaxResult;
    }
}
