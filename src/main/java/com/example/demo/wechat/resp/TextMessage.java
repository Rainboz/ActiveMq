package com.example.demo.wechat.resp;

/**
 * @program: ${CLASS_NAME}
 * @description: 文本消息消息体
 * @author: LS
 * @create: 2018-09-05 08:52

 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

