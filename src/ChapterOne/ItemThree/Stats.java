package ChapterOne.ItemThree;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/4/17 16:25
 * @version 1.0
 * p77 背包的典型用例：简单地计算输入中所有的double值的平均值和样本标准差。
 * idea 直接运行，字符输入完回车按 ctrl + d
 * 用cmd窗口运行，字符输入完回车按 ctrl + z
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        double sum = 0.0;
        while (!StdIn.isEmpty()) {
            double v = StdIn.readDouble();
            numbers.add(v);
            sum += v;
        }


        double average = sum / numbers.size();
        sum = 0.0;
        for (Double number : numbers) {
            sum += (number - average) * (number - average);
        }
        double std = Math.sqrt(sum / (numbers.size() - 1));

        StdOut.printf("Average: %.2f\n",average);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
