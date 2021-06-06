package leetcode;

public class CheckIfTwoStringsAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
