package com.sun.datastructure.thread;

public class BaseUse implements Runnable {
    private String name;
    public BaseUse(String name){
        this.name=name;
    }
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(name+"运行，i="+i);
        }
    }
    static class MyThread extends Thread{
        private String name;
        public MyThread(String name){
            this.name=name;
        }
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(name+"运行，i= "+i);
            }
        }
    }

    public static void main(String[] args) {
//        BaseUse base1=new BaseUse("线程一");
//        BaseUse base2=new BaseUse("线程二");
//        Thread t1=new Thread(base1);
//        Thread t2=new Thread(base2);
//        t1.start();
//        t2.start();

//        测试二
        MyThread myThread1=new MyThread("线程A");
        MyThread myThread2=new MyThread("线程B");
        myThread1.start();
        myThread2.start();
    }

}
