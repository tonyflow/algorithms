if __name__ == '__main__':
    """
       + and * on sequences
       """
    print([1, 2, 3] * 5)
    print('abc' * 5)

    ttt_board = [['_'] * 3 for _ in range(3)]
    print(f'Tic Tac Toe board {ttt_board}')
    ttt_board[0][1] = 'O'
    print(f'Tic Tac Toe board after a move{ttt_board}')

    """
    The following code is syntactic sugar for this
    row = ['_'] * 3 board = []
    for i in range(3):
        board.append(row)
    The outer list has a reference to one inner list
    """
    weird_tt_board = [['_'] * 3] * 3
    print(f'Weird/Wrong Tic Tac Toe board {weird_tt_board}')
    weird_tt_board[0][1] = 'O'
    print(f'Weird/Wrong Tic Tac Toe board after a move{weird_tt_board}')

    """
    This covers augmented assignment operators += and *= in sequences
    """
    al = [1, 2]
    print(id(al))
    al *= 2
    print(id(al))
    t = (1, 2)
    print(id(t))
    t *= 5
    print(id(t))
