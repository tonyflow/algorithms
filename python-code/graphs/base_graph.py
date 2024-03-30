from abc import ABC
from typing import *


class BaseGraph:

    def __init__(self,
                 graph: Dict[int, Set[int]],
                 origin: int):
        self.graph: Dict[int, Set[int]] = graph
        self.origin: int = origin
        self.visited: Set[int] = set()
        self.edge_to: Dict[int, int] = {}

    def path_to(self, to: int) -> Optional[List[int]]:
        if to not in self.visited:
            return None

        node: int = self.edge_to[to]
        stack: List[int] = [to]
        while node != self.origin:
            stack.append(node)
            node = self.edge_to[node]

        # Reverse to convert to correct path ordering
        stack.reverse()

        return list(stack)
