package fourthlab.models.Stacks;

public class SimpleUpStack<T> implements StackInterface<T> {

    private int maxStack;
    private int emptyStack;
    private int top;
    private T[] items;

    public SimpleUpStack(int size) {
        this.maxStack = size;
        this.emptyStack = 0;
        this.top = maxStack;
        this.items = (T[]) new Object[size];
    }

    @Override
    public void push(T item) {
        if (!isFull()) {
            items[--top] = item;
            System.out.println("Pushed stack: " + item);
        } else {
            System.out.println("Stack is full. Cannot push item " + item);
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T item = items[top++];
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
            System.out.println("Last added item = " + items[top]);
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public boolean isFull() {
        return (top == emptyStack);
    }

    @Override
    public boolean isEmpty() {
        return (top == maxStack);
    }

    @Override
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Simple down stack elements:");
            for (int i = top; i < maxStack; i++) {
                System.out.println("Item nr " + (i + 1) + ": " + items[i]);
            }
            System.out.println();
        }
    }
}
