from typing import *


def two_sum(r: List[int], target: int) -> (int, int):
    diffs: Dict[int, int] = {}
    for i in range(len(r)):
        diffs[r[i]] = i
        print(f"Iteration {i} and diffs {diffs}")

    for i in range(len(r)):
        k = target - r[i]
        if diffs[k]:
            print(f"Found {k}")
            return i, diffs[target - r[i]]
        else:
            print(f"Not found {k}")
    return -1


if __name__ == "__main__":
    print(two_sum([2, 7, 11, 15], 9))
