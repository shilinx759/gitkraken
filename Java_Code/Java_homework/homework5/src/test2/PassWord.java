package test2;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class PassWord {
    public static void main(String[] args) {
        boolean success=false;
        int count=0;
        Console cons;
        char[]passwd;
        cons=System.console();
        while(true){
            System.out.print("输入密码：");
            passwd=cons.readPassword();
            count++;
            String password=new String(passwd);
            if(password.equals("tiger123")){
                success=true;
                System.out.println("您第"+count+"次输入的密码正确！");
                break;
            }
            else{
                System.out.println("您第"+count+"次输入的密码"+password+"不正确");
            }
            if(count==3){
                System.out.println("您"+count+"次输入的密码都不正确");
                System.exit(0);
            }
        }
        if(success){
            File file=new File("F:\\gitkraken\\Java_Code\\Java_homework\\homework5\\src\\test2\\score.txt");
            try{
                FileReader inOne=new FileReader(file);
                BufferedReader inTwo=new BufferedReader(inOne);
                String s=null;
                while((s=inTwo.readLine())!=null){
                    System.out.println(s);
                }
                inOne.close();
                inTwo.close();
            }
            catch(IOException e){}
        }
     
    }
}
