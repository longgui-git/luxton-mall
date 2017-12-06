package com.luxton.pojo.common;

import com.luxton.pojo.LuxItem;

public class AdvertWithItem extends LuxItem{

	private Integer advertId;
	
	private String itemRecommend;
	
	private Integer sortNum;
	
	private String typeTitle;
	
	private Integer typeId;

	public Integer getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
	}

	public String getItemRecommend() {
		return itemRecommend;
	}

	public void setItemRecommend(String itemRecommend) {
		this.itemRecommend = itemRecommend;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getTypeTitle() {
		return typeTitle;
	}

	public void setTypeTitle(String typeTitle) {
		this.typeTitle = typeTitle;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	
	
	
}
