from threading import Lock
from typing import List
from sqlite3 import connect
from tempfile import TemporaryFile
from requests import Session
from contextlib import contextmanager
from unittest import TestCase


def file_context_manager():
    with open('./test_resources/file.txt', 'r') as f:
        print(f.readlines())
        # for line in f.readlines():
        #     print(line)


test_lock: Lock = Lock()
thread_safe_list: List[int] = []


def locks_in_threading(n: int):
    with test_lock:
        thread_safe_list.append(n)


def database_connections():
    with connect('test_database.db') as connection:
        cursor = connection.cursor()
        cursor.execute('select * from users')
        # process query results


def temporary_files_and_directories():
    """
    TemporaryFile(mode='w+b', buffering=-1, encoding=None,
                      newline=None, suffix=None, prefix=None,
                      dir=None, *, errors=None)
    """
    with TemporaryFile() as tmp_file:
        tmp_file.write(b'Does this really work')
        tmp_file.seek(0)
        print(tmp_file.readlines())


def session_management_in_requests():
    with Session() as session:
        response = session.get(
            'https://images5.1000ps.net/c-cms_W14242_10-tenere700-black-edition-637661001319175475.jpg')
        with open('some_output_folder_and_path', 'wb') as output_f:
            output_f.write(response.content)


def decimal_context():
    pass


# class MyTestTest(TestCase):
#     def test_a_test(self):
#         with self.assertRaises(ValueError):
#             raise ValueError('This is a test Value error')


class ManagedResource:
    def __enter__(self):
        print('Acquire resource')
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        print('Release resource')


@contextmanager
def a_custom_context():
    print('Acquire resource')
    try:
        yield
    finally:
        print('Release resource')


if __name__ == '__main__':
    # file_context_manager()
    # temporary_files_and_directories()
    # with a_custom_context():
    #     print('Using resource - context manager from contextlib')
    #
    with ManagedResource():
        print('Using resource - context manager from a class')
