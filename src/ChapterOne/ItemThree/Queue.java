package ChapterOne.ItemThree;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/18 21:04
 * @version 1.0
 * 算法1.3 先进先出队列 p95
 *
 * javac -encoding utf-8 ChapterOne\ItemThree\Queue.java
 * java ChapterOne.ItemThree.Queue <  data\tobe.txt
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first; // 指向最早添加的结点的链接
    private Node last; // 指向最近添加的节点的链接
    private int N; // 队列中元素的数量
    // 定义了结点的嵌套类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // 从队尾添加元素
       Node oldLast = last;
       last = new Node();
       last.item = item;
       last.next = null;
       if (isEmpty()) {
           first = last;
       }else {
           oldLast.next = last;
       }
       N++;
    }

    public Item dequeue() {
        // 从队头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueNode();
    }

    private class QueueNode implements Iterator<Item>{
        private Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
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
        Queue<String> s = new Queue<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) {
                s.enqueue(str);
            } else if (!s.isEmpty()) {
                StdOut.print(s.dequeue() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on Queue)");
    }
}
