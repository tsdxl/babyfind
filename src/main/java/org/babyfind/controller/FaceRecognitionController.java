package org.babyfind.controller;

import org.babyfind.common.AjaxResult;
import org.babyfind.common.BaiduFaceApi;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
@RequestMapping("/face/")
public class FaceRecognitionController {
    private static final String path = "D:\\d\\Program Files\\JetBrains\\IntelliJ IDEA 2017.3.4\\workspace\\babyfind\\src\\main\\webapp\\upload\\imgs\\";

    @RequestMapping("compare")
    @ResponseBody
    public AjaxResult faceCompare(File file1) {
        AjaxResult ajaxResult = AjaxResult.succ();
        BaiduFaceApi faceApi = new BaiduFaceApi();
        File file2 = new File(path + "*.jpg");
        JSONObject json = faceApi.matchPics(file1, file2);
        ajaxResult.addObject("score", json.get("score"));
        return ajaxResult;
    }


//    public static void main(String[] args) {
//        BaiduFaceApi faceApi = new BaiduFaceApi();
//        File pic1 = new File(path+"123.jpg");
//        File pic2 = new File(path+"234.jpg");
//        JSONObject json = faceApi.matchPics(pic1,pic2);
//        System.out.println(json.toString());
//    }
}

