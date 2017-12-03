package com.luxton.pojo;

import java.math.BigDecimal;

public class LuxItem {
    private Integer itemId;

    private String title;

    private String sellPoint;

    private Integer supplierId;

    private Integer catId;

    private BigDecimal price;

    private Boolean status;

    private String picUrl;

    private String picDetailed;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getPicDetailed() {
        return picDetailed;
    }

    public void setPicDetailed(String picDetailed) {
        this.picDetailed = picDetailed == null ? null : picDetailed.trim();
    }

	@Override
	public String toString() {
		return "LuxItem [itemId=" + itemId + ", title=" + title + ", sellPoint=" + sellPoint + ", supplierId="
				+ supplierId + ", catId=" + catId + ", price=" + price + ", status=" + status + ", picUrl=" + picUrl
				+ ", picDetailed=" + picDetailed + "]";
	}
    
    
    
    
}