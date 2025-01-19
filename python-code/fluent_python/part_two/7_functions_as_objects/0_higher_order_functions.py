from typing import List

"""
What is a first class object? A first-class object is a program entity which is
- created at runtime
- assigned to a variable or element in a data structure
- passed as an argument to a function
- returned as a result of a function



"""


def factorial(n: int):
    """
    returns n!
    """
    return 1 if n < 2 else n * factorial(n - 1)


if __name__ == "__main__":
    print(factorial(4))
    print(factorial.__doc__)
    print(type(factorial))

    # Assigning a function to a variable is an indication of Python as a first-class function
    fact = factorial
    print(fact(5))
    for m in map(factorial, range(10)):
        print(m)

    """
    A function that takes another function as an argument or returns another function as a result is called.
    Some of the most popular higher order functions in Python are:
    - reduce
    - filter
    - map
    - sorted
    - reverse
    - apply => now deprecated
    """
    fruits = ["strawberry", "fig", "apple", "cherry", "raspberry", "banana"]
    sorted_by_length = sorted(fruits, key=len)
    print(sorted_by_length)

    old_fashioned_map: List[int] = list(map(factorial, range(4)))
    modern_map: List[int] = [factorial(x) for x in range(4)]
    old_fashioned_map_2: List[int] = list(
        map(factorial, filter(lambda x: x % 2 == 0, range(10)))
    )
    modern_map_2: List[int] = [factorial(x) for x in range(10) if x % 2 == 0]

    from functools import reduce
    from operator import add

    old_fashioned_sum: int = reduce(add, range(5))
    print(f"old_fashioned_sum {old_fashioned_sum}")
    modern_sum = sum(range(5))
    print(f"modern_sum {modern_sum}")

    # Other nice reducing build ins
    if all([x % 2 == 0 for x in range(2, 11, 2)]):
        print("all works correctly!")

    if any(x % 2 == 0 for x in range(100)):
        print("any works correctly as well!")
