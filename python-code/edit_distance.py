from typing import *


class Solution:

    def __init__(self):
        self.alphabet: List[str] = [chr(ord('a') + i) for i in range(26)]
        self.result = float('inf')

    def minDistance(self, word1: str, word2: str) -> int:

        if not word1:
            return len(word2)

        if not word2:
            return len(word1)

        if word1[0] == word2[0]:
            return self.minDistance(word1[1:], word2[1:])

        # Try insertions
        min_insertions_cost: int = 1 + self.minDistance(word1, word2[1:])

        # Try deletion
        min_deletions_cost: int = 1 + self.minDistance(word1[1:], word2)

        # Try substitutions
        min_substitutions_cost: int = 1 + self.minDistance(word1[1:], word2[1:])

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
