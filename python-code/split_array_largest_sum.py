from typing import List


class Solution:
    """
    The largest sum of any subarray is minimized
    - Return the minimized largest sum

     Can we split the array into several sub-arrays so that the sum
        of the elements for each of the splits is less or equal than the candidate_sum.
        Instead of figuring out all possible splits and making sure that each split has a sum which is
        less or equal to tge candidate_sum, we can prove that the candidate_sum is a good candidate through
        contradiction. In order to do that, we will try to figure out how many splits we can have by
        sequentially iterating over the elements of the array.
        [1,2,3,4,5,6,7,8], k=2
        =====
        [1],
        [2,3..]
        =====
        [1,2]
        [3,4,5..]
        =====
        [1,2,3]
        [4,5...]
        =====
        [1,2,3,4]
        [5,6...]
        =====
        [1...5]
        [6..8]
        =====
        [1...6]
        [7...8]
        =====
        [1...7]
        [8]

        Number of ways to split the array = len(nums) // k
    """

    def splitArray(self, nums: List[int], k: int) -> int:

        left, right = max(nums), sum(nums)

        def can_split(candidate_sum: int) -> bool:
            total_splits: int = 0
            total_sum: int = 0
            for n in nums:
                if total_sum + n > candidate_sum:
                    total_sum = 0
                    total_splits += 1
                total_sum += n

            # If we have split the array x times, then we are handling x + 1 contiguous sub-arrays thus the
            # total splits should strictly smaller than k
            return total_splits < k

        while left < right:
            middle: int = left + (right - left) // 2
            if can_split(middle):
                right = middle
            else:
                left = middle + 1

        return left


if __name__ == '__main__':
    solution: Solution = Solution()
    print(solution.splitArray([7, 2, 5, 10, 8], 2))
    print(solution.splitArray([1, 4, 4], 3))
