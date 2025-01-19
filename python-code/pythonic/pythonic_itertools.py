from itertools import chain, count, permutations, combinations
from typing import List

"""
The itertools module provides a collection of tools for handling iterators. 
These tools are useful for constructing and using iterators in efficient and elegant ways
"""


def chain_collections(*lists: List[int]):
    for i in chain(*lists):
        print(i)


def permutations_producer():
    perms = permutations(a)
    for p in perms:
        print(p)


def combinations_producer():
    combs = combinations(a, 2)
    for c in combs:
        print(c)


if __name__ == "__main__":
    a = [1, 2, 3, 4]
    b = [5, 6, 7, 8]
    # chain_collections(a, b)
    combinations_producer()
    # permutations_producer()
