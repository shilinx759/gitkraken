import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthDesktopIconUI;

public class FoundPrice {
    public static void main(String[] args) {
        String s="牛奶：89.8元，香肠：12.9元 啤酒：69元 巧克力：132元";
        String regex="[^0123456789.]";
        String digitMess=s.replaceAll(regex, "*");
        // System.out.println(digitMess);
        StringTokenizer fenxi=new StringTokenizer(digitMess,"*");
        // System.out.println(fenxi);
        int number=fenxi.countTokens();
        double sum=0;
        while(fenxi.hasMoreTokens()){
            String str =fenxi.nextToken();
            System.out.println(str);
            sum=sum+Double.parseDouble(str);
        }
        System.out.println("购物小票中的商品种类："+number+"种");
        System.out.println("购物小票中的价格总额："+sum+"元");
    }
}
