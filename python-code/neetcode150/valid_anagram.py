def is_anagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False

    return sorted(s) == sorted(t)


from collections import defaultdict


def using_hashmap(s: str, t: str):
    count_s: dict[str, int] = defaultdict(int)
    count_t: dict[str, int] = defaultdict(int)

    if len(s) != len(t):
        return False

    for i in range(len(s)):
        count_t[s[i]] += 1
        count_t[t[i]] += 1

    # for char, count in count_s.items():
    #     if char not in count_t:
    #         return False

    #     if count != count_t[char]:
    #         return False

    # return True

    return count_t == count_s


def fixed_size_array(s: str, t: str):
    """Using the limited size of the solution space.

    Increment the count in the array for every character we find in s.
    Decrement the count in the array for every character we find in t.
    """
    if len(s) != len(t):
        return False

    counts = [0] * 26

    for i in range(len(s)):
        counts[ord(s[i]) - ord("a")] += 1
        counts[ord(t[i]) - ord("a")] -= 1

    for c in counts:
        if c != 0:
            return False

    return True


if __name__ == "__main__":
    print(using_hashmap("catt", "tac"))
    print(fixed_size_array("catt", "tac"))
