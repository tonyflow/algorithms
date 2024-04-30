from typing import List, Iterator, Generator


def do_generate(a_i: int) -> str:
    return str(a_i ** 3)


def generate_numbers() -> Iterator[int]:
    """
    There are different type hints that can be used on a method that returns
    a generator:
    1. Generator
    2. Iterator

    """
    # def generate_numbers() -> Generator[int,None,None]:
    for bla in range(10):
        yield do_generate(bla)


def interactive_counter(initial: int) -> Generator[int, int, int]:
    """
    - In general the next method is designed to advance the generator to its next yield point
    - On the first yield invocation the generator will return the current's value back to the
    caller, and it will pause execution.
    - At this point the generator is waiting for a value to be sent back to it through the "send()"
    command

    """
    current = initial
    print('Initialized current')
    while True:
        print('Inside infinite loop')
        increment = yield current  # Yield the current value and wait for a new increment
        print(f'Increment initialized with {increment}')
        if increment is None:  # If None is sent, break the loop
            print('Increment was set to None: Breaking')
            break
        print('Updating current\'s value')
        current += increment
    print('Returning current')
    return current  # Return the last value of current when exiting


def fib(n: int) -> Iterator[int]:
    a, b = 0, 1
    while a < n:
        yield a
        a, b = b, a + b
        print(f'Updated a to {a} and b to {b}')


if __name__ == '__main__':
    # print(list(generate_numbers()))
    # counter: Generator[int, int, int] = interactive_counter(10)
    # print(next(counter))
    # print(counter.send(5))
    # print(counter.send(3))
    #
    # try:
    #     counter.send(None)  # This should exit the generator loop
    # except StopIteration as e:
    #     print(f"Generator returned after exhaustion: {e.value}")

    for i in fib(45):
        print(i)
