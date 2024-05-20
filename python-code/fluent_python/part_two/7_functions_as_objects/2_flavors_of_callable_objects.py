from typing import List
from random import shuffle

"""
As of Python 3.9 there are 9 callable types:
1. User defined functions
2. build-in functions
3. build-in methods
4. methods
5. classes
6. class instances
7. generator functions
8. native coroutine functions
9. asynchronous generator functions
"""


class BingoCage:
    def __init__(self, items: List[int]):
        self._items = list(items)
        shuffle(self._items)

    def pick(self) -> int:
        try:
            return self._items.pop()
        except IndexError:
            raise LookupError('pick up from empty items list')

    def __call__(self, *args, **kwargs):
        return self.pick()


if __name__ == '__main__':
    """
    There are also user-defined callable types!!! A class implementing __call__ is an easy way to create function-like
    objects that have some internal state that must be kept across invocations, like the remaining items of the BingoCage
    """
    bingo: BingoCage = BingoCage([1, 2, 3, 4, 5, 6])
    print(bingo.pick())
    print(bingo())
