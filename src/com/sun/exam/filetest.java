package com.sun.exam;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class filetest {
    public static String FilePath="a.txt";
    public static int rows=10000*10;
    public static List<String> fileList=null;
    public static ConcurrentHashMap<String,Integer> urlMap=new ConcurrentHashMap<>();



    /**
     * 排序文件内容
     */
    public static void sortMap(){
        //频率排序
        List<Map.Entry<String,Integer>> sortList=new ArrayList<>(urlMap.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //取前100最多的频率
        for (int i=0;i<sortList.size();i++){
            if (i>100){
                break;
            }
            System.out.println("URL:"+sortList.get(i).getKey()+"----------出现的频率："+sortList.get(i).getValue());
        }
    }


    /**
     * 创建线程池，启动线程处理文件
     *
     */

    public static void ThreadFile(){
        System.out.println("多线程分析文件。。。");
        long begin=System.currentTimeMillis();
        //线程数 最好依据cpu 分配
        ExecutorService es= Executors.newCachedThreadPool();
        filetest su=new filetest();

    }
}


