package com.sun.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Remove {
    //    给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
//    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//    链接：https://leetcode-cn.com/problems/remove-element
    public static int[] f(int[] arr,int key){
        int tmp=0;
        for (int i:arr){
            if (i!=key){
                arr[tmp]=i;
                tmp++;
            }
        }
        //因为超出的数组长度并没有赋值，所以还是保持原来的长度，如果
        //需要打印需要打印部分，这个部分也重新创建新的数组了！！！
        return Arrays.copyOf(arr,tmp);
    }
    //数组结构不能增加元素
    //如果需要返回数组，需要使用链表结构，创建新的变量进行赋值
    public static ArrayList f1(int[] arr,int key){
        int tmp=0;
        ArrayList list=new ArrayList();
        for (int i:arr){
            if (i!=key){
                list.add(i);
                tmp++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr={2,2,2,3,2,3,10};
        int[] arr2= f(arr,2);
        for (int i:arr2){
            System.out.println(i);
        }
    }

}
