package com.sakuraruo.leetcode.binarytree;

/****
 * 0226 反转二叉树 二叉树反转就是交换左右子树 可以使用前后序遍历
 */
public class ReverseBinaryTree {
    public static void reverseBinaryTree(BinaryTreeTraversal.BinaryTree root){
        if(root==null){
            return ;
        }
        BinaryTreeTraversal.BinaryTree leftNode=root.leftNode;
        BinaryTreeTraversal.BinaryTree rightNode=root.rightNode;
        BinaryTreeTraversal.BinaryTree temp=leftNode;
        root.leftNode=rightNode;
        root.rightNode=temp;
        reverseBinaryTree(root.leftNode);
        reverseBinaryTree(root.rightNode);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal.BinaryTree root = new BinaryTreeTraversal.BinaryTree(5);
        root.leftNode=new BinaryTreeTraversal.BinaryTree(4);
        root.rightNode=new BinaryTreeTraversal.BinaryTree(6);
        root.leftNode.leftNode=new BinaryTreeTraversal.BinaryTree(1);
        root.leftNode.rightNode=new BinaryTreeTraversal.BinaryTree(2);
        root.rightNode.leftNode=new BinaryTreeTraversal.BinaryTree(7);
        root.rightNode.rightNode=new BinaryTreeTraversal.BinaryTree(8);

        reverseBinaryTree(root);

    }
}
