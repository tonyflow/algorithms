from collections import defaultdict
import heapq


def top_k_frequent_elements(nums: list[int], k: int):
    # Mapping number to count
    counts: dict[int, int] = defaultdict(int)
    for n in nums:
        counts[n] += 1

    r = [[count, number] for number, count in counts.items()]
    r.sort()

    result = []
    while k > 0:
        result.append(r.pop()[1])
        k -= 1

    return result


def top_k_frequent_elements_heap(nums: list[int], k: int):
    # Mapping number to count
    counts: dict[int, int] = defaultdict(int)
    for n in nums:
        counts[n] += 1

    minheap: list[list[int]] = []
    for n, count in counts.items():
        heapq.heappush(minheap, (count, n))
        if len(minheap) > k:
            popped = heapq.heappop(minheap)
            print(f"Popped {popped} as smallest")

    result = []
    while minheap:
        result.append(heapq.heappop(minheap)[1])

    return result


if __name__ == "__main__":
    print(top_k_frequent_elements([1, 2, 3, 4, 4, 4, 4, 4], 2))
    print(top_k_frequent_elements_heap([1, 2, 3, 4, 4, 4, 4, 4], 2))
