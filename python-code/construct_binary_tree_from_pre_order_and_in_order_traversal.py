from typing import *
from tree_node import TreeNode


class Solution:
    """
    preorder = root,left,right
    inorder = left,root,right
    """

    def construct_tree_from_preorder_and_inorder(
        self, preorder: List[int], inorder: List[int]
    ) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None

        root_val: int = preorder.pop(0)
        root: TreeNode = TreeNode(root_val)
        inorder_root_val_index = inorder.index(root_val)
        root.left = self.construct_tree_from_preorder_and_inorder(
            preorder, inorder[:inorder_root_val_index]
        )
        root.right = self.construct_tree_from_preorder_and_inorder(
            preorder, inorder[inorder_root_val_index + 1 :]
        )

        return root


if __name__ == "__main__":
    reconstructed_tree = Solution().construct_tree_from_preorder_and_inorder(
        [3, 9, 20, 15, 7], [9, 3, 15, 20, 7]
    )
    print(reconstructed_tree)
