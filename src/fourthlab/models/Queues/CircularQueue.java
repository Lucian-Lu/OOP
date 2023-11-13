package fourthlab.models.Queues;

import java.util.Queue;

public class CircularQueue<T> implements QueueInterface<T> {

    private T[] items;
    private int size;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        this.size = size;
        this.items = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue item: " + item);
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % size;
            items[rear] = item;
            System.out.println("Enqueued item: " + item);
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        } else {
            T dequeuedItem = items[front];
            items[front] = null;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println("Dequeued item: " + dequeuedItem);
            return dequeuedItem;
        }
    }

    @Override
    public void peek() {
        if (!isEmpty()) {
            System.out.println(items[front]);
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public boolean isFull() {
        return (front == (rear + 1) % size);
    }

    @Override
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Circular queue elements:");
            int i = front;
            do {
                System.out.println("Item nr " + (i + 1) + ": " + items[i]);
                i = (i + 1) % size;
            } while (i != (rear + 1) % size);
        }
    }
}