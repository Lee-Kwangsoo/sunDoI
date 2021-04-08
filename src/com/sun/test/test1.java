package com.sun.test;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
    //硬币规划{1，5，7，10}  https://www.cnblogs.com/zzlback/p/8571113.html
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] tmp=new int[n+1];//存放每种硬币取得最少的取法
        int weizhi[]={1,5,7,10};
        for (int i=1;i<tmp.length;i++){
            int minV=i;//初始化最小为minV，因为最小取的硬币数量肯定不会比i还要大
            for (int j=0;j<weizhi.length;j++){
                if (i>=weizhi[j]){//取到的硬币数比有的数目要大
                    int k=tmp[i-weizhi[j]]+1;
                    if (k<minV){
                        minV=k;
                    }
                }
            }
            tmp[i]=minV;

        }
        System.out.println("至少需要"+tmp[n]+"枚硬币");


    }
}
