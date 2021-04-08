package com.sun.datastructure.thread;

public class threadlocalTest {
    static ThreadLocal<String> localVar=new ThreadLocal<>();
    static void print(String var){
        //打印当前线程中本地内存中本地变量的值
        System.out.println(var+":  "+localVar.get());
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                print("thread1");
                System.out.println("after remove: "+localVar.get());
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar2");
                print("thread2");
                System.out.println("after remove: "+ localVar.get());
            }
        });
        t1.start();
        t2.start();
    }
}
