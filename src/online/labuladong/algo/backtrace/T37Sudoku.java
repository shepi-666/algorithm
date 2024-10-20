package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-19 20:03
 * @description:
 */
public class T37Sudoku {


    /**
     * 解数独
     * @param board
     */
    public void solveSudoku(char[][] board) {
        // 初始化递归开始坐标
        int i = 0;
        int j = 0;

        // 进入递归
        backtrace(i, j, board);


        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 回溯解决数独问题
     * @param i
     * @param j
     * @param board
     */
    private boolean backtrace(int i, int j, char[][] board) {

        // 从(i, j)开始遍历下一个需要插入的位置
        int m = -1, n = -1;
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[0].length; l++) {
                if (board[k][l] == '.') {
                    // 记录这个位置
                    m = k;
                    n = l;
                    break;
                }
            }
            if (m != -1) {
                break;
            }
        }
        // 根据m, n判断所有的数字是否填完了
        if (m == -1 ) {
            return true;
        }

        // 根据m,n判断这个位置需要该填的位置
        List<Character> available = findValidNums(m, n, board);

        for (Character num : available) {
            // 将当前位置填入数字
            board[m][n] = num;
            // 从当前位置填下一个数字
            if (backtrace(m, n, board)) {
                return true;
            }
            // 将当前的位置清除
            board[m][n] = '.';
        }
        return false;

    }

    /**
     * 找到当前位置可选数字的集合
     * @param m 横坐标
     * @param n 纵坐标
     * @param board
     * @return
     */
    private List<Character> findValidNums(int m, int n, char[][] board) {
        boolean[] used = new boolean[10];
        List<Character> res = new ArrayList<>();
        // 判断该行使用的数字
        for (int i = 0; i < board[0].length; i++) {
            if (board[m][i] != '.') {
                used[board[m][i] - '0'] = true;
            }
        }
        // 判断该列使用的数字
        for (int i = 0; i < board.length; i++) {
            if (board[i][n] != '.') {
                used[board[i][n] - '0'] = true;
            }
        }

        // 判断该小方格用过的字母
        int startRow = m / 3 * 3;
        int startCol = n / 3 * 3;
        int endRow = startRow + 2;
        int endCol = startCol + 2;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] != '.') {
                    used[board[i][j] - '0'] = true;
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                res.add((char)('0' + i));
            }
        }

        return res;
    }


    @Test
    public void testSolution() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
    }
}
