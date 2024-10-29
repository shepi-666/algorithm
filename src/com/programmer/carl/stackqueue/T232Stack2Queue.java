package com.programmer.carl.stackqueue;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 15:32
 * @description:
 */
public class T232Stack2Queue {
}

/**
 * 使用栈来实现队列
 */
class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;


    public MyQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        // 先检查 popStack 中是否有元素
        if (popStack.isEmpty()) {
            transfer(pushStack, popStack);
        }
        // 从 popStack 中弹出元素
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            transfer(pushStack, popStack);
        }
        return popStack.peek();
    }

    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    private void transfer(Stack<Integer> pushStack, Stack<Integer> popStack) {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}