from typing import Callable, Any
from time import sleep


class Retrier:
    def __init__(self, max_retries: int = 4, backoff_in_secs: int = 2):
        self.max_retries = max_retries
        self.backoff_in_secs = backoff_in_secs

    def retry(
        self, func: Callable[..., Any], retry_count: int = 0, *args, **kwargs
    ) -> Any:
        try:
            return func(*args, **kwargs)
        except Exception as e:
            if retry_count < self.max_retries:
                sleep(retry_count * self.backoff_in_secs)
                return self.retry(func, retry_count + 1, *args, **kwargs)
            else:
                raise e
