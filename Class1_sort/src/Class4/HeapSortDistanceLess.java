package Class4;

import java.util.PriorityQueue;

public class HeapSortDistanceLess {
    public void sortedDistanceLessK(int[] arr,int K){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int gap=0;
        int i=0;
        for(;gap<=Math.min(arr.length-1, K);gap++){
            heap.add(arr[gap]);//前几个若不足Kge元素，则这直接循环小根堆就能排完
        }
        for(;gap<arr.length;i++,gap++){//大于K后的元素继续
            
            arr[i]=(int) heap.poll();
            heap.add(arr[gap]);
            
           
        }//小根堆末尾还会剩数量小于K没有pop到，直接全部pop就行
        while(!heap.isEmpty()){
            arr[i++]=(int)heap.poll();
        }
        

    }
    public static void main(String[] args) {
        PriorityQueue<Integer> hp=new PriorityQueue<>();
        hp.add(8);
        hp.add(4);
        hp.add(4);
        hp.add(2);
        hp.add(8);


    }
    
}
