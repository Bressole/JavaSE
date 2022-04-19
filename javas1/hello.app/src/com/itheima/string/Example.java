package com.itheima.string;

import java.util.Random;

//String类开发验证码功能
//随机产生一个6位的验证码，每位可能是数字、大写字母、小写字母

//①定义一个String类型的变量存储a-z A-Z 0-9之间的全部字符
//②循环5次，随机一个范围内的索引，获取对应字符连接起来即可
public class Example {
    public static void main(String[] args) {
//        1、定义可能出现的字符信息
        String datas ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        2、循环5次，每次生成一个随机的索引，提取队形的字符连接起来即可
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            //随机一个索引
            int index = r.nextInt(datas.length());
//            System.out.println(index);
            char c = datas.charAt(index);
//            System.out.println(c);
            code += c;
        }
//        3、输出字符串变量即可
        System.out.println(code);
    }
}
