from typing import Set

if __name__ == '__main__':
    a_set: Set[int] = {1, 2, 3, 3, 3, 3}
    print(a_set)
    l = ['spam', 'spam', 'eggs', 'spam', 'bacon', 'eggs']
    print(set(l))
    try:
        hash(a_set)
    except TypeError as e:
        print(f'Set is not hashable {e}')

    try:
        hash_value: int = hash(frozenset(a_set))
        print(f'Hash value of frozenset is {hash_value}')
    except TypeError as te:
        print('Should not have produced a type error')

    """
    Infix operators for sets
    | = Union
    & = intersection
    - = difference
    ^ = symmetric difference: Elements from both sets which are not included
    in their intersection. In other words, this is the complement of their intersection.
    
    Literal set syntax like {1, 2, 3} is both faster and more readable than calling the constructor
    (e.g., set([1, 2, 3])). The latter form is slower because, to evaluate it, Python has to look up
    the set name to fetch the constructor, then build a list, and finally pass it to the constructor.
    In contrast, to process a literal like {1, 2, 3}, Python runs a specialized BUILD_SET bytecode.
    """
    one: Set[int] = {1, 2, 3, 4}
    another: Set[int] = {3, 4, 5, 6}
    print(f'Set union {one | another}')
    print(f'Set intersection {one & another}')
    print(f'Set intersection another way {one.intersection(another)}')
    print(f'Set difference {one - another}')
    print(f'Set difference another way {one.difference(another)}')
    print(f'Set symmetric difference {one ^ another}')
    print(f'Set symmetric difference another way {one.symmetric_difference(another)}')
    print(f'Is disjoint {one.isdisjoint(another)}')
    print(f'Is subset {one.issubset(another)}')
    print(f'Is superset {one.issuperset(another)}')
    print(one.__gt__({1, 2}))

    """
    Set comprehensions can be used the exact same way as a list comprehension
    """
    from unicodedata import name

    a_set_comp: Set[chr] = {chr(i) for i in range(32, 256) if 'SIGN' in name(chr(i), '')}
    print(a_set_comp)
