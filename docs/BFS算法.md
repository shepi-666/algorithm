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

本节通过两道BFS经典题目，[[二叉树最小高度](https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/)]和[[打开密码锁需要的最少步数]()]两道题深入体会BFS算法的核心思路。

## 2.1 二叉树最小高度

**题目描述**

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

**说明：**叶子节点是指没有子节点的节点。

**我的思路**

* 对二叉树进行层序遍历，层序遍历也就是BFS
* 维护一个记录深度的变量`minHeight`，每遍历一层，这个值就加1
* 如果到达叶子节点，就直接返回树的深度