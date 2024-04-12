import time
from typing import *
import os


class Piece:
    def __init__(self, coordinates: List[Tuple[int, int]]):
        self.coordinates = coordinates


class TetrisBoard:
    def __init__(self, m, n):
        self.m = m
        self.n = n
        self.board: List[List[str]] = []

        for i in range(m):
            self.board.append(['.'] * (n - 1))

        # self.draw_board()

    def draw_board(self):
        # os.system('cls' if os.name == 'nt' else 'clear')
        print('\n' * 100)
        for i, row in enumerate(self.board):
            print(f'{i} {' '.join(row)}\n')

        print('\n\n\n')

    def compute_next_position(self, piece_next: Piece) -> Optional[Piece]:
        new_coordinates: List[Tuple[int, int]] = [(x + 1, y) for x, y in piece_next.coordinates]

        # Housekeeping
        # contain piece inside board limits
        return Piece(new_coordinates) if self._check_inside_board(new_coordinates) else None

    def _check_inside_board(self, new_coordinates: List[Tuple[int, int]]):
        return all([0 <= c[0] < self.m and 0 <= c[1] < self.n for c in new_coordinates])

    def draw_piece(self, piece_to_draw: Piece):
        for coordinate in piece_to_draw.coordinates:
            self.board[coordinate[0]][coordinate[1]] = 'o'

    def clear_piece(self, piece_to_clear: Piece):
        for coordinate in piece_to_clear.coordinates:
            self.board[coordinate[0]][coordinate[1]] = '.'

    def fall(self, piece_to_drop: Piece):

        """
        Stops falling when one of the coordinates overlaps with an already drawn part of the board
        - compute the next coordinates
        - if one of the coordinates overlaps with an already drawn part of the board then do not draw the next piece
        - otherwise keep falling
        """

        last_known_position: Optional[Piece] = None
        while piece_to_drop and self.does_not_overlap(piece_to_drop):
            last_known_position = piece_to_drop
            self.draw_piece(piece_to_drop)
            self.draw_board()
            time.sleep(1)
            piece_on_new_location = self.compute_next_position(piece_to_drop)
            if piece_on_new_location:
                self.clear_piece(piece_to_drop)

            piece_to_drop = piece_on_new_location

        if last_known_position:
            self.fix_piece(last_known_position)

    def fix_piece(self, piece_to_fix: Piece):
        for coordinate in piece_to_fix.coordinates:
            self.board[coordinate[0]][coordinate[1]] = 'x'

    def does_not_overlap(self, potentially_overlapping_piece: Piece) -> bool:
        return all([self.board[coordinate[0]][coordinate[1]] != 'x' for coordinate in
                    potentially_overlapping_piece.coordinates])


if __name__ == "__main__":
    square_coordinates = [(0, 0), (1, 0), (0, 1), (1, 1)]
    board: TetrisBoard = TetrisBoard(10, 20)
    # piece: Piece = Piece(coordinates=[(1, 2), (1, 3), (1, 2), (2, 3)])
    piece: Piece = Piece(square_coordinates)
    board.fall(piece)
    board.fall(piece)
