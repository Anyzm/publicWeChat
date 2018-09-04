package com.anyzm.wechat.service;

import com.anyzm.wechat.cache.WeChatCache;
import com.anyzm.wechat.config.WeChatConfig;
import com.anyzm.wechat.message.ReceiveXml;
import com.anyzm.wechat.message.SendXml;
import com.anyzm.wechat.util.FileUpDownUtil;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * create by Anyzm on 2018/8/5
 */
public class DealMsg {
    public static SendXml dealMsg(ReceiveXml request){
        if(StringUtils.isBlank(request.getMsgType())){
            return null;
        }
        SendXml sendMsg = null;
        switch (request.getMsgType()){
            case "text":
                sendMsg = new SendXml();
                sendMsg.setToUserName(request.getFromUserName());
                sendMsg.setFromUserName(request.getToUserName());
                sendMsg.setMsgType(request.getMsgType());
                sendMsg.setContent(request.getContent());
                break;
            case "image":
                sendMsg = new SendXml();
                sendMsg.setToUserName(request.getFromUserName());
                sendMsg.setFromUserName(request.getToUserName());
                sendMsg.setMsgType(request.getMsgType());
                File file = FileUpDownUtil.downFile(request.getPicUrl(), WeChatConfig.getInstance().getProperty("temp_file_dir"), null);
                String uploadUrl = WeChatConfig.getInstance().getProperty("upload_media_url");
                String token = WeChatCache.getAccessToken(request.getToUserName()).getToken();
                uploadUrl = uploadUrl.replace("parameter1", token);
                uploadUrl = uploadUrl.replace("parameter2",request.getMsgType());
                String s = null;
                try {
//                    s = FileUpDownUtil.uploadFile(uploadUrl, file.getName());
                    s = FileUpDownUtil.uploadFile(uploadUrl, "20180828195123409_62.jpg");
                    JSONObject jsonObject = JSONObject.fromObject(s);
                    SendXml.Image image = new SendXml.Image();
                    image.setMediaId(jsonObject.getString("media_id"));
//                    image.setMediaId(request.getMediaId());
                    sendMsg.setImage(image);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "vovice":
//                sendMsg.setToUserName(request.getFromUserName());
//                sendMsg.setFromUserName(request.getToUserName());
//                sendMsg.setMsgType(request.getMsgType());
//                sendMsg.setContent(request.getContent());
                break;
            case "location":
//                sendMsg.setToUserName(request.getFromUserName());
//                sendMsg.setFromUserName(request.getToUserName());
//                sendMsg.setMsgType(request.getMsgType());
//                sendMsg.setContent(request.getContent());
//                sendMsg.setLabel(request.getLabel());
//                sendMsg.setLocation_X(request.getLocation_X());
//                sendMsg.setLocation_Y(request.getLocation_Y());
//                sendMsg.setScale(request.getScale());
                break;
            default:
                sendMsg.setToUserName(request.getFromUserName());
                sendMsg.setFromUserName(request.getToUserName());
                sendMsg.setMsgType("text");
                sendMsg.setContent("不好意思，您所发的消息，暂时不支持");
        }
        return sendMsg;
    }
}
