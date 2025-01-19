import heapq

if __name__ == "__main__":
    pq = []

    heapq.heappush(pq, 2)
    heapq.heappush(pq, 23)
    heapq.heappush(pq, -2)
    heapq.heappush(pq, 45)
    heapq.heappush(pq, -234)

    while pq:
        item = heapq.heappop(pq)
        print(item)
