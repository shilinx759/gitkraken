
    
class StackSingleNode{
	public int value;
	public StackSingleNode next;
	public StackSingleNode(int value){
		this.value = value;
	}
}
class SingleLinkedStack{

	public StackSingleNode head = new StackSingleNode(0);
	public void push(StackSingleNode stackNode){
		if(null == head.next){
			head.next = stackNode;
		}else{
		StackSingleNode temp = head.next;		
		head.next = stackNode;
		stackNode.next = temp;
		}
	}
	
	public int pop(){
		if(null == head.next){
			System.out.println("栈为空");
		}
		int value = head.next.value;
		head.next = head.next.next;
        return value;		
	}
	
	public boolean isEmpty(){
		if(null == head.next){
			return true;
		}
		return false;
	}
	
	public int peek(){
		return head.next.value;
	}
}
public class calc {
	public String input;
	public int anser;

	// public static void main(String[] args){
	// 	calc d =new calc();
	// 	String s = "700*2+600/10+19";
	// 	int result = d.calculate(s);
	// 	System.out.println("结果为" + result);
	// }
	public calc(){}
	public calc(String s){
		this.input=s;
	}
	public static int getPriority(int num){
		char n = (char)num;
		if(n == '+'||n=='-'){
			return 0;
		}else if(n == '*'||n=='/'){
			return 1;
		}else{
			System.out.println("运算符不能识别");
			return -999;
			
		}
	}

	protected static int count(int num1, int num2, int peek) {
		char ope = (char)peek;
		switch(ope){
		  
		case '+':
			return num1 + num2;
		
		case '-':
			return num2 - num1;
		case '*':
			return num1 * num2;
		case '/':
			return num2 / num1;
		}
		return 0;
	}
}



