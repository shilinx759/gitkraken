package com.case_01.demo02;

import javax.sound.sampled.SourceDataLine;

public class aboutString {
    public static void main(String[] args) {
        String s1=new String();

        System.out.println("s1:"+s1);
        char [] cha= {'a','2','e'};
        String s2=new String(cha);
        System.out.println("s2:"+s2);

        byte [] by={98,99,100};
        String s3=new String(by);
        System.out.println("s3:"+s3);
    }
}
