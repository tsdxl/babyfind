package controller;

import com.alibaba.fastjson.JSON;
import org.babyfind.controller.UserController;
import org.babyfind.po.User;
import org.babyfind.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/** 
* UserController Tester. 
* 
* @author <Authors name> 
* @since <pre>03/09/2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
@Transactional
public class UserControllerTest { 

    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: getUserByUserId(int id, Model model)
*
*/
@Test
public void testGetUserByUserId() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getUserByJson(User user)
*
*/
@Test
public void testGetUserByJson() throws Exception {
    User user=new User();
    user.setUserid(1);
    System.out.println(JSON.toJSONString(user));
//    System.out.println(userController.getUserByJson(user).getUserid());
}


} 
