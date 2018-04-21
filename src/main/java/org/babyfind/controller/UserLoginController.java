package org.babyfind.controller;

import org.babyfind.common.AjaxResult;
import org.babyfind.po.UserLogin;
import org.babyfind.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author zx
 * @Description
 * @date 2018/3/14 14:14
 */
@Controller
@RequestMapping("/userLogin/")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    /**
    * @Description 删除账户并删除账户下所有信息
    * @author zx 2018/3/14 18:08
    * @param @param lid
    * @return org.babyfind.common.AjaxResult
    */
    @RequestMapping("deleteInfo")
    @ResponseBody
    public AjaxResult deleteInfobyLid(Integer lid) {
        AjaxResult ajaxResult = AjaxResult.succ();
        if (userLoginService.getInfoByLid(lid) == null) {
            return AjaxResult.error("没有此账户");
        }
        userLoginService.deleteInfobyLid(lid);
        return ajaxResult;
    }

    @RequestMapping("register")
    @ResponseBody
    public AjaxResult insertInfoByUserLogin(UserLogin userLogin) {
        AjaxResult ajaxResult = AjaxResult.succ();
        if (userLoginService.getInfoByPhone(userLogin.getPhone()) != null) {
            UserLogin userLogin1=userLoginService.getInfoByPhone(userLogin.getPhone());
            if(userLogin1.getFlag()==userLogin.getFlag()||userLogin1.getFlag()==2){
                return AjaxResult.error("手机号重复");
            }else{
                userLogin1.setFlag(2);
                userLoginService.updateInfoByMissInfo(userLogin1);
            }
        }
        userLoginService.insertInfoByUserLogin(userLogin);
        ajaxResult.addSingleModel(userLoginService.getInfoByPhone(userLogin.getPhone()));
        return ajaxResult;
    }

    @RequestMapping("login")
    @ResponseBody
    public AjaxResult login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AjaxResult ajaxResult = AjaxResult.succ();
        String phone=request.getParameter("phone");
        String passWord=request.getParameter("password");
        if (userLoginService.getInfoByPhone(phone)==null) {
            return AjaxResult.error("帐号密码错误");
        }
        UserLogin userLogin=userLoginService.getInfoByPhone(phone);
        if (userLogin.getPassword()!=passWord){
            return AjaxResult.error("帐号密码错误");
        }
        ajaxResult.addSingleModel(userLoginService.getInfoByPhone(phone));
        HttpSession session =request.getSession();
        session.setAttribute("phone",phone);
        return ajaxResult;
    }

    @RequestMapping("getInfoByPhone")
    @ResponseBody
    public AjaxResult getInfoByPhone(String phone) {
        AjaxResult ajaxResult = AjaxResult.succ();
        if (userLoginService.getInfoByPhone(phone)==null) {
            return AjaxResult.error("没有此账户");
        }
        ajaxResult.addSingleModel(userLoginService.getInfoByPhone(phone));
        return ajaxResult;
    }

    @RequestMapping("updateInfoByMissInfo")
    @ResponseBody
    public AjaxResult updateInfoByMissInfo(UserLogin userLogin) {
        AjaxResult ajaxResult = AjaxResult.succ();
        if (userLoginService.getInfoByLid(userLogin.getLid()) == null) {
            return AjaxResult.error("没有此账户");
        }
        UserLogin userLogin1=userLoginService.getInfoByLid(userLogin.getLid());
        if(userLogin1.getFlag()!=userLogin.getFlag()){
            userLogin.setFlag(2);
        }
        userLoginService.updateInfoByMissInfo(userLogin);
        ajaxResult.addSingleModel(userLoginService.getInfoByLid(userLogin.getLid()));
        return ajaxResult;
    }
}
