package com.sakuraruo.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/****
 * 144 二叉树遍历
 */
public class BinaryTreeTraversal {
    static class BinaryTree{
        BinaryTree leftNode;
        BinaryTree rightNode;
        int value;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    //递归写法
    public static void preTraversal(BinaryTree root, List<Integer> result){
        if(root==null){
            return ;
        }
        result.add(root.value);
        preTraversal(root.leftNode,result);
        preTraversal(root.rightNode,result);
    }

    //迭代写法
    public static void preTraversal1(BinaryTree root, List<Integer> result){
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node=root;
        stack.push(node);
        while(null!=node&&!stack.isEmpty()){
            BinaryTree tree = stack.pop();
            result.add(tree.value);
            if(null!=tree.rightNode){
                stack.push(tree.rightNode);
            }
            if(null!=tree.leftNode){
                stack.push(tree.leftNode);
            }
        }
    }

    //递归写法
    public static void inTraversal(BinaryTree root,List<Integer> result){
        if(root==null){
            return ;
        }
        inTraversal(root.leftNode,result);
        result.add(root.value);
        inTraversal(root.rightNode,result);
    }

    //迭代写法
    public static void inTraversal1(BinaryTree root,List<Integer> result){
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node=root;
        while(null!=node|| !stack.isEmpty()){
            if(null!=node){
                //将根节点入栈
                stack.push(node);
                node=node.leftNode;
            }else{
                //一直遍历到左节点的叶子节点
                BinaryTree pop = stack.pop();
                result.add(pop.value); //中节点
                node=pop.rightNode;   //右节点
            }
        }
    }

    //递归写法
    public static void postTraversal(BinaryTree root,List<Integer> result){
        if(root==null){
            return ;
        }
        postTraversal(root.leftNode,result);
        postTraversal(root.rightNode,result);
        result.add(root.value);
    }

    //迭代写法 前序是中 左 右 后序是左右中 可以通过前序调整左右位置 再反转数组就可以得到
    public static void postTraversal1(BinaryTree root,List<Integer> result){
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node=root;
        stack.push(node);
        while(null!=node&&!stack.isEmpty()){
            BinaryTree tree = stack.pop();
            result.add(tree.value);
            if(null!=tree.leftNode){
                stack.push(tree.leftNode);
            }
            if(null!=tree.rightNode){
                stack.push(tree.rightNode);
            }

        }
        //反转列表
        Collections.reverse(result);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.leftNode=new BinaryTree(4);
        root.rightNode=new BinaryTree(6);
        root.leftNode.leftNode=new BinaryTree(1);
        root.leftNode.rightNode=new BinaryTree(2);
        root.rightNode.leftNode=new BinaryTree(7);
        root.rightNode.rightNode=new BinaryTree(8);

        //前序遍历
        //preTraversal(root,new ArrayList<>());
        //preTraversal1(root,new ArrayList<>());
        //中序遍历
        //inTraversal(root,new ArrayList<>());
        //inTraversal1(root,new ArrayList<>());

        //后序遍历
        //postTraversal(root,new ArrayList<>());
        postTraversal1(root,new ArrayList<>());
    }
}
