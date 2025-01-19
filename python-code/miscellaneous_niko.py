from collections import OrderedDict
from typing import *

if __name__ == "__main__":
    # maintains insertion order but no key order
    od = OrderedDict()
    od["c"] = 3
    od["a"] = 1
    od["b"] = 2
    sorted_d = dict(sorted(od.items()))
    print(od)
    print(sorted_d)
    print(len([1, 2, 3]))
    print(list(range(1, 5, 2)))
    print(list(range(1, 5)))
    print(list(range(5)))

    d: Dict[int, str] = {}
    d[1] = 2
    s: Set[int] = set()
    foo = [1, 1, 1, 1, 1]
    for i in foo:
        s.add(i)

    print(s)
