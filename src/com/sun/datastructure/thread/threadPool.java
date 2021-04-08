package com.sun.datastructure.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadPool {
    public static void main(String[] args) {
        //创建服务，创建线程池
        //newFixedThreadPool  参数为：线程池的大小
        ExecutorService service= Executors.newFixedThreadPool(100);
        service.execute(new SunThread());
        service.execute(new SunThread());
        service.execute(new SunThread());
        service.execute(new SunThread());
        service.execute(new SunThread());
        service.shutdown();
    }


}
class SunThread implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
