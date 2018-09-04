package com.anyzm.wechat.message;

public class AccessToken {
	private String token;
	private int expiresIn;
	private long createTime = System.currentTimeMillis();
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString(){
		return "[token: "+ this.token +",expiresIn:"+ this.expiresIn +",createTime:"+ this.createTime +"]";
	}
}
