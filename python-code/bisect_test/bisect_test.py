import bisect

if __name__ == '__main__':
    test_list: list[int] = [78, 4, 56]
    sorted_test_list: list[int] = []
    for n in test_list:
        bisect.insort(sorted_test_list, n)
    bisect.insort(sorted_test_list, 0)
    bisect.insort(sorted_test_list, 1)
    bisect.insort(sorted_test_list, 4)
    print(sorted_test_list)
