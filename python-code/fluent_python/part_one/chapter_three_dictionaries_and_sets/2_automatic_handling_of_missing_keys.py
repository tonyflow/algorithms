from typing import Dict, List
from collections import defaultdict, UserDict


class CustomDict(dict):
    def __missing__(self, key):
        return [1, 2, 34]


class CustomDict2(UserDict):
    def __missing__(self, key):
        return [1, 2, 34]


if __name__ == '__main__':
    """
    There are two main ways of handling missing dictionary values:
    1. Instantiate a defaultdict instead of a dict. The first argument of a defaultdict
    provides a method that will compute the returned value in case the requested key
    does not exist
    
    2. If we do not want to use a defaultdict, then we can create a custom dict
    using dict inheritance. This custom dictionary can override the __missing__ special
    object method so that custom_dictionary[missing_key] will invoke the __missing__
    method instead
    
    """
    test: Dict[str, List[int]] = defaultdict(list)
    print(test['5'])

    test_2: CustomDict[str, List[int]] = CustomDict()
    print(test_2['5'])

    test_3: CustomDict2[str, List[int]] = CustomDict2()
    print(test_3['5'])
