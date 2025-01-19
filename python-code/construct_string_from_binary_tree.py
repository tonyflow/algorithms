from typing import *
from tree_node import TreeNode


class Solution:
    def __init__(self):
        self.result = ""

    def tree2str(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ""
        elif not root.left and not root.right:
            return f"{root.val}"
        elif root.left and not root.right:
            return f"{root.val}({self.tree2str(root.left)})"
        elif not root.left and root.right:
            return f"{root.val}()({self.tree2str(root.right)})"
        else:
            return (
                f"{root.val}({self.tree2str(root.left)})({self.tree2str(root.right)})"
            )


if __name__ == "__main__":
    root: TreeNode = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(4)
    root.right = TreeNode(3)
    print(Solution().tree2str(root))
