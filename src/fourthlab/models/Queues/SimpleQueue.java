package fourthlab.models.Queues;

public class SimpleQueue<T> implements QueueInterface<T> {

    private T[] items;
    private int size;
    public int front;
    private int rear;

    public SimpleQueue(int size) {
        this.size = size;
        this.items = (T[]) new Object[size];
        this.front = 0;
        this.rear = front;
    }

    @Override
    public void enqueue(T item) {
        if (!isFull()) {
            System.out.println("Queued item: " + item);
            items[rear] = item;
            rear = rear + 1;
        } else {
            System.out.println("Queue is full. Cannot enqueue item: " + item);
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T dequeuedItem = items[front];
            for (int i = 0; i < rear - 1; i++) {
                items[i] = items[i + 1];
            }
            items[rear - 1] = null;
            rear--;
            System.out.println("Dequeued item: " + dequeuedItem);
            return dequeuedItem;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
    }

    @Override
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Last added item = " + items[front]);
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public boolean isFull() {
        return (rear == size);
    }

    @Override
    public boolean isEmpty() {
        return (front == rear);
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Simple queue elements:");
            for (int i = 0; i < rear; i++) {
                System.out.println("Item nr " + (i + 1) + ": " + items[i]);
            }
        }
    }
}
