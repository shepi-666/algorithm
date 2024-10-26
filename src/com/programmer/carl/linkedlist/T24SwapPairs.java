package com.programmer.carl.linkedlist;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 10:22
 * @description:
 */
public class T24SwapPairs {

    /**
     * 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode();
        h.next = head;

        ListNode pre = h;
        ListNode target1 = head;
        ListNode target2 = target1.next;
        ListNode nextNode = target2.next;

        while (true) {
            target1.next = nextNode;
            target2.next = target1;
            pre.next = target2;

            // 变量更新
            pre = target1;
            if (nextNode == null || nextNode.next == null) break;
            target1 = nextNode;
            target2 = target1.next;
            nextNode = target2.next;
        }
        return h.next;
    }
}
