from typing import NamedTuple, get_type_hints


class Coordinate(NamedTuple):
    lat: float
    lon: float
    reference: str = 'WGS84'


class DemoNTClass(NamedTuple):
    a: int
    b: float = 1.1
    c = 'spam'


if __name__ == '__main__':
    try:
        DemoNTClass()
    except TypeError as te:
        print('Correct! Since a does not have a default value and no value is provided upon creation')

    foo: DemoNTClass = DemoNTClass(a=1)
    print(DemoNTClass.__annotations__)
    print(get_type_hints(DemoNTClass))
    print(DemoNTClass.__doc__)
    print(foo.a, foo.b, foo.c)
    print(DemoNTClass.a, DemoNTClass.b, DemoNTClass.c)
