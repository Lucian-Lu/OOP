Fourth Lab
---
___
Describing an abstract Stack and an abstract Queue (their interfaces) and add 3 implementations for each.

---
Stacks:
1. SimpleUpStack - default/basic stack implementation. elements start from 0 and go up to maxStack size;
2. SimpleDownStack - modified version of the SimpleUpStack, elements start at maxStack size and go down to 0 instead;
3. LinkedStack - Redefined stack that uses nodes instead of arrays.

---
Queues:
1. SimpleQueue - simple queue implementation, elements start at 0 and can hold up to maxSize elements at a time; however once a dequeue happens, next item moves down.
2. CircularQueue - modified SimpleQueue implementation that overrides the oldest items without modifying the priority list.
3. PriorityQueue - queue that implements a priority list; each item has a priority, the lower the number, the faster it gets out of the queue.