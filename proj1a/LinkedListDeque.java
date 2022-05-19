public class LinkedListDeque<T> {
    // internal class node
    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        final private T value;

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

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

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

    public T removeFirst() {
        if (isEmpty()) {
            return null;
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

    public T removeLast() {
        if (isEmpty()) {
            return null;
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
