from typing import List
import heapq


class Solution:
    """
    [1,3] + [2] => 2

    median:
    - If len(r)%2==0 => (sum of middle numbers)/2
        [1,2,3,4] => {
            middle = len(r)//2
            return (r[middle-1] + r[middle])//2
        }
    - If len(r)%2!=0 => return number in the middle
        [1,2,3] => {
            middle = len(r)//2
            return r[middle]
        }

    1,2,3,4,5,6,7,8,9
    5,6

    0,1,2,3,4,5,6,7,8,9,10
    1,2,3,4,5,5,6,6,7,8,9
    median
    """

    def findMedianSortedArraysOne(self,
                                  nums1: List[int],
                                  nums2: List[int]) -> float:
        merged: List[int] = sorted(nums1 + nums2)
        middle: int = len(merged) // 2
        if len(merged) % 2 == 0:
            return (merged[middle - 1] + merged[middle]) // 2
        else:
            return merged[middle]

    def findMedianSortedArrays(self,
                               nums1: List[int],
                               nums2: List[int]) -> float:
        pass


if __name__ == '__main__':
    print(Solution().findMedianSortedArrays([1, 3], [2]))
