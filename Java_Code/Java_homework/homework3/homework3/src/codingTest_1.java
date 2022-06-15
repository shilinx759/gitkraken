import java.util.Random;
import java.util.Scanner;

import javax.management.monitor.Monitor;
import javax.swing.Renderer;

import org.xml.sax.SAXNotRecognizedException;

public class codingTest_1 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("请输入人数：");
        int menber=in.nextInt();
        System.out.println("请输入金额：");
        double sum_money=in.nextDouble();
        Random random=new Random();
        int noGet=menber;
        for(int i=0;i<menber;i++){
            int range=(int)(sum_money*100);
            int randomMoney=random.nextInt(range)+1;
            double actual=(randomMoney-1)*0.01;
            if(noGet*0.01<=sum_money-actual && (randomMoney-1)!=0){
                if(randomMoney!=0){
                    noGet--;
                  
                }
            }
        }

    }
