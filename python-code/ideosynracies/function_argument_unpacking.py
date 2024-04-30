def add(a: int, b: int, c: int):
    return a + b + c


if __name__ == '__main__':
    a_list = [1, 2, 3]
    b_list = {'a': 1, 'b': 2, 'c': 3}
    print(add(*a_list))
    print(add(**b_list))
