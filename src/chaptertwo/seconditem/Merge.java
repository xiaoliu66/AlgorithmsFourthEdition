package chaptertwo.seconditem;

/**
 * @author https://github.com/xiaoliu66
 * @version 1.0
 * @since 2022/6/22 22:20
 * <p>
 * p171 算法2.4 自顶向下的归并排序
 */
public class Merge {

    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo...hi]进行排序
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 将左半边进行排序
        sort(a, mid + 1, hi); // 将右半边进行排序
        merge(a, lo, mid, hi); // 归并结果
    }

    /**
     * 原地归并的抽象方法
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo...mid] 和a[mid+1...hi]归并
        int i = lo, j = mid + 1;

        for (int k = 0; k <= hi; k++) {
            // 将a[lo...hi]复制到aux[lo...hi]
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            // 归并回到a[lo...hi]
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
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


}
