package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;
import online.labuladong.algo.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 18:18
 * @description:
 */
public class T19RemoveNthEnd {

    /**
     * 删除倒数第 N 个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 最后一个节点的特征是：fast.next == null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return newHead.next;

    }


    @Test
    public void testSolution() {
        int[] arr = {1};
        ListNode list = ListNodeUtils.createLinkedList(arr);
        int n = 1;
        System.out.println(removeNthFromEnd(list, n));
    }
}
