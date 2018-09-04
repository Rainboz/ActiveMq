package com.example.demo.wechat.controller;

import com.example.demo.wechat.dispatcher.EventDispatcher;
import com.example.demo.wechat.dispatcher.MsgDispatcher;
import com.example.demo.wechat.util.MessageUtil;
import com.example.demo.wechat.util.SignUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;


/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-09-04 11:25
 */
@Controller
@RequestMapping("/wechat")
//http://localhost:8999/wechat/security?+
//signature=3d8864c8b3106d85bb52556642fe11ff62e865f3&echostr=3617465863347601279&timestamp=1536037719&nonce=787286211
public class WechatSecurity {
    private static Logger logger = LogManager.getLogger(WechatSecurity.class);

    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
                logger.trace("alashdll");
            } else {
                logger.info("这里存在非法请求！");
                logger.error("Didn't do it.");
               // System.out.println("ss");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    
    /**
     * @Description: 接收微信端消息处理并做分发
     * @param @param request
     * @param @param response   
     * @author 
     * @date 2018-09-04 11:25
     */
    @RequestMapping(value = "security", method = RequestMethod.POST)
    public void DoPost(HttpServletRequest request,HttpServletResponse response) {
        try{
            Map<String, String> map= MessageUtil.parseXml(request);
            String msgtype=map.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
                EventDispatcher.processEvent(map); //进入事件处理
            }else{
                MsgDispatcher.processMessage(map); //进入消息处理
            }
        }catch(Exception e){
            logger.error(e,e);
        }
    }
}
