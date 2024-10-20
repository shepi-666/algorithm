package online.labuladong.algo.exam.bole;

/**
 * @author: DongShaowei
 * @create: 2024-10-10 20:38
 * @description:
 */
public class T1RecoverAdventurer {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回Mr.Seven最后的坐标
     * @param m int整型 正整数，代表地图的横向长度
     * @param n int整型 正整数，代表地图的纵向长度
     * @param x int整型 非负整数，代表Mr.Seven的横坐标x
     * @param y int整型 非负整数，代表Mr.Seven的纵坐标y
     * @param dirs int整型一维数组 全部是由0,1,2,3,4组成的数列
     * @return int整型一维数组
     */
    public int[] GetLocation (int m, int n, int x, int y, int[] dirs) {
        int[] cur = {x, y};
        // write code here
        for (int i : dirs) {
            switch (i) {
                case 0: {
                    break;
                }
                case 1: {
                    if (isIn(m, n, cur[0], cur[1] + 1)) {
                        cur[0]++;
                    }
                    break;
                }
                case 2: {
                    if (isIn(m, n, cur[0] - 1, cur[1])) {
                        cur[0]--;
                    }
                    break;
                }
                case 3: {
                    if (isIn(m, n, cur[0], cur[1] - 1)) {
                        cur[1]--;
                    }
                    break;
                }
                case 4: {
                    if (isIn(m, n, cur[0] + 1, cur[1])) {
                        cur[0]++;
                    }
                    break;
                }

            }
        }
        return cur;
    }

    /**
     * 判断是否在界内
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    private boolean isIn(int m, int n, int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n;
    }


}
