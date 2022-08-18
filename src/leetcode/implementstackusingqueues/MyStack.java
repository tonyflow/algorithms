package leetcode.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> a;
    Queue<Integer> b;
    Integer top;

    public MyStack() {
        a = new LinkedList();
        b = new LinkedList();
    }

    public void push(int x) {
        a.add(x);
        top = x;
    }

    public int pop() {
        while (a.size() > 1)
            b.add(a.poll());

        int polled = a.poll();
        while (b.size() > 1)
            a.add(b.poll());

        if(!b.isEmpty()){
            top = b.peek();
            a.add(b.poll());
        }

        return polled;

    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return a.size() == 0;
    }
}
