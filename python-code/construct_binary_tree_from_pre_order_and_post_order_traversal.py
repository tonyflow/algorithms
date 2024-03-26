from typing import *
from tree_node import TreeNode


class Solution:
    def construct_from_pre_order_and_post_order(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None

        root_val: int = preorder[0]
        root: TreeNode = TreeNode(root_val)
        if len(preorder) == 1:
            return root

        # Find the root of the left subtree: It's the second element of the in order traversal since preorder
        # is root -> left -> right
        left_subtree_root = preorder[1]

        # We can optimize this using a {}
        index_of_left_subtree_in_postorder: int = postorder.index(left_subtree_root)

        # Due to the nature of postorder traversal all elements on the left of the index should belong to the
        # subtree rooted at left_subtree_root. +1 is because we're counting the root as well
        left_subtree_size = index_of_left_subtree_in_postorder + 1
        root.left = self.construct_from_pre_order_and_post_order(preorder[1:1+left_subtree_size],
                                                                 postorder[:left_subtree_size])
        root.right = self.construct_from_pre_order_and_post_order(preorder[left_subtree_size + 1:],
                                                                  postorder[left_subtree_size:-1])

        return root
