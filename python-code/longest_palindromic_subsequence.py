class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        def traverse(left: int, right: int) -> int:
            if left == right:
                return 1

            if left > right:
                return 0

            if s[left] == s[right]:
                # All possible directions
                return 2 + traverse(left + 1, right - 1)

            # The characters at positions left and right are not the same
            return max(traverse(left, right - 1), traverse(left + 1, right))

        return traverse(0, len(s) - 1)
