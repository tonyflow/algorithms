from time import sleep
from typing import Callable
from threading import Thread


def some_background_task(an_on_complete_task: Callable[..., ...]):
    sleep(2)
    print('I am processing stuff')
    an_on_complete_task('I have completed processing')


def on_complete_task(message: str):
    print(message)


if __name__ == '__main__':
    thread: Thread = Thread(target=some_background_task, args=[on_complete_task])
    thread.start()
    thread.join()
