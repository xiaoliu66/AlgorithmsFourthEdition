package chapterfour.fourthitem;


import chapterone.thirditem.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Admin
 * @version 1.0
 * @since 2026/1/19 21:38
 * p343 算法 4.1 使用深度优先搜索查找图中的路径
 */
public class DepthFirstPath {
    private boolean[] marked; // 用于标识节点是否访问过
    private int count;

    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public DepthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    /**
     * p339 4.1.3.1 深度优先搜索
     *
     * @param G 图
     * @param v 给定图中一个起点
     */
    public void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        // 从邻接表中获取到指定节点的所有相邻的节点进行遍历 例如 0 : 3->4->6->7
        for (Integer w : G.adj(v)) {
            // 如果该节点没有被访问过，继续递归访问
            if (!marked[w]) {
                // edgeTo[w]=v 表示 v-w 是第一次访问 w 时经过的边 。
                // edgeTo[] 数组是一棵用父链接表示的以 s 为根且含有所有与 s 连通的顶点的树
                /**
                 *      0
                 *      |
                 *      |
                 *      2
                 *      |
                 *  1-------3
                 *          |
                 *     4----------5
                 */
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }


    /**
     * p343 4.1  s到v的路径，如果不存在则返回 null
     *
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    /**
     * 是否存在从 S 到 V 的路径
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }


    /**
     * 测试用例 测试深度优先遍历寻找路径
     * @param args
     */
    public static void main(String[] args) {
        // In in = new In(args[0]);
        In in = new In("data\\tinyCG.txt");
        // In in = new In("data\\mediumG.txt");
        // In in = new In("data\\largeG.txt");
        Graph graph = new Graph(in);
        // int s = Integer.parseInt(args[1]);
        int s = 0;
        // long l = System.currentTimeMillis();
        DepthFirstPath dfs = new DepthFirstPath(graph, s);
        /*long l1 = System.currentTimeMillis();
        System.out.println("time:" + (l1-l));*/

        for (int v = 0; v < graph.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }

}
