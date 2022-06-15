import java.util.Scanner;

public class Question extends calc{
        static Scanner up=new Scanner(System.in);
        //扫描从控制台输入的字符，并赋值给up
        
    //自定义方法，进行运算符的获取
     private static String getOp() {
        int k=(int)(Math.random()*4+1);

                String str="";
                switch(k) {
                   case 1:str = "+";
                   break;
                   case 2:str = "-";
                   break;
                   case 3:str = "*";
                   break;
                   case 4:str = "/";
                   break;   
                   }
                return str;
            }
            
    //自定义方法，计算正确的答案
    private static int calculation(int a, int b, int k){
                int sum=0;
                switch(k) {
                   case 1:sum=a+b;
                   break;
                   case 2:sum=a-b;
                   break;
                   case 3:sum=a*b;
                   break;
                   case 4:sum=a/b;
                   break;   
                   }
                return sum;
            }
        public String getQuestion(int type){
            String str;
            if(type==0){//整数型
                int a=(int)(Math.random()*100);
                int b=(int)(Math.random()*100);
                int c=(int)(Math.random()*100);
                int d=(int)(Math.random()*100);

               
                str=a+getOp()+b+getOp()+c+getOp()+d;
            }
            else {//浮点型
                double a=Math.random()*100;
                double b=Math.random()*100;
                double c=Math.random()*100;
                double d=Math.random()*100;

                str=a+getOp()+b+getOp()+c+getOp()+d;



            }
            
            return str;
        }

        public int calculate(String s){
            SingleLinkedStack numStack = new SingleLinkedStack();
            SingleLinkedStack opeStack = new SingleLinkedStack();
            String num = "";
            boolean flag = false;
            for(int i = 0;i<s.length();i++){
                if((s.charAt(i)<48) || (s.charAt(i)>57)){				
                    flag = true;
                }else{
                    num = num + s.charAt(i);
                }
                if(flag){
                    flag = false;
                    numStack.push(new StackSingleNode(Integer.valueOf(num)));
                    num = "";
                    if(opeStack.isEmpty()){
                        opeStack.push(new StackSingleNode(s.charAt(i)));
                        
                    }else{
                        
                        int m = getPriority(s.charAt(i))-getPriority(opeStack.peek());
                        if(m==0 ||m==-1){
                            
                            int num1 = numStack.pop();
                            int num2 = numStack.pop();
                            int c = count(num1,num2,opeStack.peek());
                            opeStack.pop();
                            opeStack.push(new StackSingleNode(s.charAt(i)));
                            numStack.push(new StackSingleNode(c));						
                        }
                        if(m==1){
                            opeStack.push(new StackSingleNode(s.charAt(i)));
                        }
                        
                    }
                    
                    
                }			
            }
            if(""!=num){
                numStack.push(new StackSingleNode(Integer.valueOf(num)));
            }
            while(!opeStack.isEmpty()){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                int c = count(num1,num2,opeStack.peek());
                opeStack.pop();
                numStack.push(new StackSingleNode(c));
            }
            
            return numStack.pop();
        }
    //     public static void main(String[] args) {
    //     Scanner sc=new Scanner(System.in);
    //     System.out.println("请输入操作数的范围：");
    //     int y=sc.nextInt();
    //     System.out.println("请输入题目个数：");
    //     int x=sc.nextInt();
    //     for(int i=0;i<x;i++) {
    //        int a=(int)(Math.random()*y);
    //      //扫描从控制台输入的字符，并赋值给up
    //        int b=(int)(Math.random()*y);
    //      //在指定范围内产生的数赋值给b
    //        int k=(int)(Math.random()*4+1);
    //        //随机产生1~4的数并赋值给k
    //        System.out.println(a+getOp()+b+"=");
    //        //四则运算符由自定义方法getOp获取
      
    //        System.out.println("请输入答案：");
    //        double answer=up.nextDouble();
    //        //接收输入的答案
    //        int trueanswer=calculation(a,b,k);
    //        //调用自定义方法获取答案的正确值
    //        if(answer==trueanswer) {
    //            System.out.println("你太棒了！");
    //        }
    //        else System.out.println("计算错误！");
    //       }
    //    }
    }

