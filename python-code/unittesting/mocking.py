import unittest
from unittest.mock import Mock, patch


def a_method() -> int:
    return 4


class DummyClass:
    def __init__(self, n: int):
        self.n = n

    def foo(self):
        return self.n


class MockingTestCase(unittest.TestCase):
    @patch("mocking.a_method")
    def test_with_mocking(self, mocked_method: Mock):
        mocked_method.return_value = 6
        self.assertEqual(a_method(), 6)

    @patch.object(DummyClass, "foo")
    def test_with_mocked_object(self, mocked_method: Mock):
        dummy_class: DummyClass = DummyClass(34)
        mocked_method.return_value = 45
        self.assertEqual(dummy_class.foo(), 45)


if __name__ == "__main__":
    unittest.main()
