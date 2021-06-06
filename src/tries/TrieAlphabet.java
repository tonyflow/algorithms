package tries;

public class TrieAlphabet {

    NodeAlphabet root;

    public TrieAlphabet() {
        this.root = new NodeAlphabet();
    }

    void put(String key) {
        NodeAlphabet p = root;
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            System.out.println(i);
            if (p.children[i] == null) p.children[i] = new NodeAlphabet();
            p = p.children[i];
        }
    }
}
