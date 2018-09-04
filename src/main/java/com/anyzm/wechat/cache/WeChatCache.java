package com.anyzm.wechat.cache;

import com.anyzm.wechat.message.AccessToken;
import com.anyzm.wechat.model.Site;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by Anyzm on 2018/7/12
 */
public class WeChatCache {
    public static Map<String,Site> wechatSite = new ConcurrentHashMap<String,Site>();
    public static List<String> user = new ArrayList<String>();


    public static Site setAccessToken(String appId,AccessToken token){
        wechatSite.get(appId).setAccessToken(token);
        return  wechatSite.get(appId);
    }

    public static AccessToken getAccessToken(String appId){
        if(wechatSite.get(appId) == null){
            return null;
        }
        return  wechatSite.get(appId).getAccessToken();
    }
}
