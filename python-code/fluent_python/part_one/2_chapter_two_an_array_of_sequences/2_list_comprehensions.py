from typing import List


def flatten(foo: List[List[int]]) -> List[int]:
    return [xs for x in foo for xs in x]


if __name__ == "__main__":
    colors = ["black", "white"]
    sizes = ["S", "M", "L"]
    t_shirts = [(color, size) for color in colors for size in sizes]
    t_shirts_2 = [(size, color) for color in colors for size in sizes]
    print(t_shirts)
    print(t_shirts_2)

    a_test: List[List[int]] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

    reduced = sum([sum(li) for li in a_test])
    from functools import reduce

    def reduce_lists(a: List[int], b: List[int]):
        return sum(a) + sum(b)

    reduced_2: int = sum(reduce(lambda a, b: a + b, a_test))

    """
    What about
    reduced_2: int = sum(reduce(
        lambda a, b: sum(a) + sum(b),
        a_test
    ))
    
    the problem with this solution is that the the lambda operators must be 
    of the same type. As the reduce method though is going through the rest of the
    iterable and tries to merge it with the already aggregated part it will reach 
    a stage where it will try to merge a list with an integer. This cannot happen. 
    That is why the error is going to be produced. 
    """
    print(f"Using reduce {reduced_2}")

    print(f"Using list comprehension {reduced}")

    """
    Testing flattening
    """
    result: List[int] = flatten([[1, 2, 3], [4, 5, 6]])
    print(result)
