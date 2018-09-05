package com.example.demo.wechat.menu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.wechat.util.HttpUtils;


/**
 * @program: ${CLASS_NAME}
 * @description: ${description}
 * @author: LS
 * @create: 2018-09-05 13:23
 */
public class MenuMain {
    public static  <T>  T  toObject(String object,Class clazz){
        return (T)JSONArray.parseObject(object, clazz);
    }
    public static void main(String[] args) {

        ClickButton cbt=new ClickButton();
        cbt.setKey("image");
        cbt.setName("回复图片");
        cbt.setType("click");

        ViewButton vbt=new ViewButton();
        vbt.setUrl("http://rainboz.top/Mq-Wechat/");
        vbt.setName("博客");
        vbt.setType("view");

        JSONArray sub_button=new JSONArray();
        sub_button.add(cbt);
        sub_button.add(vbt);

        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);

        JSONArray button=new JSONArray();
        button.add(vbt);
        button.add(buttonOne);
        button.add(cbt);

        JSONObject menujson=new JSONObject();
        menujson.put("button", button);
        System.out.println(menujson);
        String json = "{\n" +
                "    \"button\": [\n" +
                "        {\n" +
                "            \"name\": \"博客\", \n" +
                "            \"type\": \"view\", \n" +
                "            \"url\": \"http://rainboz.top/Mq-Wechat/\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\": \"菜单\", \n" +
                "            \"sub_button\": [\n" +
                "                {\n" +
                "                    \"key\": \"text\", \n" +
                "                    \"name\": \"回复图文\", \n" +
                "                    \"type\": \"click\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\": \"博客\", \n" +
                "                    \"type\": \"view\", \n" +
                "                    \"url\": \"http://rainboz.top/Mq-Wechat/\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"key\": \"text\", \n" +
                "            \"name\": \"回复图文\", \n" +
                "            \"type\": \"click\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject  obj=toObject(json, JSONObject.class);
        System.out.println(obj);
        //这里为请求接口的 url   +号后面的是 token，这里就不做过多对 token 获取的方法解释
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
                +"13_mYTAMSDS32ATZ831ExCp_SzF8BjZggIUd9sj9XvcRb8qYcampXDM0tJm-tpd5XZJMk2oxa0mO9QYHpkM706AR0kD4x2xOL_cZmrHJkDUNLX4nVXOeZg2brZ9oHSKrb3CUw04TB4EIDUvdTg2ZBDhAFAOQS";

        try{
            String rs= HttpUtils.sendPostBuffer(url, obj.toJSONString());
            System.out.println(rs);
        }catch(Exception e){
            System.out.println("请求错误！");
        }

    }
}
