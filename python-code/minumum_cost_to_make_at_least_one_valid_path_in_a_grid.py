class Solution:
    min_cost: int = float("inf")

    def minCost(self, grid: list[list[int]]) -> int:
        """The memoization is based on 3 dimensions:

        1. The x,y axis
        2. The min_cost that has been computed at this point
        3. Whether or not we have changed direction on this cell
        """
        Solution.min_cost = float("inf")

        # visited: list[list[bool]] = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        # self.traverse_based_on_rules(0, 0, grid, 0, visited)
        # return Solution.min_cost

        memoized: list[list[int]] = [
            [-1] for _ in range(len(grid[0])) for _ in range(len(grid))
        ]
        self.traverse_based_on_rules_with_memoization(0, 0, grid, 0, memoized)
        return memoized[0][0]

    def traverse_based_on_rules_with_memoization(
        self,
        i: int,
        j: int,
        grid: list[list[int]],
        path_cost: int,
        memoized: list[list[int]],
    ) -> float:
        if not self.in_grid(i, j, grid):
            return float("inf")

        if self.reached_the_end(i, j, grid):
            Solution.min_cost = min(Solution.min_cost, path_cost)
            # TODO What should I do here?
            return float("")

        if memoized[i][j] != -1:
            return memoized[i][j]

        # There are always two options when visiting a cell:
        match grid[i][j]:
            case 1:
                # 1. Either follow this direction OR
                min_cost_normal_case: float = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j + 1, grid, path_cost, memoized
                    )
                )

                # 2. Charge direction
                min_cost_change_direction_left = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j - 1, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_up = (
                    self.traverse_based_on_rules_with_memoization(
                        i - 1, j, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_down = (
                    self.traverse_based_on_rules_with_memoization(
                        i + 1, j, grid, path_cost + 1, memoized
                    )
                )

                min_overall = min(
                    min_cost_normal_case,
                    min_cost_change_direction_left,
                    min_cost_change_direction_up,
                    min_cost_change_direction_down,
                )
            case 2:
                # 1. Either follow this direction OR
                min_cost_normal_case = self.traverse_based_on_rules_with_memoization(
                    i, j - 1, grid, path_cost, memoized
                )

                # 2. Charge direction
                min_cost_change_direction_right = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j + 1, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_up = (
                    self.traverse_based_on_rules_with_memoization(
                        i - 1, j, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_down = (
                    self.traverse_based_on_rules_with_memoization(
                        i + 1, j, grid, path_cost + 1, memoized
                    )
                )

                min_overall = min(
                    min_cost_normal_case,
                    min_cost_change_direction_right,
                    min_cost_change_direction_up,
                    min_cost_change_direction_down,
                )
            case 3:
                # 1. Either follow this direction OR
                min_normal_cost = self.traverse_based_on_rules_with_memoization(
                    i + 1, j, grid, path_cost, memoized
                )

                # 2. Charge direction
                min_cost_change_direction_up = (
                    self.traverse_based_on_rules_with_memoization(
                        i - 1, j, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_right = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j + 1, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_left = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j - 1, grid, path_cost + 1, memoized
                    )
                )

                min_overall = min(
                    min_normal_cost,
                    min_cost_change_direction_up,
                    min_cost_change_direction_right,
                    min_cost_change_direction_left,
                )

            case 4:
                # 1. Either follow this direction OR
                min_normal_cost = self.traverse_based_on_rules_with_memoization(
                    i - 1, j, grid, path_cost, memoized
                )

                # 2. Charge direction
                min_cost_change_direction_down = (
                    self.traverse_based_on_rules_with_memoization(
                        i + 1, j, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_right = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j + 1, grid, path_cost + 1, memoized
                    )
                )
                min_cost_change_direction_left = (
                    self.traverse_based_on_rules_with_memoization(
                        i, j - 1, grid, path_cost + 1, memoized
                    )
                )

                min_overall = min(
                    min_normal_cost,
                    min_cost_change_direction_down,
                    min_cost_change_direction_right,
                    min_cost_change_direction_left,
                )
            case other:
                raise ValueError(f"Cannot process {other}")

        memoized[i][j] = min_overall

        return memoized[i][j]

    def traverse_based_on_rules(
        self,
        i: int,
        j: int,
        grid: list[list[int]],
        path_cost: int,
        visited: list[list[bool]],
    ):
        if not self.in_grid(i, j, grid):
            return

        if self.reached_the_end(i, j, grid):
            Solution.min_cost = min(Solution.min_cost, path_cost)
            return

        if visited[i][j]:
            return

        # else mark cell as visited and proceed to the next one
        visited[i][j] = True

        # There are always two options when visiting a cell:
        match grid[i][j]:
            case 1:
                # 1. Either follow this direction OR
                self.traverse_based_on_rules(i, j + 1, grid, path_cost, visited)

                # 2. Charge direction
                self.traverse_based_on_rules(i, j - 1, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i - 1, j, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i + 1, j, grid, path_cost + 1, visited)
            case 2:
                # 1. Either follow this direction OR
                self.traverse_based_on_rules(i, j - 1, grid, path_cost, visited)

                # 2. Charge direction
                self.traverse_based_on_rules(i, j + 1, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i - 1, j, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i + 1, j, grid, path_cost + 1, visited)
            case 3:
                # 1. Either follow this direction OR
                self.traverse_based_on_rules(i + 1, j, grid, path_cost, visited)

                # 2. Charge direction
                self.traverse_based_on_rules(i - 1, j, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i, j + 1, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i, j - 1, grid, path_cost + 1, visited)
            case 4:
                # 1. Either follow this direction OR
                self.traverse_based_on_rules(i - 1, j, grid, path_cost, visited)

                # 2. Charge direction
                self.traverse_based_on_rules(i + 1, j, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i, j + 1, grid, path_cost + 1, visited)
                self.traverse_based_on_rules(i, j - 1, grid, path_cost + 1, visited)
            case other:
                raise ValueError(f"Cannot process {other}")

        # We need to backtrack so that we can traverse all cells
        visited[i][j] = False

    def reached_the_end(self, i: int, j: int, grid: list[list[int]]):
        return j == len(grid[0]) - 1 and i == len(grid) - 1

    def in_grid(self, i: int, j: int, grid: list[list[int]]):
        return 0 <= i <= len(grid) - 1 and 0 <= j <= len(grid[0]) - 1


if __name__ == "__main__":
    grid_a = [[1, 1, 1, 1], [2, 2, 2, 2], [1, 1, 1, 1], [2, 2, 2, 2]]
    grid_b = [[1, 1, 3], [3, 2, 2], [1, 1, 4]]
    grid_c = [[1, 2], [4, 3]]
    grid_d = [
        [3, 4, 3],
        [2, 2, 2],
        [2, 1, 1],
        [4, 3, 2],
        [2, 1, 4],
        [2, 4, 1],
        [3, 3, 3],
        [1, 4, 2],
        [2, 2, 1],
        [2, 1, 1],
        [3, 3, 1],
        [4, 1, 4],
        [2, 1, 4],
        [3, 2, 2],
        [3, 3, 1],
        [4, 4, 1],
        [1, 2, 2],
        [1, 1, 1],
        [1, 3, 4],
        [1, 2, 1],
        [2, 2, 4],
        [2, 1, 3],
        [1, 2, 1],
        [4, 3, 2],
        [3, 3, 4],
        [2, 2, 1],
        [3, 4, 3],
        [4, 2, 3],
        [4, 4, 4],
    ]
    solution = Solution()
    minimum_cost = solution.minCost(grid_d)
    print(minimum_cost)
