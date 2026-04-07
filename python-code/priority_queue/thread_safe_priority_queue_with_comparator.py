import queue
from dataclasses import dataclass


class Bar:
    def __init__(self, a: int, b: int, c: int):
        self.a = a
        self.b = b
        self.c = c

    def __lt__(self, other):
        return self.c > other.c

    def __str__(self):
        return f"Bar({self.a},{self.b},{self.c})"


if __name__ == "__main__":
    pq: queue.PriorityQueue[Bar] = queue.PriorityQueue()
    pq.put(Bar(1, 2, 3))
    pq.put(Bar(1, 4, 5))
    pq.put(Bar(1, 6, 7))
    pq.put(Bar(1, 8, 9))

    while not pq.empty():
        print(pq.get_nowait())
