package com.programmer.carl.stackqueue;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 16:37
 * @description:
 */
public class T150EvalRPN {

    public int evalRPN(String[] tokens) {
        if (tokens.length <= 2) return Integer.parseInt(tokens[tokens.length - 1]);
        int[] dataStack = new int[tokens.length / 2 + 1]; // 最多 n / 2 + 1 个操作数
        int index = 0; // 模拟栈帧

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    // 加法，取出两位操作数相加，计算结果赋值到第一个操作数的位置
                    dataStack[index - 2] = dataStack[index - 2] + dataStack[index - 1];
                    // 栈帧指向有效操作数的后一位
                    index--;
                    break;
                }
                case "-": {
                    dataStack[index - 2] = dataStack[index - 2] - dataStack[index - 1];
                    index--;
                    break;
                }
                case "*": {
                    dataStack[index - 2] = dataStack[index - 2] * dataStack[index - 1];
                    index--;
                    break;
                }
                case "/": {
                    dataStack[index - 2] = dataStack[index - 2] / dataStack[index - 1];
                    index--;
                    break;
                }
                default: {
                    // 操作数，直接入栈
                    dataStack[index++] = Integer.parseInt(token);
                }
            }
        }
        return dataStack[0];
    }
}
