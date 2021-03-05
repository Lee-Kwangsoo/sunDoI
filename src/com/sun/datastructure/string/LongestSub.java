package com.sun.datastructure.string;

public class LongestSub {
//    获取两个字符串中最大相同子串
//    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
//    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    public static String f(String str1,String str2){
       if (str1!=null&&str2!=null){
           String maxStr=(str1.length()>=str2.length()?str1:str2);
           String minStr=(str1.length()<str2.length()?str1:str2);
           int length=minStr.length();
           for (int i=0;i<length;i++){
               for (int x=0,y=length-i;y<length;x++,y++){
                   if (maxStr.contains(minStr.substring(x,y))){
                       return minStr.substring(x,y);
                   }
               }
           }
       }
    return null;

    }

    public static void main(String[] args) {
        String str1="abcwerthelloyuiodef";
        String str2="cvhellobnm";
        System.out.println(f(str1,str2));

        for (int i=0,j=0;i<3;i++,j++){
            System.out.println(i);
            System.out.println(j);
        }

    }



}
