from threading import Thread, get_ident
from queue import Queue


class Consumer:
    def __init__(self, pc_queue: Queue):
        self.consumer_thread = Thread(target=self._consume, daemon=True)
        self.queue = pc_queue

    def _consume(self):
        while True:
            next_item: int = self.queue.get()
            print(f'Consumer Thread {get_ident()}: Received item {next_item}')
            self.queue.task_done()

    def start(self):
        self.consumer_thread.start()

    def wait_for_completion(self):
        self.consumer_thread.join()
