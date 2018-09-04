package com.anyzm.wechat.model;

import java.io.File;
import java.util.Properties;
import com.anyzm.wechat.message.AccessToken;

public class Site {
	private String name;
	private AccessToken accessToken;
	private String appId;
	private String appSecret;
	private String propertiesFileName;
	private String nonce;
	private String timeStamp;
	private String fileNamePrefix = "properties";
	private Properties p = new Properties();

	public String getPropertiesFileName() {
		return propertiesFileName;
	}
	public void setPropertiesFileName(String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
		if(propertiesFileName != null && !propertiesFileName.trim().equals("")){
			try{
				p.load(this.getClass().getClassLoader().getResourceAsStream(fileNamePrefix + File.separator + propertiesFileName));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public Properties getP() {
		return p;
	}
	public AccessToken getAccessToken() {
		return accessToken;
	}
	public void setP(Properties p) {
		this.p = p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProperty(String key){
		return p.getProperty(key);
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void refreshSiteConfig(){
		if(propertiesFileName != null && !propertiesFileName.trim().equals("")){
			try{
				p.load(this.getClass().getClassLoader().getResourceAsStream(fileNamePrefix + File.separator + propertiesFileName));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
