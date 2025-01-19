from typing import *
from tree_node import TreeNode


class Solution:
    def __init__(self):
        self.to_add: int = 0

    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self._postorder(root)
        return root

    def _postorder(self, root: Optional[TreeNode]):
        if root:
            self._postorder(root.right)
            print(f"Convert {root.val} to {root.val + self.to_add}")
            root.val += self.to_add
            self.to_add = root.val
            self._postorder(root.left)


if __name__ == "__main__":
    root: TreeNode = TreeNode(4)
    root.left = TreeNode(1)
    root.left.left = TreeNode(0)
    root.left.right = TreeNode(2)
    root.left.right.right = TreeNode(3)
    root.right = TreeNode(6)
    root.right.right = TreeNode(7)
    root.right.left = TreeNode(5)
    root.right.right.right = TreeNode(8)
    greater: TreeNode = Solution().convertBST(root)
    greater
