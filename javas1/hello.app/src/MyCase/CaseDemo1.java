package MyCase;

import java.util.Scanner;

//飞机票的价格计算
public class CaseDemo1 {
    public static void main(String[] args) {
//        1、让用户输入原价、月份和仓位类型
        Scanner sc = new Scanner(System.in);
        System.out.printf("请您输入机票原价：");
        double money = sc.nextDouble();
        System.out.printf("请您输入机票月份(1-12)：");
        int month = sc.nextInt();
        System.out.printf("请您选择仓位类型：");
        String type = sc.next();
//    4、调用方法
        System.out.printf("机票优惠后的价格为：" + calc(money,month,type));
    }

//    2、定义方法接收信息，统计优惠后的价格返回
    public static double calc(double money,int month,String type)
    {
//        3、判断用户选择的信息情况
        if (month >= 5 && month <= 10)//旺季
        {
            switch (type){
                case "头等舱":
                    money = money * 0.9;
                    break;
                case "经济舱":
                    money = money * 0.85;
                    break;
                default:
                    System.out.printf("您输入的仓位类型有误！");
                    money = -1;
            }
        }
        else if(month == 11 || month == 12 || month == 1 || month == 2 || month == 3 || month == 4)//淡季
        {
            switch (type){
                case "头等舱":
                    money = money * 0.7;
                    break;
                case "经济舱":
                    money = money * 0.65;
                    break;
                default:
                    System.out.printf("您输入的仓位类型有误！\n");
                    money = -1;
            }
        }
        else {
            System.out.printf("您输入的月份有误！\n");
            money = -1;
        }
        return money;
    }


}
