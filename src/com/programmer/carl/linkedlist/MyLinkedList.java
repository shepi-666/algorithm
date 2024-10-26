package com.programmer.carl.linkedlist;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 09:29
 * @description:
 */
public class MyLinkedList {

    public ListNode head;

    public int length;

    public MyLinkedList() {
        head = new ListNode();
    }

    public int get(int index) {
        if (index >= this.length) {
            return -1;
        }
        int curIndex = 0;
        ListNode p = head;
        while (curIndex <= index) {
            p = p.next;
            curIndex++;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        ListNode cur = new ListNode(val);
        cur.next = head.next;
        head.next = cur;
        length++; //长度加 1
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) return;
        ListNode p = head;
        ListNode newNode = new ListNode(val);
        int curIndex = 0;
        while (curIndex < index) {
            p = p.next;
            curIndex++;
        }
        newNode.next = p.next;
        p.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index >= length) return;
        ListNode p = head;
        int curIndex = 0;
        while (curIndex < index) {
            p = p.next;
            curIndex++;
        }
        p.next = p.next.next;
        this.length--;

    }


}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode() { }
}
