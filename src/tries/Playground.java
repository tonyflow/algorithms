package tries;

import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Playground {

    public static void main(String[] args) {
        String[] input = new String[]{"she", "sells", "sea", "shells", "by", "the", "sea", "shore"};

//        TrieAlphabet trieAlphabet = new TrieAlphabet();
//        for (String s : input) {
//            trieAlphabet.put(s);
//        }
//
//        System.out.println();



        Trie trie = new Trie();
        for (String word : input) {
            trie.put(word);
        }

        System.out.println(trie.get("she"));
        System.out.println(trie.get("shells"));
        System.out.println(trie.get("shell"));
        System.out.println(trie.get("shore"));
        System.out.println(trie.get("shores"));

        System.out.println();
        System.out.println("All keys");
        trie.keys().forEach(key -> System.out.println(key));

        System.out.println();
        System.out.println("Keys with prefix she");
        Queue<String> she = trie.keysWithPrefix("she");
        she.forEach(key -> System.out.println(key));
//        she.stream().collect(Collectors.toMap(String::length, Function.identity()));

        System.out.println();
        System.out.println(trie.longestPrefixOf("sh"));

//        TrieRecapII trieII = new TrieRecapII();
//        for (String word : input) {
//            trieII.put(word);
//        }
//
//        System.out.println(trieII.get("she"));
//        System.out.println(trieII.get("shells"));
//        System.out.println(trieII.get("shell"));
//        System.out.println(trieII.get("shore"));
//        System.out.println(trieII.get("shores"));

//        String[] words = {"w", "wo", "wor", "worl", "world"};
//        String[] wordsII = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
//        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
//        String result = longestWordInDictionary.find(words);
//        System.out.println(result);
//        System.out.println(longestWordInDictionary.find(wordsII));

    }
}
