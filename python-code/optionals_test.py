from typing import *


def test_optional(num: Optional[int]):
    if num:
        print(f"Found num {num}")
    else:
        print("Did not find anything")


def test_without_optional(num: int):
    if num:
        print(f"Found num {num}")
    else:
        print("Did not find anything")


if __name__ == "__main__":
    test_optional(None)
    test_optional(234)
    test_without_optional(None)
    test_without_optional(567)
