package com.sakuraruo.leetcode.linkedlist;

import java.util.Optional;

/**
 * 707 设计链表
 */
public class LinkedList<T> {
    private int size=0;
    private Node<T> head=new Node();
    private Node<T> tail=head;
    private static class Node<T>{
        public Node next;
        public T value;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }

    /***
     * 获取第index位置的节点
     * @param index
     * @return
     */
    public Node getIndex(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException();
        }
        Node<T> root=head;
        for(int i=0;i<index;i++){
            root=root.next;
        }
        return root;
    }

    /***
     * 在链表最前面插入一个节点
     * @param node
     */
    public void addHead(Node node){
        Optional.ofNullable(node).orElseThrow(()->new IllegalArgumentException());
        Node next = head.next;
        node.next=next;
        head.next=node;
        size++;
    }

    /***
     * 在链表最后面插入一个节点
     * @param node
     */
    public void addTail(Node node){
        Optional.ofNullable(node).orElseThrow(()->new IllegalArgumentException());
        tail.next=node;
        tail=node;
        size++;
    }

    /****
     * 在第Index位置前一位插入节点
     * @param index
     * @param node
     */
    public void addIndex(int index,Node node){
        Optional.ofNullable(node).orElseThrow(()->new IllegalArgumentException());
        if(index<0||index>size){
            throw new IllegalArgumentException();
        }
        //当index=2时就是插入第一个节点
        if(index==2){
            addHead(node);
            return ;
        }
        Node<T> root=head;
        for(int i=0;i<index-1;i++){
            root=root.next;
        }
        //获取到了index前一位
        Node next = root.next;
        root.next=node;
        node.next=next;
        size++;

    }

    public Node removeIndex(int index){
        if(size==0){
            throw new IllegalArgumentException("LinkedList is empty");
        }
        //删除头节点
        if(index==1){
            Node next=head.next;
            head.next=next.next;
            return next;
        }
        Node<T> root=head;
        //获取到index-1位置的元素
        for(int i=0;i<index-1;i++){
            root=root.next;
        }
        Node indexNode = root.next;
        root.next=indexNode.next;
        size--;
        return indexNode;
    }

    /**
     * 打印链表
     */
    public void printLinkedList(){
        Node root=head;
        System.out.print("Head:");
        while(root!=null){
            System.out.print(root.value+"-->");
            root=root.next;
        }
    }

    public LinkedList reverseList(LinkedList list){
        //指向第一个节点
        Node cur=getHead().next;
        Node pre=null;
        if(cur!=null){
            list.setTail(cur);
        }else{
            list.setTail(getHead());
        }
        Node temp=null;
        while(cur!=null){
            //当前指针的节点
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        Node head = getHead();
        head.next=pre;
        list.setHead(head);
        return list;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addTail(new Node<Integer>(3));
        list.addHead(new Node<Integer>(1));
        list.addHead(new Node<Integer>(2));
        list.printLinkedList();
        list.addIndex(1,new Node<Integer>(4));
        list.printLinkedList();
        System.out.println("\n");
        System.out.println(list.getIndex(1).value);
        list.removeIndex(2);
        System.out.println(list.getIndex(2).value);
        list.reverseList(list);
        list.printLinkedList();

    }

}
