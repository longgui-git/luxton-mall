package com.luxton.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxton.mapper.LuxUserMapper;
import com.luxton.pojo.LuxUser;
import com.luxton.pojo.LuxUserExample;
import com.luxton.pojo.common.DataWithPageResults;
import com.luxton.service.UserService;
import com.luxton.utils.LuxtonResult;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private LuxUserMapper userMapper;
	
	@Override
	public LuxtonResult getUserList(Integer page, Integer stage) {

		PageHelper.startPage(page, stage);
		
		List<LuxUser> list = userMapper.selectByExample(null);
		
		DataWithPageResults data = new DataWithPageResults();
		data.setRows(list);
		
		PageInfo<LuxUser> info = new PageInfo<>(list);
		data.setTotal(info.getTotal());
		
		return LuxtonResult.ok(data);
	}

	@Override
	public LuxtonResult getUserByUserName(String userName) {

		
		return LuxtonResult.ok(userMapper.getUserByUserName(userName));
	}

	@Override
	public LuxtonResult insertUser(LuxUser user) {

		if(user.getUserId() == null){
			
			LuxUserExample example = new LuxUserExample();
			example.createCriteria().andUsernameEqualTo(user.getUsername());
			List<LuxUser> list = userMapper.selectByExample(example);
			if(list!=null && list.size()>0){
				return LuxtonResult.build(556, "用户名已存在");
			}
			
			user.setCreateTime(new Date());
			userMapper.insertSelective(user);
		}else{
			userMapper.updateByPrimaryKeySelective(user);
		}
		
		return LuxtonResult.ok();
	}

}
