from typing import *
from trie_node import TrieNode


class Trie:
    def __init__(self):
        self.root: TrieNode = TrieNode()

    def insert(self, word: str):
        node: TrieNode = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.end_of_word = True

    def search(self, word: str) -> bool:
        node: TrieNode = self.root
        for c in word:
            if c not in node.children:
                return False
            node = node.children[c]

        return node.end_of_word

    def starts_with(self, prefix: str) -> bool:
        node: TrieNode = self.root
        for c in prefix:
            if c not in node.children:
                return False
            node = node.children[c]

        return True


if __name__ == "__main__":
    trie: Trie = Trie()
    trie.insert("sarcastic")
    print(trie.search("sarcastic"))
    print(trie.starts_with("sar"))
    print(trie.starts_with("sarcasti"))
    print(trie.starts_with("FOO"))
    print(trie.search("cat"))
    """
    Space: O(m), m = average number of characters in the strings inserted
    Runtime: O(m), dito
    """
