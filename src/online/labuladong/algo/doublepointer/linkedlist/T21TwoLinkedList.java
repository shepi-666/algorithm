package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 16:33
 * @description: 合并两个升序链表
 */
public class T21TwoLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode head = new ListNode();
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 == null) p.next = p2;
        if (p2 == null) p.next = p1;
        return head.next;

    }
}
