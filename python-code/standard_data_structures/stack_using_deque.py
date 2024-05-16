from collections import deque
from typing import Deque

if __name__ == '__main__':
    """
    Deque is optimised for accessing elements located at the ends of 
    the data structure
    """
    d: Deque[int] = deque()
    d.append(1)
    d.append(2)

    while d:
        print(d.pop())
