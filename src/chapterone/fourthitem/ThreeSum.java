package chapterone.fourthitem;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/18 22:54
 * @version 1.0
 * p109 三数之和
 *
 * javac -encoding utf8 chapterone/fourthitem/ThreeSum.java
 *
 * java chapterone.fourthitem.ThreeSum data/8Kints.txt
 * startTime: 2022-05-24T21:37:47.636
 * elapsed time = 0.089S
 * 32074
 * endTime: 2022-05-24T21:37:47.729
 *
 * java chapterone.fourthitem.ThreeSum data/1Mints.txt
 * startTime: 2022-05-24T21:42:35.387
 * elapsed time = 1154.046S
 * 62532564313
 * endTime: 2022-05-24T22:01:49.437
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


    public static long getArraysSort(int[] arrays) {
        long total = 0;
        // 获取数组长度
        int length = arrays.length;
        if (length < 3) {
            System.out.println("length < 3");
            return total;
        }
        // 数组排序
        Arrays.sort(arrays);
        // 采用指针进行遍历，找值
        for (int i = 0; i < length; i++) {
            // 判断剩余的数是否都为正数
            if (arrays[i] > 0) {
                return total;
            }
            // 判断数字是否重复
            if (i > 0 && arrays[i] == arrays[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int temp = arrays[i] + arrays[left] + arrays[right];
                if (temp == 0) {
                    total++;
                    left++;
                    right--;
                    while (left < right && arrays[left] == arrays[left - 1]) {
                        left++;
                    }
                    while (left < right && arrays[right] == arrays[right + 1]) {
                        right--;
                    }
                    continue;
                } else if (temp < 0) {
                    left++;
                    continue;
                } else {
                    right--;
                    continue;
                }

            }
        }

        return total;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        System.out.println("startTime: " + LocalDateTime.now());
        Stopwatch timer = new Stopwatch();
        long count = getArraysSort(a);
        StdOut.println("elapsed time = " + timer.elapsedTime() + "S");
        StdOut.println(count);
        System.out.println("endTime: " + LocalDateTime.now());
    }
}
