package com.luxton.pojo;

import java.util.Date;

public class LuxAdvert {
    private Integer advertId;

    private Integer typeId;

    private Integer itemId;

    private Integer sortNum;

    private String itemRecommend;

    private Date createTime;

    public Integer getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Integer advertId) {
        this.advertId = advertId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getItemRecommend() {
        return itemRecommend;
    }

    public void setItemRecommend(String itemRecommend) {
        this.itemRecommend = itemRecommend == null ? null : itemRecommend.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}