package com.anyzm.wechat.test;

import com.anyzm.wechat.util.WeixinUtil;

public class WeixinTest {
	public static void main(String[] args) {
		try {
			//GetToken token = WeixinUtil.getAccessToken();
			//System.out.println("票据"+token.getToken());
			//System.out.println("有效时间"+token.getExpiresIn());
			
			//String path = "D:/imooc.jpg";
			//String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
			//System.out.println(mediaId);
			
			String result = WeixinUtil.translate("my name is laobi");
			//String result = WeixinUtil.translateFull("");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
