from typing import *
from base_graph import BaseGraph


class DFS(BaseGraph):
    def __init__(self, graph: Dict[int, Set[int]], origin: int):
        super().__init__(graph, origin)
        self._dfs(self.origin)

    def _dfs(self, node: int):
        self.visited.add(node)
        neighbors: Set[int] = self.graph[node]
        for n in neighbors:
            if n not in self.visited:
                self.edge_to[n] = node
                self._dfs(n)


if __name__ == "__main__":
    graph: Dict[int, Set[int]] = {1: {2, 4}, 2: {1, 3}, 3: {2}, 4: {1, 5}, 5: {4}}

    graph_dfs: DFS = DFS(graph, 1)
    print(graph_dfs.path_to(5))
