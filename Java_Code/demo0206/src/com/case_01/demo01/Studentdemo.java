package com.case_01.demo01;

public class Studentdemo {
    private String name;
    private int age;
    public static void main(String[] args) {

    }
    public Studentdemo(){

    }
    //构造器传参数
    public Studentdemo(String name,int age){
        this.name=name;
        this.age=age;

    }
    //成员函数传参数
    public void setName(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }
    public  int getAge(){
        return age;
    }
    public void show(){
        System.out.println(name+","+age);
    }


}
