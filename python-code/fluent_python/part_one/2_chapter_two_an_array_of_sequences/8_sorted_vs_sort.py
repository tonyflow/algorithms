from typing import List

if __name__ == "__main__":
    """
    sorted VS list.sort

    list.sort
    =========
    The list.sort method sorts a list in place—that is, without making a copy. It returns None to
    remind us that it changes the receiver and does not create a new list. This is an important Python 
    API convention: functions or methods that change an object in place should return None to make it clear
    to the caller that the receiver was changed, and no new object was created.

    sorted
    =======
    In contrast, the built-in function sorted creates a new list and returns it. It accepts any
    iterable object as an argument, including immutable sequences and generators. Regardless of the 
    type of iterable given to sorted, it always returns a newly created list.

    """
    another_list: List[int] = list(range(10, 0, -1))
    another_list.sort()
    print(another_list)

    using_sorted_list: List[int] = list(range(10, 0, -1))
    print(sorted(using_sorted_list))

    # More examples
    fruits = ["grape", "raspberry", "apple", "banana"]
    print(f"Sorted default {sorted(fruits)}")
    print(f"Sorted reverse {sorted(fruits, reverse=True)}")
    print(
        f"Sorted using another key in reverse {sorted(fruits, key=len, reverse=True)}"
    )

    # Sorting in place
    fruits.sort()
    print(fruits)
