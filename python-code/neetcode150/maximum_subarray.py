class Solution:
    def __init__(self):
        self.max = float("-inf")

    def maxSubArray(self, nums: list[int]) -> int:
        self._traverse(nums, 0, 0)
        return self.max

    def _traverse(self, nums: list[int], current_index: int, current_sum: int):

        if current_index == len(nums):
            return

        self.max = max(self.max, current_sum)
        # 1. Keep this index or
        self._traverse(nums, current_index + 1, current_sum + nums[current_index])

        # 2. Stop here and start a new subarray
        self._traverse(nums, current_index + 1, nums[current_index])


if __name__ == "__main__":
    s = Solution()
    result = s.maxSubArray([2,-3,4,-2,2,1,-1,4])
    print(result)