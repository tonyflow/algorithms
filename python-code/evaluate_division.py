from typing import *


class Solution:

    def __init__(self):
        self.directed_weighted_graph: Dict[str, Dict[str, float]] = {}
        self.results: List[float] = []

    def calcEquation(self,
                     equations: List[List[str]],
                     values: List[float],
                     queries: List[List[str]]) -> List[float]:

        visited: Set[str] = set()
        self.directed_weighted_graph: Dict[str, Dict[str, float]] = self.build_graph(equations, values)

        for i, query in enumerate(queries):
            start: str = query[0]
            end: str = query[1]
            if start not in self.directed_weighted_graph or end not in self.directed_weighted_graph:
                self.results.append(-1.0)
            self.traverse(start, end, visited, 1.0)

        return self.results

    def traverse(self,
                 start: str,
                 end: str,
                 visited: Set[str],
                 partial_result: float):

        visited.add(start)
        if start == end:
            self.results.append(partial_result)
            visited.remove(start)
            return

        neighbors: Dict[str, float] = self.directed_weighted_graph[start]
        for n, weight in neighbors.items():
            if n not in visited:
                self.traverse(n, end, visited, partial_result * weight)

        visited.remove(start)

    # @staticmethod
    def build_graph(self, equations: List[List[str]], values: List[float]):
        directed_weighted_graph: Dict[str, Dict[str, float]] = {}

        for i, equation in enumerate(equations):
            first_operand: str = equation[0]
            second_operand: str = equation[1]

            # Add the forward relation
            if first_operand in directed_weighted_graph:
                neighbors: Dict[str, float] = directed_weighted_graph[first_operand]
                neighbors[second_operand] = values[i]
            else:
                directed_weighted_graph[first_operand] = {second_operand: values[i]}

            # Add the reverse relation
            if second_operand in directed_weighted_graph:
                neighbors: Dict[str, float] = directed_weighted_graph[second_operand]
                neighbors[first_operand] = 1 // values[i]
            else:
                directed_weighted_graph[second_operand] = {first_operand: 1.0 / values[i]}

        return directed_weighted_graph


if __name__ == '__main__':
    result = Solution().calcEquation(equations=[["a", "b"], ["b", "c"]],
                                     values=[2.0, 3.0],
                                     queries=[["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
                                     )

    print(result)
