package com.sun.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class MidTravel {
    List<Integer> list=new ArrayList<>() ;
    public List<Integer> test(TreeNode root){
        if (root!=null){
            helper(root);
        }
        return list;

    }
    public void helper(TreeNode root){
        if (root.left!=null){
            helper(root.left);
        }
        list.add(root.val);
        if (root.right!=null){
            helper(root.right);
        }
    }

    public static void main(String[] args) {

        TreeNode node1=new TreeNode(2,null,null);
        TreeNode node2=new TreeNode(9,null,null);
        TreeNode root=new TreeNode(1,node1,node2);
        MidTravel midTravel=new MidTravel();
        System.out.println(midTravel.test(root));
    }
}
