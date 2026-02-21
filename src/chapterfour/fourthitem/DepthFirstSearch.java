package chapterfour.fourthitem;

import chapterone.thirditem.Stack;
import edu.princeton.cs.algs4.In;

/**
 * @author Admin
 * @version 1.0
 * @since 2026/1/19 21:38
 * p339 4.1.3. 深度优先搜索
 */
public class DepthFirstSearch {
    private boolean[] marked; // 用于标识节点是否访问过
    private int count;


    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];

        dfs(G, s);
    }

    /**
     * 深度优先搜索
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

}
