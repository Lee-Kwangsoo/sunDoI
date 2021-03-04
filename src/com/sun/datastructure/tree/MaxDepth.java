package com.sun.datastructure.tree;

public class MaxDepth {

    public int f(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=f(root.left);
        int right=f(root.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {

        TreeNode node1=new TreeNode(2,null,null);
        TreeNode node2=new TreeNode(9,null,null);
        TreeNode root=new TreeNode(1,node1,node2);
        MaxDepth maxDepth=new MaxDepth();
        System.out.println(maxDepth.f(root));
    }
}
