from dataclasses import dataclass, field, InitVar
from typing import get_type_hints, Set, ClassVar, TypeVar


@dataclass
class DemoDataClass:
    a: int
    b: float = 1.1
    c = "spam"
    d: list[str] = field(default_factory=list)


@dataclass
class ClubMember:
    """
    Create a club member with default athlete value False and this attribute is omitted from the representation method
    """

    name: str
    guests: list = field(default_factory=list)
    athlete: bool = field(default=False, repr=False)


@dataclass
class HackerClubMember(ClubMember):
    """
    Defining all_handles like

    all_handles:Set[str] = set()

    would not work since - based on dataclass - syntax, this would mean that all_handles is an instance attribute.
    and in turn, we would be creating an instance attribute with a default value of set(). Mutable default values
    are not allowed in dataclasses!!!
    """

    all_handles: ClassVar[set[str]] = set()
    handle: str = ""

    def __post_init__(self):
        cls = self.__class__
        if self.handle == "":
            self.handle = self.name.split()[0]

        if self.handle in cls.all_handles:
            raise ValueError(f"handle {self.handle} already exists")

        cls.all_handles.add(self.handle)


class DatabaseType:
    def lookup(self, bla: str) -> int:
        return 4


@dataclass
class C:
    i: int
    j: int = None
    database: InitVar[DatabaseType] = None

    def __post_init__(self, database):
        if self.j is None and database is not None:
            self.j = database.lookup("j")


if __name__ == "__main__":
    print(DemoDataClass.__annotations__)
    print(DemoDataClass.__doc__)
    print(get_type_hints(DemoDataClass))
    try:
        print(DemoDataClass.a, DemoDataClass.b, DemoDataClass.c)
    except AttributeError as ae:
        print(f"Correct! It should have produced an Attribute error and it did: {ae}")

    """
    More on dataclasses
    
    @dataclass(*, init=True, repr=True, eq=True, order=False, unsafe_hash=False, frozen=False)
    """

    c: C = C(i=3, database=DatabaseType())
    print(c.j)

    hacker_athlete: HackerClubMember = HackerClubMember(name="Niko Strongioglou")
    print(hacker_athlete.handle)

    try:
        HackerClubMember(name="Niko Alla")
    except ValueError as ve:
        print(f"Correct! A {ve} should be produced")
