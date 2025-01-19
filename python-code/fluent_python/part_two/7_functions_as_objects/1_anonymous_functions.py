from typing import List

"""
The lambda keyword creates anonymous functions within a Python expression.
If the lambda tends to get more complicated this is a nice recipe for refactoring:
1. Write a comment explaining what the heck that lambda does.
2. Study the comment for a while, and think of a name that captures the essence of
the comment.
3. Convert the lambda to a def statement, using that name.
4. Remove the comment.
"""

if __name__ == "__main__":
    """
    The best use for an anonymous function in in an arguments list for a higher order function like sorted
    """
    fruits = ["strawberry", "fig", "apple", "cherry", "raspberry", "banana"]
    sorted_reversed_fruits: List[str] = sorted(fruits, key=lambda x: x[::-1])
    print(sorted_reversed_fruits)
