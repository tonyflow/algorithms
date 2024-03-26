from typing import *
from tree_node import TreeNode


class Solution:
    '''
    - Find the node of the existing tree which has val == key

    '''

    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:

        if not root:
            return None

        if root.val == key:
            if not root.right and not root.left:
                return None

            elif not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                # both left and right are populated
                # Find the successor of the node to be deleted: The successor of the node
                # to be deleted is the smallest node of the right subtree
                successor_value = self._find_minimum(root.right)
                root.val = successor_value
                root.right = self.deleteNode(root.right, successor_value)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            root.left = self.deleteNode(root.left, key)

        return root

    def _find_minimum(self, root: Optional[TreeNode]) -> int:
        min_val = float('inf')
        while root:
            min_val = min(min_val, root.val)
            root = root.left

        return min_val
