package com.luxton.service;

import com.luxton.pojo.LuxUser;
import com.luxton.utils.LuxtonResult;

public interface UserService {

	public LuxtonResult getUserList(Integer page ,Integer stage);
	
	public LuxtonResult getUserByUserName(String userName);
	
	public LuxtonResult insertUser(LuxUser user);
	
}
