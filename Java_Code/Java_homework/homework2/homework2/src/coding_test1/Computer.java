package coding_test1;

public class Computer {
    private MobileMachine UsbDrive;

    public MobileMachine get_usbDrive() {
        return UsbDrive;
    }

    public void set_usbDrive(MobileMachine _usbDrive) {
        this.UsbDrive = _usbDrive;
    }

    public Computer(){}

    public Computer(MobileMachine _usbDrive) {
        this.UsbDrive = _usbDrive;
    }

    public void ReadData(){
        this.UsbDrive.Read();
    }

    public void WriteData(){
        this.UsbDrive.Write();
    }
}
