from typing import *


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack: List[str] = []
        visited: Set[str] = set()
        last_occurrence: Dict[str, int] = {}

        for i in range(len(s)):
            last_occurrence[s[i]] = i

        print(last_occurrence)

        for i in range(len(s)):
            if s[i] not in visited:
                while stack and stack[-1] > s[i] and last_occurrence[stack[-1]] > i:
                    visited.remove(stack.pop())

                stack.append(s[i])
                visited.add(s[i])

        return "".join(stack)


if __name__ == "__main__":
    print(Solution().removeDuplicateLetters("cbacdcbc"))
