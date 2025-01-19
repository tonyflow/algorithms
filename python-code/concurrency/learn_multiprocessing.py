from multiprocessing import Pool
from concurrent.futures import ProcessPoolExecutor, Future
from typing import List, Generator
import os


def square(number: int) -> int:
    print(f"[process_id={os.getpid()}] producing {number * number}")
    return number * number


def using_process_poll_executor() -> List[Future[int]]:
    with ProcessPoolExecutor(max_workers=3) as ppe:
        for i in range(1, 6):
            yield ppe.submit(square, number=i)
        # yield [ppe.submit(square, number=i) for i in range(1, 6)]


def using_multiprocessing_pool() -> Generator[int, None, None]:
    numbers = [1, 2, 3, 4, 5]
    with Pool(5) as pool:
        yield pool.map(square, numbers)


if __name__ == "__main__":
    task_futures: List[Future[int]] = using_process_poll_executor()
    results: List[int] = [r.result() for r in task_futures]
    print(results)

    results_from_multiprocessing_pool = using_multiprocessing_pool()
    print(list(results_from_multiprocessing_pool))
