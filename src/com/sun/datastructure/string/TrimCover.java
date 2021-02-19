package com.sun.datastructure.string;

public class TrimCover {
//    1）模拟一个trim方法，去除字符串两端的空格。
    public static String f(String s){
        String target;
        if (s.length()==0||s==null){
            return "";
        }
       int start=0;int end=s.length()-1;
       while (start<end&&s.charAt(start)==' '){
           start++;
       }
       while (start<end&&s.charAt(end)==' '){
           end--;
       }
       target=s.substring(start,end);
       return target;
    }

    public static void main(String[] args) {
        String s1="";
       System.out.println(f(s1).length());
    }
}
