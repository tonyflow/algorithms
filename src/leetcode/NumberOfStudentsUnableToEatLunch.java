package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch {

    int faster(int[] students, int[] sandwiches) {
        int[] numberOfStudentsThatPreferEitherOneOrZero = new int[2];

        for (int student : students) {
            numberOfStudentsThatPreferEitherOneOrZero[student]++;
        }

        for (int sandwich : sandwiches) {
            if (numberOfStudentsThatPreferEitherOneOrZero[sandwich] == 0) {
                return numberOfStudentsThatPreferEitherOneOrZero[Math.abs(sandwich - 1)];
            }
            numberOfStudentsThatPreferEitherOneOrZero[sandwich]--;
        }

        return 0;
    }

    static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichStack = new Stack<>();
        Queue<Integer> studentsQueue = new LinkedList<>();
        int[] numberOfStudentsThatPreferEitherOneOrZero = new int[2];
        int[] numOfOneOrZeroSandwiches = new int[2];

        // Create stack
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.add(sandwiches[i]);
            numOfOneOrZeroSandwiches[sandwiches[i]]++;
        }

        //Create queue
        for (int student : students) {
            studentsQueue.add(student);
            numberOfStudentsThatPreferEitherOneOrZero[student]++;
        }

        while (!sandwichStack.isEmpty()) {
            if (sandwichStack.peek() == studentsQueue.peek()) {
                Integer sandwichType = sandwichStack.pop();
                numOfOneOrZeroSandwiches[sandwichType]--;

                Integer foodieType = studentsQueue.poll();
                numberOfStudentsThatPreferEitherOneOrZero[foodieType]--;

            } else {
                if (numberOfStudentsThatPreferEitherOneOrZero[sandwichStack.peek()] != 0) {
                    Integer toTheEndOfTheLine = studentsQueue.poll();
                    studentsQueue.add(toTheEndOfTheLine);
                } else return studentsQueue.size();
            }

        }

        return studentsQueue.size();
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}


