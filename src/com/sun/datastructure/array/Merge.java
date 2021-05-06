package com.sun.datastructure.array;

import java.util.Arrays;

public class Merge {
    //以数组 intervals 表示若干个区间的集合，
    //其中单个区间为 intervals[i] = [starti, endi] 。
    //请你合并所有重叠的区间，并返回一个不重叠的区间数组，
    //该数组需恰好覆盖输入中的所有区间。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-intervals
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public int[][] test(int[][] a){
//       if (a.length==0){
//           return new int[0][2];
//       }
//
//
//
//    }


    //合并两个有序数组
    public void test1(int[] nums1,int m,int[] nums2,int n){
        //最直观的方法是先将数组nums2 放进nums1的尾部，然后直接对nums2排序
        for (int i=0;i!=n;++i){
            nums1[m+1]=nums2[i];

        }
        Arrays.sort(nums1);
    }

    //双指针 为两个数组分别设置一个指针p1与p2 作为队列的头部指针。
    public void test2(int[] nums1,int m,int[] nums2,int n){
        int p=0;
        int q=0;
        int[] sorted=new int[m+n];
        int cur;//记录当前值
        while (p<m||q<n){
            if (p==m){
                cur=nums2[q++];
            }else if(q==n){
                cur=nums1[p++];
            }else if (nums1[p]<nums2[q]){
                cur=nums1[p++];
            }else {
                cur=nums2[q++];
            }
            sorted[p+q-1]=cur;
        }
        for (int i=0;i!=m+n;i++){
            nums1[i]=sorted[i];
        }
    }
}
