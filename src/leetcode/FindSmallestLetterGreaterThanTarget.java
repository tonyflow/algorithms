package leetcode;

public class FindSmallestLetterGreaterThanTarget {

    // 0 1 2
    // c f j
    // a
    static char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) return letters[0];

        int start = 0;
        int end = letters.length - 1;
        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (letters[middle] <= target) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }

        // Exit condition is start == end
        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // f
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')); // f
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g')); // j
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); // c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k')); // c
    }
}
