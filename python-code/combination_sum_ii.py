from typing import *

"""
[1,2,3,4,4,5,6,6]
"""


class Solution:
    def __init__(self):
        self.result: Set[Set[int]] = set()

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        return_value: Set[frozenset[int]] = set()
        self._do_combine(candidates, 0, [], target)

        deduplicated_list = [
            list(s)
            for s in set(
                frozenset(sublist)
                for sublist in map(
                    lambda indexes: map(lambda i: candidates[i], indexes), self.result
                )
            )
        ]
        # print(f'Deduplicated list {deduplicated_list}')
        # print(f'Final result with indexes {self.result}')
        # # Map result to return value
        # for partial in self.result:
        #     partial_return_value = []
        #     for index in partial:
        #         partial_return_value.append(candidates[index])
        #     return_value.add(frozenset(partial_return_value))
        return deduplicated_list

    def _do_combine(
        self,
        candidates: List[int],
        path_sum: int,
        candidates_in_path: List[int],
        target: int,
    ):
        if not candidates or path_sum > target:
            return

        if path_sum == target:
            self.result.add(frozenset(candidates_in_path))
            return

        for c_index in range(len(candidates)):
            if c_index not in candidates_in_path:
                candidates_in_path.append(c_index)
                self._do_combine(
                    candidates,
                    path_sum + candidates[c_index],
                    candidates_in_path,
                    target,
                )
                candidates_in_path.pop()


if __name__ == "__main__":
    print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
