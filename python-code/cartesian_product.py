from copy import deepcopy


def find_cartesian(r: list, current: int, partial: list, a_result: list):
    if current == len(r):
        result.append(deepcopy(partial))
        return

    for i in r[current]:
        partial.append(i)
        find_cartesian(r, current + 1, partial, a_result)
        partial.pop()


if __name__ == '__main__':
    result = []
    # find_cartesian([[1, 2, 3], [4, 5]], 0, [], result)
    find_cartesian([[1, 2, 3]], 0, [], result)
    print(result)
