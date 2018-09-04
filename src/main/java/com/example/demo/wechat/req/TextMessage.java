package com.example.demo.wechat.req;

/**
 * @program: ${CLASS_NAME}
 * @description: 文本消息
 * @author: LS
 * @create: 2018-09-04 18:52
 */
public class TextMessage extends BaseMessage{
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
