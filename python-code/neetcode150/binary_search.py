def binary_search(r: list[int] | None, target: int):

    if r is None or len(r) == 0:
        return -1

    left = 0
    right = len(r) - 1

    while left <= right:
        middle = left + ((right - left) // 2)
        if r[middle] < target:
            left = middle + 1
        elif r[middle] > target:
            right = middle - 1
        else:
            return middle

    return -1


if __name__ == "__main__":
    test_cases: list[tuple[list[int], int, int | None, str]] = [
        # Basic happy paths
        ([0, 1, 3, 6], 6, 3, "target at right boundary"),
        ([0, 1, 3, 6], 0, 0, "target at left boundary"),
        ([0, 1, 3, 6], 3, 2, "target in middle"),
        # Missing target
        ([0, 1, 3, 6], 2, -1, "target between existing values"),
        ([0, 1, 3, 6], -10, -1, "target below min"),
        ([0, 1, 3, 6], 10, -1, "target above max"),
        # Small inputs
        ([], 1, None, "empty list (expected to fail with current implementation)"),
        ([5], 5, 0, "single element found"),
        ([5], 2, -1, "single element missing"),
        # Two elements
        ([1, 2], 1, 0, "two elements, find first"),
        ([1, 2], 2, 1, "two elements, find second"),
        (
            [1, 2],
            3,
            None,
            "two elements, missing high (expected to fail with current implementation)",
        ),
        # Duplicates
        ([1, 1, 1, 1], 1, None, "all duplicates (any index 0..3 is valid)"),
        ([1, 2, 2, 2, 3], 2, None, "duplicate block (any index 1..3 is valid)"),
        # Negatives and mixed values
        ([-10, -5, -1, 0, 4, 9], -10, 0, "negative, left boundary"),
        ([-10, -5, -1, 0, 4, 9], 9, 5, "positive, right boundary"),
        ([-10, -5, -1, 0, 4, 9], -6, -1, "missing negative"),
    ]

    for arr, target, expected, label in test_cases:
        try:
            result = binary_search(arr, target)

            if expected is None:
                # Case where multiple answers are valid or we intentionally expect current code to fail.
                if label.startswith("all duplicates"):
                    passed = result in {0, 1, 2, 3}
                elif label.startswith("duplicate block"):
                    passed = result in {1, 2, 3}
                else:
                    passed = False
            else:
                passed = result == expected

            status = "PASS" if passed else "FAIL"
            print(
                f"[{status}] {label}: arr={arr}, target={target}, "
                f"result={result}, expected={expected}"
            )
        except Exception as exc:
            print(
                f"[EXCEPTION] {label}: arr={arr}, target={target}, "
                f"{type(exc).__name__}: {exc}"
            )
