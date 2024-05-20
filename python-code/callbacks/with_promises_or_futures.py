from concurrent.futures import ThreadPoolExecutor, Future
import time


def background_task(a_message: str) -> str:
    time.sleep(2)
    print(a_message)
    return 'somthing to print when completed'


def on_task_complete(a_future: Future[str]):
    print(a_future.result())


if __name__ == '__main__':
    executor: ThreadPoolExecutor = ThreadPoolExecutor(max_workers=1)
    future: Future = executor.submit(background_task, a_message='something to print while processing')
    future.add_done_callback(on_task_complete)
    executor.shutdown()
