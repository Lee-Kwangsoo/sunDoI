package com.sun.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class threeSum {
//   数组内三个数字组合是0，不允许重复
    /**
     * 1.遍历数组
     * 先排序，排序后固定一个数num[i],在使用左右指针指向num[i]后面的两端，数字分别
     * 为nums[L] 和 nums[R],计算三个树的和sum 判断是否满足0，满足则添加结果集。
     *如果nums[i] 大于0，则三个数的和必然无法等于0，结束循环
     * 如果nums[i]==num[i-1] 则说明该数字会重复，会导致结果重复，所以应该跳过
     * 当sum==0 ，nums[L]=num[L+1],则会导致结果重复，应该跳过，L++；
     * 当sum==0，nums[R]=nums[R-1]则会导致结果重复，应该跳过，R--；
     *
     * 问题分解
     */
    public static List<List<Integer>> f(int[] a){
        List<List<Integer>> ans=new ArrayList<>();
        int len=a.length;
        if (a==null||len<3) return ans;
        Arrays.sort(a);//先排序
        for (int i=0;i<len;i++){
            if (a[i]>0){ break;}
            if (i>0&&a[i]==a[i-1]) continue;
            int L=i+1;
            int R=len-1;
            while (L<R){
                int sum=a[i]+a[R]+a[L];
                if (sum==0){
                    ans.add(Arrays.asList(a[i],a[R],a[R]));
                    while (L < R && a[L] == a[L+1]) L++;
                    while (L<R && a[R]==a[R--])  R--;
                    L++;
                    R--;
                }
                else if (sum<0) L++;
                else if(sum>0) R--;
            }
        }
        return ans;
    }

    //找出最接近target 的三个数之和
    public int f(int[] nums,int target){
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for (int i=0;i<nums.length;i++){
            int start=i+1;
            int end=nums.length-1;
            while (start<end){
                int sum=nums[start]+nums[end]+nums[i];
                if (Math.abs(target-sum)<Math.abs(target-ans))//取绝对值
                ans=sum;
                if (sum>target)
                    end--;
                else if (sum<target)
                    start++;
                else
                    return ans;
                }
            }
        return ans;
        }


}
