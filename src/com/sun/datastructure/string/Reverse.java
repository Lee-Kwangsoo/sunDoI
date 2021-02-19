package com.sun.datastructure.string;

public class Reverse {
    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
     */

    public static String f(String s,int start,int end){
        if (s.length()==0||s==null){
            return "";
        }
        if (end<=start){
            return s;
        }
        String tmp=s.substring(start,end);
        StringBuffer taget=new StringBuffer();
        taget.append(s.substring(0,start));
        for (int i=tmp.length();i>=0;i--){
            taget.append(s.charAt(i));
        }
        if (end!=s.length())
            taget.append(s.substring(end+1,s.length()));


        return taget.toString();
    }

    public static void main(String[] args) {
        String s1="823s4s1";
        System.out.println(f(s1,0,5));
        System.out.println(reverse(s1,0,5));
    }

    //百度的方法，使用数组
    public static String reverse(String str,int start,int end){
        if (str !=null){
            char[] chars=str.toCharArray();
            for (int i=start,j=end;i<j;i++,j--){
                char tmp=chars[i];
                chars[i]=chars[j];
                chars[j]=tmp;
            }
            return new String(chars);
        }
        return null;
    }



}
