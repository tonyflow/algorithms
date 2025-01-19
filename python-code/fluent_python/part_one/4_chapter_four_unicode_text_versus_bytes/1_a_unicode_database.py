import sys
import unicodedata
from typing import List

START, END = ord(" "), sys.maxunicode + 1


def translate(query_words: List[str]):
    query = {w.upper() for w in query_words}
    for code in range(START, END):
        char = chr(code)
        name = unicodedata.name(char, None)
        if name and query.issubset(name.split()):
            print(f"U+{code:04X}\t{char}\t{name}")


if __name__ == "__main__":
    translate("grinning cat face with smiling eyes".split())
