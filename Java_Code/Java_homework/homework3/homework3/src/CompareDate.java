import java.time.*;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
public class CompareDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入开始的年， 月， 日 ");
        System.out.println("年月日之间用-， /或.分隔\n 例如： 2018-2-12");
        String regex = "[-./]";
        String [] input = scanner.nextLine().split(regex);
        int year = Integer.parseInt(input[0]);
        int month = Integer.parseInt(input[1]);
        int day = Integer.parseInt(input[2]);
        LocalDate dateStart = null;
        dateStart= LocalDate.of(year, month, day);
        //【代码 1】 // LocalDate 调用 of 方法， 返回年月日分别是 year,,month,day 的 dateSart 对象
        System.out.print("输入结束的年， 月， 日:");
        input = scanner.nextLine().split(regex);
        year = Integer.parseInt(input[0]);
        month = Integer.parseInt(input[1]);
        day = Integer.parseInt(input[2]);
        LocalDate dateEnd = null;
        dateEnd=LocalDate.of(year, month, day);
       // 【代码 2】 // LocalDate 调用 of 方法返回年月日分别是 year,,month,day 的 dateEnd 对象
        long days = dateEnd.toEpochDay()-dateStart.toEpochDay();
        //【代码 3】 //得到 dateStart 和 dateEnd 相隔的天数
        boolean boo = dateEnd.isAfter(dateStart);
        //【 代码 4】 //判断 dateEnd 是否在 dateStart 之后
        if(boo)
            System.out.println(dateEnd+"在"+dateStart+"之后");
            System.out.println(dateStart+"和"+dateEnd+"相隔： ");
            System.out.println(Math.abs(days)+"天(不足一天的零头按 0 计算)");
        
    }
}
