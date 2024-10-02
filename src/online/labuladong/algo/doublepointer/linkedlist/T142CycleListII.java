package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 21:21
 * @description:
 */
public class T142CycleListII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) break;
            fast = fast.next.next;
            slow = slow.next;
        }

        // 判断fast的状态
        if (fast == null || fast.next == null) return null;
        fast = head; // fast回到头结点
        slow = slow.next; // slow向后移动一步
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
