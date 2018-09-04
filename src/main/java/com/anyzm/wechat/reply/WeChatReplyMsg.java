package com.anyzm.wechat.reply;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anyzm.wechat.cache.WeChatCache;
import com.anyzm.wechat.config.WeChatConfig;
import com.anyzm.wechat.message.imp.TextMessage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.LoggerFactory;


public class WeChatReplyMsg implements ReplyMsgInterface {


    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(WeChatReplyMsg.class);

	@Override
	public String sendText(String appId,String openId, Object obj) throws Exception {
		TextMessage msg = (TextMessage) obj;
		Gson gson =new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		String json = gson.toJson(msg);
		return sendMsg(appId,openId,json);
	}


	public String sendMsg(String appId,String openId, String json){

		String token = WeChatCache.getAccessToken(appId).getToken();
		String reply_msg_url = WeChatConfig.getInstance().getProperty("reply_msg_url");
		reply_msg_url = reply_msg_url.replaceAll("parameter1", token);
		HttpPost post = new HttpPost(reply_msg_url);
		post.setHeader("Content-Type", "text/html;charset=UTF-8");
		String responseMsg = null;
		String res = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			ByteArrayEntity e = new ByteArrayEntity(json.getBytes("UTF-8"));
			post.setEntity(e);
			HttpResponse execute = httpclient.execute(post);
			HttpEntity entity = execute.getEntity();
			if (execute.getStatusLine().getStatusCode() == 200) {
				responseMsg = EntityUtils.toString(entity, "UTF-8");
				// logger.info(publicUserId + "发给微信公众平台的响应" + responseMsg);
				GsonBuilder gb = new GsonBuilder();
				Gson g = gb.create();
				Map m = g.fromJson(responseMsg, Map.class);
				String errcode = String.valueOf(m.get("errcode"));
				if (errcode.equals("null") || Double.valueOf(errcode) == 0) {
					logger.info("发给微信公众平台成功，publicUserId：" +  appId + "，消息内容:" + json + "，响应：" + responseMsg );
				} else {
					if (!errcode.equals("null") && (Double.valueOf(errcode) == 42001 || Double.valueOf(errcode) == 40001)) {
						logger.error(appId + "发送消息出错，token过期,重新获取token........");
					} else {
						logger.error(appId+ "发送json消息出错，错误代码为:" + errcode);
					}
				}
				res = errcode;
			} else {
				logger.error("48小时回复接口：服务器无响应！");
				res = String.valueOf(execute.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				post.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return res;
	}


}
