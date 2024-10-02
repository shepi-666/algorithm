package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 21:35
 * @description: T160 相交链表
 */
public class T160IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        // 首先先计算出两个链表的长度
        int lenA = 1;
        int lenB = 1;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            lenA++;
            p2 = p2.next;
            lenB++;
        }
        //
        if (p1 == null) {
            while (p2 != null) {
                p2 = p2.next;
                lenB++;
            }
        } else {
            while (p1 != null) {
                p1 = p1.next;
                lenA++;
            }
        }

        int total = lenA + lenB;
        p1 = headA;
        p2 = headB;
        for (int i = 1; i < total; i++) {
            if (p1 == p2) return p1;
            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }
        return null;



    }
}
