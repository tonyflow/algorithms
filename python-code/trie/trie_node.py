from typing import *


class TrieNode:
    def __init__(self):
        self.children: Dict[str, TrieNode] = {}
        self.end_of_word: bool = False
