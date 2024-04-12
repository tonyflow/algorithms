from typing import *


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        """
        Integers are in the range [1,n]
        nums contains n+1 integers
        so if integers are in the range [1,5]
        the nums array could be [1,1,2,3,5]

        - sort the array
        - sliding window

        """
        sorted_nums = sorted(nums)
        for i in range(len(nums) - 1):
            if sorted_nums[i] == sorted_nums[i + 1]:
                return sorted_nums[i]

    def find_duplicates_array_manipulation(self, nums: List[int]) -> int:
        """
        [1,1,2,3,5]
        - [-1,1,2,3,5]
        [5,3,1,2,1]
        - [5,3,1,2,-1]
        - [5,3,-1,2,-1]
        - [-5,3,-1,2,-1]
        - [-5,-3,-1,2,-1]
        """
        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1] < 0:
                return abs(nums[i])
            else:
                nums[abs(nums[i]) - 1] = -1 * nums[abs(nums[i]) - 1]
                # print(nums)

    def find_duplicates_hare_and_the_tortoise(self, nums: List[int]) -> int:
        """
        This is Floyd's cycle detection algorithm applied to a list of numbers.
        Usually this is applied on a linked list
        [5,3,4,1,2,1]
        0 ===========
        slow = 5
        fast = 1
        1 ===========
        slow = 1
        fast = 1
        condition break the first while


        [1,3,4,2,2]
        0 ===========
        slow = 1
        fast = 3
        1 ===========
        slow = 3
        fast = 4
        2 ===========
        slow = 2
        fast = 4
        3 ===========
        slow = 4
        fast = 4
        """
        slow = nums[0]
        fast = nums[nums[0]]

        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]
            print(slow, fast)

        slow = 0

        print("Finding cycles entry point")
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
            print(slow, fast)

        return slow

    def detect_cycle(self, nums: List[int]) -> Optional[int]:
        """
        This comes from ChatGPT
        """
        if not nums or len(nums) < 2:
            return None

        tortoise = nums[0]
        hare = nums[0]

        while True:
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]
            print(tortoise, hare)

            if tortoise == hare:
                # Detected a cycle, now find the start of the cycle
                print("Finding cycle's entry point")
                tortoise = nums[0]
                while tortoise != hare:
                    tortoise = nums[tortoise]
                    hare = nums[hare]
                    print(tortoise, hare)
                return tortoise

            if tortoise == 0 or hare == 0:
                return None


if __name__ == '__main__':
    solution: Solution = Solution()
    # print(solution.find_duplicates_array_manipulation([5, 3, 1, 2, 1]))
    print("Leet code approach")
    print(solution.find_duplicates_hare_and_the_tortoise([1, 3, 4, 2, 2]))
    print("Wikipedia and ChatGPT approach")
    print(solution.detect_cycle([1, 3, 4, 2, 2]))
    # print(solution.find_duplicates_hare_and_the_tortoise([5, 3, 4, 1, 2, 1]))
