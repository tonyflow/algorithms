class Solution:
    def __init__(self):
        self.visited: set[tuple[int, int]] = set()
        self.directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    def exist(self, board: list[list[str]], word: str) -> bool:

        ROWS = len(board)
        COLS = len(board[0])

        def helper(i: int, j: int, word_index: int):

            if word_index == len(word):
                return True

            # Out of bounds
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
                return False

            # Already visited
            if (i, j) in self.visited:
                return False

            # Performance optimization for matching
            if word[word_index] != board[i][j]:
                return False

            self.visited.add((i, j))

            found = (
                helper(i, j + 1, word_index + 1)
                or helper(i, j - 1, word_index + 1)
                or helper(i + 1, j, word_index + 1)
                or helper(i - 1, j, word_index + 1)
            )

            self.visited.remove((i, j))
            return found

        for i in range(ROWS):
            for j in range(COLS):
                self.visited.clear()
                found = helper(i, j, 0)
                if found:
                    return True
        return False


# if __name__ == "__main__":
#     s = Solution()
#     found = s.exist(
#         board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
#         word="ABCCED",
#     )

#     print(f"Found {found}")

#     found = s.exist(
#         board=[["A", "B", "C", "D"], ["S", "A", "A", "T"], ["A", "C", "A", "E"]],
#         word="CAT",
#     )

#     print(f"Found {found}")

#     found = s.exist(
#         board=[["A", "B", "C", "D"], ["S", "A", "A", "T"], ["A", "C", "A", "E"]],
#         word="BAT",
#     )

#     print(f"Found {found}")
