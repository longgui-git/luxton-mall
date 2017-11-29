package com.luxton.service;

import javax.servlet.http.HttpServletRequest;

import com.luxton.utils.LuxtonResult;

public interface AdminLoginService {

	public LuxtonResult getAdminLogin(HttpServletRequest req,String username,String password);
	
	public LuxtonResult createAdmin(HttpServletRequest req,String username,String password);
	
	public LuxtonResult getAdminList(HttpServletRequest req);
	
	public LuxtonResult createRegisterCode();
	
	public LuxtonResult deleteAdmin(HttpServletRequest req ,Integer adminId);
	
}
