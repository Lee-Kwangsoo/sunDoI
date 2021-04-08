package com.sun.datastructure.thread;

public class synchronizedTest {
    //修饰代码块、方法、静态方法、类



    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        SyncThread syncThread=new SyncThread();
        Thread thread1=new Thread(syncThread,"SynThread1");
        Thread thread2=new Thread(syncThread,"SynThread2");
        thread1.start();
        thread2.start();

    }

}
class SyncThread implements  Runnable{
    private static int count;
    public SyncThread(){
        count=0;
    }
    public void run(){
        //当有两个线程同时访问一个对象中的synchronized 代码块时，在同一时刻智能有一个线程得到执行，另一个
        //线程受阻塞，必须等待当前线程执行完以后才能执行该代码块
        synchronized (this){
            for (int i=0;i<5;i++){
                try {
                    System.out.println("线程数"+Thread.currentThread().getName()+":"+(count++));
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public int getCount(){
        return count;
    }

}
