## ATM系统

## 1、账户类、首页设计

### (1)系统准备内容分析

- 每个用户的账户信息都是一个对象，需要提供==账户类==
- 需要准备一个==容器==，用于存储系统全部账户对象信息
- 首页只需要包含：登录和注册两个功能

### (2)实现步骤

- 定义账户类，用于后期创建账户对象封装用户的信息
- 账户类中的信息至少包含（卡号、姓名、密码、余额、取现额度）
- 需要准备一个ArrayList的集合，用于存储系统用户的账户对象

~~~java
ArrayList<Account> accounts = new ArrayList<>();
~~~

- 需要展示欢迎页包含2个功能：开户功能、登录账户。

## 2、开户功能

### (1)分析

- 开户功能就是往系统的集合容器中存入一个新的账户对象的信息

### (2)步骤

- 开户应该定义一个方法，并传入账户集合：

~~~java
Account account = new Account();
~~~

- 创建一个Account账户类的对象封装账户信息（姓名、密码、卡号）
- 键盘录入姓名、密码、确认密码（需保证两次密码一致）
- 生成账户卡号，卡号必须由系统自动生成8为数字（必须保证卡号的唯一）
- ==把Account账户对象存入到集合accounts中去==

## 3、登录功能

- 登录功能应该定义成一个方法，并传入账户集合
- 让用户输入卡号，根据卡号去账户集合查询账户对象
- 如果没有找到账户对象，说明登录卡号不存在，提示继续输入卡号
- 如果找到了账户对象，说明卡号存在，继续输入密码
- 如果密码不正确，提示继续输入密码
- 如果密码也正确，登陆成功

## 4、用户操作页、查询、退出

- 用户登录成功，需要进入用户操作页
- 查询就是直接展示当前登录成功的账户对象的信息
- 退出账户是需要回到首页的

## 5、存款

- 存款就是拿到当前账户对象
- 然后让用户输入存款的金额
- 调用账户对象的setMoney方法将账户余额修改成存钱后的余额

~~~java
acc.setMoney(acc.getMoney() + money);
~~~

## 6、转账

- 转账功能需要判断系统中是否有2个账户对象及以上
- 同时还要判断自己账户是否有钱
- 接下来需要输入对方卡号，判断对方账户是否存在
- 对方账户存在还需要认证对方户主的姓氏
- 满足要求则可以把自己账户对象的金额修改到对方账户对象中去

## 7、修改密码、销户

- 修改密码就是当前对象的密码属性使用set方法进行更新
- 销户就是从集合对象中删除对象，并回到首页

Tip：

~~~
1、alt + crtl + t ：可以将一串代码加入死循环
2、可以直接先写方法名，然后按 alt + enter 自动创建方法
~~~

index.java

~~~java
package com.itheima.ATMSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * ATM系统的入口类
 */
public class index {
    public static void main(String[] args) {
//        1、定义账户类
//        2、定义一个集合容器，存储全部的账户对象
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
//        3、展示系统首页
        while (true) {
            System.out.println("===========搞钱ATM系统===========");
            System.out.println("1、账户登录");
            System.out.println("2、账户开户");
            System.out.println("请输入您要执行的操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:            //用户登录
                    login(accounts,sc);
                    break;
                case 2:             //用户开户
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("无效操作！");
            }
        }
    }

