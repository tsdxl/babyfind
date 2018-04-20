import org.babyfind.common.BaiduFaceApi;
import org.json.JSONObject;

import java.io.File;

public class BaiduFaceApiTest {
    public static void main(String[] args) {
        BaiduFaceApi faceApi = new BaiduFaceApi();
        File pic1 = new File("D:\\d\\Program Files\\JetBrains\\IntelliJ IDEA 2017.3.4\\workspace\\babyfind\\src\\main\\webapp\\upload\\imgs\\123.jpg");
        File pic2 = new File("D:\\d\\Program Files\\JetBrains\\IntelliJ IDEA 2017.3.4\\workspace\\babyfind\\src\\main\\webapp\\upload\\imgs\\234.jpg");
        JSONObject json = faceApi.matchPics(pic1,pic2);

        System.out.println(json.toString());
    }

}
