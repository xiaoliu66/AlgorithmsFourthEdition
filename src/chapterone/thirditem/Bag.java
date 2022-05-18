package chapterone.thirditem;

import java.util.Iterator;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/5/18 22:13
 * @version 1.0
 * 算法1.4 背包 p98
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first; // 链表的首节点
    private int N;

    public Bag() {
        first = null;
        N = 0;
    }

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

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagNode();
    }

    private class BagNode implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
