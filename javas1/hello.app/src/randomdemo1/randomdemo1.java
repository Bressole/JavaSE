package randomdemo1;

import java.util.Random;

public class randomdemo1 {
    public static void main(String[] args) {
        //    1.导包
//    2.创建随机数对象
        Random r = new Random();
//    3.调用nextInt功能，可以返回一个整型的随机数
        for (int i = 0;i<5;i++) {
            int data = r.nextInt(10);
            System.out.println(data);
        }
    }
}
