from typing import List

if __name__ == "__main__":
    s = "bicycle"
    print(s[::3])
    print(s[::-1])
    print(s[::-2])

    for f in s[::-2]:
        print(f)

    """
    Slices can also be represented as objects
    """
    SLICE_OBJECT = slice(1, 3)
    print(s[SLICE_OBJECT])

    l = list(range(10))
    print(f"l is {l} and length is {len(l)}")
    l[2:5] = [10, 20]
    print(f"Mutating: l is {l} and length is {len(l)}")
    del l[2:5]
    print(f"Deleting: l is {l} and length is {len(l)}")
    l[2:5] = [100]
    print(f"Mutating again: l is {l} and length is {len(l)}")
