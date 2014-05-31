package com.TtMyth123.examsys.base;

import android.os.Message;

public class SimpleNewMessageBuilder {
	public static String Data_MsgKey = "Handle_Key";
	static public  Message createSimpleMessage(final String msgValue) {
		Message msg = new Message();
		msg.getData().putString(Data_MsgKey, msgValue);
		return msg;
	}
	static public String getSimpleMessage(Message msg){
		return msg.getData().getString(Data_MsgKey);
	}
}