    /**
     * 登录功能
     * @param accounts
     * @param sc
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("================系统登录操作=================");
//        1、判断账户集合中是否存在账户
        if(accounts.size() == 0){
            System.out.println("当前系统无任何账户，请先开户！");
            return;
        }
//        2、正式进入登录
        while (true) {
            System.out.println("请您输入登录卡号：");
            String cardId = sc.next();
//        3、判断卡号是否存在
            Account acc = getAccountByCardID(cardId,accounts);
            if(acc != null){
//                4、让用户输入密码
                while (true) {
                    System.out.println("请输入账户密码：");
                    String passWord = sc.next();
//                5、判断密码是否正确
                    if(acc.getPassWord().equals(passWord)){
                        System.out.println("登录成功！欢迎" + acc.getUserName());
                        //展示登录后的操作页
                        showUserCommand(sc,acc,accounts);
                        return;
                    }
                    else {
                        System.out.println("您输入的密码有误！");
                    }
                }
            }
            else {
                System.out.println("系统中不存在改账户卡号！");
            }
        }

    }

    /**
     * 用户操作页面
     * @param sc
     * @param acc
     */
    private static void showUserCommand(Scanner sc,Account acc,ArrayList<Account> accounts) {
        while (true) {
            System.out.println("============用户操作页面===========");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销用户");
            System.out.println("请输入操作：");
            int command = sc.nextInt();
            switch (command){
                case 1:                //查询
                    showAccount(acc);
                    break;
                case 2:                //存款
                    depositMoney(acc,sc);
                    break;
                case 3:                 //取款
                    drawMoney(acc,sc);
                    break;
                case 4:                 //转账
                    transferMoney(sc,acc,accounts);
                    break;
                case 5:                 //修改密码
                    updatePassword(sc,acc);
                    break;
                case 6:                  //退出
                    System.out.println("退出成功，欢迎下次光临！");
                    return;
                case 7:                  //注销
                    if(deleteUser(acc,sc,accounts)){//删除当前账户
                        //销户成功，回到首页
                        return;
                    }
                    else {
                        //取消销户，回到操作页
                        break;
                    }
                default:
                    System.out.println("无效命令！");
            }
        }
    }

    /**
     * 销户功能
     * @param acc
     * @param sc
     * @param accounts
     */
    private static boolean deleteUser(Account acc,Scanner sc,ArrayList<Account> accounts) {
        System.out.println("==================用户销户操作================");
        System.out.println("是/否确认销户？");
        String rs = sc.next();
        switch (rs){
            case "是":
                if(acc.getMoney() > 0){
                    System.out.println("您的账户还有余额，不可以销户！！！");
                }
                else {
                    accounts.remove(acc);
                    System.out.println("您的账户销户完成！");
                }
                return true;//让当前方法停止执行
            default:
                System.out.println("取消销户！");
                return false;
        }

    }

    /**
     * 修改密码功能
     * @param sc
     * @param acc
     */
    private static void updatePassword(Scanner sc, Account acc) {
        System.out.println("================修改密码操作================");
        while (true) {
            System.out.println("请输入您的原密码：");
            String password = sc.next();
            if (acc.getPassWord().equals(password)) {
                System.out.println("请您输入新密码：");
                String newPassword = sc.next();
                System.out.println("请您确认新密码：");
                String okPassword = sc.next();

                if(newPassword.equals(okPassword)){
                    acc.setPassWord(newPassword);
                    System.out.println("密码修改成功！");
                    return;//结束修改密码方法
                }
                else{
                    System.out.println("两次输入密码不一致！");
                }
            } else {
                System.out.println("密码错误！");
            }
        }
    }

    /**
     * 转账功能
     * @param sc 扫描器
     * @param acc 自己的账户对象
     * @param accounts 全部账户的集合
     */
    private static void transferMoney(Scanner sc, Account acc, ArrayList<Account> accounts) {
//        1、判断是否有两个账户以上
        if(accounts.size() < 2){
            System.out.println("当前系统不足两个账户，无法转账！");
            return;//结束方法
        }
//        2、开始转账
//        判断自己账户有没有钱
        if(acc.getMoney() == 0){
            System.out.println("当前账户没有钱！");
            return;//结束方法
        }
        else {
            while (true) {
                System.out.println("请输入您要转账的账户卡号：");
                String cardId = sc.next();
                //这个卡号不能是自己的
                if(cardId.equals(acc.getCardId())){
                    System.out.println("您不能给自己的账户转账！");
                    continue;//结束当次循环，死循环进入下一次
                }
                //查询账户是否存在
                Account account = getAccountByCardID(cardId, accounts);
                if (account == null) {
                    System.out.println("对不起，您输入的卡号不存在！");
                }
                else{
                    //账户对象存在
                    String userName = account.getUserName();
                    String tip = "*" + userName.substring(1);
                    System.out.println("请您输入" + tip + "的姓氏");
                    String preName = sc.next();
                    if(userName.startsWith(preName)){
                        //认证通过，开始转账
                        while (true) {
                            System.out.println("请您输入转账金额：");
                            double money = sc.nextDouble();
                            //判断余额是否足够
                            if (acc.getMoney() < money) {
                                System.out.println("余额不足！您最多可以转账" + acc.getMoney());
                            }
                            else{
                                //余额足够
                                acc.setMoney(acc.getMoney() - money);
                                account.setMoney(account.getMoney() + money);
                                System.out.println("转账成功！当前账户还剩余" + acc.getMoney());
                                return;//退出转账方法
                            }
                        }
                    }
                    else {
                        System.out.println("对不起，您输入的信息有误！");
                    }
                }
            }
        }
    }

