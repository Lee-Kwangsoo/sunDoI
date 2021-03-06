package com.sun.datastructure.list;

import java.util.HashSet;
import java.util.Set;

public class MyList {
    static class Node{
        Node next=null;//节点的引用，指向下一个节点
        int data;//节点对象
         Node(int data){
            this.data=data;
        }
         Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    //声明头节点
    Node head=null;
    /**
     * 链表的基本操作
     */
    public void  addNode(int d){
        //实例化一个节点
        Node newNode=new Node(d);
        if (head==null){
            head=newNode;
            return;
        }
        Node tmp=head;
        while (tmp.next!=null){//while 循环找到最后一个节点进行插入数据
            tmp=tmp.next;
        }
        tmp.next=newNode;
    }
    /**
     * 返回链表长度
     */
    public int length(){
        Node tmp=head;
        int length=0;
        while (tmp.next!=null){
            length++;
            tmp=tmp.next;
        }
        return length;
    }
    /**
     * 删除第index个节点 返回是否删除成功
     */
    public boolean deleteNode(int index){
        //入参判断
        if (index<1||index>length()){
            return false;
        }
        //分为是头节点和非头节点
        if(index==1){
            head=head.next;
            return true;
        }
        //不是头节点，需要遍历链表，找到对应的节点pre.next=cur.next
        int i=0;
        Node pre=head;
        Node cur= head.next;
        while (cur!=null){
            if (i==index) {
                pre.next = cur.next;
                return true;
            }
            pre=cur;
            cur=cur.next;
            i++;
        }
        return false;
    }
    /**
     * 给定Node删除节点
     */
    public boolean deleteNode1(Node n){
        if (n==null||n.next==null){
            return false;
        }
        int tmp=n.data;
        n.data=n.next.data;
        n.next.data=tmp;
        n.next=n.next.next;
        System.out.println("success！！！");
        return true;

    }
    /**
     * 打印
     */
    public void printList(){
        Node tmp=head;
        while (tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }
    }


    /**
     * 链表相关的常用操作实现方法
     *
     */

    //链表反转
    public Node ReverseInteratively(Node head){
        Node pReversedHead=head;
        Node pNode=head;
        Node pPre=null;
        while (pNode!=null){
            Node pNext=pNode.next;
            if (pNext==null){
                pReversedHead=pNode;
            }
            pNode.next=pPre;
            pPre=pNode;
            pNode=pNext;
        }
        this.head=pReversedHead;
        return this.head;

    }

    /**
     * 查找链表的中间节点
     */
    public Node SearchMid(Node head){
        Node p=this.head,q=this.head;
        while (p!=null&&p.next!=null&&p.next.next!=null){
            //快指针走两步 慢指针走一步，快指针到终点时慢指针走到终点
            p=p.next.next;
            q=q.next;
        }
        System.out.println("mid:"+q.data);
        return q;
    }
    /**
     * 查找倒数第k个元素  我的思路是用链表长度求出来index 然后遍历去查找
     * 给出来的思路是，让其中一个指针先走k步，然后第一个指针到尾，第二个指针就是节点就是倒数第k个元素
     */
    public Node findElem(Node head,int k){
        if (k<1||k>this.length()){
            return null;
        }
        Node p1=head;
        Node p2=head;
        for (int i=0;i<k;i++){
            p1=p1.next;
        }
        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
    /**
     * 对链表进行排序(快速排序和归并排序)
     *
     */
    public Node orderList(Node head){
//        我们只需要两个指针p1和p2，这两个指针均往next方向移动，
//        移动的过程中保持p1之前的key都小于选定的key，p1和p2之间的key都大于选定的key，
//        那么当p2走到末尾时交换p1与key值便完成了一次切分。
        //归并排序1.将待排序数组一分为二 2.递归对左半部分归并排序 3.递归对右半部分归并排序 4.将两个部分merge得到结果
        quickSort(head,null);
        return head;
    }
    public static void quickSort(Node head,Node end){
        if (head!=end){
            Node node=partion(head,end);
            quickSort(head,node);
            quickSort(node.next,end);
        }
    }
    public static Node partion(Node head,Node end){
        Node p1=head;
        Node p2=head.next;
        while (p2!=end){
            if (p2.data<head.data){
                p1=p1.next;

                int temp=p1.data;
                p1.data=p2.data;
                p2.data=temp;

            }
            p2=p2.next;
        }
        if (p1!=head){
            int temp=p1.data;
            p1.data=head.data;
            head.data=temp;
        }
        return p1;
    }
    public Node sortList(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node mid=getMid(head);
        Node right=mid.next;
        mid.next=null;
        return mergeSort(sortList(head),sortList(right));
    }
    /**
     * 获取链表的中间节点，偶数时取中间第一个
     *
     */
    private Node getMid(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //归并排序两个有序链表
    private Node mergeSort(Node head1,Node head2){
        Node p1=head1;
        Node p2=head2;
        Node head;
        //得到头节点指向
        if (head1.data<head2.data){
            head=head1;
            p1=p1.next;
        }else {
            head=head2;
            p2=p2.next;
        }
        Node p=head;
        //比较链表中的值
        while(p1!=null&&p2!=null) {
            if (p1.data < p2.data) {
                p1.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
            //第二条链表空了
            if (p1!=null){
                p1.next=p1;
            }
            if (p2!=null){
                p2.next=p2;
            }
            return head;
    }

    /**
     * 删除重复节点  排序链表中的重复节点
     */
    public  void deleteDuplecate(Node head){
        Node p=head;
        while (p.next!=null){
            Node  q=p;
            while (q.next!=null){
                if (p.data==q.next.data){
                    q.next=q.next.next;
                }else
                    q=q.next;
            }
        }
    }
    /**
     * 递归方式输出单链表
     */
    public void  printListReversely(Node head){
        if (head!=null){
            printListReversely(head.next);
            System.out.println(head.data);
        }
    }
    /**
     * 判断链表是否有环，单向链表有环时，尾节点相同
     */
    //循环遍历节点，遍历一个标记一个，遍历过程判断是否被标记，
    public boolean hasCycle(Node head){
        Set<Node> set=new HashSet<Node>();
        while (head!=null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
                head=head.next;
            }
        }
        return false;
    }

    /**
     * 方法二：声明两个指针，一个指针走一次经过两个节点，另一个经过一个节点
     * 若无环--》慢指针肯定追不上快指针  有环--》肯定能追上快指针
     */
    public boolean hasCycle1(Node head){
        //声明两个节点从头开始遍历节点
        Node quick=head;
        Node slow=head;
        while (quick!=null||quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
            if (quick==slow){
                return true;
            }
        }
        return false;
    }







}
