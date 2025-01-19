"""
There is no put of the box tree map Python implementation but there are a few ways to go about creating a treemap
This is how some of them are created
"""

from sortedcontainers import SortedDict
from collections import OrderedDict

if __name__ == "__main__":
    """
    The first implementation makes use of the installed sorted containers library
    """
    sd: SortedDict = SortedDict()
    sd[3] = "foo"
    sd[-33] = "foo"
    sd[0] = "foo"
    sd[67] = "foo"

    for k, v in sd.items():
        print(k, v)

    """
    The second implementation makes use of the dict but the items are sorted upon insert. This is
    obviously not the most effective way of implementing a treemap
    """
    simple_sd = {"c": 2, "b": 1, "a": -45}
    sorted_d = dict(sorted(simple_sd.items()))

    for k, v in sorted_d.items():
        print(k, v)

    """
    The third implementation makes use of the OrderedDict struct from the collection module. The problem with this is
    that it will only preserve the insertion order. If we want to order the items based on their key, we would have to
    sort them again ourselves
    """

    od: OrderedDict = OrderedDict()
    od["c"] = 3
    od["a"] = 1
    od["b"] = 2
    od = OrderedDict(sorted(od.items()))

    for key, value in od.items():
        print(key, value)
