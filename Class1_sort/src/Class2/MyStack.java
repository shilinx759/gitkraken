package Class2;

import java.util.Stack;

public class MyStack {
    private Stack <Integer> stackDate;
    private Stack<Integer> stackMin;

    public MyStack(){
        this.stackDate=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }
    //压一个新的数到栈里

    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }
        else if(newNum<this.getmin()){
            this.stackMin.push(newNum);
        }
        else{
            int newMin=this.stackMin.peek();
            this.stackMin.push(newMin);
        }//这些判断的目的是为了更新记录最小值的栈
        //但无论怎样  Date都要更新这个newNum
        this.stackDate.push(newNum);
    }

    //取出最小栈的顶部
    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack was empty");
        }
        return this.stackMin.peek();
    }

    public int pop(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack was empty");
        }
        this.stackMin.pop();//要与数字栈同步，但是不给用户返回最小栈
        return this.stackDate.pop();//给用户返回
    }

    public static void main(String[] args) {
        
    }
    
}
