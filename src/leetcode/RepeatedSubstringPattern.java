package leetcode;

public class RepeatedSubstringPattern {

    static boolean faster(String s) {
        if (s.length() < 2) return false;
        int constructorLength = 1;
        int a = 0;
        int b = constructorLength;
        while (constructorLength < s.length() / 2 + 1) {
            while (b < s.length() && s.charAt(a % constructorLength) == s.charAt(b)) {
                a++;
                b++;
            }
            if (b == s.length() && b%constructorLength == 0) {
                return true;
            } else {
                a = 0;
                constructorLength++;
                b = constructorLength;
            }
        }

        return false;
    }

    static boolean repeatedSubstringPattern(String s) {

        if (s.length() < 2) return false;

        // Find potential start
        int to = 1;
        while (to < s.length() / 2 + 1) {
            String potentialConstructor = s.substring(0, to);
            String rest = s.substring(to);

            // The potentialConstructor could be the one we're looking for
            if (rest.startsWith(potentialConstructor)) {
                boolean found = true;
                int start = 0;
                int end = to;
                while (end <= rest.length() && found) {
                    String match = rest.substring(start, end);
                    if (match.equals(potentialConstructor)) {
                        start += to;
                        end += to;
                    } else {
                        found = false;
                    }
                }

                if (found && start == rest.length()) return true;
            }

            to++;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(repeatedSubstringPattern("abab"));
//        System.out.println(repeatedSubstringPattern("ababab"));
//        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
//        System.out.println(repeatedSubstringPattern("aba"));

        System.out.println(faster("abab"));
        System.out.println(faster("ababab"));
        System.out.println(faster("abcabcabcabc"));
        System.out.println(faster("aba"));
        System.out.println(faster("aabaaba"));
    }
}
