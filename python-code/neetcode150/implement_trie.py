class TrieNode:
    def __init__(self):
        self.children: dict[str, TrieNode] = {}
        self.is_end: bool = False


class PrefixTree:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.is_end = True

    def search(self, word: str) -> bool:
        node = self._traverse(word)

        return node is not None and node.is_end

    def startsWith(self, prefix: str) -> bool:
        node = self._traverse(prefix)

        return node is not None

    def _traverse(self, word_or_prefix: str) -> TrieNode | None:
        node = self.root
        for ch in word_or_prefix:
            if ch not in node.children:
                return None
            node = node.children[ch]

        return node


if __name__ == "__main__":
    trie = PrefixTree()
    trie.insert('good')
    trie.insert('goodies')
    print(f'Found {trie.search('good')}')
    print(f'Found {trie.search('goodie')}')
    print(f'Found {trie.startsWith('goodie')}')
    print(f'Found {trie.search('goodies')}')
    print(f'Found {trie.search('god')}')
