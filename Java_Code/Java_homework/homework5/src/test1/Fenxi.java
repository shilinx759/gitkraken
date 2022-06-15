package test1;
import java.util.StringTokenizer;

public class Fenxi {
    public static double getTotalScore(String s) {
        String regex="[^0123456789.]";
        String digitMess=s.replaceAll(regex, "*");
        StringTokenizer fenxi=new StringTokenizer(digitMess,"*");
        double totalScore=0;
        while(fenxi.hasMoreTokens()){
            double score=Double.parseDouble(fenxi.nextToken());
            totalScore=totalScore+score;
        }
    return totalScore;
    }
}
