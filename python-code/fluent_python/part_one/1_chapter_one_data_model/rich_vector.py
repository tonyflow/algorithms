import math


class Vector:
    def __init__(self, x: int = 0, y: int = 0):
        self.x = x
        self.y = y

    def __repr__(self):
        """
        !r returns the __repr__ method value of the object is used upon. Otherwise, the
        interpreter uses the str(obj) method on the object.
        """
        return f"Vector({self.x!r},{self.y!r})"

    def __abs__(self):
        return math.hypot(self.x, self.y)

    def __bool__(self):
        return bool(abs(self))

    def __add__(self, other_vector_to_add):
        return Vector(self.x + other_vector_to_add.x, self.y + other_vector_to_add.y)

    def __mul__(self, scalar: int):
        return Vector(scalar * self.x, scalar * self.y)


if __name__ == "__main__":
    vector: Vector = Vector(1, 3)
    other: Vector = Vector(4, 5)
    print(vector + other)
    multiplied = vector * 4
    print(multiplied)
    print(vector)
    # if Vector():
    if vector:
        print("Evaluated truthy")
    else:
        print("Evaluated falsy")

    an_intersection = {1, 2, 3, 4, 5} & {4, 5}
    print(an_intersection)
