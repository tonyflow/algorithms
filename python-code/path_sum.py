from typing import *
from tree_node import TreeNode


def hasPathSum(root: Optional[TreeNode], targetSum: int) -> bool:
    return doesHave(root, 0, targetSum)


def doesHave(root: TreeNode, path_sum: int, target_sum: int) -> bool:
    if root is None:
        return False

    # Reached a leaf node, so we're checking the path sum against the target
    if root.left is None and root.right is None:
        return path_sum + root.val == target_sum

    return doesHave(root.left, path_sum + root.val, target_sum) or doesHave(
        root.right, path_sum + root.val, target_sum
    )


if __name__ == "__main__":
    a: TreeNode = TreeNode(2)
    print(a.left)
