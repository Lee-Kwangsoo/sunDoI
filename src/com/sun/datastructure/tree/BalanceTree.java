package com.sun.datastructure.tree;

public class BalanceTree {
    public boolean test(TreeNode node){
        if (node==null){
            return true;
        }else {
            return Math.abs(height(node.left)-height(node.right))<=1&&test(node.left)&&test(node.right);
        }

    }
    public int height(TreeNode root){//计算节点高度
        if (root==null){
            return 0;
        }else {
            return Math.max(height(root.right),height(root.left))+1;
        }

    }
}
