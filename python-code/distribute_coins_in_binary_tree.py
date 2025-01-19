from typing import *
from tree_node import TreeNode


class Solution:
    def __init__(self):
        self.answer: int = 0

    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        if root:
            left_surplus: int = self.distributeCoins(root.left)
            right_surplus: int = self.distributeCoins(root.right)

            # Answer represents the moves that is why we need to take the absolute
            # value of the coins that need to be moved (in or out)
            self.answer = self.answer + abs(left_surplus) + abs(right_surplus)

            # The return value represents the coins that we have a surplus of. This means that we
            # need to take care of both giving coins AND taking coins. That is why there is no
            # abs method applied here. The -1 represents the coins we need to keep so that all nodes
            # on the tree can have at least one coin
            return left_surplus + right_surplus - 1
        return 0
