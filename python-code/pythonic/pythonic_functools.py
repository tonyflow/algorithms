from functools import partial, lru_cache, reduce
from typing import List

"""
The functools module is intended to help with higher-order functions: functions that act on 
or return other functions
"""


def power(num: int, exponent: int) -> int:
    return num**exponent


@lru_cache(maxsize=None)
def fib(n: int) -> int:
    if n < 2:
        return n
    return fib(n - 1) + fib(n - 2)


def add_by_reduction(l: List[int]) -> int:
    return reduce(lambda x, y: x + y, l)


if __name__ == "__main__":
    # square = partial(power, exponent=2)
    # print(square(3))

    # for n in range(10):
    #     print(fib(n))
    # print(fib(40))
    print(add_by_reduction([1, 2, 3, 45]))
