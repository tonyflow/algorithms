from typing import Any, NamedTuple, List

if __name__ == "__main__":
    """
    Simple pattern syntax.
    The simple pattern syntax of float(x) is a special case that applies only to nine blessed built-in types and these
    are:
      bytes   dict   float   frozenset   int   list   set   str   tuple
      
    In those classes, the variable that looks like a constructor argument—e.g., the x in float(x) is bound to the whole 
    subject instance or the part of the subject that matches a subpattern
    """

    def identify_type(o: Any):
        match o:
            case float():
                print("this is a float")
            case str():
                print("this is a string")
            case int():
                print("this is an integer")
            case _:
                print("Cannot identify object type")

    identify_type(1)
    identify_type(1.3)
    identify_type("foo")

    """
    Keyword class patterns
    """

    class City(NamedTuple):
        continent: str
        name: str
        country: str

    cities = [
        City("Asia", "Tokyo", "JP"),
        City("Asia", "Delhi", "IN"),
        City("North America", "Mexico City", "MX"),
        City("North America", "New York", "US"),
        City("South America", "São Paulo", "BR"),
    ]

    asian_cities: List[City] = []
    for city in cities:
        match city:
            case City(continent="Asia"):
                asian_cities.append(city)

    print(f"All Asian city named tuples {asian_cities}")

    asian_city_names: List[City] = []
    for city in cities:
        match city:
            case City(continent="Asia", name=cc):
                asian_city_names.append(cc)

    print(f"All Asian city names {asian_city_names}")

    """
    Positional class patterns
    """
    asian_cities_by_position: List[City] = []
    for city in cities:
        match city:
            case City("Asia"):
                asian_cities_by_position.append(city)

    print(f"All Asian city named tuples by position {asian_cities_by_position}")

    asian_city_names_by_position: List[City] = []
    for city in cities:
        match city:
            case City("Asia", name):
                asian_city_names_by_position.append(name)

    print(f"All Asian city names by position {asian_city_names_by_position}")
