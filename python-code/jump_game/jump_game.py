from functools import lru_cache
from typing import List, Dict, Tuple
from utilities.timer import timer
import sys


class SolutionBrute:

    @timer
    def canJump(self, nums: List[int]) -> bool:
        return self.jump(nums, 0)

    def jump(self, nums: List[int], current_index: int) -> bool:
        if current_index == len(nums) - 1:
            return True

        if current_index > len(nums) - 1:
            return False

        decision = False

        for j in range(1, nums[current_index]):
            decision = decision | self.jump(nums, current_index + j)

        return decision


class SolutionMemoWithIndentation:

    def canJump(self, nums: List[int]) -> bool:
        memo: Dict[int, bool] = {}
        return self.jump(nums, memo, 0)

    def jump(self,
             nums: List[int],
             memo: Dict[int, bool],
             current_index: int,
             indentation: str = '') -> bool:
        # If we have reached the final cell, or we were able to exceed it, then return true
        if current_index >= len(nums) - 1:
            print(f'{indentation}... I was able to reach {current_index}')
            return True

        if current_index in memo:
            print(f'{indentation}... Found {current_index} in memo table and returning  {memo[current_index]}')
            return memo[current_index]

        decision = False

        for j in range(1, nums[current_index] + 1):
            decision = decision | self.jump(nums, memo, current_index + j, indentation + '\t')

        # Update memo
        print(f'{indentation}... After recursion for {current_index} decided on {decision} for CANJUMP')
        memo[current_index] = decision
        return memo[current_index]


class SolutionMemo:

    @timer
    def canJump(self, nums: List[int]) -> bool:
        memo: Dict[int, bool] = {}
        return self.jump(nums, memo, 0)

    def jump(self,
             nums: List[int],
             memo: Dict[int, bool],
             current_index: int) -> bool:
        # If we have reached the final cell, or we were able to exceed it, then return true
        if current_index >= len(nums) - 1:
            return True

        if current_index in memo:
            return memo[current_index]

        decision = False

        for j in range(1, nums[current_index] + 1):
            decision = decision | self.jump(nums, memo, current_index + j)

        # Update memo
        memo[current_index] = decision
        return memo[current_index]


class SolutionLRUCache:

    @timer
    def canJump(self, nums: List[int]) -> bool:
        return self.jump(tuple(nums), 0)

    @lru_cache(maxsize=None)
    def jump(self,
             nums: Tuple[int, ...],
             current_index: int) -> bool:
        # If we have reached the final cell, or we were able to exceed it, then return true
        if current_index >= len(nums) - 1:
            return True

        decision = False

        for j in range(1, nums[current_index] + 1):
            decision = decision | self.jump(nums, current_index + j)

        return decision


class SolutionOptimal:

    @timer
    def canJump(self, nums: List[int]) -> bool:
        maxx = 0
        for i, n in enumerate(nums):
            # If the index is bigger than the max index we can currently reach
            # then this means that index i is unreachable. Thus, we cannot reach
            # the end of the array
            if i > maxx:
                return False
            maxx = max(i + n, maxx)

        return maxx >= len(nums) - 1


if __name__ == '__main__':
    solution_lru_cache = SolutionLRUCache()
    solution_memo = SolutionMemo()
    solution_brute = SolutionBrute()
    solution_optimal = SolutionOptimal()

    # print(solution_lru_cache.canJump([2, 3, 1, 1, 4]))
    # print(solution_lru_cache.canJump([3, 2, 1, 0, 4]))
    # print(solution_memo.canJump([2, 3, 1, 1, 4]))
    # print(solution_memo.canJump([3, 2, 1, 0, 4]))
    # print(solution_brute.canJump([2, 3, 1, 1, 4]))
    # print(solution_brute.canJump([3, 2, 1, 0, 4]))

    test_case = list(range(100, -1, -1))

    print(solution_lru_cache.canJump(test_case))
    print(solution_memo.canJump(test_case))
    print(solution_optimal.canJump(test_case))
    # print(solution_brute.canJump(test_case))

    # print(sys.getrecursionlimit())
