from typing import *
from tree_node import TreeNode
from collections import deque


class TreeTraversals:
    def in_order(self, root: Optional[TreeNode]):
        if root:
            self.in_order(root.left)
            print(root.val)
            self.in_order(root.right)

    def post_order(self, root: Optional[TreeNode]):
        if root:
            self.post_order(root.left)
            self.post_order(root.right)
            print(root.val)

    def pre_order(self, root: Optional[TreeNode]):
        if root:
            print(root.val)
            self.post_order(root.left)
            self.post_order(root.right)

    def level_order(self, root: Optional[TreeNode]):
        if root:
            # q: deque = deque()
            q: List[TreeNode] = []
            q.append(root)
            level: int = 0
            while q:
                q_size = len(q)

                print(f'Processing level {level}')
                for _ in range(q_size):
                    # polled: TreeNode = q.popleft()
                    polled: TreeNode = q.pop(0)
                    print(polled.val)
                    if polled.left:
                        q.append(polled.left)
                    if polled.right:
                        q.append(polled.right)

                level += 1


if __name__ == '__main__':
    tt: TreeTraversals = TreeTraversals()
    root: TreeNode = TreeNode(10)
    root.left = TreeNode(7)
    root.right = TreeNode(30)
    root.right.right = TreeNode(60)
    root.right.left = TreeNode(20)
    root.left.right = TreeNode(8)
    root.left.left = TreeNode(6)

    print('PRE ORDER')
    tt.pre_order(root)

    print('POST ORDER')
    tt.post_order(root)

    print('IN ORDER')
    tt.in_order(root)

    print('LEVEL ORDER')
    tt.level_order(root)
