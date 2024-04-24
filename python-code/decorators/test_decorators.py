def simple_decorator(func):
    def wrapper():
        print('Before method call')
        result = func()
        print('After method call')
        return result

    return wrapper


def decorator_with_args(foo: int):
    """
    Stackoverflow: https://stackoverflow.com/a/5929165/6566916
    The decorator with arguments should return a function that will take a function and return another function
    :param foo:
    :return:
    """
    def decorator(func):
        def wrapper(*args, **kwargs):
            print(f'Before method call for {foo}')
            result = func()
            print(f'After method call for {foo}')
            return result

        return wrapper

    return decorator


# @simple_decorator
@decorator_with_args(45)
def hello():
    print('Hello')


if __name__ == '__main__':
    hello()
