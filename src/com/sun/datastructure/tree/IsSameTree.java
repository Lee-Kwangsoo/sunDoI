package com.sun.datastructure.tree;

public class IsSameTree {
    //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    //
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public boolean test(TreeNode q,TreeNode p){
        if (q==null&&p==null){
            return true;
        }else if (q==null||p==null){
            return false;
        }else if(q.val!=p.val){
            return false;
        }else {
            return test(q.left,p.left)&&test(q.right,p.right);
        }
    }
}
