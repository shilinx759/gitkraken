package com.case_01.demo02;

import java.util.Scanner;

public class aboutAPI {
    public static void main(String[] args) {
        //创建对象in
        Scanner in=new Scanner(System.in);
        //接受数据
        System.out.println("请输入数据：");
        //ctrl+alt+v 自动生成变量line，只需要写右边就行
        String line = in.nextLine();
        System.out.println("你输入的是："+line);


    }
}
