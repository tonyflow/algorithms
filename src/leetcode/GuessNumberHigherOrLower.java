package leetcode;

public class GuessNumberHigherOrLower {

    int guessNumber(int n) {
        int low = 1;
        int high = n;

        int middle = -1;
        while (low <= high) {
            middle = (high - low) / 2 + low;
            if (guess(middle) < 0) {
                high = middle - 1;
            } else if (guess(middle) > 0) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return middle;
    }

    int guess(int n) {
        return -1;
    }
}
