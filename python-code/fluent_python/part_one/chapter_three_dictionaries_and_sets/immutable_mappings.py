from types import MappingProxyType
from typing import Dict

if __name__ == '__main__':
    a_dict: Dict[str, int] = {'a': 1}
    a_dict_immutable = MappingProxyType(a_dict)
    # a_dict_immutable['a'] = 3
    a_dict['a'] = 3
    print(a_dict)
