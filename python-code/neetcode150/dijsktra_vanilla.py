import heapq


def dijsktra(
    graph: dict[int, list[tuple[int, int]]], source: int, number_of_nodes: int
) -> tuple[list[int], list[int]]:
    """Vanilla Dijstra implementation."""

    dist: list[int] = [float("inf")] * number_of_nodes
    dist[source] = 0.0

    # Helper for path reconstruction
    previous: list[int] = [index for index in range(number_of_nodes)]

    processing_heap = []
    heapq.heappush(processing_heap, (0.0, source))

    while processing_heap:
        current_min_distance_from_source, v = heapq.heappop(processing_heap)

        if current_min_distance_from_source > dist[v]:
            continue

        for neighbor, weight in graph[v]:
            if current_min_distance_from_source + weight < dist[neighbor]:
                dist[neighbor] = current_min_distance_from_source + weight
                previous[neighbor] = v
                heapq.heappush(processing_heap, (dist[neighbor], neighbor))

    return dist, previous


def reconstruct_path(source: int, destination: int, previous: list[int]):
    path = [destination]
    while destination != source:
        path.append(previous[destination])
        destination = previous[destination]

    path.reverse()
    return path


if __name__ == "__main__":
    graph = {0: [(3, 10), (1, 2)], 1: [(2, 1)], 2: [(3, 1)], 3: []}

    print(dijsktra(graph, 0, 4))
    print(reconstruct_path(0, 3, [0, 0, 1, 2]))
