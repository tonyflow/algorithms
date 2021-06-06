package leetcode;

public class ReverseString {

    public void reverseString(char[] s) {
        int right = 0;
        int left = s.length-1;

        while (right <= left) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            right++;
            left--;
        }
    }
}
