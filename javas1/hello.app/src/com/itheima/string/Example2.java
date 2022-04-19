package com.itheima.string;

import java.util.Scanner;

//手机号码屏蔽
//需求：以字符串形式从键盘接受一个手机号，将中间四位号码屏蔽
//思路：截取手机号码前三位，截取手机号码后四位，中间以****拼接

public class Example2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pin = "****";
        System.out.println("请输入您的手机号码：");
        String phoneNum = sc.next();
        String topNum = phoneNum.substring(0,3);
        String lastNum = phoneNum.substring(7);
        String resultNum = topNum + pin + lastNum;
        System.out.println(resultNum);
    }
}
