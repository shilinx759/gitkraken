package coding_test1;

public class Main {
    
        public static void main(String[] args) {
            Computer computer = new Computer();
            MobileMachine Mp3 = new Mp3();
            MobileMachine Upan = new Upan();
            MobileMachine moblieHardDisk = new MobileHardDisk();
            Mp3 mp3=new Mp3();
    
            System.out.println("电脑给MP3写入数据:");
            computer.set_usbDrive(Mp3);
            computer.WriteData();
            System.out.println("====================");
    
            System.out.println("从固态硬盘读取数据:");
            computer.set_usbDrive(moblieHardDisk);
            computer.ReadData();
            System.out.println("====================");
    
            System.out.println("从U盘读取数据，并写入一些数据:");
            computer.set_usbDrive(Upan);
            computer.ReadData();
            computer.WriteData();
            System.out.println("====================");

            System.out.println("用MP3放歌：");
            mp3.PlayMusic();

            

        }
       
          
        
    
}
