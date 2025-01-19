from typing import Dict, List

if __name__ == "__main__":
    test: Dict[str, List[int]] = {"a": [1234]}
    """
    ********************
    ******* SUGAR ******
    ********************
    This is a great way to append to mapping types when the values are lists
    and we're not sure about the existence of the key to be updated
    """
    test.setdefault("b", []).append(6578)
    test.update(b=[1, 2, 34], c=[456])
    print(test)
    test.update({"d": [41234]})
    print(test)
    test.update(**{"e": [23452345]})
    print(test)
