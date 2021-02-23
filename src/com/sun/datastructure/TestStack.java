package com.sun.datastructure;

public class TestStack {
    /**
     * 顺序栈和链栈
     */
    class sqStack<T>{
        private T data[];//用数组表示栈元素
        private  int maxSize;//栈空间大小（常量）
        private int top;//栈顶指针（指向栈顶元素）
        @SuppressWarnings("unchecked")
        public  sqStack(int maxSize){
            this.maxSize=maxSize;
            this.data=(T[])new Object[maxSize];
            this.top=-1;
        }
        //判断栈是否为空
        public  boolean isNull(){
            boolean flag=this.top<=-1?true:false;
            return flag;
        }
        //判断是否栈满
        public boolean isFull(){
            boolean flag=this.top==this.maxSize-1?true:false;
            return flag;
        }
        //压栈
        public  boolean push(T value){
            if (isFull()){
                return false;
            }else {
                data[++top]=value;
                return true;
            }
        }

        //弹栈
        public T pop(){
            if(isNull()){
                return null;
            }else {
                T value=data[top];
                --top;
                return value;
            }
        }
    }

    class LinkStack<T>{
        /** 这个形式下的栈就可以不用声明大小啦
         * 链栈：用链表实现 主要有四个元素：2状态 2操作
         * 2状态：栈空 栈满（逻辑上永远不会栈满，除非电脑没有内存）
         * 2操作：压栈push 出栈pop
         */


    }

}
