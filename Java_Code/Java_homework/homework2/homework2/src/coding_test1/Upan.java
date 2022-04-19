package coding_test1;

public class Upan implements MobileMachine {
    public void Read(){
        System.out.println("读取U盘的数据 ");
        System.out.println("reading:done");
    }
    public void Write(){
        System.out.println("给U盘写入数据 ");
        System.out.println("writing:done");

    }
}
