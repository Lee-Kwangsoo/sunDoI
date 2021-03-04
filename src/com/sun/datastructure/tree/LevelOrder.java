package com.sun.datastructure.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class LevelOrder {
    /**
     * DFS BFS 深度优先和广度优先 算法
     * 层级遍历二叉树
     * 最短路径问题
     */
    //深度优先
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
    public void bfs(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();//poll：将首个元素从队列中弹出，如果队列是空的，就返回null
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }

        }

    }

    public List<Integer> bft(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> list=new LinkedList<Integer>();
        if (node==null){
            return list;
        }
        queue.add(node);
        while (queue.isEmpty()){
            TreeNode t=queue.remove();
            if (t.left!=null){
                queue.add(t.left);
            }
            if (t.right!=null){
                queue.add(t.right);
            }
            list.add(t.val);
        }
        return list;

    }

    public List<List<Integer>> bft2(TreeNode root){
        //List<List<Integer>>
        //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
        //返回层数 二维数组

        //想不通的时候可以试着按照程序运行 的步骤捋一捋
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if (root==null){
            return ret;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level=new ArrayList<Integer>();
            int currentLevelSize=queue.size();
            for (int i=1;i<=currentLevelSize;++i){
                TreeNode node=queue.remove();
                level.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null)
                    queue.add(node.right);

            }
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        for(int i=1;i<2;++i){
            System.out.println(i);
        }
    }
}
