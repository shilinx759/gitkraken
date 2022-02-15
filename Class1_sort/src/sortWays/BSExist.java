package sortWays;



public class BSExist {
    //二分法
    public static boolean exist(int [] sorteArry,int num){
        if(sorteArry==null||sorteArry.length<2){
            return false;
        }
        int L=0;
        int R=sorteArry.length-1;//下标边界
        int mid=0;
        while(L<R){
            mid=L+((R-L)>>1);//取中点下标
            if(sorteArry[mid]==num){
                return true;
            }
            else if(sorteArry[mid]>num){
                R=mid-1;//mid肯定不对，所以不用包括它，直接等于它左边一个数就行
            }
            else {
                L=mid+1;
            }
        }
        return sorteArry[L]==num;//求的是最左边的
    }
    
}
