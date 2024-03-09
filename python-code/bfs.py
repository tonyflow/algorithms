from typing import *
from collections import deque


class Graph:
    def __init__(self, adj: dict, n: int):
        self.adj = adj
        self.n = n
        self.bfs_edge_to = {}
        self.dfs_edge_to = {}

    def _do_dfs(self, v: int, visited: List[bool]):
        visited[v] = True

        for w in self.adj[v]:
            if not visited[w]:
                self.dfs_edge_to[w] = v
                self._do_dfs(w, visited)

    def _do_bfs(self, v: int, visited: List[bool]):
        q: deque = deque()
        q.append(v)

        while q:
            popped = q.pop()
            visited[popped] = True
            for v in self.adj[popped]:
                visited[v] = True
                self.bfs_edge_to[v] = popped
                q.append(v)

    def dfs(self):
        visited: List[bool] = [False for _ in range(self.n)]

        for k in self.adj.keys():
            if not visited[k]:
                self._do_dfs(k, visited)

    def bfs(self):
        visited: List[bool] = [False for _ in range(self.n)]

        for k in self.adj.keys():
            if not visited[k]:
                self._do_bfs(k, visited)
