package com.luxton.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxAdminMapper;
import com.luxton.pojo.LuxAdmin;
import com.luxton.pojo.LuxAdminExample;
import com.luxton.pojo.LuxAdminExample.Criteria;
import com.luxton.service.AdminLoginService;
import com.luxton.utils.LuxtonResult;
import com.luxton.utils.MD5;
@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private LuxAdminMapper adminMapper;
	
	@Override
	public LuxtonResult getAdminLogin(HttpServletRequest req,String username, String password) {

		LuxAdminExample example = new LuxAdminExample();
		Criteria criteria = example.createCriteria();
		
//		md5加密
		MD5 md5 = new MD5();
		try{
			if(password!=null){
				password = md5.getMD5ofStr(md5.getMD5ofStr(password));
			}
			//添加查询条件
			criteria.andUsernameEqualTo(username+"");
			criteria.andPasswordEqualTo(password+"");
			
			List<LuxAdmin> list = adminMapper.selectByExample(example);
			
			if(list!=null && list.size()>0){
				LuxAdmin admin = list.get(0);
				//管理员登录验证成功
				req.getSession().setAttribute("adminRole", admin.getIdentity());
				req.getSession().setMaxInactiveInterval(7200);
				
				
				return LuxtonResult.ok(admin.getIdentity());
			}
		}catch(Exception e){
			//e.printStackTrace();
			return LuxtonResult.build(409, "登陆错误");
		}
		
		return LuxtonResult.build(401, "您输入的用户名或密码错误");
	}

	
	
	@Override
	public LuxtonResult createAdmin(HttpServletRequest req,String username, String password) {

		String adminRole = (String) req.getSession().getAttribute("adminRole");
		if(adminRole.equals("admin")){
			
			LuxAdmin adminUser = new LuxAdmin();
			adminUser.setCreateTime(new Date());
			adminUser.setIdentity("user");
			adminUser.setUsername(username);
			
			//密码加密
			MD5 md5 = new MD5();
			password = md5.getMD5ofStr(md5.getMD5ofStr(password));
			adminUser.setPassword(password);
			
			adminMapper.insertSelective(adminUser);
		}else{
			return LuxtonResult.build(551, "权限不允许");
		}
		
		return LuxtonResult.ok();
	}

	
	
	
}
