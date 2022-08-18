package leetcode.hard;

import java.util.*;

public class MaximumFrequencyStack {

    class FreqStackQueue {

        class Node {
            int val;
            int insertionOrder;

            public Node(int val, int insertionOrder) {
                this.val = val;
                this.insertionOrder = insertionOrder;
            }

            int reverseInsertionOrder() {
                return -this.insertionOrder;
            }
        }

        Map<Integer, Integer> valToFrequency;
        Map<Integer, PriorityQueue<Node>> frequencyToVals;
        int maxFreq;
        int insertionOrder;

        public FreqStackQueue() {
            valToFrequency = new HashMap();
            frequencyToVals = new HashMap();
        }

        public void push(int val) {
            int updatedFrequency = valToFrequency.getOrDefault(val, 0) + 1;
            valToFrequency.put(val, updatedFrequency);

            // Update frequency to vals
            if (frequencyToVals.containsKey(updatedFrequency)) {
                frequencyToVals.get(updatedFrequency).offer(new Node(val, insertionOrder++));
            } else {
                PriorityQueue<Node> q = new PriorityQueue(Comparator.comparingInt(Node::reverseInsertionOrder));
                q.offer(new Node(val, insertionOrder++));
                frequencyToVals.put(updatedFrequency, q);
            }

            maxFreq = Math.max(maxFreq, updatedFrequency);
        }

        public int pop() {
            Node polled = frequencyToVals.get(maxFreq).poll();
            if (frequencyToVals.get(maxFreq).size() == 0) maxFreq--;
            valToFrequency.put(polled.val, valToFrequency.get(polled.val) - 1);
            return polled.val;
        }
    }

    class FreqStackStack {

        Map<Integer, Integer> valToFrequency;
        Map<Integer, Stack<Integer>> frequencyToVals;
        int maxFreq;


        public FreqStackStack() {
            this.valToFrequency = new HashMap();
            this.frequencyToVals = new HashMap();
            this.maxFreq = 0;
        }

        public void push(int val) {
            if (!valToFrequency.containsKey(val)) {
                valToFrequency.put(val, 1);
                if (!frequencyToVals.containsKey(1)) {
                    Stack<Integer> update = new Stack();
                    frequencyToVals.put(1, update);
                }
                frequencyToVals.get(1).push(val);
                maxFreq = Math.max(maxFreq, 1);
            } else {
                int updatedFreq = valToFrequency.get(val) + 1;
                valToFrequency.put(val, updatedFreq);

                if (frequencyToVals.containsKey(updatedFreq)) {
                    Stack<Integer> update = new Stack();
                    frequencyToVals.put(updatedFreq, update);
                }

                frequencyToVals.get(updatedFreq).push(val);
                maxFreq = Math.max(maxFreq, updatedFreq);
            }
        }


        public int pop() {
            Integer popped = frequencyToVals.get(maxFreq).pop();
            valToFrequency.put(popped, valToFrequency.get(popped) - 1);
            if (frequencyToVals.get(maxFreq).size() == 0) maxFreq--;
            return popped;
        }
    }

}
