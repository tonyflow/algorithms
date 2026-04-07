def twoSum(nums: list[int], target: int) -> list[int]:
    # Create diff map: Diff to index that creates that diff is
    diffs: dict[int, int] = {}
    for i in range(len(nums)):
        diffs[target - nums[i]] = i

    def is_same_number() -> bool:
        return diffs[nums[i]] == i

    for i in range(len(nums)):
        if nums[i] in diffs and not is_same_number():
            return i, diffs[nums[i]]


def two_sum_one_pass(nums: list[int], target: int) -> list[int]:
    """We do not need to create the entire diffs map.

    We can search for the compliment in the array as we're creating the diffs map
    """

    def is_same_number() -> bool:
        return diffs[nums[i]] == i

    # Create diff map: Diff to index that creates that diff is
    diffs: dict[int, int] = {}
    for i in range(len(nums)):
        diffs[target - nums[i]] = i
        if nums[i] in diffs and not is_same_number():
            return i, diffs[nums[i]]


def twoSumSort(nums: list[int], target: int) -> list[int]:
    sorted_nums = sorted(nums)
    left: int = 0
    right: int = len(nums)

    while left < right:
        if sorted_nums[left] + sorted_nums[right] > target:
            pass
        elif sorted_nums[left] + sorted_nums[right] < target:
            pass
        else:
            return [left, right]


if __name__ == "__main__":
    print(twoSum(nums=[3, 4, 5, 6], target=7))
    print(twoSum(nums=[4, 5, 6], target=10))
    print(twoSum(nums=[5, 5], target=10))
