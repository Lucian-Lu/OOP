package fourthlab.models.Stacks;

public class SimpleDownStack<T> implements StackInterface<T> {

    private int maxStack;
    private int emptyStack;
    public int top;
    private T[] items;

    public SimpleDownStack(int size) {
        this.maxStack = size;
        this.emptyStack = 0;
        this.top = emptyStack;
        this.items = (T[]) new Object[size];
    }

    @Override
    public void push(T item) {
        if (!isFull()) {
            items[top] = item;
            System.out.println("Pushed stack: " + item);
            top++;
        } else {
            System.out.println("Stack is full. Cannot push item " + item);
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T item = items[--top];
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
            System.out.println("Last added item = " + items[top - 1]);
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public boolean isFull() {
        return (top == maxStack);
    }

    @Override
    public boolean isEmpty() {
        return (top == emptyStack);
    }

    @Override
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Simple up stack elements:");
            for (int i = top - 1; i >= 0; i--) {
                System.out.println("Item nr " + (i + 1) + ": " + items[i]);
            }
            System.out.println();
        }
    }
}
