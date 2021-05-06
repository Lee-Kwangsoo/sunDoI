package com.sun.datastructure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bianliTest {
    //map 类型遍历
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(1,2);
        //entrySet 遍历，在键和值都需要使用
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println("key="+entry.getKey()+",value="+entry.getValue());
        }

        //通过keySet或values 来实现遍历，性能略低于第一种
        for (Integer key:map.keySet()){
            System.out.println("key="+key);
        }

        //遍历map中的value
        for (Integer values:map.values()){
            System.out.println("key="+values);
        }


        //使用Iterator 遍历

        Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Integer> entry=it.next();
            System.out.println("key:="+entry.getKey()+", value:="+entry.getValue());
        }
    }


}
