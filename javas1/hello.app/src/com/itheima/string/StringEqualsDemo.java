package com.itheima.string;

import java.util.Scanner;

public class StringEqualsDemo {
    public static void main(String[] args) {
//        1、正确登录名和密码
        String okName = "admin";
        String okPassword = "123";
//        2、请用户输入
        Scanner sc = new Scanner(System.in);
        System.out.println("登录用户：");
        String name = sc.next();
        System.out.println("登录密码：");
        String password = sc.next();
//        3、判断登录名称与密码与正确内容是否相等
//        if(okName == name && okPassword == password)  这种方法是不行的！
        if(okName.equals(name) && okPassword.equals(password)){
            System.out.println("登录成功！");
        }
        else{
            System.out.println("用户名不存在或者密码错误！");
        }
//        4、忽略大小比较内容的API，一般用于比较验证码
        String okCode = "23Abc";
        String code = "23aBc";
        System.out.println(okCode.equalsIgnoreCase(code));//忽略大小写


    }
}
