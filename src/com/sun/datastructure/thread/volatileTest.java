package com.sun.datastructure.thread;

public class volatileTest extends Thread {
    //volatile 关键字作用：使变量在多个线程间可见
    private volatile  boolean isRunning=true;
    private void setRunning(boolean isRunning){
        this.isRunning=isRunning;
    }
    public void  run(){
        System.out.println("进入run方法。。。。");
        int i=0;
        while (isRunning==true){
            //....
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        volatileTest rt=new volatileTest();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning 的值已经被设置了false");
    }

}
