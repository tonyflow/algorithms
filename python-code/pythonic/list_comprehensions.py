from typing import Iterator, Generator


def convert_to_other(x: int) -> str:
    return str(x)


def get_xs() -> Generator[int, None, None]:
    # def get_xs() -> Iterator[int]:
    # def get_xs() -> range:
    return range(1, 101, 5)


def meets_criteria(x: int) -> bool:
    return x > 50


if __name__ == '__main__':
    result = [convert_to_other(x) for x in get_xs() if meets_criteria(x)]
    print(result)
