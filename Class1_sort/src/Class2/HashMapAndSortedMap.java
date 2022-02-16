package Class2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;


public class HashMapAndSortedMap {
    //在使用来增删改查，都是O（1）！！！
    private static final String TreeMap = null;
    //非基础类型
    private static class Node{
        public int value;
        public Node(int v){
            value=v;
        } 
    }

    public static void main(String[] args) {
        //      key,    value
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"woshi 1");
        map.put(2,"woshi 2");
        map.put(3,"woshi 3");
        map.put(4,"woshi 4");
        //检查有没有加入过key为1的数据 返回true/false
        System.out.println(map.containsKey(1));
        //查出key为4的数据
        System.out.println(map.get(4));
        //没记录的 会输出null
        System.out.println(map.get(10));
        //更新操作
        map.put(4,"tashi 4");
        System.out.println(map.get(4));
        map.remove(4);//删除
        System.out.println(map.get(4));


        //       key
        HashSet<String> set=new HashSet<>();
        set.add("woshi 1");
        set.contains("woshi 1");//返回true/false
        set.remove("woshi 1");

        System.out.println("========================");

      TreeMap<Integer,String> treeMap=new TreeMap<>();
      treeMap.put(1,"yi");
      treeMap.put(2,"er");
      treeMap.put(3,"san");
      treeMap.put(4,"si");
    
      System.out.println(treeMap.firstKey());//输出排第一的值

      System.out.println(treeMap.lastKey());

      //<=4离4最近的数
      System.out.println(treeMap.floorKey(4));
      //>=4离4最近的数
      System.out.println(treeMap.ceilingKey(4));
    


    }
    
}
