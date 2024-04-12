from typing import *
from list_node import *


def reverse(head: ListNode) -> ListNode:
    current: ListNode = head
    next_node: Optional[ListNode] = None
    previous: Optional[ListNode] = None

    while current:
        next_node = current.next
        current.next = previous

        previous = current
        current = next_node

    return previous


if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3)))

    result: ListNode = reverse(head)

    while result:
        print(result.val)
        result = result.next
