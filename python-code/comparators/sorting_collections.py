from typing import NamedTuple
from random import randint
from requests import get


def get_list_of_words() -> list[str]:
    response = get('https://www.mit.edu/~ecprice/wordlist.10000')
    return [byteload.decode('utf-8') for byteload in response.content.splitlines()]


def random_word_list(size: int) -> list[str]:
    al = get_list_of_words()
    return [al[randint(0, 10001)] for _ in range(size)]


class SomeClass(NamedTuple):
    a: int
    b: float = 0.0
    c: str = 'a'


if __name__ == '__main__':
    """Simple ordering-sorting

    Use one attribute or the default one to sort the collection
    """
    some_classes = [SomeClass(a=randint(0, 100)) for _ in range(10)]

    # Sort numbers in natural order
    # natural_order = sorted(some_classes, key=lambda sc: sc.a)
    # print([x.a for x in natural_order])
    some_classes.sort(key=lambda sc: sc.a)
    print([x.a for x in some_classes])

    # Sort numbers in reverse order
    # reverse_order = sorted(some_classes, key=lambda sc: sc.a, reverse=True)
    # print([x.a for x in reverse_order])
    some_classes.sort(key=lambda sc: sc.a, reverse=True)
    print([x.a for x in some_classes])

    # Sort strings in natural order
    # list_of_words = random_word_list(size=40)
    # list_of_words.sort()
    # print(list_of_words)

    # Sort tuples in reverse order
    some_tuples = [(randint(1, 100), randint(1, 100), randint(1, 100)) for _ in range(20)]
    print(f'Length of some_tuples {len(some_tuples)}')

    # Sort by the first element
    some_tuples.sort(key=lambda t: t[0])
    print([t[0] for t in some_tuples])

    # Sort by the second element
    some_tuples.sort(key=lambda t: t[1])
    print([t[1] for t in some_tuples])

    """Composite sorts
    
    Providing multiple attributes for sorting
    """
    # Sort tuples
    other_tuples = [(randint(1, 4), randint(1, 100), randint(1, 100)) for _ in range(20)]
    other_tuples.sort(key=lambda t: (t[0], t[1]))
    print(other_tuples)

    # Sort classes
    list_of_words = random_word_list(size=50)
    some_classes_other = [SomeClass(a=randint(1, 4), c=list_of_words[randint(0, 50)]) for _ in range(50)]
    some_classes_other.sort(key=lambda sc: (sc.a, sc.c))
    print(some_classes_other)
