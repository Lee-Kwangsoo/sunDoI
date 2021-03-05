package com.sun.datastructure;

import java.util.ArrayList;
import java.util.Iterator;

public class TestListJ {
    /**
     * java中的List接口，具体使用时可以用他的实现类
     * ArrayList---基于数组，每次创建都会创建新的数组，但数组有索引，arrayList有查询快，增删慢的特点
     * LinkedList---基于链表（双向）实现。每个元素存储本身内存地址的同时，还会存储下一个元素的地址。所以LinkedList有查询慢、增删快的特点。
     * Vector---基于数组，Vector和ArrayList用法上几乎相同，但Vector比较古老，一般不用。Vector是线程同步的，效率低
     *https://www.cnblogs.com/bl123/p/13869396.html
     */
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        //迭代器
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //for 循环
        for(String val:list){
            System.out.println(val);
        }

        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
