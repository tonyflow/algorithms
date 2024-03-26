from tree_node import TreeNode
from typing import *

graph: Dict = {}


def find_target(root: TreeNode, target: int) -> TreeNode:
    if root.val == target:
        return root

    result_left = find_target(root.left, target)
    result_right = find_target(root.right, target)

    if result_left:
        return result_left

    return result_right


def create_graph(root: TreeNode):
    if root is None:
        return

    root_neighbors = graph.get(root, [])

    if root.left:
        left_child_neighbors = graph.get(root.left, [])
        left_child_neighbors.append(root)
        graph[root.left] = left_child_neighbors
        root_neighbors.append(root.left)
        create_graph(root.left)

    if root.right:
        right_child_neighbors = graph.get(root.right, [])
        right_child_neighbors.append(root)
        graph[root.right] = right_child_neighbors
        root_neighbors.append(root.right)
        create_graph(root.right)

    graph[root] = root_neighbors


def traverse_bfs(root: TreeNode,
                 distance: int,
                 k: int,
                 result: List[TreeNode]) -> None:
    if root is None:
        return

    if distance == k:
        result.append(root)

    traverse_bfs(root.left, distance + 1, k, result)
    traverse_bfs(root.right, distance + 1, k, result)


def tree_dfs(root: TreeNode,
             distance: int,
             k: int,
             visited: Set,
             result: List[TreeNode]):
    if root is None:
        return

    visited.add(root)

    if distance == k:
        result.append(root)

    for v in graph[root]:
        if v not in visited:
            tree_dfs(v, distance + 1, k, visited, result)


if __name__ == '__main__':
    visited: Set = set()
    result: List[TreeNode] = []
    a: TreeNode = TreeNode(1)
    a.left = TreeNode(2)
    a.right = TreeNode(3)
    # traverse_bfs(a, 0, 1, result)
    # while result:
    #     print(result.pop())

    create_graph(a)
    tree_dfs(a.left, 0, 2, visited, result)

    print(graph)
    print(result)
