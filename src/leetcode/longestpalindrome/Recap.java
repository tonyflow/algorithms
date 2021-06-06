package leetcode.longestpalindrome;

import java.util.Arrays;

public class Recap {

    static int longestPalindrome(String s) {
        int[] counts = new int[52];
        Arrays.fill(counts,0);

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                counts[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }

        int length = 0;
        boolean foundOneCount = false;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0 && counts[i] % 2 != 0) {
                foundOneCount = true;
                counts[i]-=1;
            }
            length += counts[i];
        }

        return foundOneCount ? length + 1 : length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
