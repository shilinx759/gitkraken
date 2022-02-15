package sortWays;

public class InsertionSort {
    //插入
    public static void insertionSort(int [] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        //判断0-0有序的
        //0-i想有序
        for(int i=0;i<arr.length;i++){//0-i做到有序
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){//j-1=i;将第i位与前面的所有数比较，更小就换
                swap(arr,j,j+1);
            }
        }
        
    }

    public static void swap(int []arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
}
