package leetcode.longestpalindrome;
import java.util.Arrays;

public class LongestPalindrome {

    static public int longestPalindrome(String s) {

        // Create array of letter counts
        int[] counts = new int[128];
        Arrays.fill(counts, 0);
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        boolean foundOddCount = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] % 2 != 0) {
                counts[i] -= 1;
                foundOddCount = true;
            }
        }

        int maxOdd = 0;
        int maxLength = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                maxLength += counts[i];
            }
        }

        // For odd sized palindromes all letter counts should be 2*k apart from the middle one

        // For even letter palindromes all letter counts should be 2*k - there is no middle on in this case

        return foundOddCount ? maxLength + 1 : maxLength;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
