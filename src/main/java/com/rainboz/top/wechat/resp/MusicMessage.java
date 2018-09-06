package com.rainboz.top.wechat.resp;

/**
 * @program: ${CLASS_NAME}
 * @description: 音乐消息
 * @author: LS
 * @create: 2018-09-05 08:54
 */
public class MusicMessage extends BaseMessage{
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
