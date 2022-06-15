import java.awt.event.*;
public class IdentiListener implements ActionListener {
    Window view;
    String str;
    
    public void setView(Window view){
        this.view=view;
    }
    public IdentiListener(String str){
        this.str=str;
    }
    public IdentiListener(){}
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub\
        // String str=view.testInput.getText();
        Question que=new Question();
        // String str=que.getQuestion(0);
        // calc calculator=new calc();
        Question cal=new Question();
        str=view.testShow1.getText();
        // String str=que.getQuestion(0);
        int anser= cal.calculate(str);
        view.testShow2.setText(""+anser);
        String input=view.testInput.getText();
        int innum=Integer.valueOf(input);
        if(innum==anser){
            view.testInput.setText("正确！");
        }
        else{
            view.testInput.setText("回答错误");
        }

       
    }

    
}
