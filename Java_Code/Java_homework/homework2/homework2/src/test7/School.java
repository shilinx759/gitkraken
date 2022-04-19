package test7;

public class School implements CompurerAverage {
    public double average(double x[]){
        double sum=0;
        for(int i=0;i<x.length;i++){
            sum+=x[i];
        }
        return sum/(double)x.length;
    }
}
