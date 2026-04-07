
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

    def findMedianSortedArraysOne(self, nums1: list[int], nums2: list[int]) -> float:
        """Brute force.

        1. Merge the two sorted arrays
        2. Check their length
        3. Find the median
        """
        merged: list[int] = sorted(nums1 + nums2)
        middle: int = len(merged) // 2
        if len(merged) % 2 == 0:
            return (merged[middle - 1] + merged[middle]) // 2
        else:
            return merged[middle]

    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        """Optimal.
        1. Find the length of each array
        2. Find the length of the merged array
        3. Find the position of the middle element or middle elements
        4. Find where does the smaller array fit. There are multiple cases here:
            a. Smaller array
        2.
        Second array sits in the middle of the first
        1,2,7,8
        5,6

        Second array sits in the beginning of the first
        5,6,7,8
        1,2

        Second array sits in the end of the first
        1,2,5,6
        7,8

        Intermediate condition
        1,5,8
        2,5,7
        """
        len_nums1 = len(nums1)
        len_nums2 = len(nums2)

        if len_nums1 % 2 == 0:
            # Even number
            pass
        else:
            # odd
            pass

        pass


if __name__ == "__main__":
    print(Solution().findMedianSortedArrays([1, 3], [2]))
