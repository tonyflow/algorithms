from collections import deque


def topological_sort(graph: dict[list[int]], number_of_nodes: int):
    in_degree: list[int] = [0] * number_of_nodes
    order = []

    # COmpute in_degree
    for u, neighbors in graph.items():
        for n in neighbors:
            in_degree[n] += 1

    queue = deque([i for i in range(number_of_nodes) if in_degree[i]==0])

    while queue:
        current = queue.popleft()
        order.append(current)

        for nei in graph[current]:
            in_degree[nei]-=1
