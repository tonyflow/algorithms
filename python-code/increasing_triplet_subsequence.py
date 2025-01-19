from typing import *


class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        dp: List[int] = [1] * len(nums)

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    dp[j] = max(dp[j] + 1, dp[i])

        # print(dp)
        return max(dp) >= 3

    def increasingTripletBruteForce(self, nums: List[int]) -> bool:
        """
        Brute forcing this
        """
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    for k in range(j + 1, len(nums)):
                        if nums[k] > nums[j]:
                            return True
        return False


if __name__ == "__main__":
    solution: Solution = Solution()
    # print(solution.increasingTriplet([4, 5, 2147483647, 1, 2]))
    print(solution.increasingTriplet([5, 1, 6]))
