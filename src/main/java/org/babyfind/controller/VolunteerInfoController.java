package org.babyfind.controller;

import org.babyfind.common.AjaxResult;
import org.babyfind.po.UserLogin;
import org.babyfind.po.VolunteerInfo;
import org.babyfind.service.UserLoginService;
import org.babyfind.service.VolunteerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zx
 * @Description
 * @date 2018/3/14 14:15
 */
@Controller
@RequestMapping("/volunteer/")
public class VolunteerInfoController {
    @Resource
    private VolunteerInfoService volunteerInfoService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("deleteInfo")
    @ResponseBody
    public AjaxResult deleteInfobyVid(Integer vid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(volunteerInfoService.getInfoByVid(vid)==null){
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
        UserLogin userLogin=userLoginService.getInfoByPhone(phone);
        if(userLogin.getFlag()!=0){
            userLogin.setFlag(2);
            userLoginService.updateInfoByMissInfo(userLogin);
        }
        VolunteerInfo.setLid(userLoginService.getInfoByPhone(phone).getLid());
        volunteerInfoService.insertInfoByVolunteerInfo(VolunteerInfo);
        return ajaxResult;
    }

    @RequestMapping("getInfoByVid")
    @ResponseBody
    public AjaxResult getInfoByVid(Integer vid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        VolunteerInfo VolunteerInfo=volunteerInfoService.getInfoByVid(vid);
        ajaxResult.addSingleModel(VolunteerInfo);
        return ajaxResult;
    }

    @RequestMapping("getAll")
    @ResponseBody
    public AjaxResult getAll() throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        List<VolunteerInfo> volunteerInfo=volunteerInfoService.getAll();
        ajaxResult.addObject(AjaxResult.DATAS,volunteerInfo);
        return ajaxResult;
    }

    @RequestMapping("updateInfoByVid")
    @ResponseBody
    public AjaxResult updateInfoByVolunteerInfo(VolunteerInfo VolunteerInfo) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(volunteerInfoService.getInfoByVid(VolunteerInfo.getVid())==null){
            return AjaxResult.error("没有此账户");
        }
        volunteerInfoService.updateInfoByVolunteerInfo(VolunteerInfo);
        ajaxResult.addSingleModel(volunteerInfoService.getInfoByVid(VolunteerInfo.getVid()));
        return ajaxResult;
    }
}
