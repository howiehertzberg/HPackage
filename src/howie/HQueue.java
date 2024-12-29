package howie;

/**
 * The {@code HQueue} class represents a circular queue data structure that allows
 * enqueueing and dequeueing of objects using First-In-First-Out (FIFO) logic.
 *
 * @param <T> the type of objects held in the queue
 * @author Howie Hertzberg
 */
public final class HQueue<T> {

    private final Object[] queueArray;
    private int inPtr;
    private int outPtr;

    /**
     * Constructs a new {@code HQueue} with the specified capacity.
     *
     * @param capacity the maximum number of elements the queue can hold
     * @throws IllegalArgumentException if the specified capacity is negative
     */
    public HQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue capacity must be positive.");
        }
        this.queueArray = new Object[capacity+1];
        this.inPtr = 0;
        this.outPtr = 0;
    }

    /**
     * Attempts to enqueue an object to the queue.
     *
     * @param item the object to enqueue
     * @throws IllegalArgumentException if the specified object is null
     * @throws IllegalStateException if the queue is full
     */
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Object cannot be null.");
        }
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        queueArray[inPtr] = item;
        inPtr = (inPtr + 1) % queueArray.length;
    }

    /**
     * Attempts to dequeue an element from the queue.
     *
     * @return the dequeued element
     * @throws IllegalStateException if the queue is empty
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T item = (T) queueArray[outPtr];
        queueArray[outPtr] = null;
        outPtr = (outPtr + 1) % queueArray.length;
        return item;
    }

    /**
     * Attempts to retrieve the top element from the queue.
     *
     * @return the top element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return (T) queueArray[outPtr];
    }

    /**
     * Clears all elements from the queue.
     */
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    /**
     * Checks if the queue is full.
     *
     * @return {@code true} if the queue is full, {@code false} otherwise
     */
    public boolean isFull() {
        return (inPtr + 1) % queueArray.length == outPtr;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return inPtr == outPtr;
    }

}
