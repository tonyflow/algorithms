package leetcode;

public class ValidPalindrome {
    // aba + aba
    // abc + abc == abc + abc
    static boolean isPalindrome(String s) {
        char[] cleanCharArray = s.replaceAll(" ", "").replaceAll("\\p{Punct}", "").toLowerCase().toCharArray();
        int start = 0;
        int end = cleanCharArray.length - 1;
        while (start <= end) {
            if (cleanCharArray[start] != cleanCharArray[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean usingStringBuffer(String s) {
        String clean = s.replaceAll(" ", "").replaceAll("\\p{Punct}", "").toLowerCase();
        return (new StringBuilder(clean).reverse()).toString().equals(clean);
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("race a car"));
        System.out.println(usingStringBuffer("A man, a plan, a canal: Panama"));
    }
}
