package com.rainboz.top.wechat.dispatcher;


import com.rainboz.top.wechat.req.LocationMessage;
import com.rainboz.top.wechat.resp.*;
import com.rainboz.top.wechat.util.MessageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: ${CLASS_NAME}
 * @description: 消息业务处理分发器
 * @author: LS
 * @create: 2018-09-04 18:55
 */
public class MsgDispatcher {
    private static Logger logger = LogManager.getLogger(MsgDispatcher.class);
    public static String processMessage(Map<String, String> map) {

        String openid=map.get("FromUserName"); //用户 openid
        String mpid=map.get("ToUserName");   //公众号原始 ID

        //普通文本消息

        TextMessage txtmsg=new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime());
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        //对图文消息
        NewsMessage newmsg=new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        //音乐消息
        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setToUserName(openid);
        musicMessage.setFromUserName(mpid);
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);

        //位置
        LocationMessage locationMessage = new LocationMessage();
        locationMessage.setToUserName(openid);
        locationMessage.setFromUserName(mpid);
        locationMessage.setCreateTime(new Date().getTime());
        locationMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_LOCATION);

        //视频
        VideoMessage videoMessage = new VideoMessage();
        videoMessage.setToUserName(openid);
        videoMessage.setFromUserName(mpid);
        videoMessage.setCreateTime(new Date().getTime());
        videoMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Video);

        //音频
        VoiceMessage voiceMessage = new VoiceMessage();
        voiceMessage.setToUserName(openid);
        voiceMessage.setFromUserName(mpid);
        voiceMessage.setCreateTime(new Date().getTime());
        voiceMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Voice);
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            try {
                String content = map.get("Content");
                if("1".equals(content)){
                    txtmsg.setContent("你好，你发送的内容是 1！");
                }else if("2".equals(content)){
                    txtmsg.setContent("你好，你发送的内容是 2！");
                }else if("3".equals(content)){
                    txtmsg.setContent("你好，你发送的内容是 3！");
                }else if("4".equals(content)){
                    txtmsg.setContent("<a href=\"http://rainboz.top/Mq-Wechat/\">YZEdu系统平台主页</a>");
                }else if("主页".equals(content)){
                    txtmsg.setContent("<a href=\"http://rainboz.top/Mq-Wechat/\">YZEdu系统平台主页</a>");
                }else if("我爱你".equals(content)){
                    txtmsg.setContent("我也爱你！");
                }else if("我喜欢你".equals(content)){
                    txtmsg.setContent("我也喜欢你！");
                }else if("查询".equals(content)){
                    txtmsg.setContent("查询什么呢查询！");
                }else if("分手".equals(content)){
                    txtmsg.setContent("去吧！");
                }else if("朱方安".equals(content)){
                    txtmsg.setContent("煮饭安你好帅！");
                }else if("朱葛".equals(content)){
                    txtmsg.setContent("诸葛比煮饭安帅！");
                }else if("薛志敏".equals(content)){
                    txtmsg.setContent("薛志敏是谁？！");
                }else if("罗坚".equals(content)){
                    txtmsg.setContent("坚哥还钱啦！！！！！！");
                }else if("张豪".equals(content)){
                    txtmsg.setContent("晚上打球吗，朋友0.0.0！");
                }else if("张致豪".equals(content)){
                    txtmsg.setContent("豪哥飞车来一把！");
                }else if("林宇豪".equals(content)){
                    txtmsg.setContent("干哈呢！");
                }else if("土豪".equals(content)){
                    txtmsg.setContent("突突突！");
                }else if("尼玛".equals(content)){
                    txtmsg.setContent("尼玛尼玛！");
                }else if("不打".equals(content)){
                    txtmsg.setContent("不打尼玛！");
                }else if("打".equals(content)){
                    txtmsg.setContent("打尼玛！");
                }else if("漂亮".equals(content)){
                    txtmsg.setContent("漂亮尼玛！");
                }else if("jjjjj".equals(content)){
                    txtmsg.setContent("jjjjj！");
                }else if("音乐".equals(content)){
                    try {
                        //图文1
                        Article article=new Article();
                        article.setDescription("推荐音乐"); //图文消息的描述
                        //article.setDescription("您发送的链接"); //图文消息的描述
                        article.setPicUrl("http://rainboz.top/Mq-Wechat/images/music2.png"); //图文消息图片地址
                        article.setTitle("音乐");  //图文消息标题
                        article.setUrl("http://isure.stream.qqmusic.qq.com/C400000YoVKg3RqJQO.m4a?vkey=D4C8B8BC93DCE06288A489DF056523FA90EE25A6F5C7557BB480927D5B846366F0379CF468214BC305AE1E3D6049899357245A7ACEC9EF24&guid=689503405&uin=0&fromtag=66");  //图文 url 链接
                        List<Article> list=new ArrayList<Article>();
                        list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                        newmsg.setArticleCount(list.size());
                        newmsg.setArticles(list);
                        System.out.println("======"+MessageUtil.newsMessageToXml(newmsg)+"========这是链接消息！");
                        return MessageUtil.newsMessageToXml(newmsg);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }else{
                    txtmsg.setContent("你好，欢迎来到来到公众号！");
                }

                return MessageUtil.textMessageToXml(txtmsg);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            try {
                System.out.println("==============这是图片消息！");
                //图文1
                Article article=new Article();
                article.setDescription("这是YZEdu系统平台微信WEB端主页"); //图文消息的描述
                article.setPicUrl("http://rainboz.top/Mq-Wechat/images/图片2.png"); //图文消息图片地址
                article.setTitle("YZEdu系统平台主页");  //图文消息标题
                article.setUrl("http://rainboz.top/Mq-Wechat/");  //图文 url 链接
                //图文2
                Article article1 = new Article();
                article1.setDescription("你的图片");
                article1.setTitle("你的图片");
                //article1.setUrl("http://rainboz.top/Mq-Wechat/");  //图文 url 链接
                article1.setUrl(map.get("PicUrl"));  //图文 url 链接
                article1.setPicUrl(map.get("PicUrl"));
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                list.add(article1);
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                return MessageUtil.newsMessageToXml(newmsg);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if (map.get("MsgType").equals(MessageUtil.RESP_MESSAGE_TYPE_MUSIC)){
            try {
                Music music = new Music();
                music.setTitle(map.get("Title"));
                music.setDescription(map.get("Description"));
                music.setThumbMediaId(map.get("ThumbMediaId"));
                music.setMusicUrl(map.get("MusicURL"));
               // music.setMusicUrl("http://isure.stream.qqmusic.qq.com/C400000YoVKg3RqJQO.m4a?vkey=D4C8B8BC93DCE06288A489DF056523FA90EE25A6F5C7557BB480927D5B846366F0379CF468214BC305AE1E3D6049899357245A7ACEC9EF24&guid=689503405&uin=0&fromtag=66");
                musicMessage.setMusic(music);
                System.out.println("音乐===="+MessageUtil.musicMessageToXml(musicMessage)+"====");
                return MessageUtil.musicMessageToXml(musicMessage);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            try {

                //图文1
                Article article=new Article();
                article.setDescription(map.get("Description")); //图文消息的描述
                //article.setDescription("您发送的链接"); //图文消息的描述
                article.setPicUrl("http://rainboz.top/Mq-Wechat/images/logo.jpg"); //图文消息图片地址
                article.setTitle(map.get("Title"));  //图文消息标题
                article.setUrl(map.get("Url"));  //图文 url 链接
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                System.out.println("======"+MessageUtil.newsMessageToXml(newmsg)+"========这是链接消息！");
                return MessageUtil.newsMessageToXml(newmsg);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            try {
                String Location_X = map.get("Latitude");
                String Location_Y = map.get("Longitude");
                String Scale = map.get("Scale");
                String Label = map.get("Label");
                txtmsg.setContent("您发送的位置，纬度为："+Location_X+";经度为："+Location_Y+";缩放级别为："+Scale+";位置为："+Label);
                System.out.println("=="+MessageUtil.textMessageToXml(txtmsg)+"============这是位置消息！");
                return MessageUtil.textMessageToXml(txtmsg);
            }catch (Exception e){
                e.printStackTrace();
            }

        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            try {
                String v = map.get("MediaId");
                Video video = new Video();
                video.setMediaId(v);
                video.setTitle("视频");
                video.setDescription("您发送的视频是：");
                videoMessage.setVideo(video);
                System.out.println("==="+MessageUtil.videoMessageToXml(videoMessage)+"===="+video.toString()+"=======这是视频消息！");
                return MessageUtil.videoMessageToXml(videoMessage);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            try {
                String v = map.get("MediaId");
                Voice voice = new Voice();
                voice.setMediaId(v);
                voiceMessage.setVoice(voice);
                System.out.println("===="+MessageUtil.voiceMessageToXml(voiceMessage)+"==="+voice.toString()+"=======这是语音消息！");
                return MessageUtil.voiceMessageToXml(voiceMessage);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return null;
    }
}
