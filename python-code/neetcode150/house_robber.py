class Solution:
    def __init__(self):
        self.max = float("-inf")

    def rob(self, nums: list[int]) -> int:
        """House robber.

        A robber can either:
        a. Rob the current house on location X and move
        to the location X + 2 or
        b. Do not rob the house and move to the next one.

        Once we run out of houses to rob we need to update
        the maximum amount of money
        """
        self._traverse(nums, 0, 0)
        return self.max

    def _traverse(self, nums: list[int], house_index: int, money: int):
        if house_index >= len(nums) - 1:
            self.max = max(self.max, money)
            return

        # Rob the current house
        self._traverse(nums, house_index + 2, money + nums[house_index])

        # Do NOT rob the current house
        self._traverse(nums, house_index + 1, money)


if __name__ == "__main__":
    """Trace [2, 9, 8, 3, 6]
    This is not really an integer though
    2
        8
            6
        3
            None => Update
        Avoid
            6 => Update

        
    
    
    """
    s = Solution()
    the_max = s.rob(nums=[1, 1, 3, 3])
    print(the_max)

    the_max = s.rob(nums=[2, 9, 8, 3, 6])
    print(the_max)
