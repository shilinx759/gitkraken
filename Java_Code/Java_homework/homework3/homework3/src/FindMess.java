import javax.print.attribute.IntegerSyntax;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.text.StringContent;
import javax.swing.text.AbstractDocument.ElementEdit;

public class FindMess {
    public static void main(String[] args) {
        String mess ="书名：Java程序设计，出版时间：2011.10.01，"+
        "出版社：清华大学出版社，价格：29.8元，页数：389页";
        if(mess.contains("出版")){
            System.out.println("图信息包含有\"程序\"");
        }
        int index=mess.indexOf(':', 4);
        String date=mess.substring(index+1, index+11);
        System.out.println(date);
        int pricePosition=mess.indexOf("价格");
        int endPosition=mess.indexOf("元");
        String priceMess=mess.substring(pricePosition+3, endPosition);
        System.out.println("图书价格："+priceMess);
        double price =Double.parseDouble(priceMess);
        if(price>=29){
            System.out.println("图书价格"+price+"大于或等于29元");
        }
        else{
            System.out.println("图书价格"+price+"小于29元");
        }
        index=mess.lastIndexOf('：');
        endPosition=mess.lastIndexOf("页");
        String pageMess =mess.substring(index+1, endPosition);
        int p =Integer.parseInt(pageMess);
        if(p>=360){
            System.out.println("图书的页数"+p+"大于或等于360");
        }
        else{
            System.out.println("图书的页数"+p+"小于360");
        }

    }
}
