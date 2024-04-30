from typing import List


def mutable_default_arguments(to_append: int,
                              a: List[int] = []):
    print(a)
    a.append(to_append)


if __name__ == '__main__':
    for i in range(10):
        mutable_default_arguments(i)
