package com.programmer.carl.linkedlist;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 10:37
 * @description:
 */
public class T19RemoveEndNode {

    /**
     * 删除倒数第 n 个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode h = new ListNode();
        h.next = head;

        // 快慢指针初始化，指向虚拟头结点
        ListNode fast = h;
        ListNode slow = h;

        // 快指针先行 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 快指针到达最后一个节点，慢指针指向目标节点的 前驱节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 将 目标节点 即 slow.next 移除
        slow.next = slow.next.next;

        return h.next;
    }
}
