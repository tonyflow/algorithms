class Solution:
    """
    Interesting post on binary search for solution space search
    https://leetcode.com/problems/koko-eating-bananas/solutions/769702/python-clear-explanation-powerful-ultimate-binary-search-template-solved-many-problems
    """

    def mySqrt(self, x: int) -> int:
        """
        9
        left,right = 0,9
        middle = 0 + (9-2)//2 = 0+6//2 = 3


        36
        left,right = 0,36
        middle = 0 + (36-0)//2 = 0 + 18 = 18
        18*18 = 324 > 36
        right = middle - 1 = 17
        ======
        middle = 0 + (17 - 0)//2 = 0 + 8 = 8
        8*8 = 64 > 36
        right = middle - 1 = 8 - 1 = 7
        ======
        middle = 0 + (7 - 0)//2 = 0 + 3 = 3
        3*3 = 9 <=36
        left = 3
        ======
        middle = 3 + (7-3)//2 = 3 + 2 = 5
        5*5 = 25 <= 36
        left = 5
        ======
        middle = 5 + (7-5)//2 = 5 + 1 = 6
        6*6 = 36 <= 36
        left = 6
        ======
        middle = 6 + (7-6)//2 = 6 + 0 = 6
        6*6 = 36 <= 36
        left = 6
        """
        left, right = 1, x

        while left <= right:
            middle: int = left + (right - left) // 2
            if middle * middle == x:
                return middle
            elif middle * middle < x:
                left = middle + 1
            else:
                right = middle - 1

            print(right, left)

        return right


if __name__ == "__main__":
    solution = Solution()
    print(solution.mySqrt(8))
