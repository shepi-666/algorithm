package com.programmer.carl.linkedlist;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 09:58
 * @description:
 */
public class T206ReverseList {

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode();
        h.next = head;
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            ListNode temp = p.next;
            pre.next = temp;
            p.next = h.next;
            h.next = p;
            p = temp;
        }
        return h.next;
    }
}
