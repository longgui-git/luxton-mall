package com.luxton.pojo;

public class LuxItemProperty {
    private Integer ipropertyId;

    private Integer itemId;

    private Integer propertyId;

    private Integer propertyValueId;

    private Integer skuId;

    private Boolean isSku;

    public Integer getIpropertyId() {
        return ipropertyId;
    }

    public void setIpropertyId(Integer ipropertyId) {
        this.ipropertyId = ipropertyId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Boolean getIsSku() {
        return isSku;
    }

    public void setIsSku(Boolean isSku) {
        this.isSku = isSku;
    }
}