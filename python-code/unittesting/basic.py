import unittest
import sys
from math import sqrt


def is_even(n: int) -> bool:
    return n % 2 == 0


def is_prime(a: int):
    if not isinstance(a, int):
        raise TypeError('Expected an integer')
    if a < 2:
        raise ValueError('Expected integer greater of equals to 2')

    for i in range(2, int(sqrt(a) + 1)):
        if a % i == 0:
            return False

    return True


class DummyClass:
    def __init__(self, a: int):
        self.a = a


class SkipTestCase(unittest.TestCase):
    @unittest.skip("Testing skip annotation")
    def test_equals(self):
        self.assertEqual(abs(10), 10)

    @unittest.skipIf(sys.version_info > (3, 4), "Requires Python <= 3.4")
    def test_equals_negative(self):
        self.assertEqual(abs(-10), 10)

    @unittest.skipUnless(sys.platform.startswith('mac'), "Cannot run on MACs")
    def test_assert_zero(self):
        self.assertEqual(abs(10), 10)


class SimpleTestCase(unittest.TestCase):
    def test_even_numbers(self):
        for number in [2, 4, 6, -8. - 10, -12]:
            with self.subTest(number=number):
                self.assertEqual(is_even(number), True)

    def test_odd_numbers(self):
        for number in [1, 3, 5, -7, -9, -11]:
            with self.subTest(number=number):
                self.assertEqual(is_even(number), False)


class AssertMethodsTestCase(unittest.TestCase):
    def test_is(self):
        a = [1, 2, 3]
        b = a
        self.assertIs(a, b)

    def test_list_objs(self):
        a = [1, 2, 3]
        b = [1, 2, 3]
        self.assertListEqual(a, b)

    def test_membership(self):
        a = [1, 2, 3]
        self.assertIn(1, a)

    def test_instance(self):
        a = DummyClass(1)
        self.assertIsInstance(a, DummyClass, 'a should be a DummyClass instance')


class RaisesTestCase(unittest.TestCase):
    def test_is_prime(self):
        self.assertTrue(is_prime(3))

    def test_is_prime_false(self):
        self.assertFalse(is_prime(4))

    def test_is_prime_raises_value_error(self):
        with self.assertRaises(ValueError):
            is_prime(1)

    def test_assert_raises_type_error(self):
        with self.assertRaises(TypeError):
            is_prime('foo')


def make_test_suite() -> unittest.TestSuite:
    all_test_cases = [
        SimpleTestCase("test_even_numbers"),
        RaisesTestCase("test_assert_raises_type_error")
    ]

    return unittest.TestSuite(tests=all_test_cases)


if __name__ == '__main__':
    unittest.main(verbosity=2)
    # test_suite: unittest.TestSuite = make_test_suite()
    # runner = unittest.TextTestRunner(verbosity=2)
    # runner.run(test_suite)
