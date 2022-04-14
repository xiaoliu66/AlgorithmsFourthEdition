package ChapterOne.ItemOne;

import java.util.Arrays;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/4/11 22:48
 * @version 1.0
 * @Description p15 二分查找的递归实现
 */
public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] nums = {11, 434, 5, 4656, 334, 32};
        // 二分查找算法的前提是排序好的数据。
        Arrays.sort(nums);
        System.out.println(rank(12, nums));
        // Arrays工具类中有自带二分查找方法。
        // int i = Arrays.binarySearch(nums, 5);
        // System.out.println(i);
    }

    public static int rank(int key, int[] a) {

        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        // 防止整数溢出
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

   /* public static int rank(int key, int[] a) {
        Arrays.sort(a);
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (key == a[mid]) return mid;

        if (key < a[mid]) {
            return rank(key, a, lo, mid);
        } else if (key > a[mid]) {
            return rank(key, a, mid, hi);
        } else {
            return -1;
        }

    }*/
}
