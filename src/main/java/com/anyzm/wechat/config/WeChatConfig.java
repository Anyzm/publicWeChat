package com.anyzm.wechat.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WeChatConfig {
	public static Gson gson = new GsonBuilder().create();
	private static WeChatConfig weChatConfig;
	private  static  Properties properties = new Properties();
	private static List<String> groups = new ArrayList<String>();
	private WeChatConfig() {
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("properties" + File.separator + "weChat.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WeChatConfig getInstance(){
		if(weChatConfig == null){
			weChatConfig = new WeChatConfig();
		}
		return weChatConfig;
	}
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	
	public static void refreshConfig(){
		InputStream is=null;
		try {
			is=WeChatConfig.class.getClassLoader().getResourceAsStream("properties" + File.separator +  "weChatConfig.properties");
			properties.load(is);
			String mtlxs = properties.getProperty("mtlxs");
			String[] array = mtlxs.split(";");
			for(int i=0;i<array.length;i++){
				String[] pros = array[i].split(",");
				String key = pros[0];
				String value = pros[1];
				properties.put(key, value);
			}
			String[] temps  = properties.getProperty("groups").split(",");
			for(int i=0;i<temps.length;i++){
				groups.add(temps[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
