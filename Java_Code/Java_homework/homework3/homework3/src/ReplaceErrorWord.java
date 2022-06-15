import java.util.regex.*;
public class ReplaceErrorWord {
    public static void main(String[] args) {
        String str = "登录网站: 222.128.89.253";
        Pattern pattern;
        Matcher matcher;
        String regex = "[\\d]{1,3}[.][\\d]{1,3}[.][\\d]{1,3}[.][\\d]{1,3}";
        pattern = Pattern.compile(regex);//【代码 1】 //初试化模式对象
        matcher = pattern.matcher(str);//【代码 2】 //匹配对
        String IP="222.128.89.253";
        while(matcher.find()) {
        IP= matcher.group();
        System.out.print(matcher.start()+"位置出现:");
        System.out.println(IP);
        } 
        System.out.printf("将%s 替换为 202.192.78.56\n",IP);
        String result = matcher.replaceAll("202.192.78.56");
        System.out.println(result);
        }
}

