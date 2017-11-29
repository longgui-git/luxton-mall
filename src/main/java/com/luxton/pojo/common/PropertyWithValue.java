package com.luxton.pojo.common;

import java.util.List;

import com.luxton.pojo.LuxProperty;
import com.luxton.pojo.LuxPropertyValue;

public class PropertyWithValue {

	private LuxProperty property;
	
	private List<LuxPropertyValue> values;

	
	public LuxProperty getProperty() {
		return property;
	}

	public void setProperty(LuxProperty property) {
		this.property = property;
	}

	public List<LuxPropertyValue> getValues() {
		return values;
	}

	public void setValues(List<LuxPropertyValue> values) {
		this.values = values;
	}
	
	
}
