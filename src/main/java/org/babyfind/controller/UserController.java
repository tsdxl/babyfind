package org.babyfind.controller;


import org.babyfind.common.AjaxResult;
import org.babyfind.po.User;
import org.babyfind.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("showUser")
    public String getUserByUserId(int id, Model model) {

        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        System.out.println("UserController.getUserByName:id" + id);
        return "showUser";
    }

    @RequestMapping(value = "userByJson", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getUserByJson(String u, String p) throws Exception {
        AjaxResult result = AjaxResult.succ();
////		String DDut.println("user:"+u+"----------------------------------------------------password:"+p);
        if (u.equals("zx")) {
            result = AjaxResult.failure();
        }
        List list=new ArrayList();
        User user = new User();
        user.setUserid(1);
        user.setPhone(p);
        list.add(user);
        User user1=new User();
        user1.setUserid(2);
        user1.setPhone(p);
        list.add(user1);
        result.addPageInfo(user.getUserid());
        result.addList(list);

        return result;
    }
}
