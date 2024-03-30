from typing import *
from heapq import *


class Dijkstra:
    def __init__(self,
                 graph: Dict[int, Dict[int, float]],
                 origin: int):
        self.graph = graph
        self.edge_to: Dict[int, int] = {}
        self.distances: Dict[int, float] = {vertex: float('inf') for vertex in self.graph}
        self.origin = origin
        self._find(self.origin)

    def _find(self, node: int):

        self.distances[node] = 0

        # Priority queue which stores tuples from distance to node id
        # Distance is the first in the tuple order since it needs to have
        # priority when entries are inserted into the priority queue
        priority_queue: List[(float, int)] = [(node, 0)]

        while priority_queue:
            current_node, current_distance = heappop(priority_queue)

            # If the distance currently recorded at the distances dict is
            # bigger than the one pushed to the pq then we do not need to
            # process this entry
            if current_distance > self.distances[current_node]:
                continue

            for n, weight in self.graph[current_node].items():
                updated_distance = current_distance + weight

                if updated_distance < self.distances[n]:
                    self.distances[n] = updated_distance
                    self.edge_to[n] = current_node
                    heappush(priority_queue, (n, updated_distance))

    def reconstruct_path(self, destination: int) -> List[int]:
        node: int = destination
        path: List[int] = []

        while node != self.origin:
            path.append(node)
            node = self.edge_to[node]

        path.reverse()
        return path


if __name__ == '__main__':
    graph = {
        1: {2: 1, 3: 4},
        2: {1: 1, 3: 2, 4: 5},
        3: {1: 4, 2: 2, 4: 1},
        4: {2: 5, 3: 1}
    }

    dijkstra: Dijkstra = Dijkstra(graph, 1)

    print(dijkstra.distances)
    print(dijkstra.reconstruct_path(4))
    print(dijkstra.reconstruct_path(2))
    print(dijkstra.reconstruct_path(3))
