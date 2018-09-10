package com.rainboz.top.wechat.resp;

/**
 * @program: ${CLASS_NAME}
 * @description: 语音消息体
 * @author: LS
 * @create: 2018-09-05 08:55
 */
public class Voice {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "MediaId='" + MediaId + '\'' +
                '}';
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
