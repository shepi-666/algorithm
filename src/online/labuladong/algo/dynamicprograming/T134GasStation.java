package online.labuladong.algo.dynamicprograming;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-08 17:36
 * @description:
 */
public class T134GasStation {

    /**
     * 加油站
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; ) {
            int curGas = gas[i];
            int nextStation = -1;
            for (int j = i; j < i + n; j++) {

                if (curGas < cost[j % n]) {
                    curGas = curGas - cost[j % n];
                    // 不可达 j + 1
                    nextStation = (j + 1) % n;
                    break;
                } else {
                    curGas = curGas - cost[j % n];
                    curGas = curGas + gas[(j + 1)% n];
                }
            }
            if (curGas >= 0) return i;
            visited[i] = 1;
            if (visited[nextStation] == 1) {
                return -1;
            }
            i = nextStation;

        }
        return -1;
    }

    @Test
    public void testSolution() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }


    public int canCompleteCircuitI(int[] gas, int[] cost) {
        int n = gas.length;
        // 需要记录最小值的坐标和值
        int minGas = Integer.MAX_VALUE;
        int minIndex = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minGas) {
                minIndex = i;
                minGas = sum;
            }
        }
        if (sum < 0) {
            // 表示根本就没有足够的油来环游一周
            return -1;
        }

        return (minIndex + 1) % n;
    }
}
