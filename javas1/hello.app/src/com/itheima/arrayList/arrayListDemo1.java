package com.itheima.arrayList;

import java.util.ArrayList;

public class arrayListDemo1 {
    public static void main(String[] args) {
//        1、创建ArrayList集合的对象
        ArrayList list = new ArrayList<>();
//        2、添加数据
        list.add("Java");
        list.add("daodao");
//        3、给指定索引位置插入元素
        list.add(1,"billie");
        System.out.println(list);
    }
}
