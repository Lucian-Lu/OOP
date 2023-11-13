package fourthlab.models.Queues;

public interface QueueInterface<T> {

    void enqueue(T item);

    T dequeue();

    void peek();

    boolean isFull();

    boolean isEmpty();

    void printQueue();
}
