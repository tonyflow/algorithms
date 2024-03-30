import heapq
from typing import *


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        temp: List[int] = []
        for n in nums:
            heapq.heappush(temp, -1 * n)

        for _ in range(k - 1):
            heapq.heappop(temp)

        print(temp)
        return -temp[0]


if __name__ == '__main__':
    solution: Solution = Solution()
    print(solution.findKthLargest([3, 2, 1, 5, 6, 4], 2))
    print(solution.findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6], 4))
