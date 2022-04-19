package coding_test1;

public class MobileHardDisk implements MobileMachine {
    public void Read() {
        System.out.println("读取固态硬盘的数据");
        System.out.println("reading： done");
    }

    
    public void Write() {
        System.out.println("给固态硬盘写入数据");
        System.out.println("writing： done");
    }
}
