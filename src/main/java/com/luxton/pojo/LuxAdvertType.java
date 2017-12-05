package com.luxton.pojo;

public class LuxAdvertType {
    private Integer typeId;

    private String typeTitle;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle == null ? null : typeTitle.trim();
    }
}