package com.anyzm.wechat.controller;

import com.anyzm.wechat.cache.MenuDataCache;
import com.anyzm.wechat.cache.WeChatCache;
import com.anyzm.wechat.config.HttpClientUtil;
import com.anyzm.wechat.config.WeChatConfig;
import com.anyzm.wechat.message.ReceiveXml;
import com.anyzm.wechat.message.SendXml;
import com.anyzm.wechat.service.DealMsg;
import com.anyzm.wechat.util.CheckUtil;
import com.anyzm.wechat.util.MessageUtil;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Map;
import java.util.Set;

/**
 * create by Anyzm on 2018/6/13
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @GetMapping(value = "/test")
    public String test(){
        return "ok";
    }

    /**
     * 公众号对接接口
     * @param req
     * @param resp
     */
    @GetMapping(value = "/entrance")
    public void getEntrance(HttpServletRequest req, HttpServletResponse resp){
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            out.print(echostr);
        }else{
            out.print(false);
        }
    }

    /**
     * 公众号接收消息接口
     * @param req
     * @param resp
     */
    @PostMapping(value = "/entrance")
    public String postEntrance(HttpServletRequest req) {
        String s = "";
        try {
            StringReader reader = new StringReader("");
            String xmlmsg = IOUtils.toString(req.getInputStream(), "utf-8");
            System.out.println("收到消息：" + xmlmsg);
            ReceiveXml requestMsg = MessageUtil.parseToReceiveXml(xmlmsg);
            SendXml sendXml = DealMsg.dealMsg(requestMsg);
            if(sendXml != null) {
                s = MessageUtil.parseToString(sendXml);
            }
            System.out.println("回复消息：" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }


    @GetMapping(value = "/pushMenu")
    @ResponseBody
    public Object pushMenu(@RequestParam("wxId") String wxId) throws IOException {
        String create_menu_url = WeChatConfig.getInstance().getProperty("create_menu_url");
        String token = WeChatCache.getAccessToken(wxId).getToken();
        create_menu_url = create_menu_url.replace("parameter1",token );
        JSONObject jsonObject = HttpClientUtil.doPostStr(create_menu_url, MenuDataCache.menu);
        return jsonObject;
    }

    @GetMapping(value = "/pushMsg")
    @ResponseBody
    public Object pushMsg(@RequestParam("msg") String msg) throws IOException {
        String push_kf_message_url = WeChatConfig.getInstance().getProperty("push_kf_message_url");
        Set<String> strings = WeChatCache.wechatSite.keySet();
        JSONObject jsonObject = null;
        for(String appId : strings){
            String json = "{" +
                    "    \"touser\":\"o_V7-0gfBdJJh4svuAfbydEIjaRU\"," +
                    "    \"msgtype\":\"text\"," +
                    "    \"text\":\n" +
                    "    {" +
                    "         \"content\":\""+ msg +
                    " \"  }" +
                    "}";
            String token = WeChatCache.getAccessToken(appId).getToken();
            push_kf_message_url = push_kf_message_url.replace("parameter1",token );
            jsonObject = HttpClientUtil.doPostStr(push_kf_message_url, json);
        }
        return jsonObject;
    }

    @GetMapping(value = "/pushTemplate")
    @ResponseBody
    public Object pushTemplate(@RequestParam("msg") String msg) throws IOException {
        String push_template_url = WeChatConfig.getInstance().getProperty("push_template_url");
        Set<String> strings = WeChatCache.wechatSite.keySet();
        JSONObject jsonObject = null;
        for(String wxId : strings){
            String json = "   {" +
                    "           \"touser\":\"o_V7-0gfBdJJh4svuAfbydEIjaRU\"," +
                    "           \"template_id\":\"VoeIBtz02Dy6eeU4zD9KolXYULjhWCY8FRupc5UCifQ\"," +
                    "           \"data\":{" +
//                    "                   \"first\": {" +
//                    "                       \"value\":\"恭喜你购买成功！\"," +
//                    "                       \"color\":\"#173177\"" +
//                    "                   }," +
                    "                   \"xyz\":{" +
                    "                       \"value\":\"" + msg +
                    "                  \",     \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"remark\":{" +
                    "                       \"value\":\"欢迎再次购买！\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }" +
                    "           }" +
                    "       }";
            String token = WeChatCache.getAccessToken(wxId).getToken();
            push_template_url = push_template_url.replace("parameter1",token );
            System.out.println(json);
            jsonObject = HttpClientUtil.doPostStr(push_template_url, json);
            jsonObject.put("msg",json);
        }
        return jsonObject;
    }

}
