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
 * @program: EventDispatcher
 * @description:事件消息业务分发器
 * @author: LS
 * @create: 2018-09-04 19:03
 */
public class EventDispatcher {
    private static Logger logger = LogManager.getLogger(MsgDispatcher.class);
    public static String processEvent(Map<String, String> map) {
        String openid=map.get("FromUserName"); //用户 openid
        String mpid=map.get("ToUserName");   //公众号原始 ID
        TextMessage txtmsg=new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime());
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
            System.out.println("======="+MessageUtil.textMessageToXml(txtmsg)+"=======这是关注事件！");
            txtmsg.setContent("感谢关注YZEdu系统平台公众号，您可以发送文本，语音，图片来测试功能，菜单栏为YZEdu的web网页。");
            return MessageUtil.textMessageToXml(txtmsg);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件

            System.out.println("==============这是取消关注事件！");
            txtmsg.setContent("客官请留步！");
            return MessageUtil.textMessageToXml(txtmsg);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
            txtmsg.setContent("扫不了，持续更新中！");
            return MessageUtil.textMessageToXml(txtmsg);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
            txtmsg.setContent("持续更新中！");
            return MessageUtil.textMessageToXml(txtmsg);
        }
        NewsMessage newmsg=new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            String EventKey = map.get("EventKey");
            if("pingtai".equals(EventKey)){
                Article article=new Article();
                article.setDescription("互联网+教育改变了传统教育的模式，是未来教育发展的必然趋势。可使得学习无时无刻、无处不在地进行，充分利用碎片化时间，提高学习效率，打造移 动教育、智慧教育的生态圈，很好地满足多层次的教育信息化需求。");
                article.setPicUrl("http://rainboz.top/Mq-Wechat/images/pingtai.jpg");
                article.setTitle("平台介绍");
                article.setUrl("https://mp.weixin.qq.com/s/Ns-yIWatEEm8Mk9kxlsNKw");
                logger.info("自定义菜单点击事件: "+article);
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                System.out.println("======="+EventKey+"=======这是自定义菜单点击事件！");

            }else if ("joinus".equals(EventKey)){
                Article article=new Article();
                article.setDescription("join us!");
                article.setPicUrl("http://rainboz.top/Mq-Wechat/images/joinus.jpg");
                article.setTitle("加入我们");
                article.setUrl("https://mp.weixin.qq.com/s/UHT3yBY1h8OMKB1MoxPHCA");
                logger.info("自定义菜单点击事件: "+article);
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                System.out.println("======="+EventKey+"=======这是自定义菜单点击事件！");
            }
            return MessageUtil.newsMessageToXml(newmsg);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
            System.out.println("==============这是自定义菜单 View 事件！");
        }

        return null;
    }
}
