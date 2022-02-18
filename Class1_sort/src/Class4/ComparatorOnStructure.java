package Class4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorOnStructure implements Comparator<Integer> {

 

  
    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return o2-o1;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(new ComparatorOnStructure());
        heap.add(8);
        heap.add(3);
        heap.add(7);
        heap.add(4);
        heap.add(5);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
   
    
}


