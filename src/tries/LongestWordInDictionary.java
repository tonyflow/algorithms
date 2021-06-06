package tries;

public class LongestWordInDictionary {

    String answer = "";

    String find(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.put(word);
        }

        dfs(trie.root, "",false);
        return answer;
    }

    private void dfs(Node root,
                     String soFar,
                     boolean wasPreviousPrefixAWord) {
        if (root == null) return;
        if (root.isEndOfWord && wasPreviousPrefixAWord) {
            if (soFar.length() > answer.length() || (soFar.length() == answer.length() && soFar.compareTo(answer) > 0)) {
                answer = soFar;
            }
        }

        for (char i = 0; i < 256; i++) {
            dfs(root.children[i], soFar + i, root.isEndOfWord);
        }


    }

}
