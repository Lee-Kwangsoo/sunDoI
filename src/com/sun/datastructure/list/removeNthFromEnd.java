package com.sun.datastructure.list;

public class removeNthFromEnd {

    //删除倒数第n个结点
    public MyList.Node f(MyList.Node node,int n){
        MyList.Node dummy=new MyList.Node(0,node);
        int length=getLength(node);
        MyList.Node cur=dummy;
        for (int i=1;i<length-n-1;++i){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        MyList.Node ans=dummy.next;
        return ans;

    }


    public int getLength(MyList.Node head){
        int length=0;
        while (head !=null){
            ++length;
            head=head.next;
        }
        return length;
    }
}
