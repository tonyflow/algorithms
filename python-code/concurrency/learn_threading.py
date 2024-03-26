from threading import Thread
from time import sleep


def print_something(arg):
    print(f'something is {arg}')


def do_something_mem_heavy(time_s):
    sleep(time_s)


if __name__ == '__main__':
    threads = []
    t: Thread = Thread(target=print_something, args=('foo',))
    s: Thread = Thread(target=do_something_mem_heavy, args=(4,))
    s.start()
    t.start()
    threads.append(t)
    threads.append(s)

    for t in threads:
        t.join()

    print('All threads terminated!')
