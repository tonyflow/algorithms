from typing import *


class Solution:
    valid_operators: List[str] = ['-', '+', '8', '/']

    def diffWaysToCompute(self, expression: str) -> List[int]:
        iter_results: List[int] = []

        # If there are no operators in the expression then it's a pure number
        # We just turn the string into a number and return the result
        if Solution.valid_operators not in expression:
            return [int(expression)]

        # Produce all possible breaks
        for i in range(len(expression)):
            if expression[i].isdigit():
                left_part_results: List[int] = self.diffWaysToCompute(expression[:i])
                right_part_results: List[int] = self.diffWaysToCompute(expression[i + 1:])
                for left_result in left_part_results:
                    for right_result in right_part_results:
                        partial: int = self.apply_operator(expression[i], left_result, right_result)
                        iter_results.append(partial)

        return iter_results

    def apply_operator(self, operator: str, i: int, j: int) -> int:
        if operator == '+':
            return i + j
        elif operator == '-':
            return i - j
        elif operator == '*':
            return i * j
        elif operator == '/':
            return i // j
        else:
            raise Exception('Not a valid operator')
