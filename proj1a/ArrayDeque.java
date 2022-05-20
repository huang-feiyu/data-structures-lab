public class ArrayDeque<T> {

    private static final int INIT_CAPACITY = 8;
    private int capacity;
    private int head;
    private int tail;
    private T[] array;

    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        head = tail = 0;
        array = (T[]) new Object[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
    }

    public void addFirst(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (isEmpty()) {
            array[head] = item;
            tail++;
            return;
        }
        if (size() == capacity - 1) {
            extendArray();
        }
        array[(head - 1 + capacity) % capacity] = item;
    }

    public void addLast(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        array[tail] = item;
        tail = (tail + 1) % capacity;
        if (size() == capacity - 1) {
            extendArray();
        }
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return (capacity + tail - head) % capacity;
    }

    public void printDeque() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size() == capacity / 4 && capacity != INIT_CAPACITY) {
            shortenArray();
        }
        T item = array[head];
        head = (head + 1) % capacity;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size() == capacity / 4 && capacity != INIT_CAPACITY) {
            shortenArray();
        }
        T item = array[tail - 1];
        tail = (tail - 1 + capacity) % capacity;
        return item;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        int arrayIndex = (head + index) % capacity;
        return array[arrayIndex];
    }

    /**
     * copy from the first, twice the previous array
     */
    private void extendArray() {
        T[] newArray = (T[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = array[(i + head) % capacity];
        }
        head = 0;
        tail = capacity;
        capacity *= 2;
        array = newArray;
    }

    /**
     * copy from the first
     */
    private void shortenArray() {
        T[] newArray = (T[]) new Object[capacity / 2];
        for (int i = 0; i < capacity / 4; i++) {
            newArray[i] = array[(i + head) % capacity];
        }
        head = 0;
        tail = capacity / 4;
        capacity /= 2;
        array = newArray;
    }
}
