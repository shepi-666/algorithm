package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 10:45
 * @description:
 */
public class T83DuplicateNode {

    /**
     * 删除排序链表中的所有重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                // 说明快慢指针节点值不一样
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }
}
