"""
Overview
=========
The list type is flexible and easy to use, but depending on specific requirements, there are
better options. For example, an array saves a lot of memory when you need to handle millions of
floating-point values. On the other hand, if you are constantly adding and removing items from
opposite ends of a list, it’s good to know that a deque (double-ended queue) is a more efficient
FIFO14 data structure.

If your code frequently checks whether an item is present in a collection (e.g., item in
my_collection), consider using a set for my_collection, especially if it holds a large number
of items. Sets are optimized for fast membership checking. They are also iterable, but they
are not sequences because the ordering of set items is unspecified.
"""

from array import array
from random import random

if __name__ == '__main__':
    """
    array(typecode [, initializer]) -> array
    """
    a = array('d', (random() for _ in range(10 ** 7)))
    with open('floats.bin', 'wb') as ff:
        a.tofile(ff)

    b = array('d')
    with open('floats.bin', 'rb') as ff:
        b.fromfile(ff, 10 ** 7)
        print(f'Read {len(b)}')
    # print(a)
    # b = array('b', (random() for _ in range(100)))

    """
    bytes: immutable
    bytearray: mutable
    """
    with open('some_image.png', 'rb') as im:
        byte_load: bytes = im.read()
        # byte_load: bytes = bytearray(im.read())

    """
    memoryview: Similar to numpy matrices. Used for reshaping arrays and lists
    once cast to memviews
    """

    """
    deques: The class collections.deque is a thread-safe double-ended queue designed 
    for fast inserting and removing from both ends. It is also the way to go if you 
    need to keep a list of “last seen items” or something of that nature, because a deque 
    can be bounded —i.e., created with a fixed maximum length. If a bounded deque is full, 
    when you add a new item, it discards an item from the opposite end.
    """
