# 1 BFS算法解题套路框架

BFS算法的**核心思想**为：

> 将一些问题抽象为图，从一个点开始，向四周扩散。一般来说啊，BFS算法都是用到[**队列**]的，将一个节点的周围的所有节点加入到队列。

BFS算法和DFS算法主要的区别为：

* BFS算法找到的**路径一定是最短**的，但是代价就是空间复杂度比DFS大很多
* DFS算法适合寻找**通路**，即是否存在路径的问题，当然也用于解决连通性，拓扑排序等问题

BFS算法问题的**本质就是在一幅【图】中找到从起始点**`start`**到终点**`end`**的最近距离。**

常见的题目类型有：

* 走迷宫
* 两个单词，通过某些操作，将一个变为另一个
* 连连看游戏

不管题目的形式怎么改变，万变不离其宗，BFS的**解题框架**需要记牢：

```java
int BFS (Node start, Node target) {
    // 核心数据结构，队列
    Queue<Node> q;
    // 避免走回头路
    Set<Node> visited;
    
    // 将起点加入队列
    q.offer(start);
    visited.add(start);
    
    while(q not empty) {
        int size = q.size();
        // 将当前队列中的节点向四周扩散
        for (int i = 0; i < size; i++) {
            Node cur = q.poll();
            // 判断是否达到重点
            if (cur is target) {
                return step;
            }
            // 将相邻的节点加入队列
            for (Node neighbor : cur.neighbors) {
                if (neighbor have not visited) {
                    q.offer(beighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    // 图中没有目标节点
}
```

# 2 实战训练

本节通过两道BFS经典题目，[[二叉树最小高度](https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/)]和[[打开转盘锁](https://leetcode.cn/problems/open-the-lock/description/)]两道题深入体会BFS算法的核心思路。

## 2.1 二叉树最小高度

**题目描述**

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

**说明：**叶子节点是指没有子节点的节点。

**我的思路**

* 对二叉树进行层序遍历，层序遍历也就是BFS
* 维护一个记录深度的变量`minHeight`，每遍历一层，这个值就加1
* 如果到达叶子节点，就直接返回树的深度

> 实现代码见[[T111-二叉树最小深度](#T111-二叉树最小深度)]

在实现代码中，`while`循环和`for`循环来共同控制一层一层往下遍历每个节点，其中`while`循环控制一层一层往下走，而`for`循环控制每一层从左到右每一层二叉树节点。

从这个简单的题目中，我们可以寻找到下面这个问题的答案了：

* **为什么BFS可以找到最短距离？**

  我们观察DFS的逻辑，`depth`每往前走一步，队列中所有的节点都往前迈一步，这样保证到达目标节点，即终点的时候，走的步数是最小的。

  DFS可以找到最短路径，但是需要对每个可以到达终点的路径进行穷举，然后对比才能找到，这样时间复杂度非常高。

## 2.2 解开密码锁的最少次数

**题目描述**

你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： `'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'` 。每个拨轮可以自由旋转：例如把 `'9'` 变为 `'0'`，`'0'` 变为 `'9'` 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 `'0000'` ，一个代表四个拨轮的数字的字符串。

列表 `deadends` 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 `target` 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 `-1` 。

**示例**

```
输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
```

**我的思路**

* 队列中存储的是什么，当前锁的状态，锁的状态用什么存储呢？`char[4] curLock`
* `while()`控制所有的状态拨一次，`for`控制当前状态的相邻状态
* 如果遇到死锁，则不保存状态`Set<String> deadlock`

>  实现代码见[[T752-打开转盘锁](#T752-打开转盘锁)]

# 3 双向BFS优化

BFS算法有一种稍微高级的优化思路：**双向BFS**，可以进一步提高算法的效率。

传统的BFS算法是从起点开始向四周扩散，遇到终点时停止，而双向BFS则是**从起点和终点同时开始扩散**，当**两边有交集的时候停止**。

双向BFS亦有局限性，必须知道**终点**在哪里。

[[打开转盘锁](https://leetcode.cn/problems/open-the-lock/description/)]双向BFS优化之后的代码为：

```java
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
```

# BFS经典算法题

## T111-二叉树最小深度

**实现代码**

```java
/**
     * 二叉树的最小深度
     * @param root
     * @return
     */
public int minDepth(TreeNode root) {

    if (root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int minDepth = 1;
    while (!q.isEmpty()) {
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
            TreeNode cur = q.poll();
            if (cur.left == null && cur.right == null) {
                return minDepth;
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        minDepth++;
    }
    return minDepth;
}
```

## T752-打开转盘锁

**实现代码**

```java
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
```