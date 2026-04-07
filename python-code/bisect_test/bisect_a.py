import bisect

if __name__ == "__main__":
    # al: list[int] = [x for x in range(0, 21, 2)]
    # print(al)
    #
    # print(bisect.insort(al, 1))
    # print(al)
    #
    # print(bisect.insort(al, 11))
    # print(al)

    another = [-10, 2, 2, 2, 2, 2, 2, 5]
    print(bisect.bisect_left(another, 1))
    print(bisect.bisect_left(another, -11))
    print(bisect.bisect_left(another, 3))
    print(bisect.bisect_left(another, 6))
