package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-11 21:31
 * @description:
 */
public class T77Combination {


    List<List<Integer>> resList;
    /**
     * 组合
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tempList = new ArrayList<>();
        resList = new ArrayList<>();

        // 根节点元素可能为
        for (int i = 1; i <= n; i++) {
            dfs(i, tempList, k, n);
        }
        return resList;
    }

    private void dfs(int i, List<Integer> tempList, int k, int n) {

        // 将当前节点加入到路径中
        tempList.add(i);

        // 返回条件：size == k
        if (tempList.size() == k) {
            resList.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }

        // 遍历孩子节点
        for (int j = i; j <= n - 1; j++) {
            dfs(j + 1, tempList, k, n);
        }
        // 将当前节点删除
        int size = tempList.size();
        tempList.remove(size - 1);
    }

    @Test
    public void testSolution() {
        int n = 4, k = 2;
        List<List<Integer>> combines = combine(n, k);
        for (List<Integer> combine : combines) {
            System.out.println(combine);
        }
    }

}
