package Class4;

import javax.management.RuntimeErrorException;

public class MyMaxHeap1 {
    private  int[] heap;
    private int heapSize;
    private final int limit;
    public  MyMaxHeap1(int limit){
        heap=new int[limit];
        this.limit=limit;
    }

    public boolean isEmpty(){
        return heapSize==0;
    }

    public boolean isFull(){
        return heapSize==limit;
    }
    public  void push(int value){//从用户那得到数
        //放进树的最末位，
        //用heapInsert排位
        //heapSize++
        if(heapSize==limit){//heapSize；现在用掉的长度，limit才是数组长度
            throw new RuntimeException( "heap is full");
        }
        heap[heapSize]=value;
        heapInsert(heap,heapSize++);//重组最大堆，并更新树的长度

    }
    //用户要求返回最大根
    //剩下的树依然保持大根堆-->heapify完成
    public int  pop(){
        int ans=heap[0];//0 always is biggest
        swap(heap,0,--heapSize);//--heapSize:[0] change with [heapSize-1]
        heapify(heap,0,heapSize);//[0]；已经变成之前的[heapSize-1]了
        return ans;
    }
    public  void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public  void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){//当自己不必自己的父亲大时就停
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;//index往上指
        }//index==0时，arr[0]==arr[(0-1)/2],也会退出

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
