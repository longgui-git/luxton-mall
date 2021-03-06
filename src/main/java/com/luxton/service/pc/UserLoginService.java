package com.luxton.service.pc;

import javax.servlet.http.HttpServletRequest;

import com.luxton.pojo.LuxUser;
import com.luxton.utils.LuxtonResult;

public interface UserLoginService {

	public LuxtonResult createUser(LuxUser user,String registerCode);
	
	public LuxtonResult getUserLogin(HttpServletRequest req, String username,String password);
	
	public LuxtonResult getUserInfo(HttpServletRequest req);
	
}
