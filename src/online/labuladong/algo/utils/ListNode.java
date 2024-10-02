package online.labuladong.algo.utils;

/**
 * @author: DongShaowei
 * @create: 2024-10-01 15:23
 * @description: 单链表的数据结构
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {val = x;}
    public ListNode() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while (p != null) {
            sb.append(p.val).append(" -> ");
            p = p.next;
        }
        sb.append("null");
        return sb.toString();
    }


}
