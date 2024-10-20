package online.labuladong.algo.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-11 16:39
 * @description:
 */
public class T51Queens {

    char[][] board;
    List<List<String>> res;

    /**
     * N 皇后问题
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        res = new ArrayList<>();

        List<int[]> position = new ArrayList<>(); // 用来存放可能的皇后的坐标
        int row = 0;
        dfs(position, row);
        return res;

    }

    private void dfs(List<int[]> position, int row) {

        int n = board.length;
        if (position.size() == n) {
            // 已经找到了结果
            List<String> solution = new ArrayList<>();
            for (char[] resChars : board) {
                solution.add(new String(resChars));
            }
            res.add(solution);
            return;
        }
        if (row >= board.length) return;
        // 寻找第row行可以放置皇后的位置
        for (int i = 0; i < n; i++) {
            if (available(row, i, position)) { // 当前位置可以放置棋子
                // 当前位置放入棋子
                board[row][i] = 'Q';
                // 将皇后的位置保存到position中
                position.add(new int[]{row, i});
                // 遍历下一行，找到可以放置皇后的位置
                dfs(position, row + 1);
                // 将当前皇后的位置取出
                int size = position.size();
                position.remove(size - 1);
                // 将棋子擦除
                board[row][i] = '.';
            }
        }

    }

    /**
     * 判断当前坐标是否可行
     * @param row 行
     * @param i 列
     * @param position
     * @return
     */
    private boolean available(int row, int i, List<int[]> position) {
        for (int[] queen : position) {
            if (row == queen[0] || i == queen[1] || row - queen[0] == i - queen[1] || row - queen[0] == queen[1] - i) {
                return false;
            }
        }
        return true;
    }

}
