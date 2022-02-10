package sortWays;

public class selectionSort {
    public static void SelectionSort(int [] arr){
        if(arr==null||arr.length<2){
            return ;
        }

        for(int i=0;i<arr.length-1;i++){
            int minIdex=i;
            for(int j=i+1;j<arr.length-1;j++){//第i个数跟后面的所有数作比较，
                // 只要遇到第一个比他小的就换位置
                minIdex=arr[j]<arr[minIdex]?j:minIdex;//记录更小值的下标

            }
            swap(arr,i,minIdex);//交换位置
        }
    }



    public static void swap(int [] arr,int i,int j){//交互函数
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;

    }
}

