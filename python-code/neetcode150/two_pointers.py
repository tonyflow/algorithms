import re


def is_palindrome(s: str | None) -> bool:

    if s is None:
        return False

    # Lower case
    s = s.lower()

    # Remove white spaces
    s = s.replace(" ","")

    # Replace all non alhanumeric characters
    # s = re.sub(r"[^a-zA-Z0-9]", "", s)
    s = "".join([c for c in s if c.isalnum()])

    if len(s) == 0:
        return True

    left: int = 0
    right: int = len(s) - 1

    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1

    return True


if __name__ == "__main__":
    is_palindrome("Was it a car or a cat I saw?")