    /**
     * 取款功能
     * @param acc
     * @param sc
     */
    private static void drawMoney(Account acc, Scanner sc) {
        System.out.println("================取款操作===================");
        if(acc.getMoney() < 100){
            System.out.println("当前用户不足100元，请先存款！");
            return;
        }
        while (true) {
            System.out.println("请输入您要取款的金额：");
            double money = sc.nextDouble();
            if (money > acc.getMoney()) {
                System.out.println("当前账户余额不足！");
            } else {
                if (money > acc.getQuotaMoney()) {
                    System.out.println("取款金额高于限额！最多可取" + acc.getQuotaMoney());
                } else {
                    acc.setMoney(acc.getMoney() - money);
                    System.out.println("==============取款成功！=============");
                    showAccount(acc);
                    return;//结束取款方法
                }
            }
        }
    }

    /**
     *存款功能
     * @param acc
     */
    private static void depositMoney(Account acc,Scanner sc) {
        System.out.println("===============存款操作================");
        System.out.println("请您输入存款金额：");
        double money = sc.nextDouble();
        acc.setMoney(acc.getMoney() + money);
        System.out.println("===============存款成功！================");
        showAccount(acc);
    }

    /**
     * 用户查询功能
     * @param acc
     */
    private static void showAccount(Account acc) {
        System.out.println("================当前账户信息如下==============");
        System.out.println("账户卡号：" + acc.getCardId());
        System.out.println("账户户主：" + acc.getUserName());
        System.out.println("账户余额：" + acc.getMoney());
        System.out.println("账户限额：" + acc.getQuotaMoney());
    }

    /**
     * 用户开户功能的实现
     *
     * @param accounts
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=================系统开户操作==============");
//        1、创建一个账户对象，用于后期封装账户信息
        Account account = new Account();
//        2、录入当前这个账户的信息，注入到账户对象中去
        System.out.println("请输入账户用户名：");
        String usrName = sc.next();
        account.setUserName(usrName);
        while (true) {
            System.out.println("请输入账户密码：");
            String passWord = sc.next();
            System.out.println("请再次输入账户密码：");
            String okPassWord = sc.next();
            if (okPassWord.equals(passWord)) {
                account.setPassWord(okPassWord);
                break;
            } else {
                System.out.println("对不起，您输入的两次密码不一致，请重新确认!");
            }
        }
        System.out.println("请输入账户当次限额：");
        double quotaMoney = sc.nextDouble();
        account.setQuotaMoney(quotaMoney);
        //随机生成一个8位且与其他账户的卡号不能重复的号码
        String cardID = getCardID(accounts);
        account.setCardId(cardID);

//        3、把账户对象添加到账户集合
        accounts.add(account);
        System.out.println("开户成功,您的卡号为" + cardID);
    }

    /**
     * 生成随机卡号
     *
     * @return
     */
    private static String getCardID(ArrayList<Account> accounts) {
        //生成随机8位数字
        Random r = new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            //判断这个8位的数字是否与别的卡号重复
            Account acc = getAccountByCardID(cardId, accounts);
            if (acc == null) {
                return cardId;

            }
        }

    }

    /**
     * 判断生成卡号是否与别的卡号重复
     *
     * @param cardId
     * @param accounts
     * @return
     */
    private static Account getAccountByCardID(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }
}

~~~

Account.java

~~~java
package com.itheima.ATMSystem;

/**
 * 账户类
 */
public class Account {
    private String cardId;//卡号
    private String userName;//账户名
    private String passWord;//密码
    private double money;//账户余额
    private double quotaMoney;//每次提现额度

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }
}

~~~

