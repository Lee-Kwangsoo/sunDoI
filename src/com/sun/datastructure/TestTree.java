package com.sun.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class TestTree {

    static class TreeNode<T>{
        /**
         * 普通树节点
         */
        T value;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;
        TreeNode(T value){
            this.value=value;
        }
        TreeNode(){

        }

        //增加左子节点
        public void  addLeft(T value){
            TreeNode<T> leftChild=new TreeNode<T>(value);
            this.leftChild=leftChild;
        }


        public void addRight(T value){
            TreeNode<T> rightChild=new TreeNode<T>(value);
            this.rightChild=rightChild;
        }
        public boolean equals(Object obj){
            if (!(obj instanceof TreeNode)) {
                return false;
            }
            return this.value.equals(((TreeNode<?>)obj).value);
        }
        public int hasCode(){
            return this.value.hashCode();
        }
        public String toString(){
            return this.value==null?"null":this.value.toString();
        }

        /**
         * 树的基本操作
         */

        public  static  <T> int getTreeNum(TreeNode<T> root){
            /**
             * 创建树中节点的个数
             */
            if (root==null){
                return 0;
            }
            return getTreeNum(root.leftChild)+getTreeNum(root.rightChild)+1;
        }


        public static <T> int getTreeDepth(TreeNode<T> root){
            if (root==null){
                return 0;
            }
            int leftDepth=getTreeDepth(root.leftChild)+1;
            int rightDepth=getTreeDepth(root.rightChild)+1;
            return Math.max(leftDepth,rightDepth);
        }
        //访问树节点
        private  static <T> void visitNode(TreeNode<T> node){
            System.out.println(node.value+"\t");
        }

        //<T> 表示不是返回值，是指入参中有泛型
        //前序遍历：根左右
        public static <T> void preOrderTravel(TreeNode<T> root){
            if(root==null){
                return;
            }
            visitNode(root);
            preOrderTravel(root.leftChild);
            preOrderTravel(root.rightChild);
        }

        //中序遍历
        public static <T> void  midOrderTravel(TreeNode<T> root){
            if (root==null){
                return;
            }
            midOrderTravel(root.leftChild);
            visitNode(root);
            midOrderTravel(root.rightChild);
        }
        //后序遍历
        public static <T> void backOrderTravel(TreeNode<T> root) {
            if (root == null) {
                return;
            }
            backOrderTravel(root.leftChild);
            backOrderTravel(root.rightChild);
            visitNode(root);

        }
        //分层遍历
        public static <T> void levelTravel(TreeNode<T> root){
            Queue<TreeNode<T>> q=new LinkedList<TreeNode<T> >();
            q.offer(root);
            while (!q.isEmpty()){
                TreeNode<T> temp=q.poll();
                visitNode(temp);
                if (temp.leftChild!=null){
                    q.offer(temp.leftChild);
                }
                if (temp.rightChild!=null){
                    q.offer(temp.rightChild);
                }
            }
        }










    }

}
