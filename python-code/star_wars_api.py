from requests import get
from typing import Iterator, NamedTuple, Optional, Callable, Any
import json
from utilities.retry import Retrier


class Planet(NamedTuple):
    name: str
    diameter: int
    terrain: str


def get_planets() -> Iterator[Planet]:
    next_page: str = "https://swapi.dev/api/planets"
    while next_page:
        response = get(next_page)
        if response.status_code == 200:
            json_content = json.loads(response.content)
            print(f"Processing page {next_page}")
            if "results" in json_content and json_content["results"]:
                for planet in json_content["results"]:
                    yield Planet(
                        name=planet["name"],
                        terrain=planet["terrain"],
                        diameter=int(planet["diameter"])
                        if planet["diameter"].isnumeric()
                        else 0,
                    )

                next_page = json_content["next"]
        else:
            raise Exception("Unable to consume API")


def get_terrain(planet_name: str) -> Optional[str]:
    results = [planet.terrain for planet in get_planets() if planet.name == planet_name]
    return results[0] if results else None


def get_biggest_planet() -> Optional[str]:
    biggest_planet = max(get_planets(), key=lambda p: p.diameter)
    print(f"Found biggest planet with diameter {biggest_planet.diameter} km")
    return biggest_planet.name


if __name__ == "__main__":
    retrier: Retrier = Retrier()
    for planet in retrier.retry(get_planets):
        print(planet)
    # print(get_biggest_planet())
    # print(get_terrain('Bespin'))
    # print(get_terrain('Tatooine'))
