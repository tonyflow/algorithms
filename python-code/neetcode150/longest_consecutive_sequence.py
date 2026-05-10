class Solution:
    def __init__(self):
        self.longest_consecutive = 1

    def brute(self, nums) -> int:
        if not nums or len(nums) == 1:
            return 1

        for index, e in enumerate(nums):
            longest_from_index = 1
            reference = nums[index]
            for p in nums[index:]:
                if p == reference + 1:
                    longest_from_index += 1
                    reference = p

            self.longest_consecutive = max(self.longest_consecutive, longest_from_index)

        return self.longest_consecutive

    def recursive(self, nums: list[int]) -> int:
        """
        1,2,34,3,4,5: 5

        Algorithm:
        1. Start from every element
        2. Iterate over the following elements by ignoring non consecutive ones
        3. For every consecutive one, recursively invoke the function with the rest of the array nums[x:]

        Return:
        Nothing to return, we can have a global value that we can update

        Base case:
        Array is empty

        Optimization: Memoization: As we go we can keep an array which keeps at position x
        that is the longest consecutive sequence that can start from this index

        Contract: (nums, longest_so_far)

        Update:

        State: global under longest_consecutive
        """
        if not nums:
            return 0

        for index, _ in enumerate(nums):
            """
            Trace:
            1. 1, 2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            2. 2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            3. 34, 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            4. 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            5. 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            6. 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            7. 38, 39, 40, 41, 42, 5, 6, 7, 8
            8. 39, 40, 41, 42, 5, 6, 7, 8
            9. 40, 41, 42, 5, 6, 7, 8
           10. 41, 42, 5, 6, 7, 8
           11. 42, 5, 6, 7, 8
           12. 5, 6, 7, 8
           13. 6, 7, 8
           14. 7, 8
           15. 8

            """
            # The sequence can start from any index in the array
            self._helper_traverse(nums[index:], 1)

        return self.longest_consecutive

    def _helper_traverse(
        self, nums: list[int], longest_so_far: int, recursion_level: int = 1
    ):
        """
        Trace:
        1, 2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
            2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
                1, 2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 5, 6, 7, 8
                    5, 6, 7, 8
                        6, 7, 8
                            7, 8
                                8
        """
        if not nums or len(nums) == 1:
            self.longest_consecutive = max(
                self.longest_consecutive, longest_so_far, recursion_level + 1
            )
            return

        reference: int = nums[0]
        found_next = False
        for index, n in enumerate(nums[1:], start=1):
            if n == reference + 1:
                self._helper_traverse(nums[index:], longest_so_far + 1)
                found_next = True

        if not found_next:
            self.longest_consecutive = max(
                self.longest_consecutive, longest_so_far, recursion_level + 1
            )

    def sort(self, nums: list[int]) -> int:
        if not nums:
            return 0

        if len(nums) == 1:
            return 1

        # Init state
        longest = 0

        # sort array
        nums.sort()

        # 5,4,4,4,3,1 => 1,3,4,4,4,5
        cursor: int = 0

        while cursor < len(nums):
            # How long is the streak starting from cursor
            current_longest = 1
            next_in = cursor + 1
            while next_in < len(nums):
                # If we run into a duplicate we need to move forward
                if nums[next_in] == nums[cursor]:
                    cursor += 1
                    next_in += 1
                    continue

                # If we run into a consecutive then we need to continue and update the pointers
                if nums[next_in] == nums[cursor] + 1:
                    current_longest += 1
                    cursor += 1
                    next_in += 1
                    continue

                # Sequence break, update pointers and continue
                if nums[next_in] != nums[cursor] + 1:
                    cursor += 1
                    break

            # On every inner loop we need to update the global longest sequence
            longest = max(longest, current_longest)

            if cursor == len(nums) - 1:
                break

        return longest

    def longestSequence(self, nums: list[int]) -> int:

        if nums is None:
            return 0

        if len(nums) == 0:
            return 0

        longest = 1

        unique_nums = set(nums)

        for n in unique_nums:
            current_longest = 1
            # Find actual current longest
            if n - 1 not in unique_nums:
                # If x-1 is not part of the unique elements, this should be the first element of the
                # consecutive sequence
                while n + current_longest in unique_nums:
                    current_longest += 1

            # Update global longest
            longest = max(longest, current_longest)

        return longest


if __name__ == "__main__":
    s = Solution()
    result = s.recursive([1, 2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 3, 4, 5, 6])
    print(result)

    s = Solution()
    result = s.sort([1, 2, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 3, 4, 5, 6])
    print(result)

    s = Solution()
    result = s.sort(
        [
            1,
            99,
            99,
            99,
            99,
            99,
            99,
            2,
            99,
            99,
            99,
            99,
            99,
            99,
            99,
            99,
            3,
            99,
            99,
            99,
            99,
            99,
            99,
            99,
            99,
            4,
            99,
            99,
            99,
            99,
            99,
            99,
            5,
        ]
    )
    print(result)
