package Class3;

public class PatitionAndQuickSort {
    public static int[] netherlandsFlag(int[] arr,int L,int R){//最后返回L，R两个数最为分割点
        if(L>R){
            return new int[] {-1,-1};

        }
        if(L==R){
            return new int[] {L,R};
        }
        int less=L-1;//<区边界
        int more=R;//<区末位
        int index=L;//遍历介质
        while(index<more){//以arr[R]作为num

            if(arr[index]==arr[R]){
                index++;
            }
            else if(arr[index]<arr[R]){//<
                swap(arr,index++,++less);
            }
            else {//>
                swap(arr,index,--more);
            }
            
            
        }
        //more是最大区的边界，在数组的中间部分，是右边的那个分位点
            //左边的分为点
        swap(arr,more,R);//arr[r]位置在排序后一直没动，现在把它插入到大于区域 的第一个
        //就成等于区域的最后一个
        return new int[] {less+1,more};

    }

    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

    public static void quickSort(int[] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        process(arr,0,arr.length);
    }

    public static void process(int[] arr,int L,int R){
        if(L>R){
            return ;
        }
        swap(arr,(int)(Math.random()*(R-L+1)),R);//把num=arr[r]换地方，
        //换到num=arr[whatever]
        int[] equalArea=netherlandsFlag(arr, L, R);
        process(arr,L,equalArea[0]-1);
        process(arr,equalArea[1]+1,R);
    }
    
}
