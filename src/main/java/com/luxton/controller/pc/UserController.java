package com.luxton.controller.pc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxUser;
import com.luxton.service.pc.UserLoginService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/user")
public class UserController {

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
		
		LuxtonResult result = userService.getUserLogin(req, user.getUsername(), user.getPassword());
		
		try {
			if(result.getStatus().equals(200)){
				res.sendRedirect("http://www.luxtonusa.com");
			}else{
				res.sendRedirect("http://www.luxtonusa.com/error");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
}
