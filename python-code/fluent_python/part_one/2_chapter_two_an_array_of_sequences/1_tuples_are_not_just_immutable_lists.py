from typing import Any


def is_hashable(o: Any) -> bool:
    """
    The method will determine:
    1. Explicitly: if the object provided is hashable
    2. Implicitly: if the objects contained in this object are mutable or immutable
    """
    try:
        hash(o)
        return True
    except TypeError:
        return False


if __name__ == '__main__':
    """
    Tuples as records
    """
    lax_coordinates = (33.9425, -118.408056)
    city, year, pop, chg, area = ('Tokyo', 2003, 32_450, 0.66, 8014)
    traveler_ids = [('USA', '31195855'),
                    ('BRA', 'CE342567'),
                    ('ESP', 'XDA205856')]

    # for passport in sorted(traveler_ids):
    #     print('%s/%s' % passport)
    #
    # for country, passport_number in traveler_ids:
    #     print(f'{country}/{passport_number}')

    """
    Tuples as immutable lists
    The interpreter makes extensive use of immutable lists because of
    1. Clarity: When you see a tuple in code, you know its length will never change.
    2. Performance: A tuple uses less memory than a list of the same length, and it allows Python to do some 
    optimizations.
    """
    tuple_immutable = (1, 'abc', (1, 2, 3))
    tuple_mutable = (1, 'abc', [1, 2, 3])
    print(f'Immutable tuple {is_hashable(tuple_immutable)}')
    print(f'Mutable tuple {is_hashable(tuple_mutable)}')

    """
    Tuples are more efficient than lists:
    1. In order to evaluate a tuple literal, the compiler can generate bytecode in one operation.
    For a list, the bytecode generated pushes each element to the data stack one by one and then
    builds the list.
    2. Given a tuple r, tuple(r) directly returns a reference to the same r. Given a list l,
    list(l) must create a copy and then return the reference of this copy.
    3. Due its fixed length tuples are allocated a specific amount of space. List instances though
    are allocated more space since we need to accommodate the need for potential future appends.
    4. Both lists and tuples are container collections. This means that they hold references to the 
    objects they contain. For tuples, these references are held in an array inside the tuple struct.
    A list though has a reference to an array of those object references held elsewhere. This is 
    necessary since this array might need to be extended due the mutable nature of lists.
    """