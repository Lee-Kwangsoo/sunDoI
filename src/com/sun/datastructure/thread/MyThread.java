package com.sun.datastructure.thread;

public class MyThread {
    public static void main(String[] args) {
        Thread1 mt=new Thread1();
        Thread t=new Thread(mt,"线程");
        t.start();
        for (int i=0;i<50;i++){
            if (i>10){
                try {
                    t.join();//线程强制运行，运行期间其他线程无法运行
                }catch (InterruptedException e){

                }

            }

            System.out.println("Main 线程运行--》》" + i);
        }

    }

}
class  Thread1 implements Runnable{
    public void run(){
        for (int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"运行，i="+i);
        }
    }
}
