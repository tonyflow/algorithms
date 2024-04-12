from typing import *
from math import ceil


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 0, max(piles)

        def is_feasible(i: int) -> bool:
            total_hours = 0
            for pile in piles:
                total_hours += ceil(pile / i) + 1 if pile % i != 0 else 0

            return total_hours >= h

        while left < right:
            mid = left + (right - left) // 2
            if is_feasible(mid):
                right = mid
            else:
                left = mid + 1

        return left

    def binary_search(self, r: List[int]) -> int:
        def condition(i: int) -> bool:
            pass

        left, right = 0, len(r) - 1
        while left < right:
            mid = left + (right - left) // 2
            if condition(mid):
                right = mid
            else:
                left = mid - 1

        return left
