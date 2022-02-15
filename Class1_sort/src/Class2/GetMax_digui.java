package Class2;

public class GetMax_digui {
    public static int process(int [] arr,int L,int R){
        if(L==R){
            return arr[L];
        }
        int mid=L+((R-L)>>1);
        int leftMax=process(arr,0,mid);
        int rightMax=process(arr,mid+1,R);

        return Math.max(leftMax, rightMax);
    }

    public static int getMax(int [] arr){

        return process(arr,0,arr.length-1);
    }
    
}
