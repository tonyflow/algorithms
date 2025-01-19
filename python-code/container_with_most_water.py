from typing import *


def maxArea(height: List[int]) -> int:
    start: int = 0
    end: int = len(height) - 1
    max_area: int = -1

    while start < end:
        iteration_area = min(height[start], height[end]) * (end - start)
        max_area = max(max_area, iteration_area)
        if height[start] < height[end]:
            start += 1
        else:
            end -= 1

    return max_area


if __name__ == "__main__":
    print(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
    print(maxArea([1, 1]))
