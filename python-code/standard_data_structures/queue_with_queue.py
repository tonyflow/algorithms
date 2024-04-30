from queue import Queue

if __name__ == '__main__':
    q: Queue = Queue()
    q.put(5)
    q.put(6)
    q.put(7)

    while not q.empty():
        print(q.get())
        q.task_done()

    q.join()
