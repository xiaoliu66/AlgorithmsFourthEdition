package chapterone.fifthitem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/25 22:25
 * @version 1.0
 * p138 算法1.5 union-find 的实现
 *
 * javac -encoding utf-8 chapterone/fifthitem/UF.java
 *
 * java chapterone.fifthitem.UF < data/tinyUF.txt
 */
public class UF {
    private int[] id; // 分量id(以触点作为索引)
    private int count; // 分量数量

    /**
     * 以整数标识（0到N-1)初始化N个触点
     * @param N
     */
    public UF(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 连通分量的个数
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 如果p和q存在于同一个分量中则返回true
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p(0到N-1)所在的分量的标识符
     * @param p
     * @return
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * 在p和q之间添加一条连接
     */
    public void union(int p, int q) {
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        // 如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pID == qID) return;

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
