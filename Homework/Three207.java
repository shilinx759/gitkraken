import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Three207 {

	public static void main(String[] args) {
		System.out.println("第一行为m初值，第二行人数n，第三行依次每人的密码(每个密码空格隔开):");//输出提示语句
		Scanner sc = new Scanner(System.in);				//获取控制台输入
		String str = "";
		int s = 1;
		ArrayList<String> strList = new ArrayList<String>();//动态数组
		while(s<=3){  			
			str = sc.nextLine();
			strList.add(str);								//添加至动态数组
			s=s+1;
		}
		sc.close();
		
		int m = Integer.parseInt(strList.get(0).trim());
		int n = Integer.parseInt(strList.get(1).trim());
		String string = strList.get(2).trim();
		
		String strpsw [] = string.split(" ");
		if (n == strpsw.length) {
			int [] psw = new int[n];	//密码数组
			for (int i = 0; i < strpsw.length; i++) {			//密码与编号差1 
				psw[i] = Integer.parseInt(strpsw[i]);
			}
			/*
			 * 编号：0 1 2 3 4 5
			        密码：5 4 2 1 6 3
			*/
			int [] num = new int[n];	//编号数组
			for (int k = 0; k < num.length; k++) {
				num[k] = k+1;
			}
			/*		初始序列		开始第一次			。。。。。。
			 * i:0 1 2 3 4 5	0 1 2 3 4 5
			   编号:1 2 3 4 5 6	1 2 4 5 6 6
			   
			*/
			int space = m%n-1;
			while (n>0) {
				String mString=",";
				if (n==1) {
					mString=" ";
				}
				System.out.print("输出序列为："+num[space]+mString);
				int t=num[space]-1;		//先保存一下这次所数到的人的编号
				
				for (int i = space; i < n-1; i++) {
					num [i] = num[i+1];
				}
				n--;
				if (n != 0) {
					space = (space+psw[t]-1)%n;
				}
			}
		}else {
			System.out.println("密码个数输入有误！");
		}
		
		
	}

}

