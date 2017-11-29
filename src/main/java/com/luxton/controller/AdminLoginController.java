package com.luxton.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public LuxtonResult getAdminLogin(HttpServletRequest req,HttpServletResponse res ,@RequestBody LuxAdmin admin){
		
//		LuxtonResult result = adminService.getAdminLogin(req, admin.getUsername(), admin.getPassword());
		LuxtonResult result = adminService.getAdminLogin(req, admin.getUsername(), admin.getPassword());
		
		try {
			if(result.getStatus().equals(200)){
				Cookie cookie1 = new Cookie("role", (String) result.getData());
				cookie1.setDomain("luxtonusa.com");
				cookie1.setPath("/");
				cookie1.setMaxAge(7200);
				res.addCookie(cookie1);
				
//				res.sendRedirect("http://www.luxtonusa.com");
				return LuxtonResult.ok();
			}
			
//			res.sendRedirect("http://www.luxtonusa.com/error");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return LuxtonResult.build(572, "登录失败");
	}
	
	
	
	@RequestMapping("/add/adminUser")
	@ResponseBody
	public LuxtonResult createAdmin(HttpServletRequest req,@RequestBody LuxAdmin admin){
		
		LuxtonResult result = adminService.createAdmin(req, admin.getUsername(), admin.getPassword());
		
		return result;
	}
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getAdminList(HttpServletRequest req){
		
		LuxtonResult result = adminService.getAdminList(req);
		
		return result;
	}
	
	@RequestMapping("/delete/{adminId}")
	@ResponseBody
	public LuxtonResult deleteAdmin(HttpServletRequest req,@PathVariable Integer adminId){
		
		LuxtonResult result = adminService.deleteAdmin(req ,adminId);
		
		return result;
	}
	
	@RequestMapping("/create/registerCode")
	@ResponseBody
	public LuxtonResult createRegisterCode(HttpServletRequest req){
		
		LuxtonResult result = adminService.createRegisterCode();
		
		return result;
	}
	
	
	
	
}
