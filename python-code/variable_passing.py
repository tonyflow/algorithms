from typing import List


def method_a_immutable_objects(a: int):
    a += 1


def method_b_immutable_objects(a: int) -> int:
    return a + 1


def method_a_mutable_objects(a_list: List[int]):
    a_list.append(45)


def list_changer(a_list: List[int]):
    a_list = [7, 8, 9]
    print(a_list)


if __name__ == '__main__':
    b = 4
    method_a_immutable_objects(b)
    print(b)

    b = method_b_immutable_objects(b)
    print(b)

    c = [1, 2, 3]
    list_changer(c)
    print(f'Original c list: {c}')
    method_a_mutable_objects(c)
    print(f'Updated list {c}')
