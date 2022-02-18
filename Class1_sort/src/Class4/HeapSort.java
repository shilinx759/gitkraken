package Class4;

public class HeapSort {
    public void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return ;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr, i);//把数组中的树都组成大根堆
        }
        int heapSize=arr.length;
        swap(arr,0,--heapSize);//[0]是最大值，换到最后固定
        while(heapSize>0){
            heapify(arr, 0, heapSize);//这里的[0]是数组末尾的数，大小未知
            swap(arr, 0, --heapSize);//heapify之后[0]又是最大值了，换到最后
            //并且长度减一
        }
    }
    public  void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){//当自己不必自己的父亲大时就停
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;//index往上指
        }//index==0时，arr[0]==arr[(0-1)/2],也会退出

    }
    public  void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    //将大根堆重组
    public void heapify(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){//stop:no child
            int largest;
            //选出左右孩子中较大的
            largest=left+1<heapSize  && arr[left+1]>arr[left]?left+1:left;
            //把大孩子与父亲index位置的值比较，再选出较大的allargest
            int allargest=arr[largest]>arr[index]?largest:index;
            if(allargest==index){//children can not bigger than index
                break;//then break
            }
            //one of children bigger,then change
            swap(arr,allargest,index);
            index=allargest;
            left=index*2+1;
            
        }
    }
}
