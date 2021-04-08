package com.sun.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class sun {
    public int f1(int [] source,int target){
        int start=0;
        int end=source.length-1;
        int middle=(end-start)/2;
        if (target<source[start]||target>source[end]||start>end){
            return -1;
        }
        while (start<end){
            middle=(start+end)/2;
            if (target>source[middle]){
                start=middle+1;
            }else if(target<=source[middle]){
                end=middle;
            }else {
                return middle;
            }
        }
        return -1;

    }

    public int f2(int[] a){
        int s=0;
        //返回数组中第一个不重复的数字
        Map<Integer,Integer> map=new  LinkedHashMap <>();
        for (int i=0;i<a.length;i++){
            if (map.containsKey(a[i])){
                int value=map.get(a[i]);
                map.put(a[i],value+1);
            }else {
                map.put(a[i],0);
            }
        }
        for (int i=0;i<a.length;i++){
            int value=map.get(a[i]);
            if (value==0){
                s=a[i];
                break;
            }
        }
    return s;
    }

    public String f3(String a){
        //最长回文子串 暴力解题法http://www.cxyxiaowu.com/2869.html
        int maxlen=1;
        int len=a.length();
        String res=a.substring(0,1);
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                if ((j-i+1)>maxlen&&yes(a,i,j)){
                    maxlen=j-i+1;
                    res=a.substring(i,j+1);
                }
            }
        }
        return res;
    }
    private boolean yes(String s,int i,int j){
        while (j>i){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String f4(String s){
        //反转字符串
        String target="";
        for (int i=s.length()-1;i>=0;i--){
            target=target+s.charAt(i);
        }
        return target;
    }





    public static void main(String[] args) {
        String a="sun123uuu";
        //
//        System.out.println(f4(a));
        sun su=new sun();
        System.out.println(su.f3(a));
    }

}
