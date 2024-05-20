import collections
from typing import List, NamedTuple
from random import choice


# Card = collections.namedtuple('Card', ['rank', 'suit'])
class Card(NamedTuple):
    rank: str
    suit: str


class FrenchDeck:
    ranks: List[str] = [str(n) for n in range(2, 11)] + list('JKQA')
    suits: List[str] = 'spades hearts diamonds clubs'.split()

    def __init__(self):
        self._deck = [Card(r, s) for r in self.ranks for s in self.suits]

    def __len__(self):
        return len(self._deck)

    def __getitem__(self, item):
        return self._deck[item]


suit_values = dict(spades=3, hearts=2, diamonds=1, clubs=0)


def spades_high(card: Card) -> int:
    rank_value = FrenchDeck.ranks.index(card.rank)
    return rank_value * len(suit_values) + suit_values[card.suit]


if __name__ == '__main__':
    print(type(list(suit_values.keys())))

    deck: FrenchDeck = FrenchDeck()
    # Supports standard collection methods like length
    print(len(deck))

    # Supports random card selection
    print(choice(deck))
    print(choice(deck))
    print(choice(deck))

    # Supports slicing
    print(deck[:3])

    # Supports iteration
    for c in sorted(deck, key=spades_high):
        print(c)

    # Contains
    print(Card('1', 'foo') in deck)
    print(Card('A', 'spades') in deck)

    # # sorting
    # sorted_deck =
