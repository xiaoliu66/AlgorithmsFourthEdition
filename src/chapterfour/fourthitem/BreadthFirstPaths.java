package chapterfour.fourthitem;

import chapterone.thirditem.Queue;
import chapterone.thirditem.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayDeque;

/**
 * @author Admin
 * @version 1.0
 * @since 2026/2/14 19:07
 */
public class BreadthFirstPaths {
    private boolean[] marked; // 到达该顶点的最短路径已知吗？
    private int[] edgeTo; // 到达该顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     * 广度优先搜索
     *
     * @param G
     * @param s
     */
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[s] = true; // 标记起点
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (Integer w : G.adj(v)) {
                if (!marked[w]) {
                    // 对于每个未被标记的相邻节点
                    // 保存最短路径的最后一条边
                    edgeTo[w] = v;
                    marked[w] = true;
                    // 并将它添加到队列中
                    queue.enqueue(w);
                }
            }
        }
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
     * s到v的路径，如果不存在则返回 null
     *
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }


    /**
     * 用广度优先搜索查找一条最短路径
     *
     * @param args
     */
    public static void main(String[] args) {
        // In in = new In(args[0]);
        In in = new In("data\\tinyCG.txt");
        // In in = new In("data\\mediumG.txt");
        // In in = new In("data\\largeG.txt");
        // Graph graph = new Graph(in);
        Graph graph = new Graph(in);
        // int s = Integer.parseInt(args[1]);
        int s = 0;
        // long l = System.currentTimeMillis();
        BreadthFirstPaths dfs = new BreadthFirstPaths(graph, s);
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
