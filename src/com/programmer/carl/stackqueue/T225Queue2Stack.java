package com.programmer.carl.stackqueue;

import java.util.ArrayList;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 15:52
 * @description:
 */
public class T225Queue2Stack {
}

/**
 * 使用队列实现栈
 */
class MyStack {

    private final ArrayList<Integer> list;

    private int sz;

    public MyStack() {
        list = new ArrayList<>();
        sz = 0;
    }

    public void push(int x) {
        list.add(x);
        sz++;
    }

    public int pop() {
        int val = list.get(sz - 1);
        list.remove(sz - 1);
        sz--;
        return val;
    }

    public int top() {
        return list.get(sz - 1);
    }

    public boolean empty() {
        return sz == 0;
    }
}