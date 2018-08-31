package com.example.demo.main;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-30 16:09
 */
public class Z16 {
    public static void main(String[] args) {
        int param = 255;
        int paramfoot = param%16;
        int paramhead = param/16;
        String[] a = {"01","02","03","04","05","06","07","08","09","A","B","C","D","E","F"};
        System.out.println(a[paramhead-1]+"=="+a[paramfoot-1]);
    }
}
