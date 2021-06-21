package leetcode.implementtrieprefixtree;

public class Playground {

    public static void main(String[] args) {
        ImplementTriePrefixTree implementTriePrefixTree = new ImplementTriePrefixTree();
        String[] words = {"she",
                "sells",
                "sea",
                "shells",
                "by",
                "the",
                "sea",
                "shore"};

        String[] moreWords = {"she",
                "sells",
                "sea",
                "shells",
                "by",
                "the",
                "sea",
                "shore",
                "fuck",
                "you",
                "am",
                "famous"
        };

        for (String word : words) {
            implementTriePrefixTree.put(word);
        }

        for (String word : moreWords) {
            System.out.println(implementTriePrefixTree.get(word));
        }
    }
}
