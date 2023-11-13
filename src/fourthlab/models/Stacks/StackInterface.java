package fourthlab.models.Stacks;

public interface StackInterface<T> {

    void push(T item);

    T pop();

    boolean isFull();

    boolean isEmpty();

    void printStack();

    void peek();
}