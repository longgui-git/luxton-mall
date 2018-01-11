package com.luxton.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxAdminMapper;
import com.luxton.mapper.LuxRegisterCodeMapper;
import com.luxton.pojo.LuxAdmin;
import com.luxton.pojo.LuxAdminExample;
import com.luxton.pojo.LuxAdminExample.Criteria;
import com.luxton.pojo.LuxRegisterCode;
import com.luxton.service.AdminLoginService;
import com.luxton.utils.LuxtonResult;
import com.luxton.utils.MD5;
@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private LuxAdminMapper adminMapper;
	
	@Autowired
	private LuxRegisterCodeMapper codeMapper;
	
	@Override
	public LuxtonResult getAdminLogin(HttpServletRequest req,String username, String password) {

		
//		md5加密
		MD5 md5 = new MD5();
		try{
			if(password!=null){
				password = md5.getMD5ofStr(md5.getMD5ofStr(password));
			}
			//添加查询条件
			
			LuxAdminExample example = new LuxAdminExample();
			example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
			
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

		try {
			String adminRole = "admin";
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
		} catch (Exception e) {
			return LuxtonResult.build(549, "参数错误");
		}
		
		
		return LuxtonResult.ok();
	}


	
	
	

	@Override
	public LuxtonResult getAdminList(HttpServletRequest req) {
		
		//取出身份监测是否是最高管理员
		String adminRole = (String) req.getSession().getAttribute("adminRole");
				
		if(adminRole.equals("admin")){
			
			LuxAdminExample example = new LuxAdminExample();
			List<LuxAdmin> list = adminMapper.selectByExample(example);
			
			return LuxtonResult.ok(list);
		}else{
			return LuxtonResult.build(551, "权限不允许");
		}
		
	}



	@Override
	public LuxtonResult deleteAdmin(HttpServletRequest req ,Integer adminId) {
		
		String adminRole = "admin";
//		String adminRole = (String) req.getSession().getAttribute("adminRole");
		
		if(adminRole.equals("admin")){
			
			LuxAdmin admin = adminMapper.selectByPrimaryKey(adminId);
			if(admin.getIdentity().equals("user")){
				adminMapper.deleteByPrimaryKey(adminId);
			}
			
		}else{
			return LuxtonResult.build(551, "权限不允许");
		}
		
		
		
		return LuxtonResult.ok();
	}



	@Override
	public LuxtonResult createRegisterCode() {

		LuxRegisterCode code = new LuxRegisterCode();
		code.setCreateTime(new Date());
		
		String registerCode = RandomStringUtils.random(10, 0, 0, true, true, null);
		code.setRegisterCode(registerCode);
		
		codeMapper.insert(code);
		
		return LuxtonResult.ok(registerCode);
	}

	
	
	
}
