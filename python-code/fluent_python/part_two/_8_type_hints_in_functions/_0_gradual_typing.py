from pytest import mark
from typing import Optional

"""
A gradual typing system:
- is optional
- does not catch type errors at runtime
- does not enhance performance

What would be the definition of a type?
- In practice, it’s more useful to consider the set of supported operations as the defining characteristic of a type
"""


def show_count(count: int,
               word: str,
               plural: Optional[str] = None) -> str:
    if count == 1:
        return f'1 {word}'

    count_str = f'{count}' if count > 1 else f'no'
    if not plural:
        plural = f'{word}s'
    return f'{count_str} {plural}'


def test_irregular() -> None:
    got = show_count(2, 'child', 'children')
    assert got == '2 children'


@mark.parametrize('qty.expected', [
    (1, '1 part'),
    (2, '2 parts')
])
def test_show_count(qty, expected):
    got = show_count(qty, 'part')
    assert got == expected


def test_show_count_zero():
    got = show_count(0, 'part')
    assert got == 'no parts'


if __name__ == '__main__':
    print(show_count(0, 'bird'))
