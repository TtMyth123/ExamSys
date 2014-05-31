package com.TtMyth123.examsys.bean;

import android.graphics.Bitmap;

public class SourceInfo {
	private String source;
	private int sortID;
	private int srcID;
	private Bitmap bitmap;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getSortID() {
		return sortID;
	}
	public void setSortID(int sortID) {
		this.sortID = sortID;
	}
	public int getSrcID() {
		return srcID;
	}
	public void setSrcID(int srcID) {
		this.srcID = srcID;
	}
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
}
