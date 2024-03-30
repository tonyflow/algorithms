from typing import *


class Solution:

    def __init__(self):
        self.alphabet: List[str] = [chr(ord('a') + i) for i in range(26)]
        self.result = float('inf')

    def minDistance(self, word1: str, word2: str) -> int:
        return int(self._do_find(word1, word2))

    def _do_find(self,
                 word1: str,
                 word2: str) -> float:

        print(f'Checking against word {word1}')
        if word1 == word2:
            return 0

        if not word1:
            return len(word2)

        if not word2:
            return len(word1)

        # Try insertions
        min_insertions_cost: float = float('inf')
        for i in range(len(word1)):
            for letter_to_add in self.alphabet:
                new_word: str = word1[:i] + letter_to_add + word1[i:]
                min_insertions_cost = min(min_insertions_cost, 1 + self._do_find(new_word, word2))

        # Try deletion
        min_deletions_cost: float = float('inf')
        for i in range(len(word1)):
            new_word: str = word1[:i] + word1[i + 1:]
            min_deletions_cost = min(min_deletions_cost, 1 + self._do_find(new_word, word2))

        # Try substitutions
        min_substitutions_cost: float = float('inf')
        for i in range(len(word1)):
            for letter_to_substitute_with in self.alphabet:
                new_word: str = word1[:i] + letter_to_substitute_with + word1[i + 1:]
                min_substitutions_cost = min(min_substitutions_cost, 1 + self._do_find(new_word, word2))

        return min(min_insertions_cost, min_deletions_cost, min_substitutions_cost)


if __name__ == '__main__':
    # alphabet_upper_case: List[str] = [chr(i) for i in range(65, 91)]
    # print(alphabet_upper_case)
    #
    # alphabet_lower_case: List[str] = [chr(ord('a') + i) for i in range(26)]
    # print(alphabet_lower_case)
    #
    # alphabet_upper_another_way: List[str] = [chr(ord('A') + i) for i in range(26)]
    # print(alphabet_upper_another_way)
    #
    # for letter in alphabet_upper_case:
    #     print(ord(letter))

    solution: Solution = Solution()
    print(solution.minDistance('horse', 'ros'))
