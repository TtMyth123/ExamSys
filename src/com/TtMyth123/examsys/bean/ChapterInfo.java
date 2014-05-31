package com.TtMyth123.examsys.bean;

import android.content.Intent;
import android.database.Cursor;

public class ChapterInfo {
	private int cptID;
	private String chapter;
	private int sbjID;
	private int srcID;
	private boolean enabled;
	private int sortID;
	private int testCount;
	private String s;
	private boolean e;
	private int testedNum;
	private int baseCptID;
	private String lastTestTime;
	private int errTestedNum;

	public int getCptID() {
		return cptID;
	}

	public void setCptID(int cptID) {
		this.cptID = cptID;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public int getSbjID() {
		return sbjID;
	}

	public void setSbjID(int sbjID) {
		this.sbjID = sbjID;
	}

	public int getSrcID() {
		return srcID;
	}

	public void setSrcID(int srcID) {
		this.srcID = srcID;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getSortID() {
		return sortID;
	}

	public void setSortID(int sortID) {
		this.sortID = sortID;
	}

	public int getTestCount() {
		return testCount;
	}

	public void setTestCount(int testCount) {
		this.testCount = testCount;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public boolean isE() {
		return e;
	}

	public void setE(boolean e) {
		this.e = e;
	}

	public int getTestedNum() {
		return testedNum;
	}

	public void setTestedNum(int testedNum) {
		this.testedNum = testedNum;
	}

	public int getBaseCptID() {
		return baseCptID;
	}

	public void setBaseCptID(int baseCptID) {
		this.baseCptID = baseCptID;
	}

	public String getLastTestTime() {
		return lastTestTime;
	}

	public void setLastTestTime(String lastTestTime) {
		this.lastTestTime = lastTestTime;
	}

	public int getErrTestedNum() {
		return errTestedNum;
	}

	public void setErrTestedNum(int errTestedNum) {
		this.errTestedNum = errTestedNum;
	}

	public void copyValue(Cursor cursor) {
		setCptID(cursor.getInt(cursor.getColumnIndex("CptID")));
		setChapter(cursor.getString(cursor.getColumnIndex("Chapter")));
		setSbjID(cursor.getInt(cursor.getColumnIndex("SbjID")));
		setSrcID(cursor.getInt(cursor.getColumnIndex("SrcID")));
		setEnabled(cursor.getInt(cursor.getColumnIndex("Enabled")) == 1);
		setSortID(cursor.getInt(cursor.getColumnIndex("Sortid")));
		setTestCount(cursor.getInt(cursor.getColumnIndex("TestCount")));
		setS(cursor.getString(cursor.getColumnIndex("S")));
		setE(cursor.getInt(cursor.getColumnIndex("E")) == 1);
		setTestedNum(cursor.getInt(cursor.getColumnIndex("TestedNum")));
		setLastTestTime(cursor.getString(cursor.getColumnIndex("LastTestTime")));
		setErrTestedNum(cursor.getInt(cursor.getColumnIndex("ErrTestedNum")));
	}

	public void copyValue(Intent cursor) {
		setCptID(cursor.getExtras().getInt(ExtrasKey1));
		setChapter(cursor.getExtras().getString(ExtrasKey2));
		setSbjID(cursor.getExtras().getInt(ExtrasKey3));
		setSrcID(cursor.getExtras().getInt(ExtrasKey4));
		setEnabled(cursor.getExtras().getBoolean(ExtrasKey5));
		setSortID(cursor.getExtras().getInt(ExtrasKey6));
		setTestCount(cursor.getExtras().getInt(ExtrasKey7));
		setS(cursor.getExtras().getString(ExtrasKey8));
		setE(cursor.getExtras().getBoolean(ExtrasKey9));
		setTestedNum(cursor.getExtras().getInt(ExtrasKey10));
		setLastTestTime(cursor.getExtras().getString(ExtrasKey11));
		setErrTestedNum(cursor.getExtras().getInt(ExtrasKey12));
	}

	public void toValue(Intent cursor) {
		cursor.putExtra(ExtrasKey1, getCptID());
		cursor.putExtra(ExtrasKey2, getChapter());
		cursor.putExtra(ExtrasKey3, getSbjID());
		cursor.putExtra(ExtrasKey4, getSrcID());
		cursor.putExtra(ExtrasKey5, isEnabled());
		cursor.putExtra(ExtrasKey6, getSortID());
		cursor.putExtra(ExtrasKey7, getTestCount());
		cursor.putExtra(ExtrasKey8, getS());
		cursor.putExtra(ExtrasKey9, isE());
		cursor.putExtra(ExtrasKey10, getTestedNum());
		cursor.putExtra(ExtrasKey11, getLastTestTime());
		cursor.putExtra(ExtrasKey12, getErrTestedNum());
	}

	String ExtrasKey1 = "ExtrasKey1";
	String ExtrasKey2 = "ExtrasKey2";
	String ExtrasKey3 = "ExtrasKey3";
	String ExtrasKey4 = "ExtrasKey4";
	String ExtrasKey5 = "ExtrasKey5";
	String ExtrasKey6 = "ExtrasKey6";
	String ExtrasKey7 = "ExtrasKey7";
	String ExtrasKey8 = "ExtrasKey8";
	String ExtrasKey9 = "ExtrasKey9";
	String ExtrasKey10 = "ExtrasKey10";
	String ExtrasKey11 = "ExtrasKey11";
	String ExtrasKey12 = "ExtrasKey12";

}
