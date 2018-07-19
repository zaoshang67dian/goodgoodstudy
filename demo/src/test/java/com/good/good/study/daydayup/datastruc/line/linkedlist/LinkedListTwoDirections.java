package com.good.good.study.daydayup.datastruc.line.linkedlist;

/**
 * @author shipj@ctrip.com
 * @date 2018/7/18 23:11
 */
public class LinkedListTwoDirections {

    private Node head;  //头结点
    private Node tail;  //尾结点
    private int size;  //链表长度，即链表中结点数量

    public LinkedListTwoDirections(){
        head = null;
        tail = null;
        size = 0;
    }

    //私有内部类，代表链表每个结点
    private class Node{
        private Object data;    //链表结点的值
        private Node previous;  //当前结点指向的前一个结点
        private Node next;      //当前结点指向的下一个结点
        public Node(Object data){
            this.data = data;
        }
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size==0?true:false;
    }

    //返回链表长度
    public int size(){
        return size;
    }

    //查看链表头结点，不移除
    public Object headNode(){
        if(size == 0) return null;
        return head.data;
    }

    //查看链表尾结点，不移除
    public Object tailNode(){
        if(size == 0) return null;
        return tail.data;
    }

    //在链表表头插入一个结点
    public void insertInHead(Object obj){
        Node newNode = new Node(obj);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    //在链表表尾插入一个结点
    public void insertInTail(Object obj){
        Node newNode = new Node(obj);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //删除链表表头结点
    public Object deleteHeadNode(){
        if(size == 0) return null;
        Object obj = head.data;
        if(head.next == null){  //只有一个结点
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.previous = null;
        }
        size--;
        return obj;
    }

    //删除链表表尾结点
    public Object deleteTailNode(){
        if(size == 0) return null;
        Object obj = tail.data;
        if(tail.previous == null){  //只有一个结点
            head = null;
            tail = null;
        }else{
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return obj;
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
}
