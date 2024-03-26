from typing import *


class Solution:

    def __init__(self):
        self.result: Set[List[int]] = set()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self._do_combine(candidates, 0, [], target)
        return self.result

    def _do_combine(self, candidates: List[int],
                    path_sum: int,
                    candidates_in_path: List[int],
                    target: int):

        if path_sum > target:
            return

        if path_sum == target:
            self.result.add(tuple(sorted(candidates_in_path)))
            return

        for c in candidates:
            candidates_in_path.append(c)
            self._do_combine(candidates, path_sum + c, candidates_in_path, target)
            candidates_in_path.pop()


if __name__ == '__main__':
    s: Solution = Solution()
    print(s.combinationSum([2, 3, 6, 7], 7))
