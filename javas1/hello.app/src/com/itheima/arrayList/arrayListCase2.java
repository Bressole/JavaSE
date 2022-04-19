package com.itheima.arrayList;
//某影院需要在后台存储上述三部电影，然后依次展示出来
//①定义一个电影类，定义一个集合存储电影对象
//②创建3个对象，封装相关数据，把3个对象存入到集合中
//③遍历集合中的3个对象，输出相关信息

import java.util.ArrayList;

public class arrayListCase2 {
    public static void main(String[] args) {
//        1、定义电影类
//        2、创建电影对象
        Movie m1 = new Movie("《魔女库伊拉》" , 8.5,"石头姐");
        Movie m2 = new Movie("《情书》" , 8.5,"不知道谁");
        Movie m3 = new Movie("《长津湖》" , 8.5,"吴京");
//        3、创建一个电影类型的ArrayList
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
//        4、遍历电影类型的集合中的每个电影对象
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println("电影名称：" + m.getName());
            System.out.println("电影评分：" + m.getScore());
            System.out.println("电影主演：" + m.getActor());
            System.out.println("----------------------");
        }
    }
}
