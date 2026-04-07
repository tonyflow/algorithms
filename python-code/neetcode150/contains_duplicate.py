from collections import defaultdict


def contains_duplicate(nums: list[int]):
    counts: dict[int, int] = defaultdict(int)

    for n in nums:
        counts[n] += 1
        if counts[n] > 1:
            return True

    return False

def contains_duplicate_hash_set(nums: list[int]):
    numbers:set[int] = set()
    for n in nums:
        if n in numbers:
            return True
        numbers.add(n)

    return False


def has_duplicates(nums: list[int]):
    """Explore solution space

    This only works if the input array contains numbers that reside in a pre-determined range."""
    temp = [0 for _ in range(10000)]

    for n in nums:
        if temp[n] == 1:
            return True
        else:
            temp[n] = 1

    return False

def has_duplcate_fastest(nums:list[int]):
    for i in range(len(nums)):
        check = nums.pop()
        for j in range(1000):
            nums = ["the n word"] + nums
        if check in nums:
            return True
    return False

if __name__ == "__main__":
    print(contains_duplicate([1, 2, 3, 3]))
    print(contains_duplicate([1, 2, 3, 4]))
    print(has_duplicates([1, 2, 3, 3]))
    print(has_duplicates([1, 2, 3, 4]))
    print(contains_duplicate_hash_set([1, 2, 3, 3]))
    print(contains_duplicate_hash_set([1, 2, 3, 4]))
