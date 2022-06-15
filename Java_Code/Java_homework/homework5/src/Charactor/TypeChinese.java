package Charactor;

public class TypeChinese {

    public static void main(String args[]) {
        System.out.println("输入汉字练习（输入#结束程序）");
        System.out.printf("输入显示的汉字（回车）\n");
        Chinese hanzi;
        hanzi = new Chinese();
        GiveChineseThread giveHanzi;
        InputChineseThread typeHanzi;
        // 【代码1】创建线程giveHanzi
        giveHanzi=new GiveChineseThread();
        giveHanzi.setChinese(hanzi);
        giveHanzi.setSleepLength(6000);
        // 【代码2】创建线程ypeHanzi
        typeHanzi=new InputChineseThread();
        typeHanzi.setChinese(hanzi);
        giveHanzi.start();
        try {
            Thread.sleep(200);
        } 
        catch (Exception exp) {}
        typeHanzi.start();
    }
}
