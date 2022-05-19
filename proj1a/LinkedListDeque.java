public class LinkedListDeque<T> implements Deque<T> {
    // internal class node
    private static class Node<T> {
        public Node<T> prev;
        public Node<T> next;
        public T value;

        Node(T value) {
            this.prev = null;
            this.next = null;
            this.value = value;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Creates an empty linked list deque
     */
    public LinkedListDeque() {
        size = 0;
        // NOTE: first is `null`
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node<T> node = new Node<>(item);
        if (size == 0) {
            head = node;
            tail = head;
        } else {
            Node<T> oldHead = head;
            head = node;
            head.next = oldHead;
            oldHead.prev = head;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node<T> node = new Node<>(item);
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            // size = 0 case
            head = tail;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Node<T> cur = head;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println(cur.value);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T item = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T item = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /**
     * same as get above, but use recursion
     *
     * @param index from 0 to size - 1
     * @return Gets the item at the given index; null if no such item exists
     */
    public T getRecursive(int index) {
        return getRecursive(index, head);
    }

    private T getRecursive(int index, Node<T> node) {
        if (index == 0) {
            return node.value;
        }
        return getRecursive(index - 1, node.next);
    }
}
