from typing import List, Callable

if __name__ == '__main__':
    """
    The following list comprehension creates a list of integers
    """
    print("Testing simple list comprehensions")
    a: List[int] = [i for i in range(3)]
    print(a)

    """
    The following list comprehension creating a list of functions/lambdas
    which take no arguments and return an integer in the rage [0,3)
    """
    print("Testing list comprehensions producing no argument callables returning an int")
    func_other: List[Callable[[], int]] = [lambda: 1, lambda: 2, lambda: 3]
    for fo in func_other:
        print(fo())

    print("Testing list comprehensions producing a string argument callable returning an int")
    funcs_with_args: List[Callable[[str], int]] = [lambda x: 7 for _ in range(2)]
    for fwa in funcs_with_args:
        print(fwa('this is a random string'))

    print("Now actually testing late binding")
    """
    This is an example of how late binding manifests.
    Late binding refers to how function closures capture variables - NOT VALUES! - from the
    surrounding scope.The value of these variables is looked up when the function is called.
    
    This means that by the time the loop that prints the results executes, the list
    comprehension has completed, and "i" has finished its iteration over the range, ending up
    to its final value "2". Therefore, all lambda functions in the list "funcs" refer to
    the same "i" , which now is "2".
    """
    funcs = [lambda: i for i in range(3)]
    for f in funcs:
        print(f())

    """
    We can fix the previous behavior by making the lambda "remember" the value
    of "i" the time is was created by using a default argument! Default arguments
    are evaluated at the time of a functions definition - NOT EXECUTION!
    """
    print("What about circumventing the late binding thing?")
    funcs = [lambda r=r: r for r in range(3)]
    for f in funcs:
        print(f())
