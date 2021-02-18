package com.sun.datastructure.array;

import java.util.Arrays;

public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    public static String f(String[] str1){
        if (str1.length==0||str1==null){
            return "";
        }
        String target=str1[1];
        for (int i=0;i<str1.length;i++){
            //数组内逐个字符串进行遍历
            int j=0;//设置临时指针标记游标的长度
            for(;j<str1[i].length()&&j<target.length();j++){
                if (str1[i].charAt(j)!=target.charAt(j))
                break;
            }
            target=str1[0].substring(0,j);
            if (target.equals("")){
                return "";
            }

        }
        return target;
    }

    public static void main(String[] args) {
       String[] strs=new String[]{"ssis","ss","ssun","sssi"};
       System.out.println(f(strs));
    }
}
