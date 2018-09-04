package com.anyzm.wechat.config;

import com.anyzm.wechat.cache.WeChatCache;
import com.anyzm.wechat.message.AccessToken;
import com.anyzm.wechat.model.Site;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * create by Anyzm on 2018/7/12
 */
@Component
public class InitCache implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String weChatList = WeChatConfig.getInstance().getProperty("weChatList");
        String[] split = weChatList.split(",");
        for(String wxId:split){
            Site site = new Site();
            site.setPropertiesFileName(wxId + ".properties");
            site.setAppId(site.getProperty("appId"));
            site.setAppSecret(site.getProperty("appSecret"));
            WeChatCache.wechatSite.put(wxId,site);
            GetToken.getAccessToken(wxId,true);
        }
    }
}
