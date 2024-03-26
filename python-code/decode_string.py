from typing import *
import re


def _find_next_repetition_factor(s: str, start_index: int) -> int:
    repetition_factor = ''
    while s[start_index].isdigit():
        repetition_factor += s[start_index]

    return int(repetition_factor)


class Solution:
    '''
    3[a2[c]] = accaccacc
    2[abc]3[cd]ef = abcabccdcdef

    0. If string does not include [] or numbers then return string as is
    1. Identify repetition factor
    2. Find string enclosed in []
    3. Invoke the method recursively in order to resolve the encoded string
    4. After the recursive call is done multiply the string by the repetition
    factor and return the result to the higher level of recursion
    '''

    def __init__(self):
        self.numbers_expr = r'[0-9]*'

    def decodeString(self, s: str) -> str:
        stack: List[str] = []
        result_str: str = ''
        repetition_factor: int = 0
        for c in s:
            if c == '[':
                stack.append(str(repetition_factor))
                stack.append(result_str)
                repetition_factor = 0
                result_str = ''
            elif c == ']':
                previous_str = stack.pop()
                repetition_factor = int(stack.pop())
                result_str = previous_str + repetition_factor * result_str
            elif c.isdigit():
                repetition_factor = repetition_factor * 10 + int(c)
            else:
                result_str += c

        return result_str

    def decodeString2(self, s: str) -> str:
        if self._is_plain_string(s):
            return s

        # Instantiate partial result
        partial_result = ''

        # Find start index of recursive call
        start_index = 0
        while start_index < len(s):
            iteration_result = ''
            repetition_factor_str = ''

            # Compute all included strings following the patter <number>[<something_else>]

            # Identify prepended or appended plain (not-encoded) string
            while start_index < len(s) and not s[start_index].isdigit():
                partial_result += s[start_index]
                start_index += 1

            # Find repetition factor
            while start_index < len(s) and s[start_index].isdigit():
                repetition_factor_str += s[start_index]
                start_index += 1

            # Assume tha the string is valid and there's [ after the repetition factor always
            stack: List[str] = [s[start_index]]
            start_index += 1
            nested_string_start_index = start_index
            while start_index < len(s) and stack:
                if s[start_index] == '[':
                    stack.append(s[start_index])
                elif s[start_index] == ']':
                    stack.pop()

                # Do nothing if it's just a character
                start_index += 1

            if start_index < len(s):
                nested_decoded = self.decodeString(
                    s[nested_string_start_index:start_index if start_index < len(s) else start_index - 1])

                # Construct the in
                repetition_factor = int(repetition_factor_str) if repetition_factor_str else 1
                for _ in range(int(repetition_factor)):
                    iteration_result += nested_decoded

                partial_result += iteration_result

        return partial_result

    def _is_plain_string(self, s: str):
        if '[' in s or ']' in s:
            return False

        numbers_match = re.match(self.numbers_expr, s)
        if numbers_match:
            return False

        return True


if __name__ == '__main__':
    # match = re.search(r'[0-9]*\[.*\]','2[abc]3[cd]ef')
    # matches = re.findall(r'[0-9]*\[[a-z]+\]*', '3[a2[c]]')
    # print(matches)

    # result = Solution().decodeString('3[a]')
    result = Solution().decodeString('3[a2[c]]')
    print(result)
