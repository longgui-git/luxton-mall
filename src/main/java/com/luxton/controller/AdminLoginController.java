package com.luxton.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxAdmin;
import com.luxton.service.AdminLoginService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/back/admin")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminService;
	
	@RequestMapping("/login")
	@ResponseBody
	public void getAdminLogin(HttpServletRequest req,HttpServletResponse res ,@RequestBody LuxAdmin admin){
		
		LuxtonResult result = adminService.getAdminLogin(req, admin.getUsername(), admin.getPassword());
		
		try {
			if(result.getStatus().equals(200)){
				Cookie cookie1 = new Cookie("role", (String) result.getData());
				cookie1.setDomain("luxtonusa.com");
				cookie1.setPath("/");
				cookie1.setMaxAge(7200);
				res.addCookie(cookie1);
				
				res.sendRedirect("http://www.luxtonusa.com");
			}
			
			res.sendRedirect("http://www.luxtonusa.com/error");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	@RequestMapping("/")
	@ResponseBody
	public LuxtonResult createAdmin(){
		
		
		return null;
	}
	
	
	
}
