package com.anyzm.wechat.util;

import java.util.Arrays;


public class Tool {
	public static final String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

	//解密
	public static String decryption(String appId,String token,String encodingAesKey,String signature,String nonce,String timestamp,String msg){
		String result = null;
		try{
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			result = pc.decryptMsg(signature, timestamp, nonce, msg);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//加密
	public static String encryption(String appId,String token,String encodingAesKey,String nonce,String timestamp,String msg){
		String result = null;
		try{
			WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
			result = pc.encryptMsg(msg, timestamp, nonce);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
