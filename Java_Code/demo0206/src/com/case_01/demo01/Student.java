package com.case_01.demo01;

public class Student {
    public static void main(String[] args) {
        //使用无参构造器，调用setxx函数赋值
        Studentdemo s1 = new Studentdemo();
        s1.setAge(20);
        s1.setName("牛逼");
        s1.show();
        //使用带参构造器创建带有属性值的对象
        Studentdemo s2=new Studentdemo("hh",10);
        s2.show();
    }
}
