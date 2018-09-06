package com.rainboz.top.wechat.util;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-09-04 14:52
 */
public enum  LogEnum {


    BUSSINESS("bussiness"),

    PLATFORM("platform"),

    DB("db"),

    EXCEPTION("exception"),

    ;


    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
