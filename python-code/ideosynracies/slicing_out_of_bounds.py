from typing import List

if __name__ == "__main__":
    """
    Python allows slicing lists and strings without raising an error, 
    even if the indices are out of bounds:
    """
    lst: List[int] = [1, 2, 3]
    print(lst[10:])
