from typing import *
from graph_node import Node


class Solution:
    def __init__(self):
        self.components: int = 0
        self.visited: Set[int] = set()

    def find_components(
        self,
        graph: {
            int,
        },
    ) -> int:
        for node, neighbors in graph.items():
            if node.val not in self.visited:
                self._do_find(node)
                self.components += 1
        return self.components

    def _do_find(self, v: Node):
        self.visited.add(v.val)

        for n in v.neighbors:
            if v.val not in self.visited:
                self._do_find(n)
