package com.anyzm.wechat.util;

import java.text.SimpleDateFormat;

public class DateUtil {
//	private static SimpleDateFormat sdf_yyyyMMdd = new  SimpleDateFormat("yyyy-MM-dd");
//	private static SimpleDateFormat sdf_yyyyMMdd_hhmmss = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private static SimpleDateFormat sdf_yyyyMMddhhmmss = new  SimpleDateFormat("yyyyMMddHHmmss");
//	private static SimpleDateFormat sdf_yyyyMMddhhmmssSss = new  SimpleDateFormat("yyyyMMddHHmmssSSS");
//	private static SimpleDateFormat sdf_4y2M2d = new  SimpleDateFormat("yyyyMMdd");
//	public static  SimpleDateFormat format_second = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	public  static final ThreadLocal<SimpleDateFormat>sdf_yyyyMMdd=
			new  ThreadLocal<SimpleDateFormat>(){
				@Override
				protected SimpleDateFormat initialValue(){
					return new SimpleDateFormat("yyyy-MM-dd");
				}
			};
	public  static final ThreadLocal<SimpleDateFormat>sdf_yyyyMMdd_hhmmss=
					new  ThreadLocal<SimpleDateFormat>(){
				@Override
				protected SimpleDateFormat initialValue(){
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				}
			};
	public  static final ThreadLocal<SimpleDateFormat>sdf_yyyyMMddhhmmss=
					new  ThreadLocal<SimpleDateFormat>(){
				@Override
				protected SimpleDateFormat initialValue(){
					return new SimpleDateFormat("yyyyMMddHHmmss");
				}
			};
	public  static final ThreadLocal<SimpleDateFormat>sdf_yyyyMMddhhmmssSss=
					new  ThreadLocal<SimpleDateFormat>(){
				@Override
				protected SimpleDateFormat initialValue(){
					return new SimpleDateFormat("yyyyMMddHHmmssSSS");
				}
			};
	public  static final ThreadLocal<SimpleDateFormat>sdf_4y2M2d=
					new  ThreadLocal<SimpleDateFormat>(){
				@Override
				protected SimpleDateFormat initialValue(){
					return new SimpleDateFormat("yyyyMMdd");
				}
			};
	public  static final ThreadLocal<SimpleDateFormat>format_second=
					new  ThreadLocal<SimpleDateFormat>(){
				@Override
				protected SimpleDateFormat initialValue(){
					return new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				}
			};

	/*public static SimpleDateFormat getSdf_yyyyMMdd() {
		return sdf_yyyyMMdd;
	}
	public static SimpleDateFormat getSdf_yyyyMMdd_hhmmss() {
		return sdf_yyyyMMdd_hhmmss;
	}
	public static SimpleDateFormat getSdf_yyyyMMddhhmmss() {
		return sdf_yyyyMMddhhmmss;
	}
	public static SimpleDateFormat getSdf_yyyyMMddhhmmssSss() {
		return sdf_yyyyMMddhhmmssSss;
	}
	public static SimpleDateFormat getSdf_4y2M2d() {
		return sdf_4y2M2d;
	}*/

	
}
