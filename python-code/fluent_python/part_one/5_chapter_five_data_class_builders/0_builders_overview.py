from collections import namedtuple
from typing import NamedTuple, get_type_hints
from dataclasses import dataclass

"""
There are 3 main ways to create classes carrying simple attributes which do not involve business logic.
- collections.namedtuple: immutable by default
- typing.NamedTuple: immutable by default
- dataclasses.dataclass: mutable by default but it can turn to immutable if the frozen flag is set
"""


@dataclass(frozen=True)
class DecoratedCoordinate:
    """
    The data class decorator also provides type hints for the attributes defined in the class
    """

    lat: float
    lon: float


class CoordinateTuple(NamedTuple):
    """
    This is a metaclass and not a subclass of NamedTuple
    """

    lat: float
    lon: float


class Coordinate:
    """
    Much more readable implementation of the NamedTuple specification. Although NamedTuple appears in the class
    statement as a superclass, it’s actually not. typing.NamedTuple uses the advanced functionality of a metaclass
    to customize the creation of the user’s class.
    """

    def __init__(self, longitude: int, latitude: int):
        self.longitude = longitude
        self.latitude = latitude

    def __repr__(self):
        return f"Coordinate({self.longitude},{self.latitude})"


if __name__ == "__main__":
    """
    Using the data class that we created ourselves:
    - Does not provide a meaningful __repr__ implementation unless we override it ourselves
    - Cannot reason correctly about object equality. __eq__ has to be overridden in order
    to properly account for longitude and latitude.
    """
    a: Coordinate = Coordinate(1, 2)
    b: Coordinate = Coordinate(1, 2)
    print(a == b)
    print(a)

    """
    The data class builders provide the necessary __init__,
    __repr__, and __eq__ methods automatically, as well as other useful features.
    
    The following is a named tuple implementation coming from the collections module
    """
    NamedTupleCoordinate = namedtuple("Coordinate", "lat lon")
    print(issubclass(NamedTupleCoordinate, tuple))
    print(get_type_hints(NamedTupleCoordinate))
    named_a: NamedTupleCoordinate = NamedTupleCoordinate(1.23, 4.56)
    named_b: NamedTupleCoordinate = NamedTupleCoordinate(1.23, 4.56)
    print(named_a == named_b)
    print(named_a)

    """
    NamedTuple from the typing module
    """
    # TypingNamedTupleCoordinate = NamedTuple('TypingNamedTupleCoordinate', [('lat', float), ('lon', float)])
    TypingNamedTupleCoordinate = NamedTuple(
        "TypingNamedTupleCoordinate", lat=float, lon=float
    )
    print(issubclass(TypingNamedTupleCoordinate, tuple))
    print(get_type_hints(TypingNamedTupleCoordinate))

    """
    CoordinateTuple
    """
    foo: CoordinateTuple = CoordinateTuple(lat=3.23, lon=5.67)
    print(issubclass(CoordinateTuple, tuple))
    print(get_type_hints(CoordinateTuple))
    print(foo == CoordinateTuple(lat=3.23, lon=5.67))
