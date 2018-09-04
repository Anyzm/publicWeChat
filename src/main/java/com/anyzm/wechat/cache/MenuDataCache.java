package com.anyzm.wechat.cache;

/**
 * create by Anyzm on 2018/8/4
 */
public class MenuDataCache {
    public static String menu = "{\n" +
            "    \"button\": [\n" +
            "        {\n" +
            "            \"name\": \"打码\", \n" +
            "            \"sub_button\": [\n" +
            "                {\n" +
            "                    \"type\": \"scancode_waitmsg\", \n" +
            "                    \"name\": \"扫码带提示\", \n" +
            "                    \"key\": \"rselfmenu_0_0\", \n" +
            "                    \"sub_button\": [ ]\n" +
            "                }, \n" +
            "                {\n" +
            "                    \"type\": \"scancode_push\", \n" +
            "                    \"name\": \"扫码推事件\", \n" +
            "                    \"key\": \"rselfmenu_0_1\", \n" +
            "                    \"sub_button\": [ ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }, \n" +
            "        {\n" +
            "            \"name\": \"发送图片\", \n" +
            "            \"sub_button\": [\n" +
            "                {\n" +
            "                    \"type\": \"pic_sysphoto\", \n" +
            "                    \"name\": \"系统拍照发图\", \n" +
            "                    \"key\": \"rselfmenu_1_0\", \n" +
            "                   \"sub_button\": [ ]\n" +
            "                 }, \n" +
            "                {\n" +
            "                    \"type\": \"pic_photo_or_album\", \n" +
            "                    \"name\": \"拍照或者相册发图\", \n" +
            "                    \"key\": \"rselfmenu_1_1\", \n" +
            "                    \"sub_button\": [ ]\n" +
            "                }, \n" +
            "                {\n" +
            "                    \"type\": \"pic_weixin\", \n" +
            "                    \"name\": \"微信相册发图\", \n" +
            "                    \"key\": \"rselfmenu_1_2\", \n" +
            "                    \"sub_button\": [ ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }, \n" +
            "        {\n" +
            "            \"name\": \"发送位置\", \n" +
            "            \"type\": \"location_select\", \n" +
            "            \"key\": \"rselfmenu_2_0\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
