package leetcode.hard.designsearchautocompletesystem;

public class Playground {

    public static void main(String[] args) {
        String[] sentences = {
                "i love you",
                "island",
                "ironman",
                "i love leetcode"
        };

        int[] times = {5, 3, 2, 2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
        Trie trie = autocompleteSystem.getTrie();
        for (char c : new char[]{'i', ' ', 'l', 'a'}) {
            System.out.println(autocompleteSystem.input(c));
            System.out.println("===============================================");
        }

        System.out.println(trie);
    }
}
