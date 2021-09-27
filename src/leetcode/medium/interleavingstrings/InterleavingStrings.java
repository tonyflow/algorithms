package leetcode.medium.interleavingstrings;

public class InterleavingStrings {

    public boolean isInterleave(String a, String b, String c) {
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
        if (a.length() + b.length() > c.length() || a.length() + b.length() < c.length()) return false;
        Boolean[][] memo = new Boolean[a.length()][b.length()];
        return interleaveWithMemoizationSubString(a, 0, b, 0, c, 0, memo);
    }

    private boolean interleaveWithMemoizationSubString(String a,
                                                       int indexA,
                                                       String b,
                                                       int indexB,
                                                       String dst,
                                                       int indexDst,
                                                       Boolean[][] memo) {
        // The base cases are the cases where we cannot interleave the two strings anymore and this is when
        // we have reached the end for one of the two strings
        if (indexA == a.length()) {
            return b.substring(indexB).equals(dst.substring(indexDst));
        }

        if (indexB == b.length()) {
            return a.substring(indexA).equals(dst.substring(indexDst));
        }

        if (memo[indexA][indexB] != null) return memo[indexA][indexB];
        boolean useA = a.charAt(indexA) == dst.charAt(indexDst) && interleaveWithMemoizationSubString(a, indexA + 1, b, indexB, dst, indexDst, memo);
        boolean useB = b.charAt(indexB) == dst.charAt(indexDst) && interleaveWithMemoizationSubString(a, indexA, b, indexB + 1, dst, indexDst, memo);

        memo[indexA][indexB] = useA || useB;
        return memo[indexA][indexB];
    }

    public boolean isInterleaveWithMemoization(String a, String b, String c) {
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
        if (a.length() + b.length() > c.length() || a.length() + b.length() < c.length()) return false;
        Boolean[][] memo = new Boolean[a.length()][b.length()];

        return interleaveWithMemoizationNoSubString(a, 0, b, 0, "", c, memo);
    }

    private boolean interleaveWithMemoizationNoSubString(String a,
                                                         int indexA,
                                                         String b,
                                                         int indexB,
                                                         String path,
                                                         String dst,
                                                         Boolean[][] memo) {
        if (indexA == a.length() && indexB == b.length()) {
            return path.equals(dst);
        }

        if (indexA == a.length())
            memo[indexA - 1][indexB] = interleaveWithMemoizationNoSubString(a, indexA, b, indexB + 1, path + b.charAt(indexB), dst, memo);
        else if (indexB == b.length())
            memo[indexA][indexB - 1] = interleaveWithMemoizationNoSubString(a, indexA + 1, b, indexB, path + a.charAt(indexA), dst, memo);
        else
            memo[indexA][indexB] = interleaveWithMemoizationNoSubString(a, indexA, b, indexB + 1, path + b.charAt(indexB), dst, memo) ||
                    interleaveWithMemoizationNoSubString(a, indexA + 1, b, indexB, path + a.charAt(indexA), dst, memo);

        if (indexA == a.length()) return memo[indexA - 1][indexB];
        if (indexB == b.length()) return memo[indexA][indexB - 1];
        return memo[indexA][indexB];
    }

    public boolean isInterleaveWithoutMemoization(String a, String b, String c) {
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
        if (a.length() + b.length() > c.length() || a.length() + b.length() < c.length()) return false;

        return interleaveWithoutMemoization(a, 0, b, 0, "", c);
    }

    private boolean interleaveWithoutMemoization(String a,
                                                 int indexA,
                                                 String b,
                                                 int indexB,
                                                 String path,
                                                 String dst) {
        if (indexA == a.length() && indexB == b.length()) {
            return path.equals(dst);
        }

        if (indexA == a.length())
            return interleaveWithoutMemoization(a, indexA, b, indexB + 1, path + b.charAt(indexB), dst);
        if (indexB == b.length())
            return interleaveWithoutMemoization(a, indexA + 1, b, indexB, path + a.charAt(indexA), dst);

        return interleaveWithoutMemoization(a, indexA, b, indexB + 1, path + b.charAt(indexB), dst) ||
                interleaveWithoutMemoization(a, indexA + 1, b, indexB, path + a.charAt(indexA), dst);
    }
}
