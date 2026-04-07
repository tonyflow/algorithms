import bisect
import random

if __name__ == "__main__":
    pq = []

    for _ in range(0, 101):
        bisect.insort(pq, random.randint(0, 1001))

    print(pq)
