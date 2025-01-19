from collections import deque
from typing import Deque

if __name__ == "__main__":
    d: Deque = deque()

    d.append(1)
    d.append(2)
    d.append(3)
    d.append(4)
    d.append(5)

    while d:
        item = d.pop(0)
        print(item)
