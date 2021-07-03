package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    static class Pair {
        int temperature;
        int index;

        public Pair(int temperature, int index) {
            this.index = index;
            this.temperature = temperature;
        }
    }

    static public int[] dailyTemperatures(int[] temperatures) {

        Stack<Pair> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
                Pair popped = stack.pop();
                result[popped.index] = i - popped.index;
            }
            stack.add(new Pair(temperatures[i], i));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//        int[] ints = dailyTemperatures(new int[]{30,40,50,60});
//        int[] ints = dailyTemperatures(new int[]{30, 60, 90});
        System.out.println(Arrays.toString(ints));
    }
}
