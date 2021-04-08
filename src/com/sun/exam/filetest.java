package com.sun.exam;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class filetest {

    //https://bbs.csdn.net/topics/392367566?list=39254983
    public static String FilePath="a.txt";
    public static int rows=10000*10;
    public static List<String> fileList=null;
    public static ConcurrentHashMap<String,Integer> urlMap=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //拆分文件
        cutFile(FilePath,rows);
        //多线程处理文件，排序文件内容
        threadFile();
    }

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

    public static void threadFile(){
        System.out.println("多线程分析文件。。。");
        long begin=System.currentTimeMillis();
        //线程数 最好依据cpu 分配
        ExecutorService es= Executors.newCachedThreadPool();
        filetest su=new filetest();
        for (int i=0;i<fileList.size();i++){
            File file=new File(fileList.get(i));
            if (file.isFile()){
                es.execute(su.new readFile(file));
            }else {
                System.out.println("未找到文件");
            }

        }
        es.shutdown();
        while (true){
            if (es.isTerminated()){
                long end=System.currentTimeMillis();
                System.out.println("解析"+fileList.size()+"个文件 耗时"+(end-begin)+"毫秒");
                sortMap();
                break;
            }
        }
    }


    /**
     * 线程解析文件汇总url
     *
     */

    private class readFile implements Runnable{
        File tFile=null;
        public readFile(File f){
            this.tFile=f;
        }

        public void  run(){
            resolverFile();
        }
        /**
         * 解析文件
         */
        private void resolverFile(){
            FileInputStream fis=null;
            Scanner sc=null;
            Map<String,Integer> map=new HashMap<>();
            try{
                fis=new FileInputStream(tFile);
                sc=new Scanner(fis);
                while (sc.hasNextLine()){
                    String len=sc.nextLine().trim();
                    if (map.containsKey(len)){
                        int mValue=map.get(len);
                        map.put(len,mValue+1);
                    }else {
                        map.put(len,1);
                    }
                }
                sc.close();
                //合并总得urlMap ConcurrentHashMap 线程安全
                if (urlMap.size()==0){
                    urlMap.putAll(map);
                }else {
                    for (String key:map.keySet()){
                        if (urlMap.containsKey(key)){
                            int mValue=urlMap.get(key)+map.get(key);
                            urlMap.put(key,mValue);
                        }else {
                            urlMap.put(key,1);
                        }
                    }
                }
                //清空临时map内存
                //map.clear()
                System.out.println(tFile.getName()+"  mapsize:"+map.size()+"  urlmapSize: "+urlMap.size());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 大文件切割
     */
    public static void cutFile(String sourceFile,int curRows){
        System.out.println("开始拆 每 "+curRows +"行，拆分文件 ");
        FileInputStream inputStream=null;
        Scanner sc=null;
        StringBuilder sbu=null;
        BufferedWriter bw=null;
        try{
            inputStream=new FileInputStream(sourceFile);
            sbu=new StringBuilder();
            fileList=new ArrayList<>();
            long   begin=System.currentTimeMillis();
            //Scanner 方法消耗内存低
            sc=new Scanner(inputStream);
            int i=0;
            while (sc.hasNextLine()){
                sbu.append(sc.next()).append("\r\n");
                if (i%curRows==0){
                    bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(sourceFile+i+".txt")),"UTF-8"));
                    bw.write(sbu.toString());
                    fileList.add(sourceFile+i+".txt");
                    bw.close();
                    sbu.setLength(0);
                }
                i++;
            }
            //余下行数生成文件
            if (((i-1)%curRows)!=0){
                bw=new BufferedWriter(new OutputStreamWriter((new FileOutputStream(new File(sourceFile+i+".txt"))),"UTF-8"));
                fileList.add(sourceFile+i+".txt");
                bw.close();
                sbu.setLength(0);
            }
            long end=System.currentTimeMillis();
            System.out.println("切割文件消耗： "+(end-begin)+"毫秒");
            inputStream.close();
            sc.close();

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}


