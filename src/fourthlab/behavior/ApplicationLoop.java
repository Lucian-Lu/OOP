package fourthlab.behavior;


import fourthlab.models.Queues.*;
import fourthlab.models.Stacks.*;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class ApplicationLoop {
    private Scanner scanner;

    public ApplicationLoop() {
        scanner = new Scanner(System.in);
    }

    public void closeScanner() {
        scanner.close();
    }

    public void run() {
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("Queue/Stack application system:\n" +
                    "stack[size] - choose one of the 3 available stack types\n" +
                    "queue[size] - choose one of the 3 available queue types\n" +
                    "q - quit program\n\n" +
                    "> ");
            String option = scanner.nextLine();
            String[] optionCommands = option.split("[\\[\\]]");
            switch (optionCommands[0]) {
                case "stack":
                    keepLooping = stack(Integer.parseInt(optionCommands[1]));
                    System.out.println("\n");
                    break;
                case "queue":
                    keepLooping = queue(Integer.parseInt(optionCommands[1]));
                    System.out.println("\n");
                    break;
                case "q":
                    keepLooping = false;
                    closeScanner();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public boolean stack(int size) {
        System.out.print("Available stacks:\n" +
                "1 - Simple down stack\n" +
                "2 - Simple up stack\n" +
                "3 - Simple linked list stack\n" +
                "b - go back\n" +
                "q - quit\n\n" +
                "> ");
        String option = scanner.nextLine();
        boolean keepLooping = true;
        switch (option) {
            case "1":
                SimpleDownStack simpleDownStack = new SimpleDownStack(size);
                while (keepLooping) {
                    keepLooping = stackOperations(simpleDownStack);
                }
                break;
            case "2":
                SimpleUpStack simpleUpStack = new SimpleUpStack(size);
                while (keepLooping) {
                    keepLooping = stackOperations(simpleUpStack);
                }
                break;
            case "3":
                LinkedStack linkedStack = new LinkedStack();
                while (keepLooping) {
                    keepLooping = stackOperations(linkedStack);
                }
                break;
            case "b":
                return true;
            case "q":
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    public boolean queue(int size) {
        System.out.print("Available queues:\n" +
                "1 - Simple queue\n" +
                "2 - Circular queue\n" +
                "3 - Priority queue\n" +
                "b - go back\n" +
                "q - quit\n\n" +
                "> ");
        String option = scanner.nextLine();
        boolean keepLooping = true;
        switch (option) {
            case "1":
                SimpleQueue simplequeue = new SimpleQueue(size);
                while (keepLooping) {
                    keepLooping = queueOperations(simplequeue);
                }
                break;
            case "2":
                CircularQueue circularQueue = new CircularQueue(size);
                while (keepLooping) {
                    keepLooping = queueOperations(circularQueue);
                }
                break;
            case "3":
                PriorityQueue priorityQueue = new PriorityQueue();
                while (keepLooping) {
                    keepLooping = queueOperations(priorityQueue);
                }
                break;
            case "b":
                return true;
            case "q":
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    public <T> boolean stackOperations(StackInterface<? super T> stack) {
        if (stack instanceof LinkedStack) {
            System.out.println("Size parameter overwritten. Linked stack has infinite size.");
        }
        System.out.print("Available stack operations:\n" +
                "push[item] - push an item\n" +
                "pop - pop a stack item\n" +
                "peek - view last added item\n" +
                "full - check if stack is full\n" +
                "empty - check if stack is empty\n" +
                "print - print all stack elements\n" +
                "b - go back\n\n" +
                "> ");
        String option = scanner.nextLine();
        String[] optionCommands = option.split("[\\[\\]]");

        switch (optionCommands[0]) {
            case "push":
                stack.push((T) optionCommands[1]);
                break;
            case "pop":
                stack.pop();
                break;
            case "peek":
                stack.peek();
                break;
            case "full":
                System.out.println("Stack is full? " + stack.isFull());
                break;
            case "empty":
                System.out.println("Stack is empty? " + stack.isEmpty());
                break;
            case "print":
                stack.printStack();
                break;
            case "b":
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    public <T> boolean queueOperations(QueueInterface<? super T> queue) {
        System.out.print("Available queue operations:\n" +
                "enqueue[item][priority] - enqueue an item\n" +
                "-------------^^^^^^^^^^ - only for priority queue\n" +
                "dequeue - dequeue a queue item\n" +
                "peek - view last added item\n" +
                "full - check if queue is full\n" +
                "empty - check if queue is empty\n" +
                "print - print all queue elements\n" +
                "b - go back\n\n" +
                "> ");
        String option = scanner.nextLine();
        String[] optionCommands = option.split("[\\[\\]]+");
        switch (optionCommands[0]) {
            case "enqueue":
                if (!(queue instanceof PriorityQueue)) {
                    queue.enqueue((T) optionCommands[1]);
                    break;
                } else {
                    ((PriorityQueue<? super T>) queue).enqueuePriority((T) optionCommands[1],
                            Integer.parseInt(optionCommands[2]));
                }
            case "dequeue":
                queue.dequeue();
                break;
            case "peek":
                queue.peek();
                break;
            case "full":
                System.out.println("Stack is full? " + queue.isFull());
                break;
            case "empty":
                System.out.println("Stack is empty? " + queue.isEmpty());
                break;
            case "print":
                queue.printQueue();
                break;
            case "b":
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }
}
