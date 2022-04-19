package com.itheima.arrayList;

import java.util.ArrayList;

public class arrayListDemo2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add("Java");
        list.add("DaoDao");
        list.add(889);
        System.out.println(list);
        list.remove(2);//删除功能
        System.out.println(list);
    }
}
