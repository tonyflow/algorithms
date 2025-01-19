from typing import *


class Solution:
    """
    [1,2,5],11
    1+1+1+1+1
    def do_change(coins,coins_used,path_sum,amount):
        if path_sum == amount:
            self.min = min(self.min,coins_used)

        if path_sum > amount:
            return

        for c in coins:
            do_change(coins,coins_used+1,path_sum+c,amount)
    """

    def __init__(self):
        self.min = float("inf")

    def coinChange(self, coins: List[int], amount: int) -> int:
        self.do_change(coins, 0, 0, amount)
        return self.min if self.min is not float("inf") else -1

    def do_change(self, coins, coins_used, path_sum, amount):
        if path_sum == amount:
            self.min = min(self.min, coins_used)

        if path_sum > amount:
            return

        for c in coins:
            self.do_change(coins, coins_used + 1, path_sum + c, amount)

    def do_change_memo(
        self,
        coins: List[int],
        coins_used: int,
        current_index: int,
        path_sum: int,
        memo: List[int],
        amount: int,
    ):
        pass


if __name__ == "__main__":
    s: Solution = Solution()
    print(s.coinChange(coins=[1, 2, 5], amount=11))
    s.min = float("inf")
    print(s.coinChange(coins=[2], amount=3))
