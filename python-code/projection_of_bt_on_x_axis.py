from tree_node import TreeNode
from collections import deque


class ProjectionOfBTOnXAxis:

    def compute(self, root: TreeNode):
        left_end, right_end = 0, 0
        q: deque = deque()
        q.append((root, 0))

        while q:

            level_size = len(q)
            for _ in range(level_size):
                node, hd = q.popleft()
                left_end = min(left_end, hd)
                right_end = max(right_end, hd)

                if node.left:
                    q.append((node.left, hd - 1))

                if node.right:
                    q.append((node.right, hd + 1))
            # node, hd = q.popleft()
            # left_end = min(left_end, hd)
            # right_end = max(right_end, hd)
            #
            # if node.left:
            #     q.append((node.left, hd - 1))
            #
            # if node.right:
            #     q.append((node.right, hd + 1))

        return right_end - left_end


def a_test():
    root: TreeNode = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(3)
    root.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)

    challenge: ProjectionOfBTOnXAxis = ProjectionOfBTOnXAxis()
    result = challenge.compute(root)
    print(result)


def b_test():
    root: TreeNode = TreeNode(1)
    root.left = TreeNode(2)

    root.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)

    challenge: ProjectionOfBTOnXAxis = ProjectionOfBTOnXAxis()
    result = challenge.compute(root)
    print(result)


def c_test():
    root: TreeNode = TreeNode(1)

    root.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)

    challenge: ProjectionOfBTOnXAxis = ProjectionOfBTOnXAxis()
    result = challenge.compute(root)
    print(result)


if __name__ == '__main__':
    a_test()
    b_test()
    c_test()
