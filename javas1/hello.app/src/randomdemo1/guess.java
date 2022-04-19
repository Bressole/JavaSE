package randomdemo1;

import java.util.Random;
import java.util.Scanner;

//猜数
public class guess {
    public static void main(String[] args) {
        //1.生成一个幸运号码1-100
        Random r = new Random();
        int luckNumber = r.nextInt(100)+1;
        //2.使用一个死循环让用户不断地去猜测，并给出提示
        Scanner sc = new Scanner(System.in);//扫描器
        while (true){
            System.out.println("请输入您猜测的数(1-100):");
            int guessNumber = sc.nextInt();
//            3.猜测这个猜测的号码是否是幸运号码
        if(guessNumber > luckNumber){
            System.out.println("您猜测的数字过大");
        }
        else if(guessNumber < luckNumber){
            System.out.println("您猜测的数字过小");
        }
        else{
            System.out.println("猜中了！");
            break;
        }
        }
    }
}
