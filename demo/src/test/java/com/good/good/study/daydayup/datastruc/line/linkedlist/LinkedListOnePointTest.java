package com.good.good.study.daydayup.datastruc.line.linkedlist;

import org.junit.Test;

/**
 * @author shipj@ctrip.com
 * @date 2018/7/18 22:41
 */
public class LinkedListOnePointTest {

    @Test
    public void isEmpty() {
        LinkedListOnePoint onePoint = new LinkedListOnePoint();
        System.out.println(onePoint.isEmpty());
        onePoint.insertInHead("HEAD");
        System.out.println(onePoint.isEmpty());
    }

    @Test
    public void size() {
        LinkedListOnePoint onePoint = new LinkedListOnePoint();
        System.out.println(onePoint.size());
        onePoint.insertInHead("head");
        System.out.println(onePoint.size());
    }

    @Test
    public void headNode() {
        LinkedListOnePoint onePoint = new LinkedListOnePoint();
        System.out.println(onePoint.headNode());
        onePoint.insertInHead("head");
        System.out.println(onePoint.headNode());
    }

    @Test
    public void insertInHead() {

    }

    @Test
    public void deleteHeadNode() {
        LinkedListOnePoint onePoint = new LinkedListOnePoint();
        System.out.println(onePoint.deleteHeadNode());
        onePoint.insertInHead("head");
        System.out.println(onePoint.deleteHeadNode());
    }

    @Test
    public void containObject() {
    }

    @Test
    public void deleteNode() {
    }

    @Test
    public void printListFromTailToHead() {
    }

    @Test
    public void printListFromTailToHeadDiGui() {
    }

    @Test
    public void display() {
    }
}