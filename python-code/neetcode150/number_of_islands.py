def num_islands(self, grid: list[list[str]]) -> int:
    rows = len(grid)
    columns = len(grid[0])
    number_of_islands: int = 0

    def out_of_bounds(i: int, j: int) -> bool:
        return i < 0 or i >= rows or j < 0 or j >= columns

    def dfs(i: int, j: int):
        if out_of_bounds(i, j):
            return
        if grid[i][j] == "0":
            return
        # Turn land into sea
        grid[i][j] = "0"
        # Search for islands
        for direction in [[1, 0], [0, -1], [0, 1], [-1, 0]]:
            dfs(i + direction[0], j + direction[1])

    for i in range(rows):
        for j in range(columns):
            if grid[i][j] == "1":
                number_of_islands += 1
                dfs(i, j)

    return number_of_islands
