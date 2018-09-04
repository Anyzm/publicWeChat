package com.anyzm.wechat.reply;

import java.io.File;


public interface ReplyMsgInterface {
	public  String sendText(String appId,String openId, Object obj)throws Exception;

}
