package com.sun.datastructure.array;

public class revers {
//    反转字符形数组
    public void f(char[] a){
        int len=a.length;
        int left=0;
        int right=len-1;
       while (left<right){
           char tmp=a[left];
           a[left]=a[right];
           a[right]=tmp;
           left++;
           right--;
       }
    }
}
