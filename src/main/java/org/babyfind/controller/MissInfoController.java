package org.babyfind.controller;

import org.babyfind.common.AjaxResult;
import org.babyfind.po.MissInfo;
import org.babyfind.po.UserLogin;
import org.babyfind.service.MissInfoService;
import org.babyfind.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("deleteInfo")
    @ResponseBody
    public AjaxResult deleteInfobyMid(Integer mid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(missInfoService.getInfoByMid(mid)==null){
            return AjaxResult.error("没有此账户");
        }
        missInfoService.deleteInfobyMid(mid);
        return ajaxResult;
    }

    @RequestMapping("insertInfo")
    @ResponseBody
    public AjaxResult insertInfoByMissInfo(String phone,MissInfo missInfo,int flag) throws Exception {
        AjaxResult ajaxResult;
        UserLogin userLogin=new UserLogin();
        userLogin.setFlag(flag);
        userLogin.setPassword("123456");
        userLogin.setPhone(phone);
        UserLoginController userLoginController=new UserLoginController();
        ajaxResult=userLoginController.insertInfoByUserLogin(userLogin);
        missInfo.setLid(userLoginService.getInfoByPhone(phone).getLid());
        if(missInfoService.getInfoByLid(missInfo.getLid())!=null){
            List<MissInfo> missInfoList=missInfoService.getInfoByLid(missInfo.getLid());
            int size=missInfoList.stream().filter(u->u.getName()==missInfo.getName()).collect(Collectors.toList()).size();
            if(size==0)
                return AjaxResult.error("已登记过此人信息");
        }
        missInfoService.insertInfoByMissInfo(missInfo);
        return ajaxResult;
    }

    @RequestMapping("getInfoByMid")
    @ResponseBody
    public AjaxResult getInfoByMid(Integer mid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        MissInfo missInfo=missInfoService.getInfoByMid(mid);
        ajaxResult.addSingleModel(missInfo);
        return ajaxResult;
    }

    @RequestMapping("getAll")
    @ResponseBody
    public AjaxResult getAll() throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        List<MissInfo> missInfo=missInfoService.getAll();
        ajaxResult.addObject(AjaxResult.DATAS,missInfo);
        return ajaxResult;
    }

    @RequestMapping("getInfoByLid")
    @ResponseBody
    public AjaxResult getInfoByLid(Integer lid) throws Exception {
        AjaxResult ajaxResult=AjaxResult.succ();
        if(missInfoService.getInfoByLid(lid).isEmpty())
            return AjaxResult.error("没有失踪人信息");
        List<MissInfo> missInfo=missInfoService.getInfoByLid(lid);
        ajaxResult.addObject(AjaxResult.DATAS,missInfo);
        return ajaxResult;
    }
    @RequestMapping("updateInfoByMid")
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
