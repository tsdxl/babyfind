package org.babyfind.common;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.util.Base64Util;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 仅参考。具体文档自行查看官网说明  ai.baidu.com
 * @author 小帅丶
 * @类名称  FaceDetectTest
 * @remark 
 * @date  2017-9-12
 */
public class FaceDetectTest {
	/**
	 * SDK人脸检测方式
	 * @param args
	 * @throws IOException
	 */
	public static void main2(String[] args) throws IOException {
		//初始化一个FaceClient
		AipFace face = new AipFace("你自己的APPID", "你自己的APIKEY", "你自己的SERCETKEY");
		//可选：设置网络连接参数
		face.setConnectionTimeoutInMillis(60000);
		face.setSocketTimeoutInMillis(60000);
		//调用API
		HashMap map = new HashMap();
		//
		map.put("face_fields", "age,beauty,expression,gender,glasses,race,qualities");
		String path = "图片本地目录路径";
		AipRequest aipRequest = new AipRequest();
		aipRequest.setBody(map);
		JSONObject result = face.detect(FileUtil.readFileByBytes(path),map);
		System.out.println(result.toString(2));
	}
	/**
	 * API调用人脸检测方式
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/****************/
		String Filepath = "图片本地目录路径";
		String image = Base64Util.encode(FileUtil.readFileByBytes(Filepath));
		String url = "https://aip.baidubce.com/rest/2.0/face/v1/detect";
		String params =  URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(image, "UTF-8")+"&face_fields=age,beauty,expression,gender,glasses,race,qualities";
		try {
			HttpUtil httpUtil = new HttpUtil();
			String result = httpUtil.post(url, "自己应用的accesstoken", params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
