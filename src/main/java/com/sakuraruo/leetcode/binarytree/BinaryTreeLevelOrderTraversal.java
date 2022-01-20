package com.sakuraruo.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 102 二叉树的层序遍历
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<int[]> levelOrderTraversal(BinaryTreeTraversal.BinaryTree root){
        Queue<BinaryTreeTraversal.BinaryTree> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<int[]>();
        BinaryTreeTraversal.BinaryTree node=root;
        queue.add(node);
        while(!queue.isEmpty()){
            int size= queue.size();
            int[] ints = new int[size];
            for(int i=0;i<size;i++){
                BinaryTreeTraversal.BinaryTree front = queue.remove();
                ints[i]=front.value;
                if(null!=front.leftNode){
                    queue.add(front.leftNode);
                }
                if(null!=front.rightNode){
                    queue.add(front.rightNode);
                }
            }
            list.add(ints);
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal.BinaryTree tree = new BinaryTreeTraversal.BinaryTree(6);
        tree.leftNode = new BinaryTreeTraversal.BinaryTree(4);
        tree.rightNode = new BinaryTreeTraversal.BinaryTree(7);
        tree.leftNode.leftNode=new BinaryTreeTraversal.BinaryTree(1);
        tree.leftNode.rightNode=new BinaryTreeTraversal.BinaryTree(3);
        tree.rightNode.leftNode = new BinaryTreeTraversal.BinaryTree(5);
        tree.rightNode.rightNode = new BinaryTreeTraversal.BinaryTree(8);

        levelOrderTraversal(tree);
    }
}
