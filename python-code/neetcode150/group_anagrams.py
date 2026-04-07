from itertools import groupby


def group_anagrams(strs: list[str]) -> list[list[str]]:
    """
    word = anagram of existing group or new group
    [a,b,c,d,e,f,g] = [[a,d],[b],[c,e],[f],[g]]
    """

    def is_anagram(a: str, b: str):
        if len(a) != len(b):
            return False

        return sorted(a) == sorted(b)

    groups: list[list[str]] = []
    for word in strs:
        for group in groups:
            if is_anagram(word, group[0]):
                group.append(word)
                break
        else:
            groups.append([word])

    return groups


def group_anagrams_hash(strs: list[str]) -> list[list[str]]:
    groups: dict[list[int], list[list[str]]] = {}

    def compute_hash(s: str):
        key: list[int] = [0] * 26
        for i in range(len(s)):
            key[ord(s[i]) - ord("a")] += 1

        return key

    for word in strs:
        word_k = compute_hash(word)
        if word_k in groups:
            groups[word_k].append(word)
        else:
            groups[word_k] = word


if __name__ == "__main__":
    print(group_anagrams(["act", "pots", "tops", "cat", "stop", "hat"]))
