package org.babyfind.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.babyfind.po.User;
import org.babyfind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("showUser")
	public String getUserByUserId(int id,Model model){
		
		User user=this.userService.getUserById(id);
		model.addAttribute("user",user);		
		System.out.println("UserController.getUserByName:id"+id);
		return "showUser";
	}
	@RequestMapping("userByJson")
	@ResponseBody
	public String getUserByJson(String u,String p) throws Exception {
//		String u=request.getParameter("u");
//		String p=request.getParameter("p");
		System.out.println("user:"+u+"----------------------------------------------------password:"+p);
		return "y";
	}
}
