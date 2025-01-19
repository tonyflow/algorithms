from typing import *
from graph_node import Node


class Solution:
    def __init__(self):
        self.visited: Set[int] = set()
        self.cloned_nodes: Dict[int, Node] = {}

    """
    node -> cloned_node
    cloned_node.value = node.value
    cloned_node.neighbors  = [graph nodes coming from deeper recursive calls]
    
    def deep_clone(w:Node):
    
        if not w:
            return None
            
        cloned_w = Node(val.w)
        cloned_w_neighbors = []
        for v in node:
            if v not in visited:
                cloned_v = deep_clone(v)
                cloned_w_neighbors.append(cloned_v)
    
    """

    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:
        return self.deep_clone(node)

    def deep_clone(self, w: Node):
        if not w:
            return None

        cloned_w = Node(w.val)
        self.cloned_nodes[w.val] = cloned_w

        for v in w.neighbors:
            if v.val in self.cloned_nodes:
                cloned_w.neighbors.append(self.cloned_nodes[v.val])
            else:
                cloned_v = self.deep_clone(v)
                cloned_w.neighbors.append(cloned_v)

        return cloned_w


if __name__ == "__main__":
    one: Node = Node(val=1)
    two: Node = Node(val=2)
    three: Node = Node(val=3)
    four: Node = Node(val=4)
    one.neighbors = [two, four]
    two.neighbors = [one, three]
    three.neighbors = [four, two]
    four.neighbors = [one, three]
    s: Solution = Solution()
    cloned_one = s.cloneGraph(one)
    print(cloned_one)
