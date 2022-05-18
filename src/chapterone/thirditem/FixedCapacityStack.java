package chapterone.thirditem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/4/21 21:13
 * @version 1.0
 * 一种表示泛型定容栈的抽象数据类型
 */
public class FixedCapacityStack<Item> {

    private Item[] a;
    private int N; // 栈中元素的数量

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = item;
    }

    public Item pop() {
        // 从栈顶删除元素,如果数组太大将长度减半。在数组长度被减半之后，它的状态约为半满，在下次需要改变数组大小之前仍然能够进行多次push和pop操作。
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return a[--N];
    }

    private void resize(int max) {
        // 将大小为N <= max的栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) {
                s.push(str);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}
