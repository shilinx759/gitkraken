package Class4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class HeapGreater<T> {
    private ArrayList<T> heap;
    private HashMap<T,Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comp;//?

    public HeapGreater(Comparator<T> c){//构造器
        heap=new ArrayList<>();
        indexMap=new HashMap<>();
        heapSize=0;
        comp=c;

    }

    public boolean isEmpty(){//是空的 就返回1
        return heapSize==0;
    }

    public int size(){
        return heapSize;
    }

    public boolean contian(T obj){//是否已经存过了
        return indexMap.containsKey(obj);
    }

    public T peek(){
        return heap.get(0);
    }

    public void push(T obj){
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);//不管是 Insert还是heapify 都是对位置做操作
        //无所谓值
    }

    public T pop(){
        T ans=heap.get(0);
        swap(0, heapSize-1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;

        
    }

    public void remove(T obj){//这与pop中的remove无关
        T reobj=heap.get(heapSize-1);
        int replace=indexMap.get(obj);//
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if(obj!=reobj){
            heap.set(replace, reobj);
            indexMap.put(reobj, replace);
            resign(reobj);
        }
    }

    public void resign(T obj){
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));

    }

    public List<T> getAllElements(){
        List<T> ans =new ArrayList<>();
        for(T c:heap){
            ans.add(c);
        }
        return ans;
    }

    public void heapInsert(int index){//heapSize is int
        while(comp.compare(heap.get(index), heap.get((index-1)/2))<0){
            //-1,before bigger
            //1,after bigger
            //0 ,equal
            //index bigger than his father,change thier place
            swap(index,(index-1)/2);
            index=(index-1)/2;//把指针指向现在的我，在我父亲的位置上

        }

    }

    public void heapify(int index){
        int L=index*2-1;
        while(L<heapSize){
            int largest;
            //comp result;-1 L;1 L+1;0 whatever
            largest=L+1<heapSize && comp.compare(heap.get(L), heap.get(L+1))<0?L:L+1;
            //lar 两个孩子中最大的，根我比，比我还大，就交换
            int allargest=comp.compare(heap.get(largest), heap.get(index))<0?largest:index;
            if(allargest==index){//我的孩子都不比我大，就不用换
                break;
            }
            swap(allargest,index);//换值，位置没换，index是大孩子
            //把位置也换了
            index=allargest;
            L=index*2-1;


        }
        

    }

    public void swap(int i ,int j){
        T o1=heap.get(i);
        T o2=heap.get(j);
        heap.set(i, o2);//i:place o1:value
        heap.set(j, o1);
        indexMap.put(o2, i);
        indexMap.put(o1, j);

    }
}
