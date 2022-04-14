package ChapterOne.ItemOne;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/4/12 20:58
 * @version 1.0
 *
 */

/******************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch allowlist.txt < input.txt
 *  Dependencies: In.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/11model/tinyAllowlist.txt
 *                https://algs4.cs.princeton.edu/11model/tinyText.txt
 *                https://algs4.cs.princeton.edu/11model/largeAllowlist.txt
 *                https://algs4.cs.princeton.edu/11model/largeText.txt
 *  tinyAllowlist.txt 作为main方法中args[0]  tinyText.txt作为标准输入
 *  % java BinarySearch tinyAllowlist.txt < tinyText.txt
 *  50
 *  99
 *  13
 *
 *  % java BinarySearch largeAllowlist.txt < largeText.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *
 ******************************************************************************/
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(whitelist, key) < 0) {
                StdOut.println(key);
            }
        }
    }

    public static int rank(int[] a, int key) {

        int low = 0;
        int hight = a.length - 1;

        while (low <= hight) {
            int mid = low + (hight - low) / 2;

            if (key < a[mid]) {
                hight = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
