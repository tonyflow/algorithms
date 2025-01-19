"""
The only mode of parameter passing in Python is call by sharing. Call by sharing means that each formal parameter of the
function gets a copy of each reference in the arguments. In other words, the parameters inside the function become
aliases of the actual arguments.
"""

from typing import Optional, List


class HauntedBus:
    """A bus model haunted by ghost passengers"""

    def __init__(self, passengers=[]):
        self.passengers = passengers

    def pick(self, name):
        self.passengers.append(name)

    def drop(self, name):
        self.passengers.remove(name)


class HauntedBusFirstOptimization:
    def __init__(self, passengers=Optional[List[str]]):
        if passengers is None:
            self.passengers = []
        else:
            self.passengers = passengers

    def pick(self, name):
        self.passengers.append(name)

    def drop(self, name):
        self.passengers.remove(name)


class HauntedBusOptimal:
    def __init__(self, passengers=Optional[List[str]]):
        if passengers is None:
            self.passengers = []
        else:
            self.passengers = list(passengers)

    def pick(self, name):
        self.passengers.append(name)

    def drop(self, name):
        self.passengers.remove(name)


if __name__ == "__main__":

    def f(aa, bb):
        """
        If the arguments are immutable then, += will create a new object and assign it to aa
        """
        aa += bb
        return aa

    x, y = 1, 2
    a, b = [1, 2, 3], [4, 5]

    f(x, y)
    f(a, b)
    print(x, y)  # Integers are immutable and the value of x should not change
    print(a, b)  #

    print("Haunted Bus Testing")
    bus1 = HauntedBus(["Alice", "Bill"])
    print(bus1.passengers)

    bus1.pick("Charlie")
    bus1.drop("Alice")
    print(bus1.passengers)
    bus2 = HauntedBus()
    bus2.pick("Carrie")
    print(bus2.passengers)
    bus3 = HauntedBus()
    print(bus3.passengers)
    bus3.pick("Dave")
    print(bus2.passengers)
    print(bus2.passengers is bus3.passengers)
    print(bus1.passengers)

    def append_to_list(value, my_list=[]):
        my_list.append(value)
        return my_list

    # First call
    print(append_to_list(1))  # Output: [1]

    # Second call
    print(append_to_list(2))  # Output: [1, 2]

    # Third call
    print(append_to_list(3))  # Output: [1, 2, 3]

    print(append_to_list(3, []))  # Output: [1, 2, 3]
