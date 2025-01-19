from queue import Queue
from threading import Thread, get_ident
from random import randint
from time import sleep


class Producer:
    def __init__(self, pc_queue: Queue):
        self.queue = pc_queue
        self.producer_thread = Thread(target=self._produce)

    def _produce(self):
        for i in range(10):
            time_to_sleep: int = randint(1, 10)
            self.queue.put(i)
            print(
                f"Producer Thread {get_ident()}: Published {i} and sleeping for {time_to_sleep} seconds"
            )
            sleep(time_to_sleep)

    def start(self):
        self.producer_thread.start()

    def wait_for_completion(self):
        self.producer_thread.join()
