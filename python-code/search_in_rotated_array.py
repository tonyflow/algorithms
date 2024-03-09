from typing import *


def search_in_rotated(r: List[int], target: int) -> int:
    start: int = 0
    end: int = len(r) - 1
    # find the rotation point
    while start < end:
        middle: int = (start + end) // 2
        if r[middle] > r[end]:
            start = middle + 1
        else:
            end = middle

    # Define new start and end. At this point start==end==middle
    if r[start] < target <= r[len(r) - 1]:
        end = len(r) - 1
    else:
        start = 0
        end -= 1

    # Perform binary search
    while start < end:
        middle = (start + end)
        if target > r[middle]:
            start = middle + 1
        elif target < r[middle]:
            end = middle - 1
        else:
            return middle

    return -1


if __name__ == '__main__':
    print(search_in_rotated([7, 8, 9, 10, 1, 2], 8))
