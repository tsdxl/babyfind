package org.babyfind.controller;



import org.babyfind.po.User;
import org.babyfind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/editItemSubmit_RequestJson")
	@ResponseBody
	public  User getUserByJson(User user) throws Exception {
		return user;
	}
}
