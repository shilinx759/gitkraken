package RationalComputate;

public class MainClass {
    
    public static void main(String args[]){
        Rational r1=new Rational(1,5);//1/5
        Rational r2=new Rational(3,2);
        Rational result=r1.add(r2);
        int a=result.getNumerator();
        int b=result.getDenominator();
        System.out.println("1/5+3/2="+a+"/"+b);
    }

    
}
