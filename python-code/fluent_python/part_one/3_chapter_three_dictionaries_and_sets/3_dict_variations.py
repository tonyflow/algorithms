from collections import ChainMap, Counter, OrderedDict

if __name__ == "__main__":
    """
    1. collections.OrderedDict: Now that the built-in dict also keeps the keys ordered since Python 3.6,
     the most common reason to use OrderedDict is writing code that is backward compatible with earlier Python 
     versions. The ordered list only respects INSERTION order.
        *** The regular dict was designed to be very good at mapping operations. 
            Tracking insertion order was secondary.
        *** OrderedDict was designed to be good at reordering operations. 
            Space efficiency, iteration speed, and the performance of update operations were secondary.
        *** Algorithmically, OrderedDict can handle frequent reordering operations better than dict.
            This makes it suitable for tracking recent accesses (for example, in an LRU cache).
    2. collections.ChainMap
    3. collections.Counter
    4. shelve.Shelf: Mapping of string keys to Python objects serialized using
    the pickle binary format: "pickle jars are stored on shelves".
    """
    ordered_dict = OrderedDict({"b": 2, "a": 1})
    print(ordered_dict)
    d1 = dict(a=1, b=3)
    d2 = dict(a=2, b=4, c=6)
    chain = ChainMap(d1, d2)
    print(chain["a"])
    print(chain["c"])

    # Updates or insertions only affect the first input mapping
    chain["c"] = -1
    print(d1)

    ct = Counter("abracadabra")
    print(ct)
    ct.update("aaaaazzz")
    print(ct)
    print(ct.most_common(3))
