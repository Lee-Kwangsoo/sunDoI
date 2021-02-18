package com.sun.Algorithm;
/**
 *二分查找法
 */
public class BinarySearch {
    //不使用递归
    public static int commonBinarySearch(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        int middle=0;
        if (key<arr[low]||key>arr[high]||low>high){
            return -1;
        }
        while (low<=high){
            middle=(low+high)/2;
            if (arr[middle]>key){
                high=middle-1;
            }else if(arr[middle]<key){
                low=middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }
    //递归查找法
    public static int  recursionBinarySearch(int[] arr,int key,int low,int high){
        if (key<arr[low]||key>arr[high]||low>high){
            return -1;
        }
        int middle=(low+high)/2;
        if (key<arr[middle]){
            return recursionBinarySearch(arr,key,low,middle-1);
        }else if (key>arr[middle]){
            return recursionBinarySearch(arr,key,middle+1,high);
        }else {
            return middle;
        }

    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,67,100,101};
        int key=1;
        int position=commonBinarySearch(arr,key);
        int position1=recursionBinarySearch(arr,1,0,6);
        System.out.println(position);
        System.out.println(position1);

    }
    /**
     * 找出感染疾病的人，100个人，有一人感染，用最少试剂
     */
    public static int findSick(int[] arr){
        int low=0;
        int high=arr.length-1;
        int sick=0;
        while (low<high){
            sick=(low+high)/2;
            if (f(arr,low,sick)==true){
                high=sick-1;
            }else if(f(arr,sick,high)==true){
                low=sick+1;
            }else {
                return sick;
            }
        }
        return -1;
    }

    /**
     * 试纸变色----阳性
     * @return
     */
    public static boolean f(int[] a,int start,int end){
        if(true){
            return true;
        }else {
            return false;
        }
    }
}
