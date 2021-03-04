package com.sun.datastructure.tree;

import com.sun.source.tree.Tree;

public class IsSymmetric {
    //给定一个二叉树，检查它是否是镜像对称的。
    //https://leetcode-cn.com/problems/symmetric-tree/
    public boolean test(TreeNode root){
        return test1(root,root);
    }
    public boolean test1(TreeNode q,TreeNode p){
        if (q==null&&p==null){
            return true;
        }
        if (q==null||p==null){
            return  false;
        }else
            return q.val==p.val&& test1(q.left,p.right)&&test1(q.right,p.left);
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(2,null,null);
        TreeNode node2=new TreeNode(2,null,null);
        TreeNode root=new TreeNode(1,node1,node2);
        IsSymmetric l=new IsSymmetric();
        System.out.println(l.test(root));
    }

}
