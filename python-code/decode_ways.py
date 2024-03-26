from typing import *


class Solution:
    '''
        0. Create the mapping in the description
        1. Tokenize the input string into groups of one or two-digit numbers
        2. Check if the group is valid
            - Group number does not start with 0
            - Group number is between 1 and 26
        3. Remove the group from the original string and call the method recursively
        using the rest of the string
    '''

    def __init__(self):
        self.result: int = 0
        self.alphabet_map = {str(i - 64): chr(i) for i in range(65, 91)}
        self.memo: List[int] = []
        self.original_length = 0

    def numDecodings(self, s: str) -> int:

        self.memo = [-1] * len(s)
        self.original_length = len(s)
        self._do_decode(s, 0)
        return self.memo[0]

    def _do_decode(self, s: str, index: int) -> int:
        if index < self.original_length and self.memo[index] != -1:
            return self.memo[index]

        if not s:
            return 1

        first_way = s[:1] if len(s) >= 1 else ''
        second_way = s[:2] if len(s) >= 2 else ''

        using_first_option: int = self._do_decode(s[1:], index + 1) \
            if self._is_valid(first_way) else 0

        using_second_option: int = self._do_decode(s[2:], index + 2) \
            if self._is_valid(second_way) else 0

        self.memo[index] = using_first_option + using_second_option
        return self.memo[index]

    def _is_valid(self, to_be_checked: str):
        return to_be_checked in self.alphabet_map


if __name__ == '__main__':
    alphabet_map = {str(i - 64): chr(i) for i in range(65, 91)}
    # print('05' in alphabet_map)
    # foo = 'c'
    # print(foo[0:])
    # print(foo[1:])
    print(Solution().numDecodings('12'))
    print(Solution().numDecodings('226'))
    print(Solution().numDecodings('06'))
