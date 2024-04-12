from typing import *

if __name__ == '__main__':
    queue: List[int] = []
    queue.append(1)
    queue.append(2)
    queue.append(3)
    queue.append(4)

    while queue:
        print(queue.pop(0))
