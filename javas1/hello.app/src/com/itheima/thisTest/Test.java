package com.itheima.thisTest;

public class Test {
    public static void main(String[] args) {
        Car c = new Car("奔驰",88.8);
        System.out.println(c.name);
        System.out.println(c.price);

        c.goWith("宝马");
    }
}
