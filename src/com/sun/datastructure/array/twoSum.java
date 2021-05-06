package com.sun.datastructure.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    //暴力解体法
    public static int[] sumTwo(int[] a,int target){
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if ((a[i]+a[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return new  int[]{};
    }

//    hashmap
    public static int[] f(int[] a,int target){
        //value->坐标数值   key->坐标
        HashMap<Integer,Integer> s=new HashMap<Integer, Integer>();
        for (int i=0;i<a.length;i++){
            if (s.containsKey(target-a[i])){
                return new int[]{s.get(target-a[i]),i};
            }
            s.put(a[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int [] a={12,3,34,1,3,2,2};
        System.out.println(Arrays.toString(sumTwo(a,400)));
        System.out.println(Arrays.toString(f(a,100)));

    }
}
