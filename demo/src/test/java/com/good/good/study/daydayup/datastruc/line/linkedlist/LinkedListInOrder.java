package com.good.good.study.daydayup.datastruc.line.linkedlist;

/**
 * @author shipj@ctrip.com
 * @date 2018/7/18 23:08
 */
public class LinkedListInOrder {

    private Node head;  //头结点
    private int size;  //链表长度，即链表中结点数量

    public LinkedListInOrder(){
        head = null;
        size = 0;
    }

    //私有内部类，代表链表每个结点
    private class Node{
        private Integer data;  //链表结点的值
        private Node next;  //指向的下一个结点
        public Node(Integer data){
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

    //在链表中插入一个结点，保持链表有序性（头结点最小，尾结点最大）
    public void insertNode(Integer obj){
        Node newNode = new Node(obj);
        if(size == 0){  //空链表直接放入头结点
            head = newNode;
        }else{
            Node previous = null;  //插入位置前一个结点
            Node current = head;  //插入位置后一个结点（当前结点）
            while(current.data<obj && current.next != null){  //找到插入位置
                previous = current;
                current = current.next;
            }
            if(current.next == null){  //如果插入的结点大于链表中所有结点，则放到链尾
                current.next = newNode;
            }else{
                previous.next = newNode;  //在合适位置插入
                newNode.next = current;
            }
        }
        size++;
    }

    //删除链表表头结点
    public Object deleteHeadNode(){
        if(size == 0) return null;
        Object obj = head.data;
        if(head.next == null){
            head = null;  //只有一个结点
        }else{
            head = head.next;
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
