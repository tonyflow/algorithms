import heapq
from typing import *
from list_node import ListNode


def merge(heads: List[ListNode]) -> ListNode:
    pq = []
    dummy: ListNode = ListNode()
    tail: ListNode = dummy
    for head in heads:
        heapq.heappush(pq, head)

    while pq:
        tail.next = heapq.heappop()
        tail = tail.next
        if tail.next:
            heapq.heappush(pq, tail.next)

    return dummy.next


if __name__ == '__main__':
    pq = []
