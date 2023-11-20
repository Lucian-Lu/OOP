package fourthlab.models.Queues;

public class PriorityQueue<T> implements QueueInterface<T> {

    private class Node {
        T item;
        int priority;
        Node next;

        Node(T item, int priority) {
            this.item = item;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node front;

    public PriorityQueue() {
        this.front = null;
    }

    public void enqueuePriority(T item, int priority) {
        Node newNode = new Node(item, priority);

        if (front == null || priority < front.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        System.out.println("Enqueued item: " + item + " -> priority: " + priority);
    }

    @Override
    public void enqueue(T item) {
        System.out.println("Use enqueuePriority instead.");
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty. Cannot dequeue");
            return null;
        } else {
            T dequeuedItem = front.item;
            front = front.next;
            System.out.println("Dequeued item: " + dequeuedItem);
            return dequeuedItem;
        }
    }

    @Override
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Last added item = " + front.item);
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty.");
        } else {
            System.out.println("Priority Queue elements:");
            Node temp = front;
            int i = 1;
            while (temp != null) {
                System.out.println("Item nr " + i + ": " + temp.item + " -> priority: " + temp.priority);
                temp = temp.next;
                i++;
            }
        }
    }
}
