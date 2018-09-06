package com.rainboz.top.wechat.req;

/**
 * @program: ${CLASS_NAME}
 * @description: 语音消息
 * @author: LS
 * @create: 2018-09-04 18:53
 */
public class VoiceMessage extends BaseMessage{
    // 媒体 ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
