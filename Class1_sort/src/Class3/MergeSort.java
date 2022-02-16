package Class3;

public class MergeSort {
    public static void mergeSort1(int [] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr,int L,int R){
        if(L==R){
            return ;
        }
        int mid=L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static int[] merge(int[] arr,int L,int mid,int R){
        int[] help=new int[R-L+1];//长度是传进来的这一部分的长度，调用的时候分了两部分传
        int p1=L;
        int p2=mid+1;
        int i=0;
       while(p1<=mid && p2<=R){
           //谁小拷贝谁
            help[i++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        //p1和p2总有一个剩下的没越界，
        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=R){
            help[i++]=arr[p2++];
        }
        //用help覆盖合并的数组
        for(i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }

        return arr;
    }


    public static void MergeSort2(int[] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        int mergeSize=1;
        int N=arr.length;
        while(mergeSize<N){
            int L=0;
            while(L<N){
                int M=L+mergeSize-1;
                if(M>=N){
                    break;
                }
                int R=Math.min(M+mergeSize,N-1);
                merge(arr,L,M,R);
                L=R+1;
            }
            if(mergeSize>N/2){
                break;
            }
            mergeSize<<=1;//*2
        }   
    }
    
}
