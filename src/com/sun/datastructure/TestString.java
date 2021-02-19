package com.sun.datastructure;

import org.junit.Test;

public class TestString {
    /**
     * java 的基本数据类型 整型： byte  short int(32位) long 浮点型：float double char boolean
     * String类不属于java的基本数据类型
     * final 类型的，不可被继承
     * 实现serializable接口，支持序列号实现comparable接口，可以比较大小
     * 1.声明方式  String s1=“hello”；String s1=new String("hello")
     * 前者 字符串常量存储在字符串常量池，共享  后者在堆空间new结构，再 char[] 对应的常量池中创建数据hello
     *
     */
    public static void main(String[] args) {
        String s1="hello";
        String s2="hello";
        String s3=new String("hello");
        String s4=new String("  he  ll  o   ");
        System.out.println(s1==s2);
        System.out.println(s3==s2);
        System.out.println(s3==s4);

//        常用方法
        /**
         * int length(); 返回长度
         *
         */
        System.out.println(s1.length());
//        char charAt(int index)
        System.out.println(s1.charAt(0));
//        判断字符串是否为空
        System.out.println(s1.isEmpty());
//        String toLowerCase()：使用默认语言环境，将 String 中的所字符转换为小写
//        String toUpperCase()：使用默认语言环境，将 String 中的所字符转换为大写
//        String trim()：返回字符串的副本，忽略前导空白和尾部空白
        System.out.println(s4.trim());
        System.out.println(s4);
//        boolean equals(Object obj)：比较字符串的内容是否相同
//        boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        System.out.println(s1.equals(s3));
//        int compareTo(String anotherString)：比较两个字符串的大小
//        String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
//        String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
//
//        boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
//        boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
//        boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
//
//        boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
//        int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
//        int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
//        int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
//        int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
    }

    /**
     * String与其他类型之间的相互转换
     */
    @Test
    public void test(){
        //String --》》char[]
        String abc="abc123";
        char[] charArray=abc.toCharArray();
        for (int i=0;i<abc.length();i++){
            System.out.print(charArray[i]);
        }
        char[] arr=new char[]{'h','e','l','l','o'};
        String str2=new String(arr);
        System.out.println(str2);
    }
    @Test
    public void test2(){
        //Stirng-->>StringBuffer,StringBuilder:调用StringBuffer、StringBuilder构造器
        //StringBuffer、StringBuilder-->>String 1.调用String构造器2.StringBuffer\StringBuilder的toString()


    }

}
