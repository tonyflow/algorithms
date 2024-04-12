from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) - 1
        result: List[int] = []

        # Find first occurrence
        while left < right:
            mid: int = left + (right - left) // 2
            if nums[mid] >= target:
                right = mid
            else:
                left = mid + 1

        result.append(left)

        # Find last occurrence
        left, right = 0, len(nums) - 1
        while left < right:
            mid: int = left + (right - left) // 2
            if nums[mid] <= target:
                left = mid
            else:
                right = mid - 1

        result.append(left)
        return result
