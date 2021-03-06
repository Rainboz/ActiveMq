package com.rainboz.top.wechat.resp;

/**
 * @program: ${CLASS_NAME}
 * @description:  视频消息体
 * @author: LS
 * @create: 2018-09-05 08:54
 */
public class Video {
    private String MediaId;
    private String Title;
    private String Description;

    @Override
    public String toString() {
        return "Video{" +
                "MediaId='" + MediaId + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
