package fourthlab.models.Stacks;

public class LinkedStack<T> implements StackInterface<T> {

    private class Node<T> {
        T item;
        Node<T> next;

        public Node(T data) {
            this.item = data;
            this.next = null;
        }
    }

    private Node<T> top;

    public LinkedStack() {
        this.top = null;
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed stack " + item);
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T item = top.item;
            top = top.next;
            System.out.println("Popped stack: " + item);
            return item;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    @Override
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Last added item = " + top.item);
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Linked stack elements:");
            Node<T> current = top;
            int i = 1;
            while (current != null) {
                System.out.println("Item nr " + i + ": " + current.item);
                current = current.next;
                i++;
            }
            System.out.println();
        }
    }
}
