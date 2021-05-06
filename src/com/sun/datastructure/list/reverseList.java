package com.sun.datastructure.list;

public class reverseList {
    /**
     * 链表反转，给出一个链表和一个数k
     * 1-2-3-4-5-9 k=2
     * 反转后  2-1-3-4-5-9
     *
     */

    private  static Node reverse2(Node on,int offset){
        if (on==null){
            return null;
        }
        Node pre=null;//部分反转的链表
        Node newN=null;//新的链表
        Node tail=null;//记录下一部分的真实引用
        for (int j=0;j<3;j++){
            Node tmp=on;
            for (int i=0;i<offset;i++){
                Node next=on.getNextNode();
                on.setNextNode(pre);
                pre=on;
                on=next;
            }
            if (j==0){
                newN=pre;

            }
            tmp.setNextNode(on);
            if (tail!=null){
                tail.setNextNode(pre);
            }
            tail=tmp;
            }
        return newN;


    }

    /**
     * 单链表反转
     * @param on
     * @return
     */
    private static Node reverse1(Node on){
        if (on==null){
            return null;
        }
        Node pre=on;
        Node cur=on.getNextNode();
        Node next=null;
        while (cur!=null){
            next=cur.getNextNode();
            cur.setNextNode(pre);
            pre=cur;
            cur=next;
        }
        on.setNextNode(null);
        return pre;
    }
    private static void printLink(Node node){
        Node on=node;
        while (on!=null){
            System.out.println(on.getCount()+"\t");
            on=on.getNextNode();
        }
        System.out.println("\n");
    }
    private static Node createLink(){
        Node on=new Node(0);
        Node next;
        Node cur=null;
        for (int i=1;i<6;i++){
            next=new Node(i);
            if (i==1){
                on.setNextNode(next);
            }else {
                cur.setNextNode(next);
            }
            cur=next;
        }
        return on;
    }

}
//定义node节点
class Node{
    private int count;
    private Node nextNode;
    public Node(int count){
        this.count=count;
    }
    public int getCount(){
        return count;
    }
    public void setCount(){
        this.count=count;
    }

    public Node getNextNode(){
        return nextNode;
    }
    public void setNextNode(Node nextNode){
        this.nextNode=nextNode;
    }
}
