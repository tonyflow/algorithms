import re


def value(roman: str) -> int | None:
    roman_mapping = {
        "i": 1,
        "v": 5,
        "x": 10,
        "l": 50,
        "c": 100,
        "d": 500,
        "m": 1000,
    }

    roman_lower = roman.lower()
    included_characters = {c for c in roman_lower}

    if not included_characters or not included_characters.issubset(
        roman_mapping.keys()
    ):
        return None

    last_digit = roman_lower[-1]
    # print(last_digit, roman_lower)
    result = roman_mapping[last_digit]

    if len(roman) == 1:
        return result
    reversed_roman = reversed(roman_lower[:-1])
    for c in reversed_roman:
        # print(f'c, roman_mapping[c]: {c, roman_mapping[c]}')
        # print(f'last_digit, roman_mapping[last_digit] {last_digit,roman_mapping[last_digit]}')
        if roman_mapping[c] >= roman_mapping[last_digit]:
            result += roman_mapping[c]
            # print(f'result {result}')
        else:
            result -= roman_mapping[c]
            # print(f'result {result}')

        if roman_mapping[c] > roman_mapping[last_digit]:
            last_digit = c

    return result


def _matches(test_name: str, input: str, expected: int | None):
    actual_value = value(input)
    is_correct = actual_value == expected

    print(
        f"{test_name} passed."
        if is_correct
        else f" {test_name} failed. Got "
        + str(actual_value)
        + ", expected "
        + str(expected)
    )


if __name__ == "__main__":
    _matches("a_i", "i", 1)
    _matches("a_v", "V", 5)
    _matches("a_x", "x", 10)
    _matches("a_l", "L", 50)
    _matches("a_c", "C", 100)
    _matches("a_d", "d", 500)
    _matches("a_m", "m", 1000)
    _matches("b_iii", "IiI", 3)
    _matches("b_vi", "VI", 6)
    _matches("b_xvii", "XVII", 17)
    _matches("b_mlxvi", "mlxvi", 1066)
    _matches("b_mmxviiI", "MMXVIII", 2018)
    _matches("c_iv", "iv", 4)
    _matches("c_xxix", "xxix", 29)
    _matches("c_mcdxliv", "mcdxliv", 1444)
    _matches("c_mcmlvi", "MCMLVI", 1956)
    _matches("d_vvvvviiiii", "vvvvviiiii", 30)
    _matches("d_mmmmmmmmmm", "mmmmmmmmmm", 10000)
    _matches("e_xiix", "xiix", 18)
    _matches("e_iiiiiiiiiixi", "iiiiiiiiiixi", 1)
    _matches("x_mmmmtasty", "MMMMTASTY", None)
    _matches("x_29", "29", None)
    _matches("x_<blank>", "", None)
