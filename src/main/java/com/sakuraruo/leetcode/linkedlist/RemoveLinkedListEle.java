package com.sakuraruo.leetcode.linkedlist;

/***
 * 203 移除链表元素
 */
public class RemoveLinkedListEle {
    static class Node<T>{
        public T value;
        public Node next;

        public Node(T value) {
            this.value=value;
        }
    }

    /****
     * 这种实现需要考虑删除头节点
     * @param node
     * @param value
     * @return
     */
    public static Node removeEle(Node<Integer> node,Integer value){
        Node root=node;
        //删除头节点
        while(root.value==value){
            root=root.next;
        }
        //删除非头节点
        Node temp=root;
        while(temp!=null&&temp.next!=null){
            Node next = temp.next;
            if(next.value==value){
                //移除该元素
                temp.next=next.next;
            }
            temp=temp.next;
        }
        return root;
    }

    /****
     * 这种实现不需要考虑删除头节点 在删除时 首先设置一个虚拟头节点
     * @param node
     * @param value
     * @return
     */
    public static Node removeEle1(Node<Integer> node,Integer value){
        Node<Integer> head = new Node<>(-1);
        head.next=node;
        Node temp=head;
        while(temp!=null&&temp.next!=null){
            Node next = temp.next;
            if(next.value==value){
                //移除该元素
                temp.next=next.next;
            }else{
                temp=temp.next;
            }
        }
        head=head.next;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(4);
        Node<Integer> node1 = new Node<>(4);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(4);
        root.next=node1;
        node1.next=node2;
        node2.next=node3;

        Node anotherRoot = removeEle1(root, 4);
        System.out.println(anotherRoot);
    }
}
