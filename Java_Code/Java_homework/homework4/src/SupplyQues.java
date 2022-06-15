import java.awt.event.*;
public class SupplyQues implements ActionListener {
    Window view;
    String str;
    int anser;
    public void setView(Window view){
        this.view=view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Question que=new Question();
        str=que.getQuestion(0);
        IdentiListener calListener=new IdentiListener(str);
        view.testShow1.setText(str);
        view.testShow2.setText("");
        view.testInput.setText("");

    }
    
}
