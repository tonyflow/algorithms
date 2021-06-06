package leetcode.wordbreak;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
//        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(wordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa")));
//        System.out.println(wordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
//        System.out.println(wordBreak.wordBreak("aaaaaaaa", Arrays.asList("aaaa", "aaa", "aa")));

        System.out.println(wordBreak.breakW("leetcode", Arrays.asList("leet", "code"))); //t
        System.out.println(wordBreak.breakW("applepenapple", Arrays.asList("apple", "pen"))); //t
        System.out.println(wordBreak.breakW("aaaaaaa", Arrays.asList("aaaa", "aa"))); //f
        System.out.println(wordBreak.breakW("aaaaaaa", Arrays.asList("aaaa", "aaa"))); //t
        System.out.println(wordBreak.breakW("aaaaaaaa", Arrays.asList("aaaa", "aaa", "aa"))); //t
        System.out.println(wordBreak.breakW("cars", Arrays.asList("car", "ca", "rs")));
    }
}