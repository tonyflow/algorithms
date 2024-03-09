from typing import List


def binary_search(r: List[int], target: int):
    start = 0
    end = len(r) - 1

    while start <= end:
        middle = (start + end) // 2

        if r[middle] < target:
            start = middle + 1
        elif r[middle] > target:
            end = middle - 1
        else:
            return middle

    # nothing is found
    return -1


if __name__ == '__main__':
    print(binary_search([1, 2, 3, 12, 56, 63, 100], 100))
