from typing import Callable, Any
from datetime import datetime
import time


def decorator(func: Callable[..., Any]):
    def wrapper(*args, **kwargs):
        print("a")
        func(*args, **kwargs)
        print("b")

    return wrapper


def decorator_two(func):
    def wrapper(*args, **kwargs):
        print("a")
        result = func(*args, **kwargs)
        print("b")
        return result

    return wrapper


def decorator_with_args(a: int):
    def decorator_a(func: Callable[..., None]):
        def wrapper(*args, **kwargs):
            print(f"This is {a}")
            func(args, kwargs)
            print(f"This is {a}")

        return wrapper

    return decorator_a


def decorator_with_args_two(a: int):
    def decorator_b(func):
        def wrapper(*args, **kwargs):
            print(f"start {a}")
            result = func(*args, **kwargs)
            print(f"end {a}")
            return result

        return wrapper

    return decorator_b


@decorator_with_args_two(a=45)
def bar():
    return 45


@decorator
def hello():
    print("this is true")


@decorator_with_args(234)
def other():
    print("this is other")


def datetime_decorator_with_arguments(a: int, b: str):
    def decorator_b(func: Callable[[Any], Any]):
        def wrapper(*args, **kwargs):
            print(f"The input string {a},{b}")
            start_time = datetime.now()
            print(f"Started at {start_time}")
            func(*args, **kwargs)
            end_time = datetime.now()
            print(f"End time {end_time}")
            print(f"The method took {end_time - start_time}")

        return wrapper

    return decorator_b


def time_decorator_with_arguments(a: int, b: str):
    def decorator_c(func: Callable[[Any], Any]):
        def wrapper(*args, **kwargs):
            print(f"The input string {a},{b}")
            start_time = time.time()
            print(f"Started at {start_time}")
            func(*args, **kwargs)
            end_time = time.time()
            print(f"End time {end_time}")
            print(f"The method took {end_time - start_time} seconds")

        return wrapper

    return decorator_c


@datetime_decorator_with_arguments(1, "what about this string")
def yet_another():
    print("this is yet another")


@time_decorator_with_arguments(1, "what about this string")
def another():
    print("sleeping for 4 seconds")
    time.sleep(5)


if __name__ == "__main__":
    # hello()
    # other()
    # yet_another()
    # another()

    print(bar())
