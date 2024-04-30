if __name__ == '__main__':
    """
    ==: Check if two variables have the same value
    is: Check if two variables point to the same object!
    """
    a = [1, 2, 3]
    b = [1, 2, 3]
    c = a
    print(a == b)
    print(a is b)
    print(a is c)
