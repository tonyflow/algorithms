import queue
import random

if __name__ == "__main__":
    pq = queue.PriorityQueue()
    for _ in range(100):
        pq.put(random.randint(0, 1000))

    while not pq.empty():
        print(pq.get_nowait())
