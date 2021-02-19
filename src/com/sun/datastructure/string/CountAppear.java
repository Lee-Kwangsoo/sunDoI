package com.sun.datastructure.string;

public class CountAppear {
//    获取一个字符串在另一个字符串中出现的次数。
    public static int f(String source,String target){
        if (target.length()>source.length()||source.length()==0||target.length()==0){
            return -1;
        }
        int sbegin=0;
        int tbegin=0;
        int count=0;
        while (sbegin<source.length()&&tbegin<=target.length()){
            if (target.charAt(tbegin)==source.charAt(sbegin)){
                sbegin++;
                tbegin++;
            }else {
                sbegin++;
            }
            if (tbegin==target.length()){
                count++;
                tbegin=0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1="abkkcadkabkebfkabkskab";
        String s2="ab";
        System.out.println(f(s1,s2));
    }

}
