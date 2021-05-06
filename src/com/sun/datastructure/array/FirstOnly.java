package com.sun.datastructure.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstOnly {

    //找出数组中，第一个不重复的数字

    public static int test(int[] a) {
        int index = 0;
        int only = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    index++;
                }

            }
            if (index == 1) {
                only = a[i];
                break;
            } else {
                index = 0;
            }
        }
        return only;
    }

    public static int f(int[] a){
        int index=0;
        int only=0;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                if (a[i]==a[j]){
                    index++;
                }
            }
            if (index==1){
                only=a[i];
            }else {
                index=0;
            }
        }
        return only;
    }

//    第二种
    public static int  test1(int[] a){
        int s=0;
//        通过把数组存入Map集合中，数组元素作为key，出现次数作为value。
//        然后通过遍历Map集合，把第一个value为0的key输出来，并跳出循环
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for (int i=0;i<a.length;i++){
            if (map.containsKey(a[i])){
                int values=map.get(a[i]);
                map.put(a[i],values+1);
            }else {
                map.put(a[i],0);
            }
        }
        //遍历map集合
        for (int i=0;i<a.length;i++){
            int value=map.get(a[i]);
            if (value==0){
                s= a[i];
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4, 5, 4, 6, 6, 6,5};
        System.out.println(a.length);
        System.out.println(test(a));
        System.out.println(test1(a));
    }

}
