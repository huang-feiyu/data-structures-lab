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
        if (size() == capacity - 1) {
            extendArray();
        }
        head = (head - 1 + capacity) % capacity;
        array[head] = item;
    }

    public void addLast(T item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (size() == capacity - 1) {
            extendArray();
        }
        array[tail] = item;
        tail = (tail + 1) % capacity;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return (capacity + tail - head) % capacity;
    }

    public void printDeque() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = array[head];
        head = (head + 1) % capacity;
        if (size() == capacity / 4 && capacity != INIT_CAPACITY) {
            shortenArray();
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        tail = (tail - 1 + capacity) % capacity;
        T item = array[tail];
        if (size() == capacity / 4 && capacity != INIT_CAPACITY) {
            shortenArray();
        }
        return item;
    }

    public T get(int index) {
        if (index >= size() || index < 0 || isEmpty()) {
            return null;
        }
        return array[(head + index) % capacity];
    }

    /**
     * copy from the first, twice the previous array
     */
    private void extendArray() {
        printDeque();
        T[] newArray = (T[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = get(i);
        }
        head = 0;
        tail = capacity - 1;
        capacity *= 2;
        array = newArray;
        printDeque();
    }

    /**
     * copy from the first
     */
    private void shortenArray() {
        T[] newArray = (T[]) new Object[capacity / 2];
        for (int i = 0; i < capacity / 4; i++) {
            newArray[i] = get(i);
        }
        head = 0;
        tail = capacity / 4;
        capacity /= 2;
        array = newArray;
    }
}
