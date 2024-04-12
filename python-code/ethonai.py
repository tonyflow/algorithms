from typing import *


class TopologicalSort:

    def __init__(self, deps: List[Tuple[int, int]], number_of_jobs: int):
        """
        (x,y)
        x depends on y
        x has an in degree of one
        """
        self.adj_list: Dict[int, List[int]] = dict()
        for n in range(1, number_of_jobs + 1):
            self.adj_list[n] = []
        self.sort: List[int] = []
        self.visited: Set[int] = set()

        for x, y in deps:
            dependencies_of_x = self.adj_list[x]
            dependencies_of_x.append(y)
            self.adj_list[x] = dependencies_of_x

        print(self.adj_list)

    def topological_sort(self) -> List[int]:
        """
        edges = E
        vertices = V
        runtime = O(2V) = O(V)
        space = O(V)

        adj_list = V = c*V
        """
        if not self.has_cycle():
            for node in self.adj_list:
                if node not in self.visited:
                    self.traverse(node)
            return self.sort

    def traverse(self, node: int):
        """
        a -> b -> c <- d
                 ^
                 |
                 e
        :param node:
        :return:
        """
        self.visited.add(node)

        for neighbor in self.adj_list.get(node, []):
            if neighbor not in self.visited:
                self.traverse(neighbor)

        self.sort.append(node)

    def has_cycle(self) -> bool:
        in_degrees: Dict[int, int] = {}
        for node, deps in self.adj_list.items():
            in_degrees[node] = len(deps)

        return False


if __name__ == '__main__':
    deps: List[Tuple[int, int]] = [(1, 2), (2, 3), (3, 4)]
    topological_sort = TopologicalSort(deps, number_of_jobs=4)
    print(topological_sort.topological_sort())

    other = [(1, 2)]
    print(TopologicalSort(deps=other, number_of_jobs=3).topological_sort())
