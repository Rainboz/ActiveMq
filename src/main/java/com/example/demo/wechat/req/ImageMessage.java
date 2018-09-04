package com.example.demo.wechat.req;

/**
 * @program: StudyActiveMq
 * @description: 图片消息
 * @author: ls
 * @create: 2018-09-04 18:49
 */
public class ImageMessage extends BaseMessage{
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
