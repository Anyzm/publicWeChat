package com.anyzm.wechat.config;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.zip.ZipEntry;

import com.anyzm.wechat.cache.WeChatCache;
import com.anyzm.wechat.message.AccessToken;
import com.anyzm.wechat.model.Site;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class GetToken {
	private static final String slaveTokenBeanName = "slavetoken";
	private String appId;
	private AccessToken accessToken;
	public AccessToken GetAccessToken() {
		return accessToken;
	}
	private static final Logger logger = Logger.getLogger(GetToken.class);
	public synchronized static String getAccessToken(String wxId, boolean force){
		synchronized(wxId){
			AccessToken token = WeChatCache.getAccessToken(wxId);
			boolean flag = false;
			if(token != null && (System.currentTimeMillis() - token.getCreateTime() > Integer.valueOf(WeChatConfig.getInstance().getProperty("token_expiration_time"))*1000)){
				flag = true;
			}
			if (force || token == null || flag) {
                String url = WeChatConfig.getInstance().getProperty("tokenurl");
				Site site = WeChatCache.wechatSite.get(wxId);
                url = url.replace("parameter1", site.getAppId());
                url = url.replace("parameter2",site.getAppSecret());
              token = new AccessToken();
                try {
                    JSONObject jsonObject = HttpClientUtil.doGetStr(url);
                    if(jsonObject != null && jsonObject.get("error_code")==null ) {
                        token.setCreateTime(System.currentTimeMillis());
                        token.setExpiresIn(jsonObject.getInt("expires_in"));
                        token.setToken(jsonObject.getString("access_token"));
                        WeChatCache.setAccessToken(wxId, token);
                        System.out.println(wxId + "获取token成功:" + token);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
			return token.getToken();
		}
		
		
	}
}
