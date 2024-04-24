from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        """
        1,2,3,7,9,11
        target=3 ==> 2
        target=6 ==> 3


        """
        left, right = 0, len(nums)
        while left < right:
            middle: int = left + (right - left) // 2
            if nums[middle] >= target:
                right = middle
            else:
                left = middle + 1

        return left


if __name__ == '__main__':
    solution = Solution()
    print(solution.searchInsert([1, 2, 3, 7, 9, 11], 6))
