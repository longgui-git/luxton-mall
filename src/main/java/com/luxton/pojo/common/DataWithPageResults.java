package com.luxton.pojo.common;

import java.util.List;
/*
 * 分页查询时存储查询结果的类
 */
public class DataWithPageResults {

	private Long total;
	
	private List<?> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
 	
}
