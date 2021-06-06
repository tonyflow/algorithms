package leetcode;

public class ReverseStringII {

    static String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(k, chars, i);
        }


        return new String(chars);
    }

    private static void reverse(int k, char[] chars, int i) {
        int start = i;
        int end = i + k - 1 >= chars.length ? chars.length - 1 : i + k - 1;
        while (start <= end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
//        System.out.println(reverseStr("abcd", 4));
//        System.out.println(reverseStr("abcd", 2));
//        System.out.println(reverseStr("abcdefg", 2));
//        System.out.println(reverseStr("abcdefg", 8));
        System.out.println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",39));

//        "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdf ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql imjkfnqcqnajmebeddqsgl"
//        "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql lgsqddebemjanqcqnfkjmi"
//        "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql imjkfnqcqnajmebeddqsgl"
//        "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql imjkfnqcqnajmebeddqsgl"
    }
}
