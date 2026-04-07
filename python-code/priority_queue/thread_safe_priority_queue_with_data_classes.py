import heapq
from dataclasses import dataclass


# The order directive is very important here since this is what is actually
# imposes the ordering/comparator here.
@dataclass(order=True)
class Foo:
    priority: int
    b: int


if __name__ == '__main__':
    pq = []
    heapq.heappush(pq, Foo(3, 2))
    heapq.heappush(pq, Foo(2, 2))
    heapq.heappush(pq, Foo(1, 2))

    while pq:
        print(heapq.heappop(pq))
