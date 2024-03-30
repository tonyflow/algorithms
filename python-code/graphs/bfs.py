from typing import *
from base_graph import BaseGraph


class BFS(BaseGraph):
    def __init__(self,
                 graph: Dict[int, Set[int]],
                 origin: int):
        super().__init__(graph, origin)
        self._bfs(self.origin)

    def _bfs(self, node: int):
        queue: List[int] = [node]

        while queue:
            level_size: int = len(queue)
            for _ in range(level_size):
                polled: int = queue.pop()
                self.visited.add(polled)

                neighbors: Set[int] = self.graph[polled]
                for n in neighbors:
                    if n not in self.visited:
                        self.edge_to[n] = polled
                        queue.append(n)


if __name__ == '__main__':
    graph: Dict[int, Set[int]] = {
        1: {2, 4},
        2: {1, 3},
        3: {2},
        4: {1, 5},
        5: {4}
    }

    graph_bfs: BFS = BFS(graph, 1)
    print(graph_bfs.path_to(5))
