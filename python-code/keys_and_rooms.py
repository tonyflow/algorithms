from typing import *


class Solution:
    visited: Set[int] = set()

    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        self.traverse(rooms, 0)
        return len(self.visited) == len(rooms)

    def traverse(self, rooms: List[List[int]], w: int):
        self.visited.add(w)

        neighbors: List[int] = rooms[w]
        for v in neighbors:
            if v not in self.visited:
                self.traverse(rooms, v)


if __name__ == "__main__":
    rooms = [[1, 3], [3, 0, 1], [2], [0]]
    rooms_true = [[1], [2], [3], []]
    s: Solution = Solution()
    result: bool = s.canVisitAllRooms(rooms_true)
    print(result)
