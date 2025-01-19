from functools import reduce
from operator import mul


def factorial(n: int):
    return reduce(lambda a, b: a * b, range(1, n + 1))


def factorial_operator(n: int):
    return reduce(mul, range(1, n + 1))


def custom_add(a: int, b: int):
    return a + b


if __name__ == "__main__":
    """
    The operator module
    """
    print(factorial(5))  # 1*2*3*4*5 = 6*20
    print(factorial_operator(5))

    """
    The following is a demonstration of how we can extract information from a data class using certain
    methods of the operator module. More specifically, here we are using:
    - itemgetter
    - attrgetter
    """
    metro_data = [
        ("Tokyo", "JP", 36.933, (35.689722, 139.691667)),
        ("Delhi NCR", "IN", 21.935, (28.613889, 77.208889)),
        ("Mexico City", "MX", 20.142, (19.433333, -99.133333)),
        ("New York-Newark", "US", 20.104, (40.808611, -74.020386)),
        ("São Paulo", "BR", 19.649, (-23.547778, -46.635833)),
    ]

    from operator import itemgetter

    print(f"Only one index {list(map(itemgetter(1), metro_data))}")
    print(f"Multiple indexes {list(map(itemgetter(1, 0), metro_data))}")
    print(sorted(metro_data, key=itemgetter(1)))

    from collections import namedtuple

    LatLon = namedtuple("LatLon", "lat lon")
    Metropolis = namedtuple("Metropolis", "name cc pop coord")
    metro_areas = [
        Metropolis(n, c, p, LatLon(lat, lon)) for n, c, p, (lat, lon) in metro_data
    ]
    print(metro_areas[0].coord.lat)

    from operator import attrgetter

    name_lat = attrgetter("name", "coord.lat")

    for city in sorted(metro_areas, key=attrgetter("coord.lat")):
        print(name_lat(city))

    # There are more than a few methods defined in the operator package
    import operator

    methods_in_the_operator_package = [
        name for name in dir(operator) if not name.startswith("_")
    ]
    print(f"methods_in_the_operator_package: {methods_in_the_operator_package}")

    from operator import methodcaller

    s = "the time has come"
    uppper_caser = methodcaller("upper")
    print(uppper_caser(s))
    hyphenate = methodcaller("replace", " ", "-")
    print(hyphenate(s))
    print(str.upper(s))

    """
    Freezing arguments using functools.partial
    """
    from functools import partial

    triple = partial(mul, 3)
    plus_four = partial(custom_add, 4)
    print(f"plus_four(5) {plus_four(5)}")
    print(triple(5))
    print([triple(x) for x in range(5)])
