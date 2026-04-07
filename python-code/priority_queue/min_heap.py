import heapq

if __name__ == "__main__":
    a: list[int] = [1, 50, 2, 57, 4, 60, 7, 8, 9, 100, 10]

    # This creates a min heap structure inside the given
    heapq.heapify(a)
    # print(heapq.heapify(a))

    while a:
        print(heapq.heappop(a))
