from typing import List, NamedTuple, Optional, Tuple


class Cell(NamedTuple):
    i: int
    j: int
    obstacles_eliminated: int


class Coordinate:
    def __init__(
        self,
        i: int,
        j: int,
        obstacles_eliminated: int,
        parent: Optional["Coordinate"] = None,
    ):
        self.i = i
        self.j = j
        self.obstacles_eliminated = 0
        self.parent = parent


class Solution:
    directions: List[List[int]] = [
        [1, 0],  # down
        [0, 1],  # right
        [-1, 0],  # up
        [0, -1],  # left
    ]

    def in_grid(self, grid: List[List[int]], i: int, j: int) -> bool:
        return len(grid) > i >= 0 and len(grid[0]) > j >= 0

    def shortestPathCoordinates(
        self, grid: List[List[int]], k: int
    ) -> List[Tuple[int, int]]:
        starting_node: Coordinate = Coordinate(i=0, j=0, obstacles_eliminated=0)
        q: List[Coordinate] = [starting_node]
        # visited: List[List[List[bool]]] = [[[False] * (k + 1)] * len(grid[0])] * len(grid)
        visited: List[List[List[bool]]] = [
            [[False for _ in range(k + 1)] for _ in range(len(grid[0]))]
            for _ in range(len(grid))
        ]

        visited[starting_node.i][starting_node.j][
            starting_node.obstacles_eliminated
        ] = True

        path_length: int = 0

        while q:
            level_size = len(q)
            for _ in range(level_size):
                polled: Coordinate = q.pop(0)

                # We reached the lower right cell, and we can return and path length
                if polled.i == len(grid) - 1 and polled.j == len(grid[0]) - 1:
                    # Construct path
                    shortest_path: List[Tuple[int, int]] = []
                    while polled:
                        shortest_path.append((polled.i, polled.j))
                        polled = polled.parent

                    # Reverse so that the start of the path is the start of the grid
                    shortest_path.reverse()
                    return shortest_path

                for d in self.directions:
                    next_i = polled.i + d[0]
                    next_j = polled.j + d[1]
                    next_k = polled.obstacles_eliminated
                    if self.in_grid(grid, next_i, next_j):
                        # If the next cell in the grid is an obstacle, then increase the obstacles eliminated
                        if grid[next_i][next_j] == 1:
                            next_k += 1

                        if next_k <= k and not visited[next_i][next_j][next_k]:
                            visited[next_i][next_j][next_k] = True
                            q.append(Coordinate(next_i, next_j, next_k, polled))

            # We might have moved on
            path_length += 1
        return []

    def shortestPathLength(self, grid: List[List[int]], k: int) -> int:
        starting_node: Cell = Cell(i=0, j=0, obstacles_eliminated=0)
        q: List[Cell] = [starting_node]
        # visited: List[List[List[bool]]] = [[[False] * (k + 1)] * len(grid[0])] * len(grid)
        visited: List[List[List[bool]]] = [
            [[False for _ in range(k + 1)] for _ in range(len(grid[0]))]
            for _ in range(len(grid))
        ]

        visited[starting_node.i][starting_node.j][
            starting_node.obstacles_eliminated
        ] = True

        path_length: int = 0

        while q:
            level_size = len(q)
            for _ in range(level_size):
                polled: Cell = q.pop(0)

                # We reached the lower right cell, and we can return and path length
                if polled.i == len(grid) - 1 and polled.j == len(grid[0]) - 1:
                    return path_length

                for d in self.directions:
                    next_i = polled.i + d[0]
                    next_j = polled.j + d[1]
                    next_k = polled.obstacles_eliminated
                    if self.in_grid(grid, next_i, next_j):
                        # If the next cell in the grid is an obstacle, then increase the obstacles eliminated
                        if grid[next_i][next_j] == 1:
                            next_k += 1

                        if next_k <= k and not visited[next_i][next_j][next_k]:
                            visited[next_i][next_j][next_k] = True
                            q.append(Cell(next_i, next_j, next_k))

            # We might have moved on
            path_length += 1

        return -1


if __name__ == "__main__":
    test_grid = [[0, 0, 0], [1, 1, 0], [0, 0, 0], [0, 1, 1], [0, 0, 0]]
    solution: Solution = Solution()
    pl: int = solution.shortestPathLength(grid=test_grid, k=1)
    print(pl)

    shortest_path: List[Coordinate] = solution.shortestPathCoordinates(
        grid=test_grid, k=1
    )
    print(shortest_path)
