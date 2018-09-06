package com.rainboz.top.wechat.dispatcher;


import com.rainboz.top.wechat.resp.Article;
import com.rainboz.top.wechat.resp.NewsMessage;
import com.rainboz.top.wechat.resp.TextMessage;
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

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            String content = map.get("Content");
            if("1".equals(content)){
                txtmsg.setContent("你好，你发送的内容是 1！");
            }else if("2".equals(content)){
                txtmsg.setContent("你好，你发送的内容是 2！");
            }else if("3".equals(content)){
                txtmsg.setContent("你好，你发送的内容是 3！");
            }else if("4".equals(content)){
                txtmsg.setContent("<a href=\"http://47.100.9.160/Mq-Wechat/\">主页</a>");
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
                txtmsg.setContent("尼玛！");
            }else{
                txtmsg.setContent("你好，欢迎来到来到公众号！");
            }

            return MessageUtil.textMessageToXml(txtmsg);
        }

        //对图文消息
        NewsMessage newmsg=new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
            Article article=new Article();
            article.setDescription("这是图文消息 1"); //图文消息的描述
            article.setPicUrl("http://47.100.9.160/Mq-Wechat/images/图片2.png"); //图文消息图片地址
            article.setTitle("图文消息 1");  //图文消息标题
            article.setUrl("http://47.100.9.160/Mq-Wechat/");  //图文 url 链接
            List<Article> list=new ArrayList<Article>();
            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
            newmsg.setArticleCount(list.size());
            newmsg.setArticles(list);
            return MessageUtil.newsMessageToXml(newmsg);
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }

        return null;
    }
}
