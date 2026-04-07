from typing import List


def encode(strs: List[str]) -> str:
    """Encode incoming list of strings.

    A naive approach would be to
    1. Concatenate all strings together
    2. Have a sentinel value to separate the concatenated strings from metadata
    3. Included metadata that defined the lengths of the strings
    4. The decoder finds the sentinel value and by reading the metadata,
    it can reconstruct the initial list of strings

    Another translation would be to
    1. Translate each character to its ordinal in the ASCII table
    2. Every character is separated by a "|"
    2. The end of the every word is identified by "--"
    3. The reconstruction follows the reverse process
    """
    # ["cat","dog","123","$%^&%"]
    parts = []
    for s in strs:
        if not s:
            continue
        for character in s:
            parts.append(str(ord(character)))
            parts.append("|")

        # Remove last "|"
        parts.pop()
        parts.append("-")

    # Do not let string end with a "-". Remove it from the end
    if parts:
        parts.pop()

    print(f"All parts {parts}")

    return "".join(parts)


def encode_naive(strs: List[str]) -> str:
    """Encode a list of strings using length-prefix framing.

    Format for each string: "<length>#<content>".
    Example: ["cat", ""] -> "3#cat0#"
    """
    return "".join(f"{len(word)}#{word}" for word in strs)


def encode_a(strs: list[str]) -> str:
    """
    Another translation would be
    1. Start with the length of the string. We append '#' at the end of the number
    reprenting the length of the string
    2. Once the digits representing the length of the string are read, we can start
    reading the actual string character by character.
    3. Once we have read the entire string, we move on to reading the length of the next string.
    """
    pass


def encode_b(strs: list[str]) -> str:
    pass


def decode_single_word(running_index: int, entire_encoding: str) -> str:
    pass


def decode(s: str) -> List[str]:
    """Input A

    99|97|116-100|111|103-49|50|51-36|37|94|38|37-
    """
    all_words: list[str] = []
    current_character = ""
    current_word = ""
    for i in range(len(s)):
        if s[i] == "-":
            # Close current word
            current_word += chr(int(current_character))

            # Update list of overall results
            all_words.append(current_word)

            # Reset current character
            current_character = ""

            # Reset word
            current_word = ""

        elif s[i] == "|":
            # Update current word
            current_word += chr(int(current_character))

            # Reset current character
            current_character = ""
        else:
            # Otherwise, we need to assemble a character
            current_character += str(s[i])

    if s:
        # Remaining characters
        current_word += chr(int(current_character))

    # Append remaining word
    all_words.append(current_word)

    return all_words


def decode_naive(s: str) -> List[str]:
    """Decode a string encoded by `encode_naive`."""
    decoded: list[str] = []
    index = 0

    while index < len(s):
        delimiter = s.find("#", index)
        if delimiter == -1:
            raise ValueError("Invalid encoding: missing length delimiter '#'.")

        word_length = int(s[index:delimiter])
        start = delimiter + 1
        end = start + word_length
        decoded.append(s[start:end])
        index = end

    return decoded

def decode_other( s: str) -> List[str]:
        index = 0
        all_words = []
        while index < len(s):
            hash_index = s.find('#', index)
            if hash_index == -1:
                raise ValueError("Could not find any #. Malformed encoding.")
            length_of_current_word = len(s[index:hash_index])
            start = hash_index + 1
            end = start + length_of_current_word
            all_words.append(s[start:end])
            index = end
        
        return all_words


def decode_a(strs: list[str]) -> str:
    pass


def decode_b(strs: list[str]) -> str:
    pass


if __name__ == "__main__":
    # for i in range(256):
    #     print(f"{i:3} -> {repr(chr(i))}")

    # encoded_word = encode(["cat", "dog", "123", "$%^&%"])
    # print(f"Encoded string is {encoded_word}")
    # decoded_word = decode(encoded_word)
    # print(decoded_word)

    # encoded_word = encode_naive(["cat", "dog", "123", "$%^&%"])
    # print(f"Encoded string is {encoded_word}")
    # decoded_word = decode_naive(encoded_word)
    # print(decoded_word)

    encoded_word = encode_naive(["Hello", "World"])
    print(f"Encoded string is {encoded_word}")
    decoded_word = decode_other(encoded_word)
    print(decoded_word)
