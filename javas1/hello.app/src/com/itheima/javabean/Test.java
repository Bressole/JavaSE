package com.itheima.javabean;

public class Test {
    public static void main(String[] args) {
//        1、无参数构造器创建对象封装一个用户信息
        User u1 = new User();
        u1.setName("叨叨");
        u1.setHeight(160.5);
        u1.setSalary(5000.0);
        System.out.println(u1.getName());
        System.out.println(u1.getHeight());
        System.out.println(u1.getSalary());

//        2、有参数构造器创建对象封装一个用户信息
        User u2 = new User("絮絮",158.0,6767.0);
        System.out.println(u2.getName());
        System.out.println(u2.getHeight());
        System.out.println(u2.getSalary());

    }
}
