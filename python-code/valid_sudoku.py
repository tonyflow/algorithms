from typing import *


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        for i in range(9):
            row_count: Dict = {}
            for j in range(9):
                if board[i][j] != '.':
                    num_count = row_count.get(int(board[i][j]), 0)
                    num_count += 1
                    if num_count > 1:
                        return False
                    row_count[int(board[i][j])] = num_count

        for j in range(9):
            column_count: Dict = {}
            for i in range(9):
                if board[j][i] != '.':
                    num_count = column_count.get(int(board[j][i]), 0)
                    num_count += 1
                    if num_count > 1:
                        return False

                    column_count[int(board[j][i])] = num_count

        for k in range(0, 9, 3):
            for l in range(0, 9, 3):
                # print(f'Square for k={k} and l={l}')
                square_count: Dict = {}
                for i in range(k, k + 3):
                    for j in range(l, l + 3):
                        # print(f'i=[{i}],j=[{j}] and board[{i}][{j}]={board[i][j]}')
                        if board[i][j] != '.':
                            num_count = square_count.get(int(board[i][j]), 0)
                            num_count += 1
                            if num_count > 1:
                                return False

                            square_count[int(board[i][j])] = num_count
                            # print(f'Square count after new number occurrence {square_count}')

        return True


if __name__ == '__main__':
    s: Solution = Solution()
    invalid = [["8", "3", ".", ".", "7", ".", ".", ".", "."]
        , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
        , [".", "9", "8", ".", ".", ".", ".", "6", "."]
        , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
        , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
        , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
        , [".", "6", ".", ".", ".", ".", "2", "8", "."]
        , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
        , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    board = [["5", "3", ".", ".", "7", ".", ".", ".", "."]
        , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
        , [".", "9", "8", ".", ".", ".", ".", "6", "."]
        , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
        , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
        , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
        , [".", "6", ".", ".", ".", ".", "2", "8", "."]
        , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
        , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    print(s.isValidSudoku(board))
    print(s.isValidSudoku(invalid))
