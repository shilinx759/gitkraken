package RationalComputate;

//计算后输出分数，而不是小数
//例如 1/6，2/3
public class Rational {
    int numerator;
    int denominator;

    //构造分数
    Rational(int a,int b){
        if(a==0){
            numerator=0;
            denominator=1;

        }
        else{
            setNumeratorAndDenominator(a,b);
        }
    }
    //设置分子和分母
    void setNumeratorAndDenominator(int a,int b){
        //求a，b的最大公约数，来化简分数
        int c=f(Math.abs(a),Math.abs(b));
        numerator=a/c;
        denominator=b/c;
        //如果都是负数，那么要改成正的
        if(numerator<0 && denominator<0){
            numerator=-numerator;
            denominator=-denominator;
        }

    }
    int getNumerator(){
        return numerator;
    }

    int getDenominator(){
        return denominator;
    }

    int f(int a,int b){//求ab的最大公约数
        if(a<b){
            int t=a;
            a=b;
            b=t;
        }
        int res=a%b;
        while(res!=0){
            a=b;
            b=res;
            res=a%b;
        }
        return b;
    }

    Rational add(Rational r){//a/b +num/deno
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b+denominator*a;
        int newDenominator=b*denominator;
        Rational result=new Rational(newNumerator,newDenominator);
        return result;

    }
    
}
