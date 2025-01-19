from typing import *
import heapq


def _find_next_zero_degree_node(in_degrees) -> Optional[int]:
    entry_node: Optional[int] = None
    for node, in_degree in in_degrees.items():
        if in_degree == 0:
            entry_node = node
            in_degrees.pop(entry_node)
            break

    return entry_node


def _filter_entry(item):
    k, v = item
    return v == 0


class TopologicalSort:
    def __init__(self):
        self.graph: Dict[int, Set[int]] = {}
        self.topo_sort_result: List[int] = {}
        self.visited: Set[int] = set()

    def topological_sort(self) -> Optional[List[int]]:
        if self.is_cyclic():
            return None

        for n, _ in self.graph.items():
            if n not in self.visited:
                self._dfs(v)

        return self.topo_sort_result

    def _dfs(self, n: int):
        self.visited.add(n)

        for neighbor in self.graph[n]:
            if neighbor not in self.visited:
                self._dfs(neighbor)

        self.topo_sort_result.append(n)

    def is_cyclic(self):
        # Find in-degrees of nodes
        in_degrees: Dict[int, int] = {}
        for v, neighbors in self.graph.items():
            for n in neighbors:
                in_degree_of_n = in_degrees.get(n, 0)
                in_degrees[n] = in_degree_of_n + 1

        # Find a node with in degree 0
        entry_node: Optional[int] = _find_next_zero_degree_node(in_degrees)

        if not entry_node:
            # We found no vertex with in-degree equal to zero
            return True

        helper: List[int] = [entry_node]
        sort: List[int] = []
        while helper:
            popped_node: int = helper.pop()
            sort.append(popped_node)
            next_node_to_process = _find_next_zero_degree_node(in_degrees)
            helper.append(next_node_to_process)

        return len(sort) == len(self.graph)


if __name__ == "__main__":
    d: Dict[int, List[int]] = {1: [12, 23, 56], 2: [1, 23, 78, 123]}

    d_one: Dict[int, int] = {1: 0, 2: 32}

    filtered: Dict[int, int] = dict(filter(_filter_entry, d_one.items()))

    for k, v in filtered.items():
        print(k, v)
