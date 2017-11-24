package com.luxton.service.impl.pc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxRegisterCodeMapper;
import com.luxton.mapper.LuxUserMapper;
import com.luxton.pojo.LuxRegisterCode;
import com.luxton.pojo.LuxUser;
import com.luxton.pojo.LuxUserExample;
import com.luxton.service.pc.UserLoginService;
import com.luxton.utils.LuxtonResult;
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private LuxUserMapper userMapper;
	
	@Autowired
	private LuxRegisterCodeMapper codeMapper;

	@Override
	public LuxtonResult createUser(LuxUser user,String registerCode) {

		LuxRegisterCode code = codeMapper.selectByPrimaryKey(registerCode);
		if(code==null){
			//注册码错误返回错误信息
			return LuxtonResult.build(573, "注册码错误");
		}
		
		//  用户名 和 电话  不能重复
		LuxUserExample example = new LuxUserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		
		List<LuxUser> list = userMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return LuxtonResult.build(556, "用户名已存在");
		}
		
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		
		userMapper.insertSelective(user);
		
		//注册码用完后删除
		codeMapper.deleteByPrimaryKey(registerCode);
		
		return LuxtonResult.ok();
	}

	@Override
	public LuxtonResult getUserLogin(HttpServletRequest req, String username,String password) {

		LuxUserExample example = new LuxUserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		
		List<LuxUser> list = userMapper.selectByExample(example);
		
		if(list!=null && list.size()>0){
			LuxUser user = list.get(0);
			//验证正确
			req.getSession().setAttribute("userId", user.getUserId());
		}
		
		return LuxtonResult.build(572, "用户名或密码错误");
	}
	
	
	
	
}
