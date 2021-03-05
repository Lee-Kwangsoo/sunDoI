package com.sun.datastructure.string;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int f(String s){
        //滑动窗口
        if (s==null){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        int max=0;
        int left=0;
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s= "abcabcbb";
        System.out.println(f(s));
    }
}
