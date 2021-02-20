package com.sun.datastructure;

public class TestList {
    //创建节点类
    class Node<E>{
        // <E>中的E表示类型形参，可以接收具体的类型实参，并且此接口定义中，凡是出现E的地方均表示相同的接受自外部的类型实参。
        Node<E> next;
        E element;
        public Node(Node next,E element){
            this.next=next;
            this.element=element;
        }
    }
    //创建单向链表
    class SingeLinkedList{
        private int size;
        private Node head;
        public SingeLinkedList(){
            size=0;
            head=null;
        }

        /**
         * 链表操作
         */
        //链表头添加元素
        public Object addhead(Object obj){

        }
    }

}
