package com.programmer.carl.linkedlist;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 11:13
 * @description:
 */
public class T142CycleListII {

    /**
     * 返回链表中的环节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        // 判断链表是否有环
        if (fast == null || fast.next == null) return null;

        // 慢指针回拨，快指针降速
        slow = head;
        fast = fast.next;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
