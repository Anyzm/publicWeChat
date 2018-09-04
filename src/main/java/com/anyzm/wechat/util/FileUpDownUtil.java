package com.anyzm.wechat.util;

import java.io.*;
import java.net.URL;

import com.anyzm.wechat.config.WeChatConfig;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import sun.misc.PostVMInitHook;

import javax.net.ssl.HttpsURLConnection;

public class FileUpDownUtil {
	private static final Logger logger = Logger.getLogger(FileUpDownUtil.class);

	public static File downFile(String downUrl, String saveDir, String suffix) {

		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse r = null;
		HttpGet get = new HttpGet(downUrl);
		InputStream is = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			 r = client.execute(get);
			HttpEntity entity = r.getEntity();
			logger.info(r.getStatusLine());
			int statusCode = r.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String fileName = null;
				if (suffix == null) {
					suffix = "";
					fileName = MathUtil.getRandomDigit20() +".jpg";
				}else{
					fileName =  suffix;
				}

				String saveUrl = saveDir + File.separator + fileName;
				logger.info("saveUrl===" + saveUrl);

				is = entity.getContent();
				logger.info("saveUrl==" + saveUrl);
				file = new File(saveUrl);
				logger.info("file==" + file);
				fos = new FileOutputStream(file);
				logger.info("fos==" + fos);
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = is.read(b)) > -1) {
					fos.write(b, 0, i);
				}
				fos.flush();
			} else {
				throw new Exception("文件下载服务器响应失败，响应编码为：" + statusCode);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return file;
	}
	public static File downOfflineFile(String downUrl, String saveDir) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse r = null;
		HttpGet get = new HttpGet(downUrl);
		InputStream is = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			r = client.execute(get);
			HttpEntity entity = r.getEntity();

			logger.info(r.getStatusLine());
			int statusCode = r.getStatusLine().getStatusCode();
			if (statusCode == 302) {
				String fileName = r.getParams().getParameter("fn").toString();
				String saveUrl = saveDir + File.separator + fileName;
				logger.info("saveUrl===" + saveUrl);

				is = entity.getContent();
				logger.info("saveUrl==" + saveUrl);
				file = new File(saveUrl);
				logger.info("file==" + file);
				fos = new FileOutputStream(file);
				logger.info("fos==" + fos);
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = is.read(b)) > -1) {
					fos.write(b, 0, i);
				}
				fos.flush();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return file;

	}
	public static String uploadFile(String uploadUrl,String fileName) throws IOException {
		//返回结果
		String result=null;
		File file=new File(WeChatConfig.getInstance().getProperty("temp_file_dir") + File.separator + fileName);
		if(!file.exists()||!file.isFile()){
			throw new IOException("文件不存在");
		}
		URL url=new URL(uploadUrl);
		HttpsURLConnection conn=(HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("POST");//以POST方式提交表单
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);//POST方式不能使用缓存
		//设置请求头信息
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Charset", "UTF-8");
		//设置边界
		String BOUNDARY="----------"+System.currentTimeMillis();
		conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
		//请求正文信息
		//第一部分
		StringBuilder sb=new StringBuilder();
		sb.append("--");//必须多两条道
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"media\"; filename=\"" + file.getName()+"\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		//获得输出流
		OutputStream out=new DataOutputStream(conn.getOutputStream());
		//输出表头
		out.write(sb.toString().getBytes("UTF-8"));
		//文件正文部分
		//把文件以流的方式 推送道URL中
		DataInputStream din=new DataInputStream(new FileInputStream(file));
		int bytes=0;
		byte[] buffer=new byte[1024];
		while((bytes=din.read(buffer))!=-1){
			out.write(buffer,0,bytes);
		}
		din.close();
		//结尾部分
		byte[] foot=("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");//定义数据最后分割线
		out.write(foot);
		out.flush();
		out.close();
		if(HttpsURLConnection.HTTP_OK==conn.getResponseCode()){
			StringBuffer strbuffer=null;
			BufferedReader reader=null;
			try {
				strbuffer=new StringBuffer();
				reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String lineString=null;
				while((lineString=reader.readLine())!=null){
					strbuffer.append(lineString);
				}
				if(result==null){
					result=strbuffer.toString();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(reader!=null){
					reader.close();
				}
			}
		}
		return result;
	  }

	public static  void downAndUpLoadFile(String downloadurl,String fileName,String suffix,String uploadurl){
		//DefaultHttpClient httpclient = new DefaultHttpClient();
		//DefaultHttpClient httpclient1 = new DefaultHttpClient();

		DefaultHttpClient httpclient = new DefaultHttpClient();
		DefaultHttpClient httpclient1 = new DefaultHttpClient();
		HttpResponse r = null, r1 = null;

		HttpGet get = null;
		InputStream is = null;
		HttpPost post = null;
		try{
			get = new HttpGet(downloadurl);
			r = httpclient.execute(get);
			HttpEntity entity = r.getEntity();
			int statusCode = r.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				is = entity.getContent();
				post = new HttpPost(uploadurl);
				InputStreamEntity reqEntity = new InputStreamEntity(is,entity.getContentLength());
				post.setEntity(reqEntity);
				r1 = httpclient1.execute(post);
				int statusCode1 = r1.getStatusLine().getStatusCode();
				if(statusCode1 == 200){
					String responseMsg = EntityUtils.toString(r1.getEntity(), "UTF-8");
				}else{
					logger.info("upload:" + uploadurl + "," + fileName +" errorcode:" + r1.getStatusLine().getStatusCode());
				}
			}else{
				logger.info("download:" + downloadurl + "," + fileName +" errorcode:" + r.getStatusLine().getStatusCode());
			}
		}catch(Exception ex){
			logger.info("download:" + downloadurl + "," + fileName +" error:" + ex);
			ex.printStackTrace();
		}
	}

}