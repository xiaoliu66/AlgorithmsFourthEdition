package chapterone.thirditem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/16 22:50
 * @version 1.0
 * 下压堆栈（链表实现）p149
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // 栈顶（最近添加的元素）
    private int N;      // 元素数量

    private class Node {
        // 定义了结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        // 向栈顶添加元素
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }

    public Item pop() {
        // 从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackNode();
    }

    private class StackNode implements Iterator<Item> {
        private Node currentNode = first;


        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public Item next() {
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        @Override
        public void remove() {}
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
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
