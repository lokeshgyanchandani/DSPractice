package com.ds.misc.yieldbook;

import java.util.Stack;

public class QuickInsertQueue implements PriorityQueue {

    Stack<QueueItem> s;

    public void queue(QueueItem q) {
        int priority = q.priority();
        QueueItem top = s.peek();
        if (top == null) {
            top = q;
        } else {
            if (priority > top.priority()) {
                s.push(q);
            } else {
                // else pop all the elements from this stack to another stack which
                // has priority greater than this new element and then place the new
                // element in original stack and then push back all the popped
                // elements from temporartuy stack to new stack. This way we can
                // maintain highest pripority elemnt on the top of stack
            }
        }
    }

    @Override
    public QueueItem dequeue() {

        return s.pop();
    }

}
