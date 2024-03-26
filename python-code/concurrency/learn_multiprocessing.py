from multiprocessing import Pool


def square(number):
    return number * number


if __name__ == '__main__':
    numbers = [1, 2, 3, 4, 5]
    with Pool(5) as pool:
        results = pool.map(square, numbers)
        print(results)
