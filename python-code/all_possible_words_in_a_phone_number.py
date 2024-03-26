from typing import *

digits_to_letters = {
    '2': ["a", "b", "c"],
    '3': ["d", "e", "f"],
    '4': ["g", "h", "i"],
    '5': ["j", "k", "l"],
    '6': ["m", "n", "o"],
    '7': ["p", "q", "r", "s"],
    '8': ["t", "u", "v"],
    '9': ["w", "x", "y", "z"],
}

result: List[str] = []


def letterCombinations(digits: str) -> List[str]:
    find(digits, 0, "")
    return result


def find(digits: str, currentIndex: int, word: str):
    if currentIndex == len(digits):
        result.append(word)
        return

    if digits[currentIndex] in digits_to_letters:
        for letter in digits_to_letters[digits[currentIndex]]:
            find(digits, currentIndex + 1, word + letter)


'''
aka letter combinations of a phone number
'''
if __name__ == '__main__':
    letterCombinations("234")
    print(result)
