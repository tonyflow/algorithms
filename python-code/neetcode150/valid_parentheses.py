def is_valid(s: str) -> bool:
    pairs: dict[str, str] = {")": "(", "}": "{", "]": "["}

    validation_stack = []

    for character in s:
        if character in pairs:
            if validation_stack and validation_stack[-1] == pairs[character]:
                validation_stack.pop()
            else:
                validation_stack.append(character)
        else:
            validation_stack.append(character)

    return False if validation_stack else True


if __name__ == "__main__":
    print(is_valid("[]"))