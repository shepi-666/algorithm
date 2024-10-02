package online.labuladong.algo.doublepointer.linkedlist;

import online.labuladong.algo.utils.ListNode;
import online.labuladong.algo.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-02 16:51
 * @description:
 */
public class T86PartitionList {

    /**
     * 分割链表
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode smaller = new ListNode();
        ListNode bigger = new ListNode();

        ListNode p1 = smaller;
        ListNode p = head;

        while (p != null) {
            ListNode temp = p;
            p = p.next;
            if (temp.val < x) {
                insertNode(temp, smaller);
                p1 = p1.next;
            } else {
                insertNode(temp, bigger);
            }

        }

        p1.next = bigger.next;
        return smaller.next;

    }

    /**
     * 按照节点顺序插入队尾
     * @param node 需要插入的节点
     * @param list 构建的链表
     */
    private void insertNode(ListNode node, ListNode list) {
        ListNode p = list;

        while (p.next != null) {
            p = p.next;
        }
        // 将node插入到p的next
        node.next = null;
        p.next = node;
    }



    @Test
    public void testSolution() {
        int[] arr = {1,4,3,2,5,2};
        ListNode head = ListNodeUtils.createLinkedList(arr);
        int x = 3;
        ListNode resList = partition(head, x);
        System.out.println(resList.toString());;
    }
}
