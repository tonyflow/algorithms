from typing import List


class Solution:
    """
    Interesting post on binary search for solution space search
    https://leetcode.com/problems/koko-eating-bananas/solutions/769702/python-clear-explanation-powerful-ultimate-binary-search-template-solved-many-problems
    """

    def shipWithinDays(self, weights: List[int], days: int) -> int:
        max_capacity = sum(weights)
        left, right = max(weights), max_capacity

        def can_ship(capacity_under_review: int) -> bool:
            carrying: int = 0
            days_needed: int = 1
            for w in weights:
                if carrying + w > capacity_under_review:
                    days_needed += 1
                    carrying = w
                else:
                    carrying += w

            return days_needed <= days

        while left < right:
            middle: int = left + (right - left) // 2
            if can_ship(middle):
                right = middle
            else:
                left = middle + 1

        return right
