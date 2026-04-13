"""Dijstra Positive Weights Directed Graph Algortihm.

Given a directed graph G(E,V) w(u,v) >= 0 compute a shortest path from a source
node s to all other nodes.

The algorithm does not work for negatives weights. The bellman ford algorithm should
be used instead.
"""

from collections import defaultdict
import heapq


class DirectedWeightedGraph:
    def __init__(self):
        self.adjacency: dict[int, tuple[int, int]] = {}


def network_delay_time(times: list[list[int]], n: int, k: int) -> int:
    # Create adjacency from incoming times
    graph: dict[int, list[tuple[int, int]]] = defaultdict(list)
    for time in times:
        u, v, weight = time
        if weight < 0:
            raise ValueError("Dijkstra cannot work with negative weights")

        graph[u].append((v, weight))

    dist: list[int] = [float("inf")] * (n + 1)
    dist[k] = 0.0
    proceccing_heap: list[tuple[int, int]] = []

    heapq.heappush(proceccing_heap, (0.0, k))

    while proceccing_heap:
        current_min_distance, u = heapq.heappop(proceccing_heap)

        if current_min_distance > dist[u]:
            continue

        for node, weight in graph[u]:
            if weight + current_min_distance < dist[node]:
                dist[node] = weight + current_min_distance
                heapq.heappush(proceccing_heap, (dist[node], node))

    # 1. We want to find the minimum times it takes for a signal to traven from the
    # source to all other nodes
    # 2. The beginning of the array will always stick with float('inf') since the
    # indexing starts from 0
    # 3. So in order to find the minimum we need to
    #   i. Ignore the dist[0] since indexing starts at 1
    #   ii. Ignore dist[k] since this is the source
    # To do so we can just pop them from the dist array
    dist.pop(0)
    dist.pop(k - 1)

    if any(d == float("inf") for d in dist):
        return -1

    return max(dist)


if __name__ == "__main__":
    print(
        network_delay_time(times=[[1, 2, 1], [2, 3, 1], [1, 4, 4], [3, 4, 1]], n=4, k=1)
    )
