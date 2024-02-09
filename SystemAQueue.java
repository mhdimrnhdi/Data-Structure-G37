
package assignment;

class SystemAQueue<T> {
    private static final int InitialSize = 10;
    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public SystemAQueue() {
        this(InitialSize);
    }

    public SystemAQueue(int capacity) {
        array = new Object[capacity];
        head = 0;
        tail = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            resize();
        }
        tail = (tail + 1) % array.length;
        array[tail] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) array[head];
        head = (head + 1) % array.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];

        int index = 0;
        for (int i = head; i <= tail; i++) {
            newArray[index++] = array[i % array.length];
        }

        array = newArray;
        head = 0;
        tail = size - 1;
    }
}
