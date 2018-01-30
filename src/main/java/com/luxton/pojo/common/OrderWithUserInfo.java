package com.luxton.pojo.common;

import com.luxton.pojo.LuxOrder;

public class OrderWithUserInfo extends LuxOrder {

	private String name;
	
	private String phone;

	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
