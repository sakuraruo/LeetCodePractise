package com.sakuraruo.leetcode.binarytree;

/****
 * 101 对称二叉树
 */
public class SymMetricTree {
    public static boolean isSymMetric(BinaryTreeTraversal.BinaryTree leftNode,BinaryTreeTraversal.BinaryTree rightNode){
        return postTraversalTwoTree(leftNode,rightNode);
    }

    public static boolean postTraversalTwoTree(BinaryTreeTraversal.BinaryTree leftNode,BinaryTreeTraversal.BinaryTree rightNode){
        if(leftNode==null&&rightNode==null){
            return true;
        }else if(leftNode==null||rightNode==null){
            return false;
        }
        if(!(Integer.valueOf(leftNode.value).equals(Integer.valueOf(rightNode.value)))){
            return false;
        }
        boolean leftFlag=postTraversalTwoTree(leftNode.leftNode, rightNode.rightNode);
        boolean rightFlag=postTraversalTwoTree(leftNode.rightNode, rightNode.leftNode);
        return leftFlag&&rightFlag;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal.BinaryTree root = new BinaryTreeTraversal.BinaryTree(2);
        root.leftNode = new BinaryTreeTraversal.BinaryTree(3);
        root.rightNode = new BinaryTreeTraversal.BinaryTree(3);
        root.leftNode.leftNode=new BinaryTreeTraversal.BinaryTree(4);
        root.rightNode.rightNode = new BinaryTreeTraversal.BinaryTree(4);

        System.out.println(isSymMetric(root.leftNode,root.rightNode));
    }
}
