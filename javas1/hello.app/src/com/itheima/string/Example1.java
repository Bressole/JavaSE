package com.itheima.string;

//模拟用户登录功能，只给三次机会
//①后台定义好正确的登录名称，密码
//②使用循环控制三次

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
//        1、定义正确的登录名称和密码
        String okLoginName = "admin";
        String okPassword = "123";
//        2、循环
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 3; i++) {
            System.out.println("登录用户名：");
            String loginName = sc.next();
            System.out.println("登录密码：");
            String password = sc.next();
//        3、判断
            if(okLoginName.equals(loginName)){
                if(okPassword.equals(password)){
                    System.out.println("登录成功！");
                    break;
                }
                else{
                    System.out.println("密码错误！您还剩余" + (3-i) + "次机会");
                }
            }
            else{
                System.out.println("用户名不存在！您还剩余" + (3-i) + "次机会");
            }
        }
    }
}
