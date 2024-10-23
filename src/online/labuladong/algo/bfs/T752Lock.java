package online.labuladong.algo.bfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author: DongShaowei
 * @create: 2024-10-23 17:38
 * @description:
 */
public class T752Lock {

    /**
     * 打开转盘锁需要的最少步数，起始状态为 0000
     * @param deadends 死锁字符串
     * @param target 密码
     * @return
     */
    public int openLock(String[] deadends, String target) {
        char[] curLock = new char[4];
        Arrays.fill(curLock, '0');


        // Set记录访问过的锁状态
        HashSet<String> tried = new HashSet<>();
        tried.add(String.valueOf(curLock));

        // 初始化队列
        LinkedList<char[]> q = new LinkedList<>();
        q.offer(curLock);

        // 将deadends存储到set中，以便快速查询
        HashSet<String> deadlocks = new HashSet<>(Arrays.asList(deadends));
        if (deadlocks.contains(String.valueOf(curLock))) return -1; // 死锁起手
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                char[] cur = q.poll();
                if (target.equals(String.valueOf(cur))) {
                    return step;
                }
                // 每一种状态严格来说有 2 ^ 4 即 16 中选择
                for (int j = 0; j < 4; j ++) {
                    // 往大拨动
                    char[] up = Arrays.copyOf(cur, cur.length);
                    up[j] = up[j] == '9' ? '0' : (char)(up[j] + 1);
                    String nextUp = String.valueOf(up);
                    if (!deadlocks.contains(nextUp) && !tried.contains(nextUp)) {
                        // 将下一个状态装进队列
                        q.offer(up);
                        tried.add(nextUp);
                    }

                    // 往小的拨动
                    char[] down = Arrays.copyOf(cur, cur.length);
                    down[j] = down[j] == '0' ? '9' : (char)(down[j] - 1);
                    String nextDown = String.valueOf(down);
                    if (!deadlocks.contains(nextDown) && !tried.contains(nextDown)) {
                        // 将下一个状态装进队列
                        q.offer(down);
                        tried.add(nextDown);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    @Test
    public void testSolution() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLockII(deadends, target));
    }

    public int openLockI(String[] deadends, String target) {
        HashSet<String> deadlocks = new HashSet<>(Arrays.asList(deadends));
        if (deadlocks.contains("0000") || deadlocks.contains(target)) return -1;

        // 记录试过的密码
        HashSet<String> tried = new HashSet<>();
        tried.add("0000");

        // 记录当前状态列表
        LinkedList<String> q = new LinkedList<>();
        q.offer("0000");

        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String curLock = q.poll();
                if (curLock.equals(target)) {
                    return step;
                }
                for (int j = 0; j < curLock.length(); j++) {
                    StringBuilder up = new StringBuilder();
                    StringBuilder down = new StringBuilder();
                    for (int k = 0; k < curLock.length(); k++) {
                        if (k == j) {
                            char newUp = curLock.charAt(k) == '9' ? '0' : (char) (curLock.charAt(k) + 1);
                            up.append(newUp);
                            char newDown = curLock.charAt(k) == '0' ? '9' : (char) (curLock.charAt(k) - 1);
                            down.append(newDown);
                        } else {
                            up.append(curLock.charAt(k));
                            down.append(curLock.charAt(k));
                        }
                    }
                    if (!deadlocks.contains(up.toString()) && !tried.contains(up.toString())) {
                        q.offer(up.toString());
                        tried.add(up.toString());
                    }

                    if (!deadlocks.contains(down.toString()) && !tried.contains(down.toString())) {
                        q.offer(down.toString());
                        tried.add(down.toString());
                    }

                }
            }
            step++;
        }
        return -1;
    }

    /**
     * BFS 双向扩散优化代码
     * @param deadends
     * @param target
     * @return
     */
    public int openLockII(String[] deadends, String target) {
        // 记录死锁密码
        HashSet<String> deadlocks = new HashSet<>(Arrays.asList(deadends));

        // 记录已经穷举过的代码
        HashSet<String> tried = new HashSet<>();
        // 两个集合，分别表示 源扩散 元素和 目标扩散 元素
        HashSet<String> source = new HashSet<>();
        HashSet<String> destination = new HashSet<>();

        int step = 0;
        source.add("0000");
        destination.add(target);
        while (!source.isEmpty() && !destination.isEmpty()) {
            // 使用temp存储扩散结果
            HashSet<String> temp = new HashSet<>();

            // 将 source 节点向周围扩散
            for (String cur : source) {
                // 判断是否到达了终点
                if (deadlocks.contains(cur)) continue;
                if (destination.contains(cur)) return step;
                tried.add(cur);

                // 将当前节点的相邻节点加入到集合中
                for (int i = 0; i < cur.length(); i++) {
                    StringBuilder up = new StringBuilder();
                    StringBuilder down = new StringBuilder();
                    for (int j = 0; j < cur.length(); j++) {
                        if (j == i) {
                            char newUp = cur.charAt(j) == '9' ? '0' : (char) (cur.charAt(j) + 1);
                            up.append(newUp);
                            char newDown = cur.charAt(j) == '0' ? '9' : (char) (cur.charAt(j) - 1);
                            down.append(newDown);
                        } else {
                            up.append(cur.charAt(j));
                            down.append(cur.charAt(j));
                        }
                    }
                    if (!tried.contains(up.toString())) {
                        temp.add(up.toString());
                    }
                    if (!tried.contains(down.toString())) {
                        temp.add(down.toString());
                    }

                }
            }
            // 增加步数
            step++;
            // 交换source 和 destination
            source = destination;
            destination = temp;
        }

        return -1;
    }

}
