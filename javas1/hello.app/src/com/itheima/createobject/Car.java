package com.itheima.createobject;
//对象
public class Car {
    String name;
    double price;

    public void start(){
        System.out.println(name + "启动了");
    }

    public void run(){
        System.out.println("价格为" + price + "的" + name + "跑得快");
    }
}
