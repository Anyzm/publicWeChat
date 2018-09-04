package com.anyzm.wechat.util;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.anyzm.wechat.message.*;
import com.anyzm.wechat.message.imp.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.thoughtworks.xstream.XStream;

/**
 * 消息封装类
 * @author Stephen
 *
 */
public class MessageUtil {

	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";

/*	private static JAXBContext reqcontext;
	private static JAXBContext respcontext;
	private static Unmarshaller um;
	private static Marshaller m;
	private static Unmarshaller um_response;
	private static Marshaller m_request;

	static{
		try {
			reqcontext = JAXBContext.newInstance(ReceiveXml.class);
			respcontext = JAXBContext.newInstance(SendXml.class);
			um = reqcontext.createUnmarshaller();
			m = respcontext.createMarshaller();
			m_request = reqcontext.createMarshaller();
			um_response=respcontext.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public static ReceiveXml parseToReceiveXml(String xml){
		StringReader sr = new StringReader(xml);
		ReceiveXml req = null;
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(ReceiveXml.class).createUnmarshaller();
			req = (ReceiveXml) unmarshaller.unmarshal(sr);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
	}

	public synchronized static String parseToString(ReceiveXml xml){
		StringWriter sw = new StringWriter();
		String res = null;
		try {
			Marshaller marshaller = JAXBContext.newInstance(ReceiveXml.class).createMarshaller();
			marshaller.marshal(xml,sw);
			res = deleteXmlNamespaces(sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public synchronized static SendXml parseToSendXml(String xml){
		StringReader sr = new StringReader(xml);
		SendXml req = null;
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(SendXml.class).createUnmarshaller();
			req = (SendXml) unmarshaller.unmarshal(sr);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (SendXml)req;
	}
	public static String parseToString(SendXml xml){
		StringWriter sw = new StringWriter();
		String res = null;
		try {
			Marshaller marshaller = JAXBContext.newInstance(SendXml.class).createMarshaller();
			marshaller.marshal(xml,sw);
			res = deleteXmlNamespaces(sw.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return res;
	}

	private synchronized static String deleteXmlNamespaces(String xml) {
		int pos = xml.indexOf("<ToUserName>");
		String msg = "<xml>" + xml;
		if(pos > -1) {
			msg = "<xml>" + xml.substring(pos);
		}
		return msg;
	}

	public synchronized static String parse3(Object resp){
		StringWriter sw = new StringWriter();
		String res = null;
		try {
			Marshaller marshaller = JAXBContext.newInstance(ReceiveXml.class).createMarshaller();
			marshaller.marshal(resp,sw);
			res = deleteXmlNamespaces(sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}



	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);

		Element root = doc.getRootElement();

		List<Element> list = root.elements();

		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}

	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 组装文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(System.currentTimeMillis());
		text.setContent(content);
		return textMessageToXml(text);
	}

	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
		sb.append("1、课程介绍\n");
		sb.append("2、慕课网介绍\n");
		sb.append("3、词组翻译\n\n");
		sb.append("回复？调出此菜单。");
		return sb.toString();
	}

	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("本套课程介绍微信公众号开发，主要涉及公众号介绍、编辑模式介绍、开发模式介绍等");
		return sb.toString();
	}

	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。");
		sb.append("慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
		return sb.toString();
	}

	public static String threeMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("词组翻译使用指南\n\n");
		sb.append("使用示例：\n");
		sb.append("翻译足球\n");
		sb.append("翻译中国足球\n");
		sb.append("翻译football\n\n");
		sb.append("回复？显示主菜单。");
		return sb.toString();
	}
	/**
	 * 图文消息转为xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * 音乐消息转为xml
	 * @param musicMessage
	 * @return
	 */
	public static String musicMessageToXml(MusicMessage musicMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();

		News news = new News();
		news.setTitle("慕课网介绍");
		news.setDescription("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。");
		news.setPicUrl("http://zapper.tunnel.mobi/Weixin/image/imooc.jpg");
		news.setUrl("www.imooc.com");

		newsList.add(news);

		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(System.currentTimeMillis());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());

		message = newsMessageToXml(newsMessage);
		return message;
	}

	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message = null;
		Image image = new Image();
		image.setMediaId("JTH8vBl0zDRlrrn2bBnMleySuHjVbMhyAo0U2x7kQyd1ciydhhsVPONbnRrKGp8m");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(System.currentTimeMillis());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}

	/**
	 * 组装音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message = null;
		Music music = new Music();
		music.setThumbMediaId("WsHCQr1ftJQwmGUGhCP8gZ13a77XVg5Ah_uHPHVEAQuRE5FEjn-DsZJzFZqZFeFk");
		music.setTitle("see you again");
		music.setDescription("速7片尾曲");
		music.setMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
		music.setHQMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");

		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(System.currentTimeMillis());
		musicMessage.setMusic(music);
		message = musicMessageToXml(musicMessage);
		return message;
	}
}
