package leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    class MyQueue {

        Stack<Integer> one;
        Stack<Integer> two;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            this.one = new Stack<>();
            this.two = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            one.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (one.size() != 1) {
                two.push(one.pop());
            }
            Integer result = one.pop();
            while (!two.isEmpty()) {
                one.push(two.pop());
            }
            return result;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (one.size() != 1) {
                two.push(one.pop());
            }
            Integer result = one.peek();
            while (!two.isEmpty()) {
                one.push(two.pop());
            }
            return result;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return one.size() == 0;
        }
    }
}
