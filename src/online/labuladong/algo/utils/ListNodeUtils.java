package online.labuladong.algo.utils;

/**
 * @author: DongShaowei
 * @create: 2024-10-01 15:22
 * @description: 主要用于将数组转换为链表
 */
public class ListNodeUtils {


    /**
     * 将数组转换为链表
     * @param arr
     * @return
     */
    public static final ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

}
