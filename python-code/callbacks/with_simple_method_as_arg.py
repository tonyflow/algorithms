from typing import Callable


def greet(name: str):
    print(f'Hello {name}!')


def callback(func: Callable[..., ...], *args, **kwargs):
    func(*args, **kwargs)


if __name__ == '__main__':
    callback(greet, 'Alice')
