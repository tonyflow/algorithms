from typing import Dict, List, Tuple, Any
from collections import OrderedDict


def dump(**kwargs):
    print(f"Received {kwargs}")
    return kwargs


def get_creators(record: Dict[str, Any]):
    match record:
        case {"type": "book", "api": 2, "authors": [*names]}:
            print(f"I got authors with names {names}")
        case {"type": "book", "api": 1, "author": name}:
            return [name]
        case {"type": "book"}:
            raise ValueError(f"Invalid 'book' record: {record!r}")
        case {"type": "movie", "director": name}:
            return [name]
        case _:
            raise ValueError(f"Record {record} could not match any case")


if __name__ == "__main__":
    """
    Dictionary generators
    """
    dial_codes: List[Tuple[int, str]] = [
        (880, "Bangladesh"),
        (55, "Brazil"),
        (86, "China"),
        (91, "India"),
        (62, "Indonesia"),
        (81, "Japan"),
        (234, "Nigeria"),
        (92, "Pakistan"),
        (7, "Russia"),
        (1, "United States"),
    ]

    country_to_code: Dict[str, int] = {country: code for code, country in dial_codes}
    print(country_to_code)

    country_to_code_filtered_and_mapped: Dict[str, int] = {
        country.upper(): code for code, country in dial_codes if code < 70
    }
    print(country_to_code_filtered_and_mapped)

    """
    dict unpacking
    """
    dump(a=3, b=4, **{"c": 5, "d": 6})

    """
    dict merging
    """
    d1 = {"a": 1, "b": 3}
    d2 = {"a": 2, "b": 4, "c": 6}
    merged = d1 | d2
    print(f"Merged {merged}")

    # or we can update an existing mapping in place
    d1 |= d2
    print(f"Updated {d2}")

    """
    Pattern matching for dictionaries
    
    *** It also works on partial matches: If we have an additional key/value pair in the 
    record which is not mentioned in the pattern but everything else matches then the 
    condition will evaluate to true
    
    dict VS defaultdict
    the main difference between these two collections is the that the second will not throw
    a KeyError once a key is requested for a key which does NOT exist in the dictionary. On the
    other hand, a simple dict will raise a KeyError in such a case
    """
    get_creators({"type": "book", "api": 2, "authors": ["niko", "strongioglou"]})
    a_record: dict = dict(type="book", api=2, authors=["niko", "strongioglou"])
    get_creators(a_record)

    b2 = OrderedDict(
        api=2,
        type="book",
        title="Python in a Nutshell",
        authors="Martelli Ravenscroft Holden".split(),
    )
    get_creators(b2)

    food: Dict[str, Any] = dict(type="ice cream", calories=1234, color="brown")
    match food:
        # When matching a dictionary, the ** pattern should always appear at the end of the pattern
        case {"type": food_type, **details}:
            print(f"I matched an {food_type} with the following details {details}")
