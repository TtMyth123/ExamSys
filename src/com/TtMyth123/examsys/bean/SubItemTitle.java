package com.TtMyth123.examsys.bean;

/**
 * ����Ŀ����.
 * @author S5
 *
 */
public class SubItemTitle {
	 private Object item = "";

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		if (item == null) {
			this.item = "";
		} else {
			this.item = item;
		}
	}
	 
	 
}
