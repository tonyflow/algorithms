from typing import *


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        """
        dp[x] carries the length of the longest subsequence which ends
        at x
        """
        dp: List[int] = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    dp[j] = max(1 + dp[j], dp[i])

        # print(dp)
        return max(dp)


if __name__ == "__main__":
    solution: Solution = Solution()
    print(solution.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))
