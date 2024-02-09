
package assignment;

class SystemCStack<T> {
    private static final int InitialSize = 10;
    private Object[] arr;
    private int top;
    private int size;

    public SystemCStack() {
        this(InitialSize);
    }

    public SystemCStack(int capacity) {
        arr = new Object[capacity];
        top = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(T data) {
        if (isFull()) {
            resize();
        }
        arr[++top] = data;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null; // Alternatively, throw an exception for an empty stack
        }
        T data = (T) arr[top--];
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null; // Alternatively, throw an exception for an empty stack
        }
        return (T) arr[top];
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("---------------------------");
    }

    private void resize() {
        int newCapacity = arr.length * 2;
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }
}


