from collections import namedtuple
import json

if __name__ == "__main__":
    City = namedtuple("City", "name country population coordinates")
    tokyo: City = City("Tokyo", "Japan", "40.000.000", (35.689722, 139.691667))
    print(tokyo)
    print(tokyo._fields)
    print(json.dumps(tokyo._asdict()))

    Coordinate = namedtuple("Coordinate", "lat lon")
    delhi_data = ("Delhi NCR", "IN", 21.935, Coordinate(28.613889, 77.208889))
    delhi = City._make(delhi_data)
    print(delhi)

    """
    namedtuple accepts the defaults keyword-only argument providing an iterable of N default values for each of the
     N rightmost fields of the class
    """
    CoordinateII = namedtuple(
        "Coordinate", "lat lon reference", defaults=[1, 2, "ws345"]
    )
    foo = CoordinateII(lat=45)
    print(foo)
