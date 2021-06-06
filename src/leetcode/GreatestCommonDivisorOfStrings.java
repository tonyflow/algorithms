package leetcode;

public class GreatestCommonDivisorOfStrings {

    static String euclidean(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);

    }

    static String gcdOfStrings(String str1, String str2) {


        // Let's assume that str2 is the greatest common divisor
        // If this is true then str1 can be written as str2+str2+...+str2
        // If this is not the case then remove the last character and try again
        // Do this until we either find the greatest common divisor or we fail
        String referenceA = str1;
        String referenceB = str2;
        String compareAgainst = str1.length() > str2.length() ? str2 : str1;


        while ((!referenceA.isEmpty() || !referenceB.isEmpty()) && !compareAgainst.isEmpty()) {
            if (referenceA.startsWith(compareAgainst)) {
                referenceA = referenceA.substring(compareAgainst.length());
            }

            if (referenceB.startsWith(compareAgainst)) {
                referenceB = referenceB.substring(compareAgainst.length());
            }

            if ((!referenceA.startsWith(compareAgainst) && !referenceA.isEmpty()) || (!referenceB.startsWith(compareAgainst) && !referenceB.isEmpty())) {
                compareAgainst = compareAgainst.substring(0, compareAgainst.length() - 1);

                // Reset referenceA and referenceB
                referenceA = str1;
                referenceB = str2;
            }
        }

        return compareAgainst;
    }


    public static void main(String[] args) {
//        System.out.println(gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
//        System.out.println(gcdOfStrings("LEET", "CODE"));
//        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));

        System.out.println(euclidean("ABCABC", "ABC"));
        System.out.println(euclidean("ABABAB", "ABAB"));
        System.out.println(euclidean("LEET", "CODE"));
        System.out.println(euclidean("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));

//        "TAUXX TAUXX TAUXX TAUXX TAUXX"
//        "TAUXX TAUXX TAUXX TAUXX TAUXX TAUXX TAUXX TAUXX TAUXX"
    }
}
