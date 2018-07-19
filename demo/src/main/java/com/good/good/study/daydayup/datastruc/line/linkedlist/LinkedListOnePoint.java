package com.good.good.study.daydayup.datastruc.line.linkedlist;

import java.util.Stack;

/**
 * @author shipj@ctrip.com
 * @date 2018/7/18 22:32
 */
public class LinkedListOnePoint {

    //记录头结点
    private Node head;
    //记录链表的长度
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    public Object headNode(){
        if(0 == size){
            return null;
        }
        return this.head.data;
    }

    //在链表表头插入一个结点（入栈）
    public void insertInHead(Object obj){
        Node newNode = new Node(obj);
        if(size == 0){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    //删除链表表头结点（出栈）
    public Object deleteHeadNode(){
        if(size == 0){
            return null;
        }
        Object obj = head.data;
        if(head.next == null){
            head = null;  //只有一个结点
        }else{
            head = head.next;
        }
        size--;
        return obj;
    }

    //链表查找：判断链表中是否包含某个元素
    public boolean containObject(Object obj){
        if(size == 0) {
            return false;
        }
        Node n = head;
        while(n != null){
            if(n.data == obj) {
                return true;
            } else {
                n = n.next;
            }
        }
        return false;
    }

    //删除链表中的指定结点（如果包含多个指定结点，只会删除第一个）
    public boolean deleteNode(Object obj){
        if(size == 0){
            System.out.println("链表为空！");
            return false;
        }
        //先在链表中查询是否包含该结点，找到之后获取该结点和其前一个结点
        Node previous = null;  //前一个结点
        Node current = head;  //当前结点
        while(current.data != obj){
            if(current.next == null){
                System.out.println("没有找到该结点！");
                return false;
            }
            previous = current;
            current = current.next;
        }
        if(current == head){
            this.deleteHeadNode();
        }else{
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //反向打印链表（用栈）
    public void printListFromTailToHead(Node node){
        if(node == null) {
            System.out.println("链表为空！");
        }
        Stack<Integer> sta = new Stack<Integer>();
        while(node != null){
            sta.push((Integer) node.data);  //先将链表压入栈中
            node = node.next;
        }
        while(!sta.empty()){
            System.out.print(sta.pop()+"<-");  //出栈
        }
        System.out.println();
    }

    //反向打印链表（递归）
    public void printListFromTailToHeadDiGui(Node node){
        if(node == null){
            System.out.println("链表为空！");
        }else{
            if(node.next != null){
                printListFromTailToHeadDiGui(node.next);
            }
            System.out.print(node.data+"<-");
        }
    }

    //正向打印链表
    public void display(){
        if(size == 0) System.out.println("链表为空！");
        Node n = head;
        while(n != null){
            System.out.print("<-"+n.data);
            n = n.next;
        }
        System.out.println();
    }

    //私有的内部类，代表链表的每个节点
    private class Node{
        //节点的数据
        private Object data;
        //指向的的下一个节点
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
