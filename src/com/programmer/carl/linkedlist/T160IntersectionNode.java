package com.programmer.carl.linkedlist;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 10:49
 * @description:
 */
public class T160IntersectionNode {

    /**
     * 链表的相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // 计算两个链表的长度
        int lenA = 0;
        ListNode pA = headA;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        pA = headA;

        int lenB = 0;
        ListNode pB = headB;
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        pB = headB;

        // 循环路程为 A B 两个链表长度之和
        int count = 0;
        while (count < lenA + lenB) {
            if (pA == pB) return pA;
            pA = pA.next == null ? headB : pA.next;
            pB = pB.next == null ? headA : pB.next;
            count++;
        }
        return null;
    }
}
