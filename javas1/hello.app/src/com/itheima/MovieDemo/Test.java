package com.itheima.MovieDemo;
//完成电影信息的展示案例，理解面向对象编程的代码

public class Test {
    public static void main(String[] args) {
//        1、设计电影类
//        2、创建3个电影对象，封装电影信息
//        3、定义一个电影类型的数组，存储3部电影
        Movie[] movies = new Movie[3];
        movies[0] = new Movie("《魔女库伊拉》" , 8.5,"石头姐");
        movies[1] = new Movie("《情书》" , 8.5,"不知道谁");
        movies[2] = new Movie("《长津湖》" , 8.5,"吴京");

//        4、遍历数组中的电影对象，然后获取它的信息展示出来
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            System.out.println("电影名称：" + m.getName());
            System.out.println("电影评分：" + m.getScore());
            System.out.println("电影主演：" + m.getActor());
            System.out.println("------------------------");
        }
    }
}
