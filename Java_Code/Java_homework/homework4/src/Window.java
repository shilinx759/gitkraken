import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
    Box baseBox,boxV1,boxV2;
    public JTextField testInput, testShow2,testShow1;
    public IdentiListener calListener,ansListener;
    public SupplyQues queListener;
    
    public JButton button1,button2;
    public Window(){
        setLayout(new java.awt.FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init(){
        boxV1=Box.createVerticalBox(); 
        boxV1.add(Box.createVerticalStrut(20));
        boxV1.add(new JLabel("题目"));
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(new JLabel("答案"));
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(new JLabel("正确答案"));
        boxV1.add(Box.createVerticalStrut(25));

        button2=new JButton("生成题目");
        boxV1.add(button2);

        boxV2=Box.createVerticalBox();
        boxV2.add(Box.createVerticalStrut(8));
        queListener=new SupplyQues();
        queListener.setView(this);
        button2.addActionListener(queListener);

        boxV2.add(Box.createVerticalStrut(20));
        testShow1=new JTextField(10);//题目
        testShow1.setEditable(false);
        boxV2.add(testShow1);
        boxV2.add(Box.createVerticalStrut(10));
        testShow1.addActionListener(queListener);
        // boxV2.add(new JTextField(10));

        testInput=new JTextField(10);//输入
        // testInput.setEditable(false);
        boxV2.add(testInput);
        boxV2.add(Box.createVerticalStrut(10));
        ansListener=new IdentiListener();
        ansListener.setView(this);
        testInput.addActionListener(ansListener);

        //不可编辑文本框
        testShow2=new JTextField(10);
        testShow2.setEditable(false);
        boxV2.add(testShow2);
        boxV2.add(Box.createVerticalStrut(10));

        button1=new JButton("验证");
        boxV2.add(button1);
        boxV2.add(Box.createVerticalStrut(8));
        calListener=new IdentiListener();
        calListener.setView(this);
        button1.addActionListener(calListener);


        baseBox=Box.createHorizontalBox();
        baseBox.add(boxV1);
        baseBox.add(Box.createHorizontalStrut(15));
        baseBox.add(boxV2);
        add(baseBox);

    }
}
