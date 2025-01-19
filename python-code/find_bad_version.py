class Solution:
    def firstBadVersion(self, n: int) -> int:
        """
        1,2,3,4,4,5,6,6
        """
        left: int = 1
        right: int = n
        while left < right:
            middle = left + (right - left) // 2
            if self.isBadVersion(middle):
                right = middle
            else:
                left = middle + 1

        return left

    def isBadVersion(self, version: int) -> bool:
        return True
