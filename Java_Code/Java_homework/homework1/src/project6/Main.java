package project6;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Main {
    public static void main(String[] args) {
        char ch;
        int n;
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入A或B（A:打印直线；B打印杨辉三角）：");
        ch=reader.next().charAt(0);
        if(ch=='A'){
            System.out.println("####################");
        }
        else if(ch=='B'){
            n=reader.nextInt();


            for(int i =0;i<n;i++) {
                int number = 1;
                //打印空格字符串
                System.out.format("%"+(n-i)*2+"s","");
                for(int j=0;j<=i;j++) {
                    System.out.format("%4d",number);
                    number = number * (i - j) / (j + 1);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("非法字符！");
        }
    }
    
}
