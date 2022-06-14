package chaptertwo.firstitem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author https://github.com/xiaoliu66
 * @version 1.0
 * @since 2022/6/6 22:26
 * <p>
 * p157 算法2.2 插入排序
 * <p>
 * 输入下面命令进行编译，如果控制台提示警告不用管，没有报错就已经编译成功。
 * javac -encoding utf8 -Xlint:unchecked chaptertwo/firstitem/Insertion.java
 * <p>
 * java chaptertwo.firstitem.Insertion < data/tiny.txt
 * <p>
 * 运行结果：A E E L M O P R S T X
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中。
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }

    }

    /**
     * 对元素v,w进行比较,如果v < w 返回true 否则返回false
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 对元素i,j进行交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
        sort(strings);
        show(strings);
    }
}
