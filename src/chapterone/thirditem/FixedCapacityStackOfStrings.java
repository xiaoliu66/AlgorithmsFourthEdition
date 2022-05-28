package chapterone.thirditem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/4/20 22:21
 * @version 1.0
 * p82 一种表示定容字符串栈的抽象数据类型
 *
 * 编译运行：首先进入src 目录下
 * javac -encoding utf-8 ChapterOne\ItemThree\FixedCapacityStackOfStrings.java
 * java ChapterOne.ItemThree.FixedCapacityStackOfStrings < data\tobe.txt
 * to be not that or be (2 left on stack)
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int size;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public String pop() {
        return a[--size];
    }

    public void push(String s) {
        a[size++] = s;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            }else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.getSize() + " left on stack)");
    }
}
