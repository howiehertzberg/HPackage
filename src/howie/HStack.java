package howie;

/**
 * The {@code HStack} class represents a stack data structure that allows
 * pushing and popping of elements using Last-In-First-Out (LIFO) logic.
 *
 * @param <T> the type of objects held in this stack
 * @author Howie Hertzberg
 */
public final class HStack<T> {

    private final Object[] stackArray;
    private final int capacity;
    private int topPtr;

    /**
     * Constructs a new {@code HStack} with the specified capacity.
     *
     * @param capacity the maximum number of elements the stack can hold
     * @throws IllegalArgumentException if the specified capacity is negative
     */
    public HStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack capacity must be positive.");
        }
        this.stackArray = new Object[capacity];
        this.capacity = capacity;
        this.topPtr = -1;
    }

    /**
     * Attempts to push an item onto the stack.
     *
     * @param item the object to push
     * @throws IllegalArgumentException if the specified object is null
     * @throws IllegalStateException if the stack is full
     */
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Object cannot be null.");
        }
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        }
        stackArray[++topPtr] = item;
    }

    /**
     * Attempts to pop an item from the stack.
     *
     * @return the popped item
     * @throws IllegalStateException if the queue is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T item = (T) stackArray[topPtr];
        stackArray[topPtr--] = null;
        return item;
    }

    /**
     * Attempts to retrieve the top element from the stack.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return (T) stackArray[topPtr];
    }

    /**
     * Clears all elements from the stack.
     */
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }
    /**
     * Checks if the stack is full.
     *
     * @return {@code true} if the stack is full, {@code false} otherwise
     */
    public boolean isFull() {
        return topPtr + 1 == capacity;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return topPtr == -1;
    }

}
