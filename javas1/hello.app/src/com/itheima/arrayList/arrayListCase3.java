package com.itheima.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

//1、定义student类，定义ArrayList集合存储如上学生对象信息，并遍历展示
//2、提供一个方法，可以接收集合，和要搜索的学生对象信息，并展示
//3、使用死循环，让用户不停搜索
public class arrayListCase3 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("201901","素囧",26,"函数一班"));
        students.add(new Student("201902","安娜",18,"花滑二班"));
        students.add(new Student("201903","叨叨",22,"物联五班"));
//        遍历展示
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.getStudyNumber() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getClassName());
        }
        //        定义方法，完成搜索功能
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入要查询的学生学号：");
            String studyNumber = sc.next();
            //调用方法
            Student s = getStudentById(students,studyNumber);
//        判断s中是否存在学生对象地址
            if(s == null){
                System.out.println("查无此人！");
            }
            else{
                System.out.println(s.getStudyNumber() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getClassName());
            }
        }
    }
//输入 /**然后回车 生成注释
    /**
     *
     * @param students
     * @param studyNumber
     * @return
     */
        public static Student getStudentById(ArrayList<Student> students,String studyNumber){
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                if(s.getStudyNumber().equals(studyNumber)){
                    //找到了
                    return s;
                }
            }
            return null;
        }
}
