package chapterfour.fourthitem;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.LinkedList;

/**
 * @author Admin
 * @version 1.0
 * @since 2026/1/19 13:08
 * p336 算法4.1.2.2 邻接表的数据结构
 */
public class Graph {
    private final int V;    // 顶点数量
    private int E;          // 边的数量
    private Bag<Integer>[] adj; // 邻接表 （自己用链表代替了书本上的Bag类）

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V]; // 创建邻接表
        // 将所有链表初始化为空
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());  // 读取V并将图初始化
        int E = in.readInt(); // 读取E
        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt(); // 读取一个顶点
            int w = in.readInt(); // 读取另一个顶点
            addEdge(v,w);           // 添加一条连接它们的边
        }
    }

    public int V() {return V;}

    public int E() {return E;};

    public void addEdge(int v, int w) {
        adj[v].add(w);      // 将w添加到v的链表中
        adj[w].add(v);      // 将v添加到w的链表中
        E++;
    }

    /**
     * 返回某个节点所有相邻的节点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
