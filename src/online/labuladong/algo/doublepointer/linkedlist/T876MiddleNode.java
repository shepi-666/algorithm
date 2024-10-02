package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 18:37
 * @description:
 */
public class T876MiddleNode {


    /**
     * 链表的中间节点
     * @param head 头结点
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) return slow; // 奇数节点数，直接返回slow
        else return slow.next; // 偶数节点数，返回slow.next
    }
}
