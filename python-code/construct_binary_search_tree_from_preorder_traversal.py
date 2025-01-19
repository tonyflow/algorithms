import bisect
from typing import *
from tree_node import TreeNode


class Solution:
    """
    Preorder => root,left,right
    """

    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None

        root_val: int = preorder[0]
        root: TreeNode = TreeNode(root_val)

        if len(preorder) == 1:
            return root

        # Find the first element after which is smaller than root_val. This would be the root of the right sub_tree
        first_bigger_index_faulty: int = 0

        while (
            first_bigger_index_faulty != len(preorder) - 1
            and preorder[first_bigger_index_faulty] <= root_val
        ):
            first_bigger_index_faulty += 1

        first_bigger_index = bisect.bisect(preorder, preorder[0])

        root.left = self.bstFromPreorder(preorder[1:first_bigger_index])
        root.right = self.bstFromPreorder(preorder[first_bigger_index:])

        return root


if __name__ == "__main__":
    # [8,5,1,7,10,12]
    # root = Solution().bstFromPreorder([8, 5, 1, 7, 10, 12])
    root = Solution().bstFromPreorder([4, 2])
    root
