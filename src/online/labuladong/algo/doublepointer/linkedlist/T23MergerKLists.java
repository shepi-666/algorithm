package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 17:52
 * @description:
 */
public class T23MergerKLists {

    /**
     * 合并K个升序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> pQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 将所有的节点添加到队列中
        for (ListNode node : lists) {
            if (node != null) {
                pQueue.add(node);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;
        ListNode min = null;
        while (!pQueue.isEmpty()) {
            // 取出节点，加入到新建节点的末尾
            min = pQueue.poll();
            if (min.next != null) pQueue.add(min.next);
            min.next = null;
            p.next = min;
            p = p.next;
        }
        return head.next;

    }
}
