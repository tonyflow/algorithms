import time
from typing import Callable, Any


class Timer:
    def time(self, func: Callable[[...], Any], *args, **kwargs) -> Any:
        start = time.time()
        result = func(*args, **kwargs)
        end = time.time()
        print(f"Method took {end - start} seconds to execute")
        return result


def timer(func: Callable[[...], Any]):
    def wrapper(*args, **kwargs):
        start = time.time_ns()
        result = func(*args, **kwargs)
        end = time.time_ns()
        print(f"Method {func.__qualname__} took {end - start} ns to execute")
        return result

    return wrapper
