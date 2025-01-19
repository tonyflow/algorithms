from typing import *


def print_formal(name: str, surname: str):
    print(f"Name:{name}, Surname:{surname}")


def print_informal(name: str, surname: str):
    print(f"Hey guys! I am {name} and my surname is {surname}")


def some_print(name: str, surname: str, action: Callable[[str, str], None]):
    action(name, surname)


if __name__ == "__main__":
    some_print(name="Niko", surname="Strongioglou", action=print_formal)
    some_print("Niko", "Strongioglou", print_informal)
