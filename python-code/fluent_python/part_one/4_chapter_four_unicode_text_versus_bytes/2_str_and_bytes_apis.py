import re

if __name__ == "__main__":
    """
    you can use regular expressions on str and bytes, but in the second case, bytes outside the ASCII 
    range are treated as nondigits and nonword characters.
    """
    digits_regex = re.compile(r"[0-9]+")
    words_regex = re.compile(r"[a-zA-Z]+")

    test_str = "I have 12 ducks with 4 ducklings each"

    found_digits = digits_regex.findall(test_str)
    found_words = words_regex.findall(test_str)

    print(f"Found the following digits {found_digits}")
    print(f"Found the following words {found_words}")
