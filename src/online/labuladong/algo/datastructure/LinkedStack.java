package online.labuladong.algo.datastructure;

import java.util.LinkedList;

/**
 * @author: DongShaowei
 * @create: 2024-10-01 15:56
 * @description: 使用链表来实现的栈
 */
public class LinkedStack<E> {

    private final LinkedList<E> list = new LinkedList<E>();

    // 向栈顶中添加元素
    public void push(E e) {
        list.add(e);
    }

    // 弹出元素
    public E pop() {
        return list.removeLast();
    }

    // 查看栈顶元素
    public E peek() {
        return list.getLast();
    }

    // 返回栈中元素的个数
    public int size() {
        return list.size();
    }

}
