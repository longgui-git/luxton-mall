package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxUser;
import com.luxton.service.UserService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/back/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/get/list/{page}")
	@ResponseBody
	public LuxtonResult getUserList(@PathVariable Integer page ,@RequestParam(value="stage" ,defaultValue="10") Integer stage) {
		
		LuxtonResult result = userService.getUserList(page, stage);
		return result;
	}
	
	@RequestMapping("/get/{userName}")
	@ResponseBody
	public LuxtonResult getUserByUserName(@PathVariable String userName) {
		
		LuxtonResult result = userService.getUserByUserName(userName);
		return result;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertUser(@RequestBody LuxUser user) {
		
		LuxtonResult result = userService.insertUser(user);
		return result;
	}
	
}
