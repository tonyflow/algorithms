class Solution:
    def __init__(self):
        self.longest_length: int = 0

    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if text1 == text2:
            return len(text1)

        self.traverse(text1, text2, 0)

        return self.longest_length

    def traverse(self, a: str, b: str, local_longest: int):
        """
        abc
        bc
        t(abc,c)
            t(abc,None)
                return with no side effects
            t(bc,c)
                t(c,c) ll=1
                    t(None,None)
                t(bc,None)
                    return with no side effects
        t(bc,bc)
            t(c,c)
                t(None,None)
        """

        if not a and not b:
            self.longest_length = max(self.longest_length, local_longest)

        if not a or not b:
            return

        if a[0] == b[0]:
            self.traverse(a[1:], b[1:], local_longest + 1)
            return

        self.traverse(a, b[1:], local_longest)
        self.traverse(a[1:], b, local_longest)


if __name__ == "__main__":
    print(Solution().longestCommonSubsequence("abcde", "ace"))
    print(Solution().longestCommonSubsequence("abc", "abc"))
    print(Solution().longestCommonSubsequence("abc", "def"))
