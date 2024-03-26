from typing import *
from tree_node import TreeNode


class Solution:
    '''
    postorder: left,right,root
    inorder: left,root,right
    '''

    def construct_from_postorder_and_inorder(self,
                                             inorder: List[int],
                                             postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return None

        root_val = postorder.pop()
        root: TreeNode = TreeNode(root_val)
        index_of_root_in_inorder = inorder.index(root_val)
        root.right = self.construct_from_postorder_and_inorder(inorder[index_of_root_in_inorder + 1:], postorder)
        root.left = self.construct_from_postorder_and_inorder(inorder[:index_of_root_in_inorder], postorder)

        return root

    def construct_from_postorder_and_inorder_better(self,
                                                    inorder: List[int],
                                                    postorder: List[int]) -> Optional[TreeNode]:
        inorder_dict: Dict[int, int] = {}
        for i, val in enumerate(inorder):
            print(f'i={i},val={val}')
            inorder_dict[inorder[i]] = i

        return self._do_construct(inorder_dict,
                                  0,
                                  len(inorder) - 1,
                                  postorder)

    def _do_construct(self,
                      inorder_dict: Dict[int, int],
                      inorder_start: int,
                      inorder_end: int,
                      postorder: List[int]) -> Optional[TreeNode]:
        if inorder_start > inorder_end:
            return None

        root_val = postorder.pop()
        root: TreeNode = TreeNode(root_val)

        root.right = self._do_construct(inorder_dict,
                                        inorder_dict[root_val] + 1,
                                        inorder_end,
                                        postorder)

        root.left = self._do_construct(inorder_dict,
                                       inorder_start,
                                       inorder_dict[root_val] - 1,
                                       postorder)

        return root


if __name__ == '__main__':
    p = [1, 2, 3, 4, 5, 6]
    # Right side is exclusive
    print(p[:2])
    # Left side is inclusive
    print(p[3:])

    reconstructed_tree = Solution().construct_from_postorder_and_inorder([9, 3, 15, 20, 7], [9, 15, 7, 20, 3])
    print(reconstructed_tree)

    reconstructed_tree_better = Solution().construct_from_postorder_and_inorder_better([9, 3, 15, 20, 7],
                                                                                       [9, 15, 7, 20, 3])

    print(reconstructed_tree_better)
