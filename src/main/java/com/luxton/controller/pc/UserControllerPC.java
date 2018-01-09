package com.luxton.controller.pc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxUser;
import com.luxton.service.pc.UserLoginService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/user")
public class UserControllerPC {

	@Autowired
	private UserLoginService userService;
	
	@RequestMapping("/register")
	@ResponseBody
	public LuxtonResult createUser(@RequestBody LuxUser user,String registerCode){
		
		LuxtonResult result = userService.createUser(user,registerCode);
		
		return result;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public LuxtonResult getUserLogin(HttpServletRequest req,HttpServletResponse res,
			@RequestBody LuxUser user){
//		){
		
//		System.out.println("--"+req.getSession().getAttribute("userId"));
		
//		LuxUser user = new LuxUser();
//		user.setUsername("1");
//		user.setPassword("1");
		LuxtonResult result = userService.getUserLogin(req, user.getUsername(), user.getPassword());
		
		return result;
	}
	
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public LuxtonResult getUserInfo(HttpServletRequest req){
		
		LuxtonResult result = userService.getUserInfo(req);
		
		return result;
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public LuxtonResult logout(HttpServletRequest req){
		
		req.getSession().removeAttribute("userId");
		
		return LuxtonResult.ok();
	}
	
	@RequestMapping("/relogin/{status}")
	@ResponseBody
	public LuxtonResult loginFalseStatus(@PathVariable Integer status){
		
		return LuxtonResult.build(status, "验证失败，请重新登录");
	}
	
}
