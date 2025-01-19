from typing import List


class MyClass:
    shared_list: List[int] = []

    def add(self, item: int):
        self.shared_list.append(item)


if __name__ == "__main__":
    obj1: MyClass = MyClass()
    obj2: MyClass = MyClass()
    obj2.add(45)
    print(obj1.shared_list)
