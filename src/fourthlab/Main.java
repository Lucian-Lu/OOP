package fourthlab;

import fourthlab.behavior.ApplicationLoop;
import fourthlab.models.Queues.*;
import fourthlab.models.Stacks.*;

public class Main {
    public static void main(String[] args) {
//        SimpleDownStack<Integer> stack1 = new SimpleDownStack<>(5);
//        stack1.push(1);
//        stack1.push(1);
//        stack1.push(1);
//        stack1.push(1);
//        stack1.push(4);
//        stack1.printStack();
//        stack1.peek();
//        stack1.pop();
//        stack1.push(5);
//        stack1.printStack();
//        stack1.peek();
//        SimpleUpStack<Integer> stack2 = new SimpleUpStack<>(5);
//        stack2.push(1);
//        stack2.push(1);
//        stack2.push(1);
//        stack2.push(1);
//        stack2.push(4);
//        stack2.printStack();
//        stack2.peek();
//        stack2.pop();
//        stack2.push(5);
//        stack2.printStack();
//        stack2.peek();
//        LinkedStack<Integer> stack3 = new LinkedStack<>();
//        stack3.push(1);
//        stack3.push(1);
//        stack3.push(1);
//        stack3.push(1);
//        stack3.push(4);
//        stack3.printStack();
//        stack3.peek();
//        stack3.pop();
//        stack3.push(5);
//        stack3.printStack();
//        stack3.peek();


//        SimpleQueue<Integer> queue1 = new SimpleQueue<>(5);
//        queue1.enqueue(3);
//        queue1.enqueue(5);
//        queue1.printQueue();
//        queue1.dequeue();
//        queue1.printQueue();
//        queue1.enqueue(4);
//        queue1.enqueue(1);
//        queue1.printQueue();
//        CircularQueue<Integer> queue2 = new CircularQueue<>(5);
//        queue2.enqueue(3);
//        queue2.enqueue(5);
//        queue2.printQueue();
//        queue2.dequeue();
//        queue2.printQueue();
//        queue2.enqueue(4);
//        queue2.enqueue(1);
//        queue2.enqueue(5);
//        queue2.enqueue(6);
//        queue2.printQueue();
//        PriorityQueue<Integer> queue3 = new PriorityQueue<>();
//        queue3.enqueuePriority(1, 3);
//        queue3.enqueuePriority(3, 1);
//        queue3.enqueuePriority(6, 2);
//        queue3.printQueue();
//        queue3.enqueuePriority(12, 2);
//        queue3.printQueue();
//        queue3.dequeue();
//        queue3.printQueue();
        ApplicationLoop app = new ApplicationLoop();
        app.run();
    }
}
