package com.anyzm.wechat.util;

import java.util.Date;

public class MathUtil {
	public static String getRandomDigit20(){
		//生成附件名，规则为当前时间+随机数2位
//		SimpleDateFormat sdf = DateUtil.getSdf_yyyyMMddhhmmssSss();
		String randomDigit = DateUtil.sdf_yyyyMMddhhmmssSss.get().format(new Date()) + "_" + Math.round(Math.random()*100);
		return randomDigit;
	}
}
