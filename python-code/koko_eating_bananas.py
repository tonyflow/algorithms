from typing import *
from math import ceil


class Solution:
    """
    Interesting post on binary search for solution space search
    https://leetcode.com/problems/koko-eating-bananas/solutions/769702/python-clear-explanation-powerful-ultimate-binary-search-template-solved-many-problems
    """

    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)

        def is_feasible(eating_speed: int) -> bool:
            total_hours = 0
            for pile in piles:
                if pile % eating_speed == 0:
                    total_hours += pile / eating_speed
                else:
                    total_hours += pile / eating_speed + 1

            return total_hours <= h

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
