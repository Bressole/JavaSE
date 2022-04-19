package com.itheima.shopcar;
//实现：添加商品到购物车，可以修改商品的购买数量，结算商品价格。

import java.util.Scanner;

public class ShopCarTest {
    public static void main(String[] args) {
//        1、定义商品类，用于后期创建商品对象
//        2、定义购物车对象，使用一个数组对象表示
        goods[] shopCar = new goods[100];
//        3、搭建操作架构
        while (true) {
            System.out.println("请您选择如下命令进行操作");
            System.out.println("添加商品到购物车：add");
            System.out.println("查询商品到购物车：query");
            System.out.println("修改商品购买数量：update");
            System.out.println("结算购买商品的金额：pay");
            Scanner sc = new Scanner(System.in);
            System.out.println("请您输入命令：");
            String command = sc.next();
            switch(command){
                case "add":
                    addGoods(shopCar,sc);
                    break;
                case "query":
                    queryGoods(shopCar);
                    break;
                case "update":
                    updateGoods(shopCar,sc);
                    break;
                case "pay":
                    pay(shopCar);
                    break;
                default:
                    System.out.println("没有该功能！");
            }
        }

    }

//    计算总金额
    public static void pay(goods[] shopCar) {
        queryGoods(shopCar);
        double money = 0;
        for (int i = 0; i < shopCar.length; i++) {
            goods g = shopCar[i];
            if(g != null){
                money += (g.price * g.buyNumber);
            }
            else{
                break;
            }
        }
        System.out.println("订单总金额：" + money);
    }

//    修改
    public static void updateGoods(goods[] shopCar,Scanner sc) {
//        让用户输入要修改商品的id
        System.out.println("请您输入要修改的商品id:");
        while (true) {
            int id = sc.nextInt();
            goods g = getGoodsById(shopCar,id);
            if(g == null){
                System.out.println("购物车中没有该商品！");
            }
            else{
                System.out.println("请您输入" + g.name + "的最新购买数量");
                int newNum = sc.nextInt();
                g.buyNumber = newNum;
                System.out.println("修改完成！");
                queryGoods(shopCar);
                break;
            }
        }
    }

//    根据id查询出要修改的商品对象
    public static goods getGoodsById(goods[] shopCar,int id){
        for (int i = 0; i < shopCar.length; i++) {
            goods g = shopCar[i];
            if(g != null){
                if(g.id == id){
                    return g;
                }
            }
            else {
                return null;
            }
        }
        return null;//找完100个商品，没有找到一样id的商品
    }

//    查询
    public static void queryGoods(goods[] shopCar) {
        System.out.println("=====================购物车信息如下==================");
        System.out.println("编号\t\t名称\t\t\t价格\t\t数量");
        for (int i = 0; i < shopCar.length; i++) {
            goods g = shopCar[i];
            if(g != null){
                System.out.println(g.id + "\t\t" + g.name + "\t\t\t" + g.price + "\t\t" +g.buyNumber);
            }
            else{
                break;
            }
        }
    }

//    添加
    public static void addGoods(goods[] shopCar,Scanner sc) {
//        1、录入用户输入的购买信息
        System.out.println("请您输入购买商品的编号：");
        int id = sc.nextInt();
        System.out.println("请您输入购买商品的名称：");
        String name = sc.next();
        System.out.println("请您输入购买商品的数量：");
        int buyNumber = sc.nextInt();
        System.out.println("请您输入购买商品的价格：");
        double price = sc.nextInt();
//        2、把购买商品的信息封装成一个商品对象
        goods g =new goods();
        g.id = id;
        g.name = name;
        g.buyNumber =buyNumber;
        g.price = price;
//        3、把商品对象添加到购物车数组
        for (int i = 0; i < shopCar.length; i++) {
            if(shopCar[i] == null){
                shopCar[i] = g;
                break;//商品已经成功存入了，不需要再找位置了
            }
            System.out.println("您的商品" + g.name + "添加到购物车完成");

        }
    }
}
