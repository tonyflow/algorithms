import unittest

"""
setUp and tearDown runs once per test case method
setUpClass and tearDownClass run once for the entire test case
"""


class UsingFixtures(unittest.TestCase):
    def setUp(self):
        self.foo = []

    def tearDown(self):
        del self.foo

    def test_fixture(self):
        self.foo.append(3)
        self.assertListEqual(self.foo, [3])


if __name__ == '__main__':
    unittest.main(verbosity=2)
