import heapq

if __name__ == "__main__":
    pq = []

    heapq.heappush(pq, (3, 5, 1))
    heapq.heappush(pq, (3, 5, 1))
    heapq.heappush(pq, (3, 5, 1))
    heapq.heappush(pq, (3, 5, 1))
    heapq.heappush(pq, (3, 5, 1))
    heapq.heappush(pq, (3, 5, 1))
    # heapq.heappush(pq, (3, 3, 1))
    # heapq.heappush(pq, (3, 2, 1))
    # heapq.heappush(pq, (3, 4, 1))

    while pq:
        print(heapq.heappop(pq))
