package chaptertwo.firstitem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.time.LocalDateTime;

/**
 * @author https://github.com/xiaoliu66
 * @version 1.0
 * @since 2022/6/16 22:49
 * p163 算法2.3 希尔排序
 *
 * javac -encoding utf8 -Xlint:unchecked chaptertwo/firstitem/Shell.java
 *
 * java chaptertwo.firstitem.Insertion < data/tinyText.txt
 */
public class Shell {

    public static void sort(Comparable[] a) {
        // 按a[]升序排序
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1; // 1,4,13,40,121,364,1093....
        }

        while (h >= 1) {
            // 将数组变为有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >=h && less(a[j], a[j-h]) ; j-=h) {
                    exch(a,j, j-h);
                }
            }
            h = h / 3;
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

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
        // Integer[] strings = {23,13,9,9,389,3,24,53,88,56};
        System.out.println("startTime: " + LocalDateTime.now());
        Stopwatch timer = new Stopwatch();
        sort(strings);
        StdOut.println("elapsed time = " + timer.elapsedTime() + "S");
        // show(strings);
    }
}
