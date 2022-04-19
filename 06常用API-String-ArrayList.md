# 常用API —— String ArrayList

## 一、API （Application Programming Interface , ==应用程序编程接口==）

- Java 写好的技术（功能代码），可以直接调用
- Oracle 也为Java 提供的这些代码提供了相应API文档（技术使用说明书）

## 二、String

- String类定义的变量可以用于存储字符串，同时String提供了很多操作字符串的功能，可以直接使用。

### 1、概述

- java.lang.String类代表字符串，String类定义的变量可以用于指向字符串对象，然后操作该字符串。
- Java 程序中的所有字符串文字（例如"abc"）都为此类的对象。
- 不可变？
  - String变量每次的修改其实是产生并指向了新的字符串对象
  - 原来的字符串对象都是没有改变的，所以称为==不可变字符串==

### 2、创建字符串对象

- 方式一：直接使用" "定义（√）

~~~java
String name = "JAVA"；
~~~

- 方式二：通过String类的构造器创建对象

<img src="C:\Users\kEEpkind-\AppData\Roaming\Typora\typora-user-images\image-20220417143627925.png" alt="image-20220417143627925" style="zoom:67%;" />

~~~java
String s1 = new String();
String s2 = new String("星期三");

char[] chars = {'星','期','三'}
String s3 = new String(chars);     //输出“星期三”

byte[] bytes = {97,98,99}
String s4 = new String(bytes);      //输出ASCII对应字母
~~~

### 3、String类常用API

#### 字符串内容比较

<img src="C:\Users\kEEpkind-\AppData\Roaming\Typora\typora-user-images\image-20220417145859262.png" alt="image-20220417145859262" style="zoom:67%;" />

~~~java
 3、判断登录名称与密码与正确内容是否相等
//        if(okName == name && okPassword == password)  这种方法是不行的！
        if(okName.equals(name) && okPassword.equals(password)){
            System.out.println("登录成功！");
        }
        else{
            System.out.println("用户名不存在或者密码错误！");
        }
//        4、忽略大小比较内容的API，一般用于比较验证码
        String okCode = "23Abc";
        String code = "23aBc";
        System.out.println(okCode.equalsIgnoreCase(code));//忽略大小写
~~~

#### 遍历 替换 截取 分割操作

<img src="C:\Users\kEEpkind-\AppData\Roaming\Typora\typora-user-images\image-20220417150713403.png" alt="image-20220417150713403" style="zoom:67%;" />

#### 案例：验证码、登录、隐私号码

<img src="C:\Users\kEEpkind-\AppData\Roaming\Typora\typora-user-images\image-20220417162023214.png" alt="image-20220417162023214" style="zoom:67%;" />



## 三、ArrayList

- 代表的是集合类，集合是一种容器，与数组类似，不同的是==集合的大小是不固定的==

- ArrayList是集合中的一种，它支持索引。

### 1、ArrayList集合的对象获取

~~~java
ArrayList list = new ArrayList<>();
~~~

### 2、ArrayList集合添加元素的方法

~~~java
list.add("Java");
list.add("daodao");
~~~

### 3、给指定索引位置插入元素

~~~java
list.add(1,"billie");
~~~

### 4、泛型（写集合最好用泛型）

- ArrayList<String>：此集合只能操作==字符串类型==的元素

~~~java
ArrayList<String> list = new ArrayList<>();
~~~

- ArrayList<Integer>：此集合只能操作==整数类型==的元素

~~~java
ArrayList<Integer> list = new ArrayList<>();
~~~

### 5、ArrayList集合常用方法

<img src="C:\Users\kEEpkind-\AppData\Roaming\Typora\typora-user-images\image-20220417215401951.png" alt="image-20220417215401951" style="zoom:67%;" />

### 6、案例

<img src="C:\Users\kEEpkind-\AppData\Roaming\Typora\typora-user-images\image-20220418001736811.png" alt="image-20220418001736811" style="zoom:67%;" />