from consumer import Consumer
from producer import Producer
from queue import Queue

if __name__ == '__main__':
    queue: Queue = Queue(maxsize=5)
    producer: Producer = Producer(queue)
    consumer: Consumer = Consumer(queue)

    producer.start()
    consumer.start()

    producer.wait_for_completion()
    # consumer.wait_for_completion()

    queue.join()
