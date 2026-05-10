import heapq


class KthLargest:
    def __init__(self, k: int, nums: list[int]):
        self.numbers = [n for n in nums]
        heapq.heapify(self.numbers)
        self.k = k

    def add(self, val: int) -> int:
        # We want a max heap so we are multipying by -1
        heapq.heappush(self.numbers, val)
        while len(self.numbers) > self.k:
            heapq.heappop(self.numbers)

        return self.numbers[0]

    # def add(self, val: int) -> int:
    #     heapq.heappush(self.numbers, val)
    #     return heapq.nlargest(self.k, self.numbers)
