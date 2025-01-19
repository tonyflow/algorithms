from typing import List

if __name__ == "__main__":
    q: List[int] = [1, 2, 3, 4, 5]

    while q:
        item = q.pop()
        print(item)
