package Class2;

import java.util.HashMap;

public class HashMapAndSortedMap {
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

    }
    
}
