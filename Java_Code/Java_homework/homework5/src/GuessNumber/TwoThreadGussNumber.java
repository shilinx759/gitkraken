package GuessNumber;

public class TwoThreadGussNumber {
    public static void main(String args[]){
        Number number=new Number();
        number.giveNumberThread.start();
        number.guessNumberThread.start();
    }
}
