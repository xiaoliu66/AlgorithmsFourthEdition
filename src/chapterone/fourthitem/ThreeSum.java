package chapterone.fourthitem;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/18 22:54
 * @version 1.0
 * p109 三数之和
 */
public class ThreeSum {
    public static int count(int[] a) {
        // 统计和为0的元组的数量
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime() + "S");
        StdOut.println(count);
    }
}
