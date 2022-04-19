package com.itheima.arrayList;

import java.util.ArrayList;

//遍历并删除元素值
//将低于80分的数据去掉
//①定义ArrayList集合存储多名学员的成绩
//②遍历集合每个元素，若低于80，则去掉
public class arrayListCase1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(98);
        list.add(77);
        list.add(66);
        list.add(89);
        list.add(79);
        list.add(50);
        list.add(100);
//        有bug！！
//        for (int i = 0; i < list.size(); i++) {
//            int score = list.get(i);
//            if(score < 80){
//                list.remove(i);
//            }
//        }
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int score = list.get(i);
            if(score < 80){
                list.remove(i);
                i--;//删除成功必须退一步
            }
        }
        System.out.println(list);
        //或者倒着遍历也可以
    }
}
