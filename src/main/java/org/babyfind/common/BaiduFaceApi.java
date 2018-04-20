package org.babyfind.common;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class BaiduFaceApi {
    /**
     * 三个认证信息
     */
    public static final String APP_ID = "10295805";
    public static final String API_Key = "1HffPsKekxwe3K1NGEX6g56o";
    public static final String Secret_Key = "dKlFfcjFraVoWQaCSgldg01qiZMt1aAP";

    /**
     * 百度人脸识别的api客户端对象
     */
    private AipFace client = null;

    /**
     * 识别的可选参数
     */
    private HashMap<String, String> options;

    public BaiduFaceApi(){
        client = new AipFace(APP_ID, API_Key, Secret_Key);
        options = new HashMap<>();
        options.put("max_face_num", "1");
        /**
         * age: 年龄，
         * beauty：美丑打分，范围0-100，越大表示越美
         * expression：表情，0，不笑；1，微笑；2，大笑
         * faceshape：square/triangle/oval/heart/round
         * gender： male、female
         * glasses：是否带眼镜，0-无眼镜，1-普通眼镜，2-墨镜
         * race：yellow、white、black、arabs
         */
        options.put("face_fields", "age,beauty,expression,faceshape,gender,glasses,race");
    }

    /**
     * 传入一张图片，检测，返回识别的json字符串
     * @param picture
     * @return
     */
    public JSONObject detectPic(File picture){
        return client.detect(picture.getPath(), options);
    }

    /**
     * 传入一组图片，两两返回相似度
     * @param pictures
     * @return
     */
    public JSONObject matchPics(File... pictures){
        ArrayList<String> pathArray = new ArrayList<>();
        for(int i=0;i<pictures.length;i++){
            pathArray.add(pictures[i].getPath());
        }
        return client.match(pathArray,new HashMap<String, String>());
    }
}
