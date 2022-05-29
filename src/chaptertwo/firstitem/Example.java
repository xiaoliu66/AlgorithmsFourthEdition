package chaptertwo.firstitem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/29 09:36
 * @version 1.0
 * p153 排序算法的模板
 *
 * 编译时不用管控制台的警告
 * javac -encoding utf8  -Xlint:unchecked chaptertwo/firstitem/Example.java
 *
 * java chaptertwo.firstitem.Example < data/tiny.txt
 */
public class Example {

    public static void sort(Comparable[] a) {
        // 选择排序
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
                exch(a, i, min);
            }
        }
    }

    /**
     * 对元素进行比较
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 对元素进行交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * 测试数组元素是否有序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序输出
        String[] a = StdIn.readAllStrings();
        sort(a);
        // System.out.println(isSorted(a));
        assert isSorted(a);
        show(a);
    }


}
