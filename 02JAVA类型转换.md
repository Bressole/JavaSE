# JAVA类型转换

## 自动类型转换

- 类型==范围小==的变量，可以直接赋值给类型==范围大==的变量

## 表达式的自动类型提升

- 表达式的最终结果类型由表达式中的==最高类型==决定
- 在表达式中，==byte、short、char==是直接转换成==int==类型参与运算的

## 强制类型转换

- 可以强制将类型范围大的变量、数据赋值给类型范围小的变量。

~~~java
数据类型 变量2 = (数据类型)变量1、数据
    int a = 20;
	byte b = (byte)a;
~~~

快捷键：Alt+回车

## 运算符

- 连接符 +
  - 能算则算，不能算则在一起

~~~java
System.out.println("abc"+"d");//abcd
~~~

- 逻辑运算符
  - && || 若左边为false，右边不执行
  - & | 无论左边是false还是true，右边都要执行

- 三元运算符

  - ~~~java
    条件表达式？值1:值2
    ~~~

  - 首先计算关系表达式的值，如果值为true，返回值1，如果为false，返回值2

# API

应用程序编程接口

- Java写好的程序（功能代码），咱们可以直接调用
- Oracle也为Java写好的程序提供了相应的API 文档（技术使用说明书）

[API文档下载](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

## 键盘录入案例

- 导包
  - 告诉程序去JDK中的哪个包中找扫描器技术
- 写一行代码代表得到键盘扫描器对象
- 等待接收用户输入数据

~~~java
package scanner;
//1.导包

import java.util.Scanner;

public class scannerdemo1 {
    public static void main(String[] args) {
//2.得到一个键盘扫描器对象
        Scanner sc = new Scanner(System.in);
//3.调用sc对象的功能等待接收用户输入的数据
//        这个代码会等待用户输入数据，直到用户输入完数据并按了回车键就会把数据拿到
        System.out.println("请输入您的年龄");
        int age=sc.nextInt();
        System.out.println("您的年龄是"+age);

        System.out.println("请输入您的名称");
        String name=sc.next();
        System.out.println("欢迎"+name);
    }
}

~~~

