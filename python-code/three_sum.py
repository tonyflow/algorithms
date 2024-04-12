from typing import *


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sorted_nums = sorted(nums)
        result: List[List[int]] = []

        for i in range(len(nums) - 2):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                to_check = sorted_nums[i] + sorted_nums[j] + sorted_nums[k]
                if to_check == 0:
                    result.append([sorted_nums[i], sorted_nums[j], sorted_nums[k]])
                    k -= 1
                    j += 1
                elif to_check > 0:
                    k -= 1
                else:
                    j += 1

        return result


if __name__ == '__main__':
    print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
