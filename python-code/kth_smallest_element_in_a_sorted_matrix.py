import heapq
from typing import *


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        pq: List[int] = []
        for row in matrix:
            for element in row:
                heapq.heappush(pq, element)

        for _ in range(k - 1):
            heapq.heappop(pq)
        print(pq)
        return pq[0]


if __name__ == '__main__':
    solution: Solution = Solution()
    print(
        solution.kthSmallest(
            matrix=[[1, 5, 9], [10, 11, 13], [12, 13, 15]],
            k=8)
    )
