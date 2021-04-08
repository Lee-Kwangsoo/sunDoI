package com.sun.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ioTest {
    /**
     * 按行读取，然后读取一行显示此行，统计此行有多少字节
     */
    public static void main(String[] args) {
        try{
            BufferedReader in=new BufferedReader(new FileReader("C:\\Users\\sunxueping-jk\\sunDoI\\src\\com\\sun\\io\\a.txt"));
            String str=null;//定义一个字符串类型变量 str
            int i=0;
            while ((str=in.readLine())!=null){
                i++;
                byte[] bytes=str.getBytes();//获得字节数
                //输出每一行的字符和字节的个数
                System.out.println("第"+i+"行"+bytes.length+"个字节"+str.length());

            }
            System.out.println("该文本共有 "+i+"行");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
