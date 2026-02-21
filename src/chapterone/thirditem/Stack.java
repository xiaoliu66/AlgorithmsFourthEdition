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
    private Node<Item> first; // 栈顶（最近添加的元素）
    private int N;      // 元素数量

    private class Node<Item> {
        // 定义了结点的嵌套类
        Item item;
        Node<Item> next;
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
        return new StackNode(first);
    }

    private class StackNode implements Iterator<Item> {
        private Node<Item> currentNode;

        public StackNode(Node<Item> first) {
            currentNode = first;
        }


        /**
         *
         * 如果你有不同理解，可能是因为对指针位置的理解不同。在迭代器中，指针并不直接指向元素，而是指向元素之间。
         *
         * 你可以这样理解迭代器的工作方式：
         *
         * 想象一个读书的书签放在书页之间
         *
         * hasNext()：问"书签后面还有页面吗？"
         *
         * next()：把书签移到下一页，然后读前一页的内容
         *
         *------------------------------------------------------------
         * ArrayList 用整数索引，指针可理解为位于元素之间。
         *
         * LinkedList 用节点引用，指针直接指向元素。
         *
         *
         * 迭代器维护一个“下一个待返回元素”的状态（可以是索引、节点引用等）。hasNext() 判断该状态是否为有效元素；
         * next() 返回当前状态指向的元素，并将状态更新为下一个元素（或索引加一、节点后移）。
         *
         */

        /**
         * 检查是否当前集合是否还有元素可返回
         * @return
         */
        @Override
        public boolean hasNext() {
            // currentNode 的含义：它代表 下一个要返回的元素，而不是已经返回的元素
            // currentNode.next != null;  这样写会漏掉最后一个元素
            return currentNode != null;
        }

        /**
         * 返回当前元素，然后将指针移动到下一个
         * @return
         */
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
