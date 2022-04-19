package coding_test1;
public class Mp3 implements MobileMachine {
    public void Read() {
        System.out.println("读取MP3的数据r");
        System.out.println("reading:done");
    }

    public void Write() {
        System.out.println("给MP3写入数据");
        System.out.println("writing:done");
    }

    public void PlayMusic(){
        System.out.println("正在播放歌曲");
    }
}
