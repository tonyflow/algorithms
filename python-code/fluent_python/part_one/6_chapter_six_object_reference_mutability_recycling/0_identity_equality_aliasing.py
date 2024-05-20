from copy import copy, deepcopy


# Singleton
class ASingleton:
    instance = None

    def __new__(cls, *args, **kwargs):
        if not cls.instance:
            cls.instance = super(ASingleton, cls).__new__(cls, )

        return cls.instance


class Bus:
    def __init__(self, passengers=None):
        if passengers is None:
            self.passengers = []
        else:
            self.passengers = list(passengers)

    def pick(self, name):
        self.passengers.append(name)

    def drop(self, name):
        self.passengers.remove(name)


if __name__ == '__main__':
    """
    Important things to take away from this chapter:
    - Equality and Identity are different
    """
    charles = {'name': 'Charles L. Dodgson', 'born': 1832}
    lewis = charles
    print(lewis is charles)
    print(id(charles), id(lewis))
    lewis['balance'] = 950
    print(charles)

    alex = {'name': 'Charles L. Dodgson', 'born': 1832, 'balance': 950}
    # == compares the values of objects
    print(alex == charles)
    # ""is"" compares the IDs of objects
    print(alex is charles)

    """
    We are using ""is"" when we want to compare a variable against singleton and sentinel objects
    - Singleton
    - Sentinel
    """

    foo = ASingleton()
    bar = ASingleton()
    print(f'Checking singleton equality {foo is bar}')

    l1 = [3, [66, 55, 44], (7, 8, 9)]
    l2 = list(l1)
    l1.append(100)
    l1[1].remove(55) # this will remove 55 from both lists!!!
    print('l1:', l1)
    print('l2:', l2)
    l2[1] += [33, 22]
    l2[2] += (10, 11)
    print('l1:', l1)
    print('l2:', l2)

    """
    Deep and Shallow copy
    """
    bus1 = Bus(['Alice', 'Bill', 'Claire', 'David'])
    bus2 = copy(bus1)
    bus3 = deepcopy(bus1)
    print(id(bus1), id(bus2), id(bus3))
    bus1.drop('Bill')
    print(bus2.passengers)
    print(bus3.passengers)
    print(id(bus1.passengers), id(bus2.passengers), id(bus3.passengers))

    # Cyclic references
    a = [1, 2]
    b = [a, 30]
    a.append(b)
    # In this case deepcopy managed to handle the cyclic reference
    c = deepcopy(a)
