package com.x.processplatform.core.entity.query;

import com.x.base.core.gson.GsonPropertyObject;

public class CalculateRow extends GsonPropertyObject {

	private String column;

	private String displayName;

	private Object value;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
