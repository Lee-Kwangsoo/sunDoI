package com.sun.datastructure;

import java.util.Arrays;

public class TestArray {
    /**
     * 学习一种数据结构思路
     * 声明方法
     * 增删改查
     * 判断相等equals与==
     * 创建字串，截取字串
     * 排序
     * 打印
     * @param args
     */
    public static void main(String[] args) {
        int[] arr={2,3,4,5};

        //截取数组和数组声明方法
        //int[] arr 和 int arr[] 无任何区别，写法不同而已，都可以
        int[] arr1= Arrays.copyOf(arr,4);
        int[] arr2=Arrays.copyOfRange(arr,1,3);
        int[] arr3=null; arr3= new int[]{3, 4, 5, 6};
        int[] arr4=new int[]{1,2,3};
        int[] arr5=new int[5]; arr5= new int[]{1, 2, 3}; arr5= new int[]{3, 3, 3,1,1,2,3};
        //排序
        String[] str=new String[]{"haha","sunsun","lili","ping"};
        float[] f=new float[]{1.122f,8,99f,10.8f};
        Arrays.sort(f);
        for (float f1:f){
            System.out.println(f1);
        }
         Arrays.sort(arr5);
         //比较 长度及元素是否相等
        System.out.println(Arrays.equals(arr1,arr));
        Arrays.sort(str);
        for (String s:str){
            System.out.println(s);
        }

        for (int i:arr5){
            System.out.println(i);

        }
        //==比较的是变量（栈）内存中存放的对象的（堆）内存空间，用来判断两个对象的地址是否相同
        //是否指相同一个对象
        System.out.println(arr==arr1);
        System.out.println(arr[0]==arr1[0]);

    }
}